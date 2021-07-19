package com.vuan.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvTuong;
    List<TuongYeuThich> list;
    TuongYTAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTuong = findViewById(R.id.lvTuong);
        list = new ArrayList<>();
        list.add(new TuongYeuThich(R.drawable.yasou1 ,"Yasou" ,"Da loc trung la phai until" ,R.drawable.anhdaidien));
        list.add(new TuongYeuThich(R.drawable.zed ,"Zed" ,"blabla" ,R.drawable.anhdaidien));
        list.add(new TuongYeuThich(R.drawable.masteryi ,"MasterYi" ,"blabla" ,R.drawable.anhdaidien));
        list.add(new TuongYeuThich(R.drawable.xinzhao ,"XinZhao" ,"blabla" ,R.drawable.anhdaidien));
        list.add(new TuongYeuThich(R.drawable.tristana ,"Tristana" ,"blabla" ,R.drawable.anhdaidien));
        list.add(new TuongYeuThich(R.drawable.jax ,"Jax" ,"blabla" ,R.drawable.anhdaidien));
        adapter = new TuongYTAdapter(MainActivity.this , R.layout.activity_line_tuong ,list);
        lvTuong.setAdapter(adapter);
    }
}