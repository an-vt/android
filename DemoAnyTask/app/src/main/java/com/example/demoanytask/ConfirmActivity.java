package com.example.demoanytask;

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
        String hoTen = intent.getStringExtra("hoTen");
        int tuoi = intent.getIntExtra("tuoi", 0);
        boolean gioiTinh = intent.getBooleanExtra("gioiTinh", false);
        float diemTrungBinh = intent.getFloatExtra("diemTrungBinh", 0);
        Student s2 = (Student) intent.getSerializableExtra("sinhVien");
        Toast.makeText(this, "" +s2 + "s2", Toast.LENGTH_LONG).show();
        Student s = new Student(hoTen, tuoi, gioiTinh, diemTrungBinh);
        Toast.makeText(this, "" +s + "s", Toast.LENGTH_LONG).show();
    }
}