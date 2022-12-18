package com.example.simplenav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplenav.CommucationController.communicationController;
import com.example.simplenav.CommucationController.getFollowed;
import com.example.simplenav.CommucationController.getProfileO;

import java.util.List;

public class UtentiSeguiti extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_utenti_seguiti, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        communicationController.getFollowed(body -> {
            System.err.println("responso utenti seguiti"+body);
            for (getProfileO x: body) {
                System.err.println(x);
            }
        });
    }
}