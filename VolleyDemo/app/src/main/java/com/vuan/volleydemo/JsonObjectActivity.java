package com.vuan.volleydemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        String url = "https://mocki.io/v1/ccc6616b-d75a-4cbb-a830-05cc3de2bdb8";
        String url = "http://192.168.43.90:4000/api/product/60c0f7b94805982a240a891a";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String name = response.getString("name");
//                            String ngaySinh = response.getString("ngaySinh");
//                            String queQuan = response.getString("queQuan");
//                            String sdt = response.getString("sdt");
//                            String email = response.getString("email");
                            Toast.makeText(JsonObjectActivity.this, "1", Toast.LENGTH_SHORT).show();
//                            Toast.makeText(JsonObjectActivity.this, ""+ngaySinh, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(JsonObjectActivity.this, ""+queQuan, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(JsonObjectActivity.this, ""+sdt, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(JsonObjectActivity.this, ""+email, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
