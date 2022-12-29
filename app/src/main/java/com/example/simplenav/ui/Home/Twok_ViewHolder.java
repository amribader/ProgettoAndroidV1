package com.example.simplenav.ui.Home;

//import static com.example.simplenav.CommucationController.communicationController.getTwokPicture;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplenav.CommucationController.GetPicture;
import com.example.simplenav.CommucationController.GetTwok;
import com.example.simplenav.CommucationController.RetrofitClient;
import com.example.simplenav.CommucationController.communicationController;
import com.example.simplenav.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//viewModel?
public class Twok_ViewHolder extends RecyclerView.ViewHolder implements Callback<GetPicture> {
    private TextView mName = null;
    private TextView mText = null;
    private ImageView mImage = null;

    private GetPicture getPicture;

    public Twok_ViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.Name);
        mText = itemView.findViewById(R.id.TwokText);
        mImage = itemView.findViewById(R.id.imageView);
    }

    @SuppressLint("ResourceAsColor")
    public void updateContent(GetTwok string){
        //mName.setText("string");
        mName.setText(string.getName());
        mText.setText(string.getText());

        System.err.println(string);

        if (string.getBgcol().length() != 6 || string.getFontcol().length()!=6 ){
            itemView.setBackgroundColor(R.color.white);
            mText.setTextColor(R.color.black);
        }else{
            itemView.setBackgroundColor(Color.parseColor("#"+string.getBgcol()));
            System.err.println("Color="+Color.parseColor("#"+string.getBgcol()));
            mText.setTextColor(Color.parseColor("#"+string.getFontcol()));
        }

        mText.setTextSize(string.getFontsize()*10);
        mName.setTextSize(string.getFontsize()*8);

        int g = string.getHalign()==0 && string.getValign()==0
                ? Gravity.LEFT|Gravity.TOP
                : string.getHalign()==0 && string.getValign()==1
                    ? Gravity.LEFT|Gravity.CENTER_VERTICAL
                    : string.getHalign()==0 && string.getValign()==2
                        ? Gravity.LEFT|Gravity.BOTTOM
                        : string.getHalign()==1 && string.getValign()==0
                            ? Gravity.CENTER_HORIZONTAL|Gravity.TOP
                            : string.getHalign()==1 && string.getValign()==1
                                ? Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL
                                : string.getHalign()==1 && string.getValign()==2
                                    ? Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM
                                    : string.getHalign()==2 && string.getValign()==0
                                        ? Gravity.RIGHT|Gravity.TOP
                                        : string.getHalign()==2 && string.getValign()==1
                                            ? Gravity.RIGHT|Gravity.CENTER_VERTICAL
                                            : string.getHalign()==2 && string.getValign()==2
                                                ? Gravity.RIGHT|Gravity.BOTTOM
                                                : Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL;
        System.err.println("G="+g);

        mName.setGravity(g);
        mText.setGravity(g);

        mText.setGravity(Gravity.BOTTOM);//|Gravity.CENTER_HORIZONTAL);
//        int valigh = 1;
//        int haligh = 1;
//        String s = "TOP";
//        switch (string.getValign() && string.getHalign()){
//            case 0:
//                mName.setGravity(Gravity+""+s);
//                break;
//            case 1:
//
//                break;
//            case 12:
//                System.out.println("Monday");
//                break;
//        }

//        Typeface typeface = Typeface.defaultFromStyle(R.font.anton_regular);
//        mText.setTypeface(Typeface.create("sans-serif-thin", R.font.anton_regular));
//        System.err.println("STRING"+string);
        //Typeface typeface = getResources().getFont(R.font.dancing_script);
        //typeface = getResources().getFont(R.font.anton_regular);
        //textView.setTypeface(typeface);
        //TODO FONT PROBLEMA QUI NON ABBIAMO ACCESSO AI FONT VISTO CHE
//        communicationController communicationController = new communicationController();
//        communicationController.getTwokPicture(string.getUid());
//        GetPicture getPicture = communicationController.getGetPicture();
//        GetPicture x = communicationController.fun();
//        System.err.println("GETPICTURE="+getPicture);
//        System.err.println("risultato="+x);
//        //getTwokPicture(string.getUid());

        GetPicture getPicture = getTwokPicture(string.getUid());
        System.err.println("BOM"+getTwokPicture(string.getUid()));
        System.err.println("BOM2"+getPicture);
        if(getPicture == null){
            return;
        }

        if (getPicture.getPicture()==null){
            mImage.setBackgroundResource(R.drawable.ic_baseline_account_circle_24);
            return;
        }

        byte[] decodedString = Base64.decode(getPicture.getPicture(),Base64.DEFAULT);
        Bitmap decodeByte = BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);
        mImage.setImageBitmap(decodeByte);
        System.err.println("BOM"+getTwokPicture(string.getUid()));


//        mImage.setOnClickListener(v ->{
//            System.err.println("hai premuto sulla immagine");
//
//            Log.d("TVH OBJ",string.toString());
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("uid",Integer.parseInt(string.getUid()));
//                    Navigation.findNavController(v).navigate(R.id.action_home_pop, bundle);
////
//
//
//
//        });

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.err.println("hai premuto sulla immagine");

                Log.d("TVH OBJ",string.toString());
                Bundle bundle = new Bundle();
                bundle.putInt("uid",Integer.parseInt(string.getUid()));
                Navigation.findNavController(view).navigate(R.id.action_home_pop, bundle);
            }
        });
    }

    public void setGetPicture(GetPicture getPicture) {
        this.getPicture = getPicture;
    }

    public GetPicture getTwokPicture(String uid) {

        Call<GetPicture> call = RetrofitClient.getInstance().getMyApi().getPicture("qaKOeIk1DhEvBLOruWaR", uid);
        //call.enqueue(this);
        call.enqueue(new Callback<GetPicture>() {
            @Override
            public void onResponse(Call<GetPicture> call, Response<GetPicture> response) {
                setGetPicture(response.body());
            }

            @Override
            public void onFailure(Call<GetPicture> call, Throwable t) {

            }
        });
        return getPicture;
    }
////
    @Override
    public void onResponse(Call<GetPicture> call, Response<GetPicture> response) {

        switch (response.code()) {
            case 400:
                System.err.println("Error 400 - Picture Client Error" + response.code());
                break;
            case 200:
                System.err.println("Success PICTURE 200 - " + response.body());
                break;
            case 500:
                System.err.println("Error 500 - Client Error" + response.code());
                break;
        }
    }

    @Override
    public void onFailure(Call<GetPicture> call, Throwable t) {
        System.err.println("ERROR");
        t.printStackTrace();
    }
}

