package com.example.smart_shop;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

TextView name , address;

    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        TextView name=view.findViewById(R.id.set_shop_name);
        TextView address= view.findViewById(R.id.set_shop_address);

      //  String str=.getStringExtra("message_key");
     //   name.setText(str);
        return view;
    }
}