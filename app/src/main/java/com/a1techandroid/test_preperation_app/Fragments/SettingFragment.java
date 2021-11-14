package com.a1techandroid.test_preperation_app.Fragments;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.a1techandroid.test_preperation_app.LoginActivty;
import com.a1techandroid.test_preperation_app.MainActivity;
import com.a1techandroid.test_preperation_app.R;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class SettingFragment extends Fragment {
    Button signOut;
    ImageView cameraButton;
    CircleImageView circleImageView;
    Dialog selectImageFromDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), LoginActivty.class));
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageSelectDialog();
            }
        });
    }

    private void initView(View v){
        signOut = v.findViewById(R.id.signOut);
        circleImageView = v.findViewById(R.id.profile_image);
        cameraButton = v.findViewById(R.id.btnCamera);
    }

    private void pickImage(){
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, 1);
        }
    }

    private void openCamera(){
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.CAMERA}, 2);
        } else {
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePicture, 2);
        }
    }

    public void showImageSelectDialog()
    {
        selectImageFromDialog = new Dialog(getActivity());
        selectImageFromDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        selectImageFromDialog.setContentView(R.layout.dialog_select_image_from);

        final TextView projectName = (TextView) selectImageFromDialog.findViewById(R.id.heading);
        final TextView galleryButton = (TextView) selectImageFromDialog.findViewById(R.id.btnChooseFromGallery);
        final TextView takePhotoButton = (TextView) selectImageFromDialog.findViewById(R.id.btnTakePhoto);

        galleryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(), new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                    //  Toast.makeText(ActivityProfile.this, "Please Allow Camera Permission First", Toast.LENGTH_SHORT).show();
                }else {
                    pickImage();
                }}
        });
        takePhotoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(), new String[] {android.Manifest.permission.CAMERA}, 2);

                    //  Toast.makeText(ActivityProfile.this, "Please Allow Camera Permission First", Toast.LENGTH_SHORT).show();
                }else {
                    openCamera();
                }}
        });


        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = selectImageFromDialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        selectImageFromDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    circleImageView.setImageURI(selectedImage);
                }

                break;
            case 2:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    circleImageView.setImageURI(selectedImage);
                }
                break;
        }
    }
}
