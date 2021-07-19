package com.example.sqlitedemo;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuanLySachActivity extends AppCompatActivity {

    MyDatabase myDatabase = new MyDatabase(QuanLySachActivity.this, "bookDatabase.sqlite", null, 1);
    String tableName = "Table_Sach";
    TextView txtBookId, txtBookName, txtBookPage, txtBookPrice, txtBookDescription;
    Button btnFirst, btnPrevious, btnNext, btnLast;
    List<Book> list = null;
    int currentId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanlysach);
        mapping();
        String sql_create_table = "CREATE TABLE IF NOT EXISTS " + tableName + " (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " BookId INTEGER," +
                " BookName VARCHAR(100)," +
                " Page INTEGER, " +
                "Price FLOAT," +
                " Description VARCHAR(200))";
        myDatabase.ExecuteSQL(sql_create_table);
        Toast.makeText(this, "Database create oke, table oke", Toast.LENGTH_SHORT).show();
//        Book book1 = new Book(4, 223, "Be khoe be dep", 333, 1000000, "Xuan Mike");
//        Book book2 = new Book(5, 333, "Huong dan hat ", 223, 2000000,"Michael Hu Don");
//        Book book3 = new Book(6, 334, "How to how to", 1000, 3000000,"Google");
//
//        insertBook(book1);
//        insertBook(book2);
//        insertBook(book3);

//        showData();
//

//        Book bookUpdate = new Book(2, 200, "Xac suat thong ke Nang cao", 456, 5000000,"Kha banh");
//        updateBook(bookUpdate);
//        showData();
        list = getAll();
        Toast.makeText(this, list.size() + "", Toast.LENGTH_SHORT).show();
        loadData();
    }


    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql_select = "SELECT * FROM " + tableName;
        Cursor c = myDatabase.SelectData(sql_select);
        while (c.moveToNext()) {
            int Id = c.getInt(0);
            int bookId = c.getInt(1);
            String bookName = c.getString(2);
            int page = c.getInt(3);
            float price = c.getInt(4);
            String description = c.getString(5);
            Book book = new Book(Id, bookId, bookName, page, price, description);
//            Toast.makeText(this, "" + book, Toast.LENGTH_SHORT).show();
            list.add(book);
        }
        return list;
    }

    private void loadData() {
        txtBookId.setText("Id Book: " + list.get(currentId).getBookId());
        txtBookName.setText("Book Name: " + list.get(currentId).getBookName());
        txtBookPage.setText("Pages: " + list.get(currentId).getPage());
        txtBookPrice.setText("Price: " + list.get(currentId).getPrice());
        txtBookDescription.setText("Description: " + list.get(currentId).getDescription());
    }

    private void mapping() {
        txtBookId = findViewById(R.id.txtBookId);
        txtBookName = findViewById(R.id.txtBookName);
        txtBookPrice = findViewById(R.id.txtBookPrice);
        txtBookPage = findViewById(R.id.txtBookPage);
        txtBookDescription = findViewById(R.id.txtBookDescription);
        btnFirst = findViewById(R.id.btnFirst);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnLast = findViewById(R.id.btnLast);
    }

    public boolean insertBook(Book book) {
        try {
            String sql_insert = "INSERT INTO " + tableName + " VALUES(null, "
                    + book.getBookId() + ", '"
                    + book.getBookName() + "', "
                    + book.getPage() + ", "
                    + book.getPrice() + ", '"
                    + book.getDescription() + "')";
            myDatabase.ExecuteSQL(sql_insert);
            return true;
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean updateBook(Book book) {
        try {
            String sql_update = "UPDATE " + tableName +
                    " SET BookId = " + book.getBookId() + ", " +
                    "BookName = '" + book.getBookName() + "', " +
                    "Page = " + book.getPage() + ", " +
                    "Price = " + book.getPrice() + ", " +
                    "Description = '" + book.getDescription() + "' " +
                    "WHERE Id = " + book.getId();
            myDatabase.ExecuteSQL(sql_update);
            return true;
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean deleteBook(Book book) {
        try {
            String sql_delete = "Delete FROM " + tableName + " WHERE Id = " + book.getId();
            myDatabase.ExecuteSQL(sql_delete);
            return true;
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean deleteBook(int id) {
        try {
            String sql_delete = "Delete FROM " + tableName + "WHERE Id = " + id;
            myDatabase.ExecuteSQL(sql_delete);
            return true;
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void showData() {
        String sql_select = "SELECT * FROM " + tableName;
        Cursor c = myDatabase.SelectData(sql_select);
        while (c.moveToNext()) {
            int Id = c.getInt(0);
            int bookId = c.getInt(1);
            String bookName = c.getString(2);
            int page = c.getInt(3);
            float price = c.getInt(4);
            String description = c.getString(5);
            Book book = new Book(Id, bookId, bookName, page, price, description);
            Toast.makeText(this, "" + book, Toast.LENGTH_SHORT).show();
        }
    }

}
