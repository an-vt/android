package com.example.demoanytask;

import java.io.Serializable;

public class Student  implements Serializable {
    private  String hoTen;
    private int tuoi;
    boolean gioiTinh; //true Nam, false Nu
    private  float   diemTrungBinh;

    public Student() {
    }

    public Student(String hoTen, int tuoi, boolean gioiTinh, float diemTrungBinh) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "Student{" +
                "hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                ", diemTrungBinh=" + diemTrungBinh +
                '}';
    }
}

