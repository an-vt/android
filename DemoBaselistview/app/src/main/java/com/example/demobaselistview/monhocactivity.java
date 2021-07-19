package com.example.demobaselistview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class monhocactivity extends AppCompatActivity {
    Button btnADD, btnEDIT;
    EditText edtmonhoc;
    ListView lvmonhoc;
    List<String> listmonhoc;
    ArrayAdapter adapter;
    int index = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monhoc);
        lvmonhoc = findViewById(R.id.lvmonhoc);
        btnADD = findViewById(R.id.btnADD);
        btnEDIT = findViewById(R.id.btnEDIT);
        edtmonhoc = findViewById(R.id.edtmonhoc);
        listmonhoc = new ArrayList<>();
        listmonhoc.add("Lap trinh Java");
        listmonhoc.add("Lap trinh Android");
        listmonhoc.add("Lap trinh iOS");
        listmonhoc.add("Lap trinh PHP");
        adapter = new  ArrayAdapter(monhocactivity.this, android.R.layout.simple_list_item_1, listmonhoc);
        lvmonhoc.setAdapter(adapter);
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(monhocactivity.this, "vi tri click: "+i, Toast.LENGTH_SHORT).show();
                String monhoc = listmonhoc.get(i);
                edtmonhoc.setText(monhoc);
                index = i;
            }
        });
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(monhocactivity.this);
                builder.setTitle("Xac nhan xoa!");
                builder.setMessage("Ban muon xoa mon hoc: "+listmonhoc.get(index)+" ?");
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        listmonhoc.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                builder.show();




            }
        });

    }
    public void addmonhoc(View view){
        String monhoc = edtmonhoc.getText().toString();
        listmonhoc.add(monhoc);
        adapter.notifyDataSetChanged();
    }
    public void editmonhoc(View view){
        String monhoc = edtmonhoc.getText().toString();
        listmonhoc.set(index, monhoc);
        adapter.notifyDataSetChanged();
    }
}
