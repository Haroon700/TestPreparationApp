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
import com.google.firebase.auth.FirebaseUser;

public class UpdatePasswordActivity extends AppCompatActivity {
    EditText email, pass1, pass2;
    Button resetPassword, backButton;
    SpinKitView spinKitView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        init();
        setUpClick();
//        loadFragment();
    }

    private void init(){
        email= findViewById(R.id.email);
        pass1= findViewById(R.id.password1);
        pass2= findViewById(R.id.password2);
        resetPassword= findViewById(R.id.btn_reset_password);
        spinKitView =  findViewById(R.id.spin_kit);
        spinKitView.setVisibility(View.INVISIBLE);
    }

    private void setUpClick() {
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() || pass1.getText().toString().isEmpty() || pass2.getText().toString().isEmpty()){
                    Toast.makeText(UpdatePasswordActivity.this, "Enter your all fields", Toast.LENGTH_SHORT).show();
                }else {
                    spinKitView.setVisibility(View.VISIBLE);
                    spinKitView.animate();
                    updatePassword(email.getText().toString());
                }
            }
        });

    }


    private void updatePassword(String password){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String newPassword = password;

        user.updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(UpdatePasswordActivity.this, "User password updated", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(UpdatePasswordActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
