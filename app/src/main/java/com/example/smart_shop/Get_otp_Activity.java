package com.example.smart_shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class Get_otp_Activity extends AppCompatActivity {
    Intent intent;
  Button verify_btn;
  ProgressBar pr_br01;
  PinView pinview;
  String verificationId;
  String otp;
 FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp);

       pinview = findViewById(R.id.pinview);
       verify_btn=findViewById(R.id.verify_btn);
       mAuth=FirebaseAuth.getInstance();
       intent = getIntent();
       verificationId=intent.getStringExtra("verificationId");

       verify_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String otp=pinview.getText().toString();

               if(pinview.getText().toString().trim().isEmpty()){
                   Toast.makeText(Get_otp_Activity.this, "Please enter valid code", Toast.LENGTH_SHORT).show();
                   return;
               }
               if(verificationId != null){
                 pr_br01 .setVisibility(View.VISIBLE);
                   PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                           verificationId,
                           otp
                   );
                   FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                           .addOnCompleteListener(task -> {
                       pr_br01.setVisibility(View.GONE);
                       if(task.isSuccessful()){
                           Intent intent = new Intent(getApplicationContext(), Home_Activity.class);
                           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                           startActivity(intent);
                       }else {
                           Toast.makeText(Get_otp_Activity.this, "The verification code entered was invalid", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
           }
       });


    }

}