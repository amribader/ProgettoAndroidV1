package com.example.simplenav.ui.Home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplenav.R;

public class Twok_ViewHolder extends RecyclerView.ViewHolder {
    private TextView mName = null;

    public Twok_ViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.Name);
    }

    public void updateContent(String string){
        mName.setText(string);
    }
}
