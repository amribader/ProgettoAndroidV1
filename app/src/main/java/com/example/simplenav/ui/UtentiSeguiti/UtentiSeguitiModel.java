package com.example.simplenav.ui.UtentiSeguiti;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.simplenav.CommucationController.communicationController;
import com.example.simplenav.CommucationController.getFollowed;
import com.example.simplenav.CommucationController.getProfileO;
import java.util.ArrayList;
import java.util.List;

public class UtentiSeguitiModel extends ViewModel {


        private List<getProfileO> follower = null;

        public UtentiSeguitiModel() {
            this.follower = new ArrayList<getProfileO>();
            //getOneTwok();
//            communicationController.getFollowed(new getFollowed() {
//                @Override
//                public void getFollow(List<getProfileO> body) {
//                    follower = body;
//                    System.err.println("body="+body);
//                }
//            });
            //System.err.println(getFollower());
        }

        public getProfileO getFollower(int pos) {
            return follower.get(pos);
        }

        public int getSize() {
            return follower.size();
        }

        public void setFollower(List<getProfileO> follower) {
            this.follower = follower;
        }

        public void initfakedata(){
            for (int i = 0; i < 10; i++) {
                getProfileO getProfileO = new getProfileO();
                String s = "ciao"+i+"";
                getProfileO.setName(s);
                follower.add(getProfileO);
            }
        }

    public List<getProfileO> getFollower() {
        return follower;
    }

    public void getOneTwok(RecyclerView rv) {
            communicationController.getFollowed(body -> {
                //System.err.println("responso utenti seguiti"+body);
                for (getProfileO x: body) {
                    //System.err.println(x);
                    follower.add(x);
                }
                //setFollower(body);
                //System.err.println("follower2"+follower);
                rv.getAdapter().notifyDataSetChanged();
            });
            //System.err.println("follower"+follower);
        }

    @Override
    public String toString() {
        return "UtentiSeguitiModel{" +
                "follower=" + follower +
                '}';
    }
}
