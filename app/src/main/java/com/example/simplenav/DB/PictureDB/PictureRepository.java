package com.example.simplenav.DB.PictureDB;

import android.content.Context;

import androidx.room.Room;

import com.example.simplenav.DB.AppDatabase;

public class PictureRepository {

    public static void getPicture(Sid sid, int pversion, PictureDBListener pictureDBListener, ErrorPictureDBListener errorPictureDBListener, Context context){
        //controlla sul db se ce nella callback
            //nella collaback se ce chiama listenerr con immagine chimata
            //se non ce fai la chiamata di rete

        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "databaseAndroid")
                .build();



    }

}
