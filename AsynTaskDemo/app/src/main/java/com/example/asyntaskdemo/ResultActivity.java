package com.example.asyntaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ResultActivity extends AppCompatActivity {
    EditText edtHoTen, edtTuoi, edtDiemTB;
    RadioButton rdNam, rdNu;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mapping();
        (findViewById(R.id.btnBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtHoTen.getText().toString();
                int tuoi = Integer.parseInt(edtTuoi.getText().toString());
                boolean gioitinh = false;
                if (rdNam.isChecked())
                    gioitinh = true;
                else if (rdNu.isChecked())
                    gioitinh = false;
                float diemTB = Float.parseFloat(edtDiemTB.getText().toString());
                Intent intent = new Intent(ResultActivity.this, ConfirmActivity.class);
                //intent.putExtra("hoten", hoten);
                //intent.putExtra("tuoi", tuoi);
                //intent.putExtra("gioitinh", gioitinh);
                //intent.putExtra("diemTB", diemTB);
                //Student s = new Student(hoten, tuoi, gioitinh, diemTB);
                //intent.putExtra("sinhvien", s);
                Bundle bundle = new Bundle();
                bundle.putString("hoten", hoten);
                bundle.putInt("tuoi", tuoi);
                bundle.putBoolean("gioitinh", gioitinh);
                bundle.putFloat("diemTB", diemTB);
                Student s = new Student(hoten, tuoi, gioitinh, diemTB);
                bundle.putSerializable("sinhvien", s);
                intent.putExtra("thongtinsv", bundle);
                startActivity(intent);
            }
        });
    }

    private void mapping() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtTuoi = findViewById(R.id.edtTuoi);
        edtDiemTB = findViewById(R.id.edtDiemTB);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNữ);
        btnSend = findViewById(R.id.btnSend);
    }
}
