package com.example.simplenav.CommucationController;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class communicationController {//implements Callback<GetPicture> {

    private GetPicture getPicture;
    private GetPicture obj;

    public communicationController(GetPicture getPicture) {
        this.getPicture = getPicture;
    }

    public communicationController() {

    }

    public GetPicture getGetPicture() {
        return getPicture;
    }

    public void setGetPicture(GetPicture getPicture) {
        System.err.println("metodo set" + getPicture);
        this.getPicture = getPicture;
    }
}
//    public synchronized void getTwokPicture(String uid) {
////
////        GetTwok getTwok = new GetTwok();
////        getTwok.setUid(uid);
////
////        JSONObject paramObject = new JSONObject();
////        try {
////
////            paramObject.put("sid", "qaKOeIk1DhEvBLOruWaR");
////            paramObject.put("uid", uid);
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
//
////
////        //getTwok.setSid("qaKOeIk1DhEvBLOruWaR");
////        System.err.println("da communicationcontroller get Picture " + getTwok);
//        Call<GetPicture> call = RetrofitClient.getInstance().getMyApi().getPicture("qaKOeIk1DhEvBLOruWaR", uid);
//        //call.enqueue(this);
//        call.enqueue(new Callback<GetPicture>() {
//            @Override
//            public void onResponse(Call<GetPicture> call, Response<GetPicture> response) {
//             obj = response.body();
//             setGetPicture(response.body());
//             //fun();
//            }
//
//            @Override
//            public void onFailure(Call<GetPicture> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public GetPicture fun(){
//        return obj;
//    }
//
//    @Override
//    public void onResponse(Call<GetPicture> call, Response<GetPicture> response) {
//        //this.getPicture = response.body();
//        Log.d("onResponseMethod",response.body().toString());
//        setGetPicture(response.body());
//        System.err.println("GETPICTURE=="+getPicture);
//        System.err.println("Response");
//        Log.d("onResponsePicture", response.toString());
//        switch (response.code()) {
//            case 400:
//                System.err.println("Error 400 - Picture Client Error" + response.code());
//                break;
//            case 200:
//                System.err.println("Success PICTURE 200 - " + response.body());
//                break;
//            case 500:
//                System.err.println("Error 500 - Client Error" + response.code());
//                break;
//        }
//    }
//
//    @Override
//    public void onFailure(Call<GetPicture> call, Throwable t) {
//        System.err.println("ERROR");
//        t.printStackTrace();
//    }
//}

        //
//        call.enqueue(new Callback<GetTwok>() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onResponse(@NonNull Call<GetTwok> call, @NonNull Response<GetTwok> response) {
//                System.err.println("Response");
//                Log.d("onResponsePicture",response.toString());
//                switch (response.code()) {
//                    case 400:
//                        System.err.println("Error 400 - Picture Client Error" + response.code());
//                        break;
//                    case 200:
//                        System.err.println("Success PICTURE 200 - " + response.body());
//                        //twokList.add(response.body());
//                        //viewPager2.getAdapter().notifyDataSetChanged();
//
//                        break;
//                    case 500:
//                        System.err.println("Error 500 - Client Error" + response.code());
//                        break;
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<GetTwok> call, @NonNull Throwable t) {
//                System.err.println("ERROR");
//                t.printStackTrace();
//            }
//  //      });
//    }
//}