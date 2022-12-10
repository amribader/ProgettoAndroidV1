package com.example.simplenav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplenav.ui.Home.TwokListAdapter;
import com.example.simplenav.ui.Home.TwoksRepository;


public class Home extends Fragment {
    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TwoksRepository twoksRepository = new TwoksRepository();
        twoksRepository.initWithFakeData();
        RecyclerView recyclerView = view.findViewById(R.id.twokRecyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TwokListAdapter adapter = new TwokListAdapter(twoksRepository,getActivity());
        recyclerView.setAdapter(adapter);
    }
}