package com.example.demoanytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InternImplicitActivity extends AppCompatActivity  implements View.OnClickListener {
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE = 555;
    ImageView imgChrome, imgCamera, imgMessage, imgGallery, imgPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern_implicit);
        mapping();
        imgPhone.setOnClickListener(this);
    }

    private void mapping() {
        imgChrome = findViewById(R.id.imageChrome);
        imgCamera = findViewById(R.id.imageCamera);
        imgGallery = findViewById(R.id.imageGallery);
        imgMessage = findViewById(R.id.imageMessage);
        imgPhone = findViewById(R.id.imagePhone);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imagePhone:
                askPermissionAndCall();
                break;

        }
    }

    private void askPermissionAndCall() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) { // 23

            // Check if we have Call permission
            int sendSmsPermisson = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE);

            if (sendSmsPermisson != PackageManager.PERMISSION_GRANTED) {
                // If don't have permission so prompt the user.
                this.requestPermissions(
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSION_REQUEST_CODE_CALL_PHONE
                );
                return;
            }
        }

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:098888888"));
        startActivity(intent);
    }
}