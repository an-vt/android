package com.example.sqlitedemo;

public class Book {
    private  int id;
    private  int BookId;
    private String BookName;
    private int Page;
    private float  Price;
    private String Description;

    public Book() {
    }

    public Book(int id, int bookId, String bookName, int page, float price, String description) {
        this.id = id;
        BookId = bookId;
        BookName = bookName;
        Page = page;
        Price = price;
        Description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", BookId=" + BookId +
                ", BookName='" + BookName + '\'' +
                ", Page=" + Page +
                ", Price=" + Price +
                ", Description='" + Description + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setPage(int page) {
        Page = page;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public int getPage() {
        return Page;
    }

    public float getPrice() {
        return Price;
    }

    public String getDescription() {
        return Description;
    }


}
