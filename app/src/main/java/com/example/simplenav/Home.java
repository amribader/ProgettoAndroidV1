package com.example.simplenav;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplenav.CommucationController.RetrofitClient;
import com.example.simplenav.CommucationController.GetTwok;
import com.example.simplenav.ui.Home.TwokListAdapter;
import com.example.simplenav.ui.Home.TwoksRepository;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {
    private ViewPager2 viewPager2;
    private TwoksRepository twoksRepository = null;
    //private TwoksRepository twoksRepository = new ViewModelProvider(this).get(TwoksRepository.class);

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

        //getOneTwok();

        //TwoksRepository twoksRepository = new TwoksRepository();
        twoksRepository = new ViewModelProvider(this).get(TwoksRepository.class);
        //twoksRepository.getTwoks();
        //twoksRepository.initWithFakeData();
//        twoksRepository.getTwoks().observe(getViewLifecycleOwner(),twoks ->{
//            //UpdateUI
//        });
        //twoksRepository.getOneTwok();
        //twoksRepository.getTwoks();
        //twoksRepository.initWithFakeData();
        twoksRepository.getTwoks();
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
                //twoksRepository.add("Ciao");
                //twoksRepository.getOneTwok();
                getOneTwok();
                //TwokListAdapter adapter = new TwokListAdapter(twoksRepository,getActivity());
                //viewPager2.setAdapter(adapter);
                //twoksRepository.getTwoks();
                //twoksRepository.getOneTwok();
                //getOneTwok();
            }
        });

    }

    private void getOneTwok(){

        GetTwok getTwok = new GetTwok();

        //getTwok.setSid("qaKOeIk1DhEvBLOruWaR");

        Call<GetTwok> call = RetrofitClient.getInstance().getMyApi().getTwok(getTwok);

        call.enqueue(new Callback<GetTwok>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<GetTwok> call, @NonNull Response<GetTwok> response) {
                System.err.println("Response");
                switch (response.code()){
                    case 400 :
                        System.err.println("Error 400 - Client Error"+response.code());
                        break;
                    case 200 :
                        System.err.println("Success 200 - "+response.body());
                        twoksRepository.add(response.body().getText());
                        viewPager2.getAdapter().notifyDataSetChanged();
                        break;
                    case 500 :
                        System.err.println("Error 500 - Client Error"+response.code());
                        break;
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetTwok> call, @NonNull Throwable t) {
                System.err.println("ERROR");
                t.printStackTrace();
            }
        });
    }

}