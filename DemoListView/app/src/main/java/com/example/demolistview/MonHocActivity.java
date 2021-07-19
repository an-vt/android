package com.example.demolistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

public class MonHocActivity extends AppCompatActivity {
    ListView listViewMonHoc;
    List<String> listMonHoc;
    ArrayAdapter adapter;
    EditText edtMonHoc;
    Button btnEdit, btnAdd, btnSwitch;
    int index;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_demo);
        listViewMonHoc = findViewById(R.id.lvMonHoc);
        edtMonHoc = findViewById(R.id.edtMonHoc);
        btnEdit = findViewById(R.id.btnEdit);
        btnAdd  = findViewById(R.id.btnAdd);
        btnSwitch =findViewById(R.id.btnSwitch);
        listMonHoc = new ArrayList<>();
        listMonHoc.add("Lap trinh java");
        listMonHoc.add("Lap trinh android");
        listMonHoc.add("Lap trinh c++");
        listMonHoc.add("Lap trinh ios");
        listMonHoc.add("Lap trinh unity");
        listMonHoc.add("Lap trinh php");
        adapter = new ArrayAdapter(MonHocActivity.this, android.R.layout.simple_list_item_1, listMonHoc);
        listViewMonHoc.setAdapter(adapter);
        listViewMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MonHocActivity.this, "vi tri " + position + " " + id,Toast.LENGTH_SHORT).show();
                String orderMonHoc = listMonHoc.get(position);
                edtMonHoc.setText(orderMonHoc);
                index = position;
            }
        });
        listViewMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MonHocActivity.this);
                builder.setTitle("Confirm remove!");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setMessage("Ban co muoon xoa mon hoc: " + listMonHoc.get(position) + " ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listMonHoc.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return false;
            }
        });
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonHocActivity.this, AutoComplateActivity.class);
                startActivity(intent);

            }
        });
    }
    public void addMonHoc(View view){
        String strBox = edtMonHoc.getText().toString();
        listMonHoc.add(strBox);
        adapter.notifyDataSetChanged();

    }

    public void editMonHoc(View view){
        String strBox = edtMonHoc.getText().toString();
        listMonHoc.set(index, strBox);
        adapter.notifyDataSetChanged();
    }
}
