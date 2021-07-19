package com.vuan.jsondemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonArrayActivity extends AppCompatActivity {
    ListView listViewKhoaHoc;
    List<String> listKhoaHoc;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonarray);
        new ReadJsonAray().execute("https://mocki.io/v1/7cb11fb8-6407-4b04-bc41-8e8a099cebae");
    }

    class ReadJsonAray extends AsyncTask<String ,Void ,String> {
        StringBuilder stringBuilder = new StringBuilder();
        @Override
        //du lieu dau vao mang string
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                //doc tung dong trong file json
                //roi ghep lai
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } catch (Exception e) {
                Log.d("error :" ,e.getMessage());
                e.printStackTrace();
            }
            //return tra vef onPostExcute
            return stringBuilder.toString();
        }

        //chi ham nay giao tiep duoc voi layout
        //nhan du lieu doInBackground
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("danhSach");
                listViewKhoaHoc = findViewById(R.id.lvKhoaHoc);
                listKhoaHoc = new ArrayList<>();
                for(int i = 0;i < jsonArray.length() ;i++) {
                    JSONObject khoaHocObj = jsonArray.getJSONObject(i);
                    String khoaHoc = khoaHocObj.getString("khoaHoc");
                    listKhoaHoc.add(khoaHoc);
                }
                adapter = new ArrayAdapter(JsonArrayActivity.this, android.R.layout.simple_list_item_1, listKhoaHoc);
                listViewKhoaHoc.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
