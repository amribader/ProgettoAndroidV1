package com.example.simplenav.ui.UtentiSeguiti;

import androidx.lifecycle.ViewModel;
import com.example.simplenav.CommucationController.getProfileO;
import java.util.ArrayList;
import java.util.List;

public class UtentiSeguitiModel extends ViewModel {


        private List<getProfileO> follower = null;

        public UtentiSeguitiModel() {
            this.follower = new ArrayList<getProfileO>();
        }

        public getProfileO getFollower(int pos) {
            return follower.get(pos);
        }

        public int getSize() {
            return follower.size();
        }

        public void add(getProfileO twok) {
            follower.add(twok);
        }

//        public void getOneTwok(ViewPager2 viewPager2) {
//
//            GetTwok getTwok = new GetTwok();
//
//            //getTwok.setSid("qaKOeIk1DhEvBLOruWaR");
//
//            Call<GetTwok> call = RetrofitClient.getInstance().getMyApi().getTwok(getTwok);
//
//            call.enqueue(new Callback<GetTwok>() {
//                @SuppressLint("NotifyDataSetChanged")
//                @Override
//                public void onResponse(@NonNull Call<GetTwok> call, @NonNull Response<GetTwok> response) {
//                    System.err.println("Response");
//                    switch (response.code()) {
//                        case 400:
//                            System.err.println("Error 400 - Client Error" + response.code());
//                            break;
//                        case 200:
//                            System.err.println("Success 200 - " + response.body());
//                            twokList.add(response.body());
//                            viewPager2.getAdapter().notifyDataSetChanged();
//                            break;
//                        case 500:
//                            System.err.println("Error 500 - Client Error" + response.code());
//                            break;
//                    }
//                }
//
//                @Override
//                public void onFailure(@NonNull Call<GetTwok> call, @NonNull Throwable t) {
//                    System.err.println("ERROR");
//                    t.printStackTrace();
//                }
//            });
//        }
}
