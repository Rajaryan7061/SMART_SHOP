package com.example.smart_shop;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    EditText et_ent_shp_name,et_email,et_password,et_phone_shop,et_address_shop;
    TextView tv_shop_register,log_in;
    FirebaseFirestore firebaseFirestore;
    DocumentReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseFirestore=FirebaseFirestore.getInstance();
        ref = firebaseFirestore.collection("client").document();
        setContentView(R.layout.activity_signup);
        et_ent_shp_name=findViewById(R.id.et_ent_shp_name);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        et_address_shop=findViewById(R.id.et_address_shop);
        et_phone_shop=findViewById(R.id.et_phone_shop);
        tv_shop_register=findViewById(R.id.tv_shop_register);
        log_in=findViewById(R.id.log_in);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginFragment.class);
                startActivity(intent);
            }
        });
        tv_shop_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( et_ent_shp_name.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this,"Please Enter your shop name ",Toast.LENGTH_SHORT).show();
                   // String str=et_ent_shp_name.getText().toString();
                  //  Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                  //  intent.putExtra("message_key",str);
                  //  startActivity(intent);
                   // Toast.makeText(SignupActivity.this,"Please Enter your shop name ",Toast.LENGTH_SHORT).show();

                }else if(et_email.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this,"Please Enter your Email",Toast.LENGTH_SHORT).show();

                }else  if(et_password.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this,"Please Enter your Password",Toast.LENGTH_SHORT).show();
                } else if (et_address_shop.getText().toString().isEmpty()) {

                    Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                    intent.putExtra("message_key",et_address_shop.getText().toString());
                   // intent.putExtra("Shop_Name",et_ent_shp_name.getText());
                    startActivity(intent);
                    Toast.makeText(SignupActivity.this,"Please Enter your Address",Toast.LENGTH_SHORT).show();
                } else if (et_phone_shop.getText().toString().isEmpty()) {
                    Toast.makeText(SignupActivity.this,"Please Enter your Phone number",Toast.LENGTH_SHORT).show();
                }else {
                    ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){
                                Toast.makeText(SignupActivity.this,"Sorry,this user is exists",Toast.LENGTH_SHORT).show();
                            }else {
                                Map<String,Object> reg_entry=new HashMap<>();
                                reg_entry.put("ShopName",et_ent_shp_name.getText().toString());
                                reg_entry.put("Email",et_email.getText().toString());
                                reg_entry.put("Password",et_password.getText().toString());
                                reg_entry.put("Address",et_address_shop.getText().toString());
                                reg_entry.put("Phone",et_phone_shop.getText().toString());

                                firebaseFirestore.collection("Shop").add(reg_entry).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Toast.makeText(SignupActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                                       // Intent intent = new Intent(getApplicationContext(), ProfileActivity. class);
                                        String str=et_ent_shp_name.getText().toString();
                                        String str1=et_address_shop.getText().toString();
                                         // Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                                         // intent.putExtra("message_key",str);
                                         //startActivity(intent);
                                        Intent intent=new Intent (SignupActivity.this, ProfileActivity.class);
                                        intent.putExtra("Shop_Name",str);
                                        intent.putExtra("Shop_Address",str1);
                                        startActivity(intent);
                                        finish();


                                    }
                                })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d("Error", e.getMessage());

                                            }
                                        });
                            }
                        }
                    });
                }
            }
        });


    }
}