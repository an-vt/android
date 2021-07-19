package com.example.demoanytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ResultActivity extends AppCompatActivity {
    Button btnBack, btnSend;
    EditText edtHoTen, edtTuoi, edtDiemTrungBinh;
    RadioButton rdbNam, rdbNu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mapping();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString();
                int tuoi = Integer.parseInt(edtTuoi.getText().toString());
                boolean gioiTinh = false;
                if(rdbNam.isChecked()){
                    gioiTinh = true;
                }
                if(rdbNu.isChecked()){
                    gioiTinh = false;
                }
                float diemTrungBinh = Float.parseFloat(edtDiemTrungBinh.getText().toString());
                Intent intent = new Intent(ResultActivity.this, ConfirmActivity.class);
                intent.putExtra("hoTen", hoTen);
                intent.putExtra("tuoi", tuoi);
                intent.putExtra("gioiTinh", gioiTinh);
                intent.putExtra("diemTrungBinh", diemTrungBinh);
                Student s = new Student(hoTen, tuoi, gioiTinh, diemTrungBinh);
                intent.putExtra("sinhVien", s);
                startActivity(intent);
                setTextEmpty();
            }

        });
    }

    private void setTextEmpty() {
        edtHoTen.setText("");
        edtTuoi.setText("");
        edtDiemTrungBinh.setText("");
        rdbNam.setChecked(false);
        rdbNu.setChecked(false);
    }

    private void mapping() {
        btnBack = findViewById(R.id.btnBack);
        btnSend = findViewById(R.id.btnSend);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtTuoi = findViewById(R.id.edtTuoi);
        edtDiemTrungBinh = findViewById(R.id.edtDiemTrungBinh);
        rdbNam = findViewById(R.id.rdbNam);
        rdbNu = findViewById(R.id.rdbNu);
    }


}