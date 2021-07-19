package com.example.demoqlcongviec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     EditText edtCongViec, edtNoiDung;
     TextView txtvNgayCongViec, txtvGioCongViec;
     Button btnChonNgay, btnChonGio, btnThemCongViec;
     ListView lvDanhSachCongViec;
     ArrayAdapter adapter;
     List<String> listCongViec = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listCongViec);
        lvDanhSachCongViec.setAdapter(adapter);
        btnChonNgay.setOnClickListener(this);
        btnChonGio.setOnClickListener(this);
        btnThemCongViec.setOnClickListener(this);
    }

    private void mapping() {
        edtCongViec = findViewById(R.id.edtCongViec);
        edtNoiDung = findViewById(R.id.edtNoiDung);
        txtvNgayCongViec = findViewById(R.id.txtvNgayCongViec);
        txtvGioCongViec = findViewById(R.id.txtvGioCongViec);
        btnChonNgay = findViewById(R.id.btnChonNgay);
        btnChonGio = findViewById(R.id.btnChonGio);
        btnThemCongViec = findViewById(R.id.btnThemCongViec);
        lvDanhSachCongViec = findViewById(R.id.lvDanhSachCongViec);

    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes= calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        switch (view.getId()){
            case R.id.btnChonNgay:
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Calendar chooseDate = Calendar.getInstance();
                            chooseDate.set(i, i1, i2);
                            String strDate = simpleDateFormat.format(chooseDate.getTime());
                            txtvNgayCongViec.setText(strDate);
                        }
                    },year, month, day
                   );
                datePickerDialog.show();
                break;
            case R.id.btnChonGio:
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                Calendar chooseTime = Calendar.getInstance();
                                chooseTime.set(year,month,day,i,i1);
                                String strTime = simpleDateFormat.format(chooseTime.getTime());
                                txtvGioCongViec.setText(strTime);

                            }
                        }, hour, minutes, true
                );
                timePickerDialog.show();
                break;
            case R.id.btnThemCongViec:
                String tenCongViec = edtCongViec.getText().toString();
                String ngayCongViec = txtvNgayCongViec.getText().toString();
                String gioCongViec = txtvGioCongViec.getText().toString();
                listCongViec.add(tenCongViec+" - "+ngayCongViec+" - "+gioCongViec);
                adapter.notifyDataSetChanged();
        }
    }
}