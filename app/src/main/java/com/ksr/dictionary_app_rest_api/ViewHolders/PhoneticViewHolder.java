package com.ksr.dictionary_app_rest_api.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ksr.dictionary_app_rest_api.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
       public TextView textPhonetic;
       public ImageButton imgBtnAudio;
    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        textPhonetic = itemView.findViewById(R.id.textPhonetic);
        imgBtnAudio = itemView.findViewById(R.id.imgBtnAudio);
    }
}
