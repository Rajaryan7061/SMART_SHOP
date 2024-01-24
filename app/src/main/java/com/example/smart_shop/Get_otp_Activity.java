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
             //  String otp=pinview.getText().toString();
               String otp =pinview.getText().toString();
               if(!otp.isEmpty()){
                   pr_br01.setVisibility(View.VISIBLE);
                   Intent i = new Intent(getApplicationContext(),Get_otp_Activity.class);
                    startActivity(i);
                   verifyOtp(verificationId ,otp);


               }else {
                   pinview.setError("Invalid otp please try again");
               }
           }
       });


    }
    private  void verifyOtp(String verificationId , String otp ){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,otp);
        signInWithPhoneAuthCredential(credential);
    }
    private  void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            pr_br01.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(Get_otp_Activity.this , Home_Activity.class);
                            startActivity(intent);
                            finish();
                            //Intent i = new Intent(getApplicationContext(),Home_Activity.class);
                           // startActivity(i);
                           // Intent i = new Intent(getApplicationContext(),Get_otp_Activity.class);
                            // startActivity(i);
                        }
                        else{
                            pr_br01.setVisibility(View.INVISIBLE);
                           String message = "Verification failed , Please try again later .";
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                               message = "Invalid code entered...";
                            }
                            Toast.makeText(Get_otp_Activity.this , message, Toast.LENGTH_SHORT).show();
                      }
                    }
                });
   }

}