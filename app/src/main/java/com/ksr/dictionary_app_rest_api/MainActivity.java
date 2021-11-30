package com.ksr.dictionary_app_rest_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ksr.dictionary_app_rest_api.API.OnFetchDataListener;
import com.ksr.dictionary_app_rest_api.API.RequestManager;
import com.ksr.dictionary_app_rest_api.Adapters.MeaningsAdapter;
import com.ksr.dictionary_app_rest_api.Adapters.PhoneticAdapter;
import com.ksr.dictionary_app_rest_api.Models.ApiResponse;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TextView textWord;
    RecyclerView recyclerPhonetics, recyclerMeanings;
    PhoneticAdapter phoneticAdapter;
    MeaningsAdapter meaningsAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        textWord = findViewById(R.id.textWord);
        recyclerPhonetics = findViewById(R.id.recyclerPhonetics);
        recyclerMeanings = findViewById(R.id.recyclerMeanings);
        progressDialog = new ProgressDialog(MainActivity.this);


        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RequestManager requestManager = new RequestManager(MainActivity.this);
        requestManager.getWordMeaning(listener, "hello");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching data for "+query);
                progressDialog.show();
                RequestManager requestManager = new RequestManager(MainActivity.this);
                requestManager.getWordMeaning(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(ApiResponse apiResponse, String message) {
            progressDialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(MainActivity.this, "No data found! ", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(ApiResponse apiResponse) {
        textWord.setText("Word: "+apiResponse.getWord());
        recyclerPhonetics.setHasFixedSize(true);
        recyclerPhonetics.setLayoutManager(new LinearLayoutManager(this));
        phoneticAdapter = new PhoneticAdapter(this, apiResponse.getPhonetics());
        recyclerPhonetics.setAdapter(phoneticAdapter);

        recyclerMeanings.setHasFixedSize(true);
        recyclerMeanings.setLayoutManager(new LinearLayoutManager(this));
        meaningsAdapter = new MeaningsAdapter(this, apiResponse.getMeanings());
        recyclerMeanings.setAdapter(meaningsAdapter);

    }

}