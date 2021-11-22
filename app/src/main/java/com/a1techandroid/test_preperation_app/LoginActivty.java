package com.a1techandroid.test_preperation_app;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.Arrays;

import es.dmoral.toasty.Toasty;


public class LoginActivty extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText etEmail, etPassword;
    private Button loginButton;
    private TextView btn_singup;
    CallbackManager callbackManager;
    LoginButton loginButton1;
    GoogleSignInClient mGoogleSignInClient;
    RelativeLayout forgotPassword, googleBtn;
    Dialog selectImageFromDialog;
    SpinKitView spinKitView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();

        init();
        setUpClick();
        googleSignIn();
        loginButton();
    }

    private void init(){
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        loginButton=findViewById(R.id.b_login);
        loginButton1 = (LoginButton) findViewById(R.id.login_button);
        btn_singup =  findViewById(R.id.btn_singup);
        googleBtn =  findViewById(R.id.googleBtn);
        forgotPassword =  findViewById(R.id.forgot_layout);
        spinKitView =  findViewById(R.id.spin_kit);
        spinKitView.setVisibility(View.INVISIBLE);
        loginButton1.setReadPermissions(Arrays.asList("haroon.chudhary555@gmail.com"));
        Log.i("test", "test");

    }

    private void setUpClick(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
                    Toasty.error(getApplicationContext(), "Please Enter Your Credentials", Toast.LENGTH_SHORT, true).show();
                }else {
                    spinKitView.setVisibility(View.VISIBLE);
                    spinKitView.animate();
                    login(etEmail.getText().toString(), etPassword.getText().toString());
                }

            }
        });

        btn_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivty.this, SignupActivty.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivty.this, ForgotPassword.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                finish();
//                showDialog();
            }
        });
    }

    private void login(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        spinKitView.setVisibility(View.INVISIBLE);
                        spinKitView.clearAnimation();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toasty.success(getApplicationContext(), "Successfully Login!", Toast.LENGTH_SHORT, true).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Toasty.error(getApplicationContext(), "Authentication Field", Toast.LENGTH_SHORT, true).show();

                            // If sign in fails, display a message to the user.
//                            Toast.makeText(LoginActivty.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void updateUI(Object o) {
        Intent i = new Intent(LoginActivty.this, MainActivity.class);
        startActivity(i);
        finish();
    }


    // google Signin
    private void googleSignIn(){
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.com_facebook_tooltip_default))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 123);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 123) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
            }
        }else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivty.this, "Success Signin", Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            updateUI(null);
                        }
                    }
                });
    }

    // facebook signin

    private void loginButton(){
        loginButton1.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Pass the activity result back to the Facebook SDK
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }

    private void handleFacebookAccessToken(AccessToken token) {

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivty.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private  void resetPassword(String emailAddress){
        mAuth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivty.this, "Reset Password Email Succeesfuly Send", Toast.LENGTH_SHORT).show();
                        }
                        selectImageFromDialog.dismiss();

                    }
                });

    }

    public void showDialog()
    {
        selectImageFromDialog = new Dialog(LoginActivty.this);
        selectImageFromDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        selectImageFromDialog.setContentView(R.layout.forget_password_dialog);

        final TextView projectName = (TextView) selectImageFromDialog.findViewById(R.id.heading);
        final TextView send = (TextView) selectImageFromDialog.findViewById(R.id.btnReset);
        final EditText etEmail =  selectImageFromDialog.findViewById(R.id.etEmail);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etEmail.getText().toString().equals("")){
                    Toast.makeText(LoginActivty.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }else {
                    resetPassword(etEmail.getText().toString());

                }
                }
        });


        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = selectImageFromDialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        selectImageFromDialog.show();
    }
}