package com.ksr.dictionary_app_rest_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ksr.dictionary_app_rest_api.Models.Definitions;
import com.ksr.dictionary_app_rest_api.R;
import com.ksr.dictionary_app_rest_api.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definations_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textDefinition.setText("Definition: "+ definitionsList.get(position).getDefinition());
        holder.textExample.setText("Example: "+ definitionsList.get(position).getExample());

        StringBuilder synonyms = new StringBuilder();
        synonyms.append(definitionsList.get(position).getSynonyms());
        holder.textSynonyms.setText(synonyms);
        holder.textSynonyms.setSelected(true);

        StringBuilder antonyms = new StringBuilder();
        antonyms.append(definitionsList.get(position).getAntonyms());
        holder.textAntonyms.setText(antonyms);
        holder.textAntonyms.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
