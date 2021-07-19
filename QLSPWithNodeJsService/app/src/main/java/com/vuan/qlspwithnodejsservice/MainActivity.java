package com.vuan.qlspwithnodejsservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> studentList;
    StudentAdapter adapter = null;
    ListView lvStudent;
    Menu menuAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvStudent = findViewById(R.id.lvStudent);
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(MainActivity.this ,R.layout.activity_line_student ,studentList);
        lvStudent.setAdapter(adapter);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.104:4000/api/android/sinh-vien";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
//                                Toast.makeText(MainActivity.this, "" + jsonObject.get("_id"), Toast.LENGTH_SHORT).show();
                                studentList.add(new Student(jsonObject.getString("_id"), jsonObject.getString("hoTen")
                                        , jsonObject.getString("ngaySinh"), jsonObject.getString("diaChi")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar ,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAddStudent){
            startActivity(new Intent(MainActivity.this ,AddStudentActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

//    public void deleteStudent(String id) {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        String url = "http://192.168.1.104:4000/api/android/sinh-vien/"+id;
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject jsonObject = response.getJSONObject(i);
////                                Toast.makeText(MainActivity.this, "" + jsonObject.get("_id"), Toast.LENGTH_SHORT).show();
//                                studentList.add(new Student(jsonObject.getString("_id"), jsonObject.getString("hoTen")
//                                        , jsonObject.getString("ngaySinh"), jsonObject.getString("diaChi")));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                }
////                new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
////                    }
////                }
//        );
//        requestQueue.add(jsonArrayRequest);
//    }
}