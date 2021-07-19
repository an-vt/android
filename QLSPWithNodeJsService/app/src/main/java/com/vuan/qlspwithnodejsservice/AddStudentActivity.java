package com.vuan.qlspwithnodejsservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddStudentActivity extends AppCompatActivity {
    EditText edtHoTen ,edtNgaySinh ,edtDiaChi;
    Button btnAdd ,btnCancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        mapping();

    }

    private void mapping() {
        edtHoTen = findViewById(R.id.editHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void cancel(View view) {
        finish();
    }

    private void insertStudent(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")){
                            Toast.makeText(AddStudentActivity.this, "Thêm mới thành công!!", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(AddStudentActivity.this, "Thêm mới thất bại!!", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(new Intent(AddStudentActivity.this ,MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddStudentActivity.this, error.toString()+" ,có lỗi xảy ra", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String ,String> map =new HashMap<>();
                map.put("hoTen" ,edtHoTen.getText().toString());
                map.put("ngaySinh" ,edtNgaySinh.getText().toString());
                map.put("diaChi" ,edtDiaChi.getText().toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void addStudent(View view) {
        String hoTen = edtHoTen.getText().toString().trim();
        String ngaySinh = edtNgaySinh.getText().toString().trim();
        String diaChi = edtDiaChi.getText().toString().trim();
        if(hoTen.equals("")||ngaySinh.matches("")||diaChi.isEmpty()){
            if(hoTen.equals("")) {
                Toast.makeText(this, "Bạn phải nhập họ tên", Toast.LENGTH_SHORT).show();
                edtHoTen.requestFocus();
            }
            if(ngaySinh.equals("")) {
                Toast.makeText(this, "Bạn phải nhập ngày sinh", Toast.LENGTH_SHORT).show();
                edtNgaySinh.requestFocus();
            }
            if(diaChi.equals("")) {
                Toast.makeText(this, "Bạn phải nhập địa chỉ", Toast.LENGTH_SHORT).show();
                edtDiaChi.requestFocus();
            }

        }else {
            //nhap url tai day
            insertStudent("http://192.168.1.104:4000/api/android/sinh-vien");
        }
        Toast.makeText(this, "add student", Toast.LENGTH_SHORT).show();
    }
}
