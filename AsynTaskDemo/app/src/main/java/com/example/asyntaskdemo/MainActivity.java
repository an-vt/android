package com.example.asyntaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button btnDownloadImage, btnNextActivity;
    TextView txtvStatus;
    ImageView imgImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        btnDownloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_anh ="https://i1-vnexpress.vnecdn.net/2021/05/14/556318717451aIsraelPalestine-1-9832-5947-1620962281.jpg?w=680&h=408&q=100&dpr=1&fit=crop&s=0Kte7njEhDWUfY34FU-WdA";
                new DownloadImage().execute("url_anh");
            }
        });
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {
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
            txtvStatus.setText("Đã tải ảnh xong!!!!");
        }
    }

    private void mapping() {
        btnDownloadImage = findViewById(R.id.btnDownLoadImage);
        txtvStatus = findViewById(R.id.txtvStatus);
        imgImage = findViewById(R.id.imgImage);
        btnNextActivity = findViewById(R.id.btnNextActivity);
    }
}
