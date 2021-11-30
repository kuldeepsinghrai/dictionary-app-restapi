package com.ksr.dictionary_app_rest_api.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ksr.dictionary_app_rest_api.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
        public TextView textPartOfSpeech;
        public RecyclerView recyclerDefinations;

    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textPartOfSpeech = itemView.findViewById(R.id.textPartOfSpeech);
        recyclerDefinations = itemView.findViewById(R.id.recyclerDefinations);
    }
}
