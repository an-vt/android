package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatabase myDatabase = new MyDatabase(MainActivity.this, "demoo1.sqlite", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String sql_create_table = "CREATE TABLE IF NOT EXISTS Account (id  INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(50), password VARCHAR(100))";
        myDatabase.ExecuteSQL(sql_create_table);
//        Toast.makeText(this, "Database create oke, table oke", Toast.LENGTH_SHORT).show();
//        String sql_insert1 = "INSERT INTO account VALUES(null, 'admin', '123456')";
//        String sql_insert2 = "INSERT INTO account VALUES(null, 'hieu', '123456')";
//        String sql_insert3 = "INSERT INTO account VALUES(null, 'superadmin', '123456')";
//        myDatabase.ExecuteSQL(sql_insert1);
//        myDatabase.ExecuteSQL(sql_insert2);
//        myDatabase.ExecuteSQL(sql_insert3);
        Toast.makeText(this, "INSERT OKE", Toast.LENGTH_SHORT).show();
        String sql_update = "UPDATE account SET username ='hieu', password = 'hahahohohehe' WHERE id = 2";
        myDatabase.ExecuteSQL(sql_update);
        showData();
////        String sql_delete = "DELETE FROM account where id = 4";
//        myDatabase.ExecuteSQL(sql_delete);
        Toast.makeText(this, "Delete Oke", Toast.LENGTH_SHORT).show();
        showData();

    }

    public void showData(){
        String sql_select = "SELECT * FROM ACCOUNT";
        Cursor c = myDatabase.SelectData(sql_select);
        while(c.moveToNext()){
            int id = c.getInt(0);
            String username = c.getString(1);
            String password = c.getString(2);
            Toast.makeText(this, "id: " + id + ", " + username + " " + password, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Read very oke", Toast.LENGTH_SHORT).show();
    }

}