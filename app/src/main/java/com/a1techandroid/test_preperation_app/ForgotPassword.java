package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText email;
    Button resetPassword, backButton;
    SpinKitView spinKitView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        mAuth = FirebaseAuth.getInstance();
        init();
        setUpClick();
    }

    private void setUpClick() {
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()){
                    Toast.makeText(ForgotPassword.this, "Enter your email", Toast.LENGTH_SHORT).show();
                }else {
                    spinKitView.setVisibility(View.VISIBLE);
                    spinKitView.animate();
                    resetPassword(email.getText().toString());
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init(){
        email= findViewById(R.id.email);
        resetPassword= findViewById(R.id.btn_reset_password);
        backButton= findViewById(R.id.btn_back);
        spinKitView =  findViewById(R.id.spin_kit);
        spinKitView.setVisibility(View.INVISIBLE);

    }

    private  void resetPassword(String emailAddress){
        mAuth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        spinKitView.setVisibility(View.INVISIBLE);
                        spinKitView.clearAnimation();
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPassword.this, "Reset Password Email Succeesfuly Send", Toast.LENGTH_SHORT).show();
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        }else {
                            Toast.makeText(ForgotPassword.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
//                        selectImageFromDialog.dismiss();

                    }
                });

    }
}
