package com.example.demolistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AutoComplateActivity  extends AppCompatActivity {
    AutoCompleteTextView actMonHoc;
    ArrayAdapter adapter;
    List<String> listMonHoc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        actMonHoc  = findViewById(R.id.actMonHoc);
        listMonHoc = new ArrayList<>();
        listMonHoc.add("Lap trinh java");
        listMonHoc.add("Lap trinh android");
        listMonHoc.add("Lap trinh c++");
        listMonHoc.add("Lap trinh ios");
        listMonHoc.add("Lap trinh unity");
        listMonHoc.add("Lap trinh php");
        adapter = new ArrayAdapter(AutoComplateActivity.this, android.R.layout.simple_dropdown_item_1line, listMonHoc);
        actMonHoc.setAdapter(adapter);
        actMonHoc.setThreshold(1);
    }
}

