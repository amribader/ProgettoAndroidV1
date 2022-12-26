package com.example.simplenav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplenav.CommucationController.communicationController;
import com.example.simplenav.CommucationController.getFollowed;
import com.example.simplenav.CommucationController.getProfileO;
import com.example.simplenav.ui.UtentiSeguiti.UtentiSeguitiAdp;
import com.example.simplenav.ui.UtentiSeguiti.UtentiSeguitiModel;

import java.util.List;

public class UtentiSeguiti extends Fragment {

    private UtentiSeguitiModel model;
    private RecyclerView recyclerView;

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

        model = new UtentiSeguitiModel();
        recyclerView = view.findViewById(R.id.recyclerViewFollower);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UtentiSeguitiAdp adapter = new UtentiSeguitiAdp(model,getActivity());
        recyclerView.setAdapter(adapter);

        model.getOneTwok(recyclerView);//riga giusta cosi funziona
        //model.initfakedata();
        ////model.getOneTwok(recyclerView);//riga giusta cosi funziona
        //model.fun(recyclerView);
//        System.err.println(model);
        //model.getOneTwok(recyclerView);
        //model.getFollower().forEach();
        for (getProfileO x :
                model.getFollower()) {

            System.err.println("model utenti seguit"+x);
        }

//
//
//        System.err.println(recyclerView);
//
//        System.err.println("model+"+model);
////        System.err.println("model+ 0"+model.getFollower(0));
//        System.err.println("model+ size"+model.getSize());
////        UtentiSeguitiAdp adapter = new UtentiSeguitiAdp(model,getActivity());
////        recyclerView.setAdapter(adapter);
    }
}