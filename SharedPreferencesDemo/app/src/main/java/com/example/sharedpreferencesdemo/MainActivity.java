package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap, btnHuy;
    EditText edtUserName, edtPassword;
    CheckBox chkLuuTT;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        edtUserName.setText(sharedPreferences.getString("userName",""));
        edtPassword.setText(sharedPreferences.getString("password",""));
        chkLuuTT.setChecked(sharedPreferences.getBoolean("isCheck",false));
    }

    public void mapping(){
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnHuy = findViewById(R.id.btnHuy);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtiPassword);
        chkLuuTT = findViewById(R.id.chkLuuTT);
    }

    public void login(View view){
        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        boolean isCheck = chkLuuTT.isChecked();
        if(userName.equals("admin") && password.equals("123456")){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if(isCheck){
                editor.putString("userName", userName);
                editor.putString("password", password);
                editor.putBoolean("isCheck", isCheck);
                editor.commit();
            }else{
                editor.remove("userName");
                editor.remove("password");
                editor.remove("isCheck");
                editor.commit();
            }
            Toast.makeText(this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();

        }
    }

    public  void cancel(View view){

    }

}