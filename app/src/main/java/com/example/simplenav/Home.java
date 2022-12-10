package com.example.simplenav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplenav.ui.Home.TwokListAdapter;
import com.example.simplenav.ui.Home.TwoksRepository;


public class Home extends Fragment {
    private ViewPager2 viewPager2;
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
        //codice funzionante primo modo prof
//        TwoksRepository twoksRepository = new TwoksRepository();
//        twoksRepository.initWithFakeData();
//        RecyclerView recyclerView = view.findViewById(R.id.viewPager2);
//        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        TwokListAdapter adapter = new TwokListAdapter(twoksRepository,getActivity());
//        recyclerView.setAdapter(adapter);



        //////////secondo modo effetto magnetico
        TwoksRepository twoksRepository = new TwoksRepository();
        twoksRepository.initWithFakeData();
        viewPager2 = view.findViewById(R.id.viewPager2);
        TwokListAdapter adapter = new TwokListAdapter(twoksRepository,getActivity());
        viewPager2.setAdapter(adapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Log.d("Home","onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("Home","onPageSelected");
            }
        });

    }
}