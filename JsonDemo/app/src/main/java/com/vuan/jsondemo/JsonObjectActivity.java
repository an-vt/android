package com.vuan.jsondemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonObjectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonobject);
        //de chay duoc thi goi ham
//        https://mocki.io/v1/ac76cfb8-2c8a-4ee5-9848-0af1fb0ccac7
//        http://localhost:4000/api/product/60c0f7b94805982a240a891a
        new ReadJsonObject().execute("https://mocki.io/v1/ac76cfb8-2c8a-4ee5-9848-0af1fb0ccac7");
    }

    //param1 url
    //param2 void
    //param3 content
    //khong giao tiep duoc voi layout
    class ReadJsonObject extends AsyncTask<String ,Void ,String>{
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
                String hoTen = jsonObject.getString("hoTen");
                String ngaySinh = jsonObject.getString("ngaySinh");
                String queQuan = jsonObject.getString("queQuan");
                String sdt = jsonObject.getString("sdt");
                String email = jsonObject.getString("email");
//                listMonHoc = new ArrayList<>();
                Toast.makeText(JsonObjectActivity.this, ""+hoTen, Toast.LENGTH_SHORT).show();
                Toast.makeText(JsonObjectActivity.this, ""+ngaySinh, Toast.LENGTH_SHORT).show();
                Toast.makeText(JsonObjectActivity.this, ""+queQuan, Toast.LENGTH_SHORT).show();
                Toast.makeText(JsonObjectActivity.this, ""+sdt, Toast.LENGTH_SHORT).show();
                Toast.makeText(JsonObjectActivity.this, ""+email, Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
