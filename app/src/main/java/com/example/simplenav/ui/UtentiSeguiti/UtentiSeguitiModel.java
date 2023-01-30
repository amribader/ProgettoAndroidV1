package com.example.simplenav.ui.UtentiSeguiti;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplenav.CommucationController.GetPicture;
import com.example.simplenav.CommucationController.communicationController;
import com.example.simplenav.CommucationController.getPictureI;
import com.example.simplenav.CommucationController.getProfileO;
import com.example.simplenav.DB.PictureDB.ErrorPictureDBListener;
import com.example.simplenav.DB.PictureDB.PictureDBListener;
import com.example.simplenav.DB.PictureDB.PictureRepository;
import com.example.simplenav.DB.PictureDB.Sid;

import java.util.ArrayList;
import java.util.List;

public class UtentiSeguitiModel extends ViewModel {

    //per il sid


        private List<getProfileO> follower = null;

        public static final String mypreference = "mypref";

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

    public void getOneTwok(RecyclerView rv, Context context) {

        SharedPreferences sharedpreferences = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        System.err.println("prova SID"+sharedpreferences.contains("sid"));
        System.err.println("prova SID"+sharedpreferences.getString("sid",""));

        String sid = sharedpreferences.getString("sid","");

            communicationController.getFollowed(body -> {
                //System.err.println("responso utenti seguiti"+body);
                for (getProfileO x: body) {
            getProfileO user = new getProfileO();
                    System.err.println("body getTwok"+x);
                    //follower.add(x);
                    user.setName(x.getName());
                    user.setUid(x.getUid());

                    //todo
                    //Qui prima di fare la chiamata di rete controllo
                    // il db per verificare se sia presewnte o meno l'immagine profilo

                    //prendi il sid dalle preferences
                    //Sid sid = new Sid();
                    PictureRepository.getPicture(sid, 1, x.getUid(), new PictureDBListener() {
                        @Override
                        public void onPictureReady(String picture) {
                            //qui gestisco immagine che ho ottenuto
                            System.err.println("USM+ getONeTwok getPicture"+body);
                            user.setPicture(picture);
                            follower.add(user);
                            rv.getAdapter().notifyDataSetChanged();
                        }
                    }, new ErrorPictureDBListener() {
                        @Override
                        public void onError(Throwable t) {
                            //gestisco il caso di errore
                            //todo
                        }
                    },context);



//                    communicationController.getPicture("qaKOeIk1DhEvBLOruWaR", x.getUid(), new getPictureI() {
//                        @Override
//                        public void getPicture(GetPicture body) {
//                            System.err.println("USM+ getONeTwok getPicture"+body);
//                            user.setPicture(body.getPicture());
//                            follower.add(user);
//                            rv.getAdapter().notifyDataSetChanged();
//                        }
//                    });//todo sid hardcoded
                }
                //setFollower(body);
                //System.err.println("follower2"+follower);
                //follower.add(user);
                //rv.getAdapter().notifyDataSetChanged();//funziona provo a spostarlo sopra
            });
            //System.err.println("follower"+follower);
        }

//    public void fun(RecyclerView rv){
//        System.err.println("fun");
//        getOneTwok(rv);
//        System.err.println("ciao i follower sono"+follower);
//        for (getProfileO x : follower) {
//            System.err.println("dentro a fun"+x);
//            communicationController.getPicture(x.getSid(),x.getUid());
//        }
//    }

//    public void fun(){
//        System.err.println("fun");
//        System.err.println("ciao i follower sono"+follower);
//        for (getProfileO x : follower) {
//            System.err.println("dentro a fun"+x);
//            communicationController.getPicture("qaKOeIk1DhEvBLOruWaR",x.getUid());//todo sid hardcoded
//        }
//    }

    @Override
    public String toString() {
        return "UtentiSeguitiModel{" +
                "follower=" + follower +
                '}';
    }
}
