package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.a1techandroid.test_preperation_app.Custom.UserModel;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import es.dmoral.toasty.Toasty;

public class SignupActivty extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText etEmail, etPassword, etFirstName;
    private Button signUpButton;
    private TextView btnLogin;
    SpinKitView spinKitView;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");
        init();
        setUpClick();
    }
    private void init(){
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etFirstName=findViewById(R.id.tvFirstName);
        signUpButton=findViewById(R.id.btnSignUp);
        btnLogin=findViewById(R.id.login_textview);
        spinKitView =  findViewById(R.id.spin_kit);
        spinKitView.setVisibility(View.INVISIBLE);

        etFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               if (s.toString().contains("0123456789")){
                   Toast.makeText(SignupActivty.this, "Numbers are not allowed", Toast.LENGTH_SHORT).show();
               }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String location_name=s.toString();

//                if (location_name.matches(".*[^a-z^].*")) {
//                    location_name = location_name.replaceAll("[^a-z^0-9]", "");
//                    etFirstName.clearComposingText();
//                    Toast.makeText(getApplicationContext(),"Only lowercase letters and numbers are allowed!",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(),"Only ",Toast.LENGTH_SHORT).show();
//
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("textBefore","");
            }
        });

    }

    private void setUpClick(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
                    Toasty.error(getApplicationContext(), "Please Enter Your Credentials", Toast.LENGTH_SHORT, true).show();
//                    Toast.makeText(SignupActivty.this, "Please Enter Your Credentials", Toast.LENGTH_SHORT).show();
                }else {
                   captchaFunction();
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivty.this, LoginActivty.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });
    }

    private void signUp(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        spinKitView.setVisibility(View.INVISIBLE);
                        spinKitView.clearAnimation();
                        if (task.isSuccessful()) {
                            UserModel userModel = new UserModel(etFirstName.getText().toString(), email);
                            myRef.push().setValue(userModel);
                            Toasty.success(getApplicationContext(), "Successfully Signup!", Toast.LENGTH_SHORT, true).show();
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                        } else {
                            Toasty.error(getApplicationContext(), "Authentication Field", Toast.LENGTH_SHORT, true).show();

                            // If sign in fails, display a message to the user.
//                            Toast.makeText(SignupActivty.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    private void updateUI(Object o) {
        Intent i = new Intent(SignupActivty.this, LoginActivty.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    public  void captchaFunction(){
//        SafetyNet.getClient(this).verifyWithRecaptcha("6LehQZgdAAAAAN2U3IbDVw6Uytn7lw3YOcxvLMuq")
//                .addOnSuccessListener((Executor) this,
//                        new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
//                            @Override
//                            public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
//                                // Indicates communication with reCAPTCHA service was
//                                // successful.
//                                String userResponseToken = response.getTokenResult();
//                                if (!userResponseToken.isEmpty()) {
//                                    // Validate the user response token using the
//                                    // reCAPTCHA siteverify API.
//
//                                    Toasty.success(SignupActivty.this, "Success");
//                                    signUp(etEmail.getText().toString(), etPassword.getText().toString());
//                                    spinKitView.setVisibility(View.VISIBLE);
//                                    spinKitView.animate();
//                                }
//                            }
//                        })
//                .addOnFailureListener((Executor) this, new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        if (e instanceof ApiException) {
//                            // An error occurred when communicating with the
//                            // reCAPTCHA service. Refer to the status code to
//                            // handle the error appropriately.
//                            ApiException apiException = (ApiException) e;
//                            int statusCode = apiException.getStatusCode();
//                            Toasty.error(SignupActivty.this, "Something went wrong");
//
//                        } else {
//                            // A different, unknown type of error occurred.
//                            Toasty.error(SignupActivty.this, "Something went wrong");
//                        }
//                    }
//                });

        SafetyNet.getClient(this).verifyWithRecaptcha("6LehQZgdAAAAAN2U3IbDVw6Uytn7lw3YOcxvLMuq")
                .addOnSuccessListener(new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(@NonNull SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                        String userResponseToken = recaptchaTokenResponse.getTokenResult();
                        if (!userResponseToken.isEmpty()) {
                            // Validate the user response token using the
                            // reCAPTCHA siteverify API.

                            Toasty.success(SignupActivty.this, "Success");
                            signUp(etEmail.getText().toString(), etPassword.getText().toString());
                            spinKitView.setVisibility(View.VISIBLE);
                            spinKitView.animate();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ApiException) {
                    // An error occurred when communicating with the
                    // reCAPTCHA service. Refer to the status code to
                    // handle the error appropriately.
                    ApiException apiException = (ApiException) e;
                    int statusCode = apiException.getStatusCode();
                    Toasty.error(SignupActivty.this, "Something went wrong");

                } else {
                    // A different, unknown type of error occurred.
                    Toasty.error(SignupActivty.this, "Something went wrong");
                }
            }
        });
    }
}