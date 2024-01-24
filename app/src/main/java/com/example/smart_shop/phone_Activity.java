package com.example.smart_shop;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class phone_Activity extends AppCompatActivity {
    ProgressBar pr_bar;
    Button home_btn;
   EditText ETget_phone_no;
   // private FirebaseAuth mAuth;
    Button btn_get_otp;
    String phoneNumber;
   // private String verificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getphone_no);
     //  mAuth = FirebaseAuth.getInstance();
        pr_bar=findViewById(R.id.pr_bar);
       ETget_phone_no=findViewById(R.id.ETget_phone_no);
       btn_get_otp=findViewById(R.id.btn_get_otp);
       home_btn=findViewById(R.id.home_btn);

       home_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),Home_Activity.class);
               startActivity(i);
           }
       });




       btn_get_otp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               phoneNumber=ETget_phone_no.getText().toString().trim();
               if (phoneNumber.isEmpty()){
                   Toast.makeText(phone_Activity.this,"Please enter a valid phone number",Toast.LENGTH_SHORT).show();
               }else {
                  pr_bar.setVisibility(View.VISIBLE);
                  // Intent i = new Intent(getApplicationContext(),Get_otp_Activity.class);
                  // startActivity(i);
                   sendVerificationCode(phoneNumber);






               }
           }
       });

    }
    private void sendVerificationCode(String phoneNumber){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+phoneNumber,
                30,
                TimeUnit.SECONDS,
                this,
                mCall
        );
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCall=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
        pr_bar.setVisibility(View.GONE);
        }
        public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token){
            pr_bar.setVisibility(View.GONE);
            String mVerificationId = verificationId;
            Log.e("phoneActivity","Verification id : "+verificationId);
            //Intent intent = new Intent(phone_Activity.this , Get_otp_Activity.class);
            Intent intent = new Intent(phone_Activity.this ,Get_otp_Activity.class);
            intent.putExtra("verificationId",mVerificationId);
            startActivity(intent);
            finish();
           // Intent i = new Intent(getApplicationContext(),Get_otp_Activity.class);
           // startActivity(i);
        }
    };
}