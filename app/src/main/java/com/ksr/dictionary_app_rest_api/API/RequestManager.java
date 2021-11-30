package com.ksr.dictionary_app_rest_api.API;

import android.content.Context;
import android.widget.Toast;

import com.ksr.dictionary_app_rest_api.API.OnFetchDataListener;
import com.ksr.dictionary_app_rest_api.Models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    Context context;

    public RequestManager(Context context) {
        this.context = context;
    }



    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    public void getWordMeaning(OnFetchDataListener listener, String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<ApiResponse>> call = callDictionary.callMeanings(word);

        try {
            call.enqueue(new Callback<List<ApiResponse>>() {
                @Override
                public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Error:response is not succesfull", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                    listener.onError("Request Failed");
                }
            });
        } catch (Exception e){
             e.printStackTrace();
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }

    }

    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<ApiResponse>> callMeanings(
                @Path("word") String word
        );


    }

}
