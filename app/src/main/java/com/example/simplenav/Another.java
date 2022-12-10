package com.example.simplenav;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Another extends Fragment implements AdapterView.OnItemSelectedListener {

    private final @NonNull CreateTwok twok = new CreateTwok();

    // two buttons to open color picker dialog and one to
    // set the color for GFG text
    private Button mSetColorButton, mPickColorButton;

    // view box to preview the selected color
    private View mColorPreview;

    // this is the default color of the preview box
    private int mDefaultColor;


    // two buttons to open color picker dialog and one to
    // set the color for GFG text
    private Button mSetColorButtonBG, mPickColorButtonBG;

    // view box to preview the selected color
    private View mColorPreviewBG;

    // this is the default color of the preview box
    private int mDefaultColorBG;



    //button Create twok and take my position
    private Button createTwok, takeMyLocation;

    public Another() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //container.getContext();
        return inflater.inflate(R.layout.fragment_another, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinnerD = view.findViewById(R.id.spinnerD);
        Spinner spinnerF = view.findViewById(R.id.spinnerF);
        Spinner spinnerV = view.findViewById(R.id.spinnerV);
        Spinner spinnerH = view.findViewById(R.id.spinnerH);

        //TextView textView = view.findViewById(R.id.textViewText);
        TextView textView = view.findViewById(R.id.textViewText);
        System.err.println(view.findViewById(R.id.textViewText));

// Create an ArrayAdapter using the string array and a default spinner layout
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        //////inizio
        //TODO rivedere convertire enum to array
        //List<String> mass = Arrays.asList(CreateTwok.Dimension.values());
        ArrayAdapter<CharSequence> adapterD = ArrayAdapter.createFromResource(activity,
                R.array.Dimension_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerD.setAdapter(adapterD);
        spinnerD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "small":
                        textView.setTextSize(20);
                        twok.setFontsize(20);
                        break;
                    case "medium":
                        textView.setTextSize(32);
                        twok.setFontsize(32);
                        break;
                    case "large":
                        textView.setTextSize(48);
                        twok.setFontsize(48);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //////////fine
        //
        // //inizio secondo spinner
        //TODO rivedere convertire enum to array
        //List<String> mass = Arrays.asList(CreateTwok.Dimension.values());
        ArrayAdapter<CharSequence> adapterF = ArrayAdapter.createFromResource(activity,
                R.array.Font_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerF.setAdapter(adapterF);
        spinnerF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.err.println(adapterView.getItemAtPosition(i));
                //Typeface face=Typeface.createFromAsset(getAssets(), "font/"+adapterView.getItemAtPosition(i).toString());
                //textView.setTypeface(face);
                System.err.println("font/"+adapterView.getItemAtPosition(i).toString()+".ttf");
                //Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "font/"+adapterView.getItemAtPosition(i).toString()+".ttf");
                System.err.println(getActivity());
                System.err.println(getActivity().getAssets());
                System.err.println(getActivity().getAssets().getLocales());

                Typeface typeface = getResources().getFont(R.font.dancing_script);

                switch (adapterView.getItemAtPosition(i).toString()){
                    case "anton_regular":
                        typeface = getResources().getFont(R.font.anton_regular);
                        textView.setTypeface(typeface);
                        twok.setFonttype(0);
                        break;
                    case "bhutuka_regular":
                        typeface = getResources().getFont(R.font.bhutuka_regular);
                        textView.setTypeface(typeface);
                        twok.setFonttype(1);
                        break;
                    case "dancing_script":
                        typeface = getResources().getFont(R.font.dancing_script);
                        textView.setTypeface(typeface);
                        twok.setFonttype(2);
                        break;
                }



                textView.setTypeface(typeface);
                //@font/anton_regular

//                Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "font/anton_regular");
//                textView.setTypeface(typeface);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        //////////fine

        //////inizio terzo spinerr Vertical
        //TODO rivedere convertire enum to array
        //List<String> mass = Arrays.asList(CreateTwok.Dimension.values());
        ArrayAdapter<CharSequence> adapterV = ArrayAdapter.createFromResource(activity,
                R.array.Vertical_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterV.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerV.setAdapter(adapterV);
        spinnerV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.err.println(adapterView.getItemAtPosition(i));
                //center_vertical	10	top 30  bottom 50
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "bottom":
                        System.err.println("BOTTOM TAB");
                        textView.setGravity(Gravity.BOTTOM);
                        twok.setValign(2);
                        break;
                    case "top":
                        textView.setGravity(Gravity.TOP);
                        twok.setValign(0);
                        break;
                    case "center":
                        textView.setGravity(Gravity.CENTER_VERTICAL);
                        twok.setValign(1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //////////fine

        //////inizio terzo spinerr Vertical
        //TODO rivedere convertire enum to array
        //List<String> mass = Arrays.asList(CreateTwok.Dimension.values());
        ArrayAdapter<CharSequence> adapterH = ArrayAdapter.createFromResource(activity,
                R.array.Horizontal_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerH.setAdapter(adapterH);


        spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)

                // LEFT 3   RIGTH 5  CENTER HORIZONTAL 1

                System.err.println("->"+textView.getGravity());

                switch (adapterView.getItemAtPosition(i).toString()){
                    case "center":
                        textView.setGravity(Gravity.CENTER_HORIZONTAL);
                        twok.setHalign(1);
                        break;
                    case "left":
                        textView.setGravity(Gravity.LEFT);
                        twok.setHalign(0);
                        break;
                    case "right":
                        textView.setGravity(Gravity.RIGHT);
                        twok.setHalign(2);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //spinnerH.setOnItemSelectedListener(this);
        //////////fine



        //PARTE SELEZIONE COLORI



        // register two of the buttons with their
        // appropriate IDs
        mPickColorButton = view.findViewById(R.id.pick_color_button);
        mSetColorButton = view.findViewById(R.id.set_color_button);

        // and also register the view which shows the
        // preview of the color chosen by the user
        mColorPreview = view.findViewById(R.id.preview_selected_color);

        // set the default color to 0 as it is black
        mDefaultColor = 0;

        // button open the AmbilWanra color picker dialog.
        mPickColorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // to make code look cleaner the color
                        // picker dialog functionality are
                        // handled in openColorPickerDialogue()
                        // function
                        openColorPickerDialogue(0);
                    }
                });

        mSetColorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // as the mDefaultColor is the global
                        // variable its value will be changed as
                        // soon as ok button is clicked from the
                        // color picker dialog.
                        textView.setTextColor(mDefaultColor);
                        String s = String.valueOf(mDefaultColor).substring(1);
                        twok.setFontcol(s);
                    }
                });
/////////////////
        //SECONDO

        // register two of the buttons with their
        // appropriate IDs
        mPickColorButtonBG = view.findViewById(R.id.pick_color_buttonBG);
        mSetColorButtonBG = view.findViewById(R.id.set_color_buttonBG);

        // and also register the view which shows the
        // preview of the color chosen by the user
        mColorPreviewBG = view.findViewById(R.id.preview_selected_colorBackground);

        // set the default color to 0 as it is black
        mDefaultColorBG = 0;

        // button open the AmbilWanra color picker dialog.
        mPickColorButtonBG.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // to make code look cleaner the color
                        // picker dialog functionality are
                        // handled in openColorPickerDialogue()
                        // function
                        openColorPickerDialogue(1);
                    }
                });

        mSetColorButtonBG.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // as the mDefaultColor is the global
                        // variable its value will be changed as
                        // soon as ok button is clicked from the
                        // color picker dialog.
                        System.err.println("Colore->"+mDefaultColorBG);
                        textView.setBackgroundColor(mDefaultColorBG);
                        String s = String.valueOf(mDefaultColorBG).substring(1);
                        twok.setBgcol(s);
                    }
                });


        takeMyLocation = view.findViewById(R.id.takeMyLocation);
        createTwok = view.findViewById(R.id.createTwok);

        createTwok.setOnClickListener(v -> {
            twok.setText(textView.getText().toString());
//            System.err.println(textView.getText());
//            System.err.println(textView.getCurrentTextColor());
//            System.err.println(textView.getBackground());
//            System.err.println(textView.getFontFeatureSettings());
//            System.err.println(textView.getTextSize());
            System.err.println(twok);


// ...

// Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            String url = "https://develop.ewlab.di.unimi.it/mc/twittok/addTwok";

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(activity, "Success", Toast.LENGTH_LONG).show(),
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("TESTTEST", "Ops: " + error.toString());
                        }
                    }){
                    //error -> Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()){
            @Override
                protected Map<String,String> getParams() throws AuthFailureError{
                    Map<String,String> params = new HashMap<>();
                    params.put("sid","qaKOeIk1DhEvBLOruWaR");
                    params.put("text",twok.getText());
                    params.put("bgcol","000000");
                    params.put("fontcol","00aeef");
                    params.put("fonttype","44");
                    params.put("halign","1");
                    params.put("valign","1");
                    params.put("lan","");
                    params.put("lon","");
                    return params;
                }
            };
            queue = Volley.newRequestQueue(getActivity());

// Add the request to the RequestQueue.
            queue.add(stringRequest);

            System.err.println(queue);
            System.err.println(stringRequest.toString());


        });


    }


    // the dialog functionality is handled separately
    // using openColorPickerDialog this is triggered as
    // soon as the user clicks on the Pick Color button And
    // the AmbilWarnaDialog has 2 methods to be overridden
    // those are onCancel and onOk which handle the "Cancel"
    // and "OK" button of color picker dialog
    public void openColorPickerDialogue(int i) {

        // the AmbilWarnaDialog callback needs 3 parameters
        // one is the context, second is default color,
        final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(getActivity(), mDefaultColor,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // leave this function body as
                        // blank, as the dialog
                        // automatically closes when
                        // clicked on cancel button
                    }
                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // change the mDefaultColor to
                        // change the GFG text color as
                        // it is returned when the OK
                        // button is clicked from the
                        // color picker dialog

                        //0 = font 1= bg
                        if(i==0){//font
                            mDefaultColor = color;

                            // now change the picked color
                            // preview box to mDefaultColor
                            mColorPreview.setBackgroundColor(mDefaultColor);
                        }else if(i==1){//bg
                            mDefaultColorBG = color;

                            // now change the picked color
                            // preview box to mDefaultColor
                            mColorPreviewBG.setBackgroundColor(mDefaultColorBG);
                        }
                    }
                });
        colorPickerDialogue.show();
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        System.err.println(this);
        System.err.println(adapterView.getId());
        System.err.println(view.getId());
        System.err.println(view.findViewById(R.id.textViewText));

        if (view.getId() == R.id.spinnerH) {
            System.err.println("pulsante premuto corretto");
        } else {
            System.err.println("pulsante sbaglaito");
        }

        //adapterView.
        TextView textView = view.findViewById(R.id.textViewText);
        //System.err.println(textView.getText());
        System.err.println("textView" + textView);
        Log.d("ciaomondo", "ciaomondo");
        System.err.println(adapterView.getItemAtPosition(i));
        //textView.setGravity(1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Another interface callback

    }
}