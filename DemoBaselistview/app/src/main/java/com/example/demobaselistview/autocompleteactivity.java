package com.example.demobaselistview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class autocompleteactivity extends AppCompatActivity {
    AutoCompleteTextView actmonhoc;
    ArrayAdapter adapter;
    List<String> listmonhoc;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete);
        actmonhoc = findViewById(R.id.actmonhoc);
        listmonhoc = new ArrayList<>();
        listmonhoc.add("Lap trinh Java");
        listmonhoc.add("Lap trinh Android");
        listmonhoc.add("Lap trinh iOS");
        listmonhoc.add("Lap trinh PHP");
        adapter = new ArrayAdapter(autocompleteactivity.this, android.R.layout.simple_dropdown_item_1line, listmonhoc);
        actmonhoc.setAdapter(adapter);
        actmonhoc.setThreshold(1);


    }
}
