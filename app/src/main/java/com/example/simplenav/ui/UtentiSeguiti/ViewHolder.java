package com.example.simplenav.ui.UtentiSeguiti;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplenav.CommucationController.getProfileO;
import com.example.simplenav.R;

public class ViewHolder extends RecyclerView.ViewHolder {//si adatta al loyout sigle line
    private ImageView image;
    private TextView text;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.profile_pic);
        text = itemView.findViewById(R.id.personName);
    }
    public void updateContent(getProfileO p){
//        image.setImageBitmap();
        text.setText(p.getName());
    }
}
