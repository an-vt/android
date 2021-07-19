package com.example.asyntaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button btnDownloadImage;
    TextView txtvStatus;
    ImageView imgImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        String url_anh ="https://cdn.tgdd.vn/2020/10/CookProduct/1-1200x676-37.jpg";
        new DowloadImage().execute("url_anh");
    }
    private class DowloadImage extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    @Override
    protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
        try {
            URL url = new URL(strings[0]);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

        @Override
        protected void onPostExecute(Bitmap s) {
            super.onPostExecute(s);
            imgImage.setImageBitmap(s);
            txtvStatus.setText("Đã tải ảnh xong!!!");
        }


    }
    private void mapping() {
        btnDownloadImage= findViewById(R.id.btnDowloadImage);
        txtvStatus= findViewById(R.id.txtStavus);
        imgImage= findViewById(R.id.imgImage);
    }
}