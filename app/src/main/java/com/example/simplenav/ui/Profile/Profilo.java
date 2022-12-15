package com.example.simplenav.ui.Profile;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.simplenav.R;

import java.util.ArrayList;
import java.util.List;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profilo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profilo extends Fragment implements EasyPermissions.PermissionCallbacks{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profilo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profilo.
     */
    // TODO: Rename and change types and number of parameters
    public static Profilo newInstance(String param1, String param2) {
        Profilo fragment = new Profilo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //initialize variable
    Button btPick;
    RecyclerView recyclerView;

    ArrayList<Uri> arrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profilo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //assign variable
        btPick = view.findViewById(R.id.bt_pick);
        recyclerView = view.findViewById(R.id.recyclerviewProfilo);

        //set listerner
        btPick.setOnClickListener(v ->{
            //definisco i permessi
            String[] strings = {Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE};

            //Check condition
            if (EasyPermissions.hasPermissions(getActivity(),strings)){
                //when permission are already granted
                //create method
                imagePicker();
            }else{
                //when permission non granted
                //request permission
                EasyPermissions.requestPermissions(
                        this,
                        "App needs access to your camera & storage",
                        100,
                        strings
                );
            }
        });

        //uses-permission android:name="android.permission.CAMERA"/
        //uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //handle the request result
        System.err.println("onRquestPermissionResult deprecato");
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    //TODO CREARE UNA GUIDA SUI FILE NECESSARI ED I PASSI PER CREARE UNA LISTA

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        System.err.println("onActivityResult deprecato");
        super.onActivityResult(requestCode, resultCode, data);
        //check condition
        if (resultCode == RESULT_OK && data != null){
            System.err.println("dentro if 1");
            //when activity contain data
            //check condition
            if (requestCode == FilePickerConst.REQUEST_CODE_PHOTO){
                System.err.println("dentro if 2");
                arrayList = data.getParcelableArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                //set adapter
                recyclerView.setAdapter(new ProfileAdp(arrayList));
            }
        }

    }

    private void imagePicker() {
        //open Picker
        FilePickerBuilder.getInstance()
                .setActivityTitle("Select Images")
                .setSpan(FilePickerConst.SPAN_TYPE.FOLDER_SPAN,3)
                .setSpan(FilePickerConst.SPAN_TYPE.DETAIL_SPAN,4)
                .setMaxCount(4)
                .setSelectedFiles(arrayList)
                .setActivityTheme(R.style.CustomTheme)
                .pickPhoto(this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        //check condition
        if (requestCode == 100 && perms.size() == 2){
            imagePicker();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            new AppSettingsDialog.Builder(this).build().show();
        }else{
            Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
}