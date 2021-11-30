package com.ksr.dictionary_app_rest_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ksr.dictionary_app_rest_api.Models.Meanings;
import com.ksr.dictionary_app_rest_api.R;
import com.ksr.dictionary_app_rest_api.ViewHolders.MeaningsViewHolder;

import java.util.List;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {
    private Context context;
    private List<Meanings> meaningsList;

    public MeaningsAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.textPartOfSpeech.setText("Part of speech: "+ meaningsList.get(position).getPartOfSpeech());
        holder.recyclerDefinations.setHasFixedSize(true);
        holder.recyclerDefinations.setLayoutManager(new LinearLayoutManager(context));
        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context,meaningsList.get(position).getDefinitions());
        holder.recyclerDefinations.setAdapter(definitionAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
