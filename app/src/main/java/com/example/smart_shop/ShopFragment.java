package com.example.smart_shop;

import static androidx.core.view.PointerIconCompat.load;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;


public class ShopFragment extends Fragment {

    TextView et_shp_create,tv_profile_btn;
  // private Button et_shp_create;
   // private String shopName,address,phoneNumber;
   // private FirebaseFirestore db;
  LoginFragment loginFragment=new LoginFragment();
     FrameLayout frame_layout_two,log_in_fragment,shop_fragment;
     Button btn_login;
    public ShopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_shop, container, false);
        TextView tv_profile_btn=(TextView)rootView.findViewById(R.id.tv_profile_btn);
     //   FrameLayout log_in_fragment=rootView.findViewById(R.id.log_in_fragment);
   TextView textView=(TextView) rootView.findViewById(R.id.et_shp_create);
   Button btn_login=(Button) rootView.findViewById(R.id.btn_login) ;



   btn_login.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           FragmentTransaction fr = getFragmentManager().beginTransaction();
           fr.replace(R.id.shop_fragment,new LoginFragment());
           fr.commit();
       }
   });

   textView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent i = new Intent(getActivity(),SignupActivity.class);
            startActivity(i);
       }
   });
   tv_profile_btn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent i = new Intent(getActivity(), ProfileActivity.class);
           startActivity(i);
       }
   });


       return rootView;


    }

}