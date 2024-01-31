package com.example.smart_shop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import kotlin.contracts.Returns;

public class LoginFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
   DocumentReference ref;
    FirebaseFirestore db;
    EditText Et_get_email ,Et_get_password , btn_Log_in;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        EditText Et_get_email=view.findViewById(R.id.Et_get_email);
        EditText Et_get_password=view.findViewById(R.id.Et_get_password);
        EditText btn_get_Log_in=view.findViewById(R.id.btn_Log_in);
        firebaseFirestore=FirebaseFirestore.getInstance();
       ref = firebaseFirestore.collection("shop").document();


        btn_get_Log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Et_get_email.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if (Et_get_password.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.collection("shop").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for(QueryDocumentSnapshot doc:task.getResult()){
                                    String a= doc.getString("Email");
                                    String b = doc.getString("Password");
                                        String a1=Et_get_email.toString().trim();
                                        String b1=Et_get_password.toString().trim();
                                        if (a.equalsIgnoreCase(a1) & b.equalsIgnoreCase(b1)){
                                            Toast.makeText(getActivity(),"Log in",Toast.LENGTH_SHORT).show();
                                           // FragmentTransaction fr = getFragmentManager().beginTransaction();
                                           // fr.replace(R.id.btn_Log_in,new HomeFragment());
                                           // fr.commit();

                                        }else{
                                            Toast.makeText(getActivity(),"Cannot login , incorrect Email and Password",Toast.LENGTH_SHORT).show();
                                        }

                                }
                            }
                        }
                    });
                }

            }

        });
        return view;


    }
}