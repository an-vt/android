package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteReadActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtTextSave, edtTextRead;
    Button btnSave, btnRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_read);
        mapping();
        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    private void mapping() {
        edtTextRead = findViewById(R.id.edtTextRead);
        edtTextSave = findViewById(R.id.edtTextSave);
        btnSave = findViewById(R.id.btnSaveToFile);
        btnRead = findViewById(R.id.btnReadFromFile);
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btnSaveToFile:
                String textSave = edtTextSave.getText().toString();
                writeData(textSave);
               break;
           case R.id.btnReadFromFile:
                String textRead = readData();
                edtTextRead.setText(textRead);
               break;

       }
    }

    private String readData() {
        FileInputStream fileInputStream = null;
        String retval = "";
        try{
            fileInputStream = openFileInput("testData.txt");
            byte[] buffer = new byte[1024];
            int count = fileInputStream.read(buffer);
            retval = new String(buffer);
            fileInputStream.close();
            Toast.makeText(this, "Doc du lieu thanh cong!!", Toast.LENGTH_SHORT).show();
        }catch(IOException e){
            e.printStackTrace();
        }
        return retval;
    }

    private void writeData(String text) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("testData.txt", MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Ghi du lieu thanh cong!!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}