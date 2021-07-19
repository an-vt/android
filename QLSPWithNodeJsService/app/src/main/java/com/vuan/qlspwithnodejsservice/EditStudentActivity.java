package com.vuan.qlspwithnodejsservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

public class EditStudentActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtHoTen ,edtNgaySinh ,edtDiaChi;
    Button btnEdit ,btnCancel;
    String idEdit = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        mapping();
        btnEdit.setOnClickListener(this);
        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("studentEdit");
        edtHoTen.setText(student.getHoTen());
        edtNgaySinh.setText(student.getNgaySinh());
        edtDiaChi.setText(student.getDiaChi());
        idEdit = student.getId();
    }

    private void mapping() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        btnEdit = findViewById(R.id.btnEdit);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void editStudent(View view) {
        Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
    }

    public void cancel(View view) {
        Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEdit:
                editStudent("http://192.168.1.104:4000/api/android/sinh-vien/"+idEdit);
                break;
            case R.id.btnCancel:
//                confirmStudent("http://192.168.1.104:4000/api/android/sinh-vien/"+idEdit);
                break;
        }
    }

    private void editStudent(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")) {
                            Toast.makeText(EditStudentActivity.this, "Sửa thành công", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(EditStudentActivity.this ,MainActivity.class));
                        }else {
                            Toast.makeText(EditStudentActivity.this, "Sửa không thành công", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditStudentActivity.this, "Có lỗi trong quá trình sửa", Toast.LENGTH_LONG).show();
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

//    private void confirmStudent(String hoTen) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Canh bao !");
//        builder.setIcon(android.R.drawable.ic_delete);
//        builder.setMessage("Ban co chac chan muon xoa"+hoTen+" ?");
//        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                deleteStudent();
//            }
//        });
//        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//    }
}
