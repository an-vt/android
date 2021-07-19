package com.example.asyntaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("thongtinsv");
        String hoten = intent.getStringExtra("hoten");
        int tuoi = intent.getIntExtra("tuoi",0);
        boolean gioiTinh = intent.getBooleanExtra("gioiTinh", false);
        float diemTB = intent.getFloatExtra("diemTB",0);
        Student s2 = (Student) intent.getSerializableExtra("sinhvien");
        Student s = new Student(hoten, tuoi, gioiTinh, diemTB);
        Toast.makeText(this, ""+s2, Toast.LENGTH_LONG).show();
        Toast.makeText(this, ""+s, Toast.LENGTH_LONG).show();
    }
}
