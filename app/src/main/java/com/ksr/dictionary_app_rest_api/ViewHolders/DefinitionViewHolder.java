package com.ksr.dictionary_app_rest_api.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ksr.dictionary_app_rest_api.R;

import org.w3c.dom.Text;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
       public TextView textDefinition,textExample,textSynonyms,textAntonyms;

    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);

        textDefinition = itemView.findViewById(R.id.textDefinition);
        textExample = itemView.findViewById(R.id.textExample);
        textSynonyms = itemView.findViewById(R.id.textSynonyms);
        textAntonyms = itemView.findViewById(R.id.textAntonyms);

    }
}
