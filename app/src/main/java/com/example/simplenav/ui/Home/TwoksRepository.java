package com.example.simplenav.ui.Home;

import androidx.annotation.NonNull;

import com.example.simplenav.CommucationController.GetTwok;
import com.example.simplenav.CommucationController.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwoksRepository {//è il model

    private List<GetTwok> twokList = null;

    public TwoksRepository() {
        this.twokList = new ArrayList<GetTwok>();
    }

    public GetTwok getTwokList(int pos) {
        return twokList.get(pos);
    }

    public int getSize(){
        return twokList.size();
    }

    public void initWithFakeData(){
        for (int i = 0; i < 100; i++) {
            //.add("Entry Twok"+i);
        }
    }

    public void add(GetTwok twok){
        twokList.add(twok);
    }

    @Override
    public String toString() {
        return "TwoksRepository{" +
                "twokList=" + twokList +
                '}';
    }

    public void getOneTwok(){
        System.err.println("getOneTwok");
        GetTwok getTwok = new GetTwok();

        getTwok.setSid("qaKOeIk1DhEvBLOruWaR");

        Call<GetTwok> call = RetrofitClient.getInstance().getMyApi().getTwok(getTwok);

        call.enqueue(new Callback<GetTwok>() {
            @Override
            public void onResponse(@NonNull Call<GetTwok> call, @NonNull Response<GetTwok> response) {
                System.err.println("Response");
//                System.err.println(response);
//                System.err.println(response.code());
//                System.err.println(response.body());
                switch (response.code()){
                    case 400 :
                        System.err.println("Error 400 - Client Error"+response.code());
                        break;
                    case 200 :
                        System.err.println("Success 200 - "+response.body());
//                        getTwok = response.body();
                        twokList.add(response.body());
                        System.err.println("List+"+twokList.toString());
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
        System.err.println("fineMetodo"+twokList.toString());

    }
}
