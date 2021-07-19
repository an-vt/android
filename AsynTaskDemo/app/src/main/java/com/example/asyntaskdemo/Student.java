package com.example.asyntaskdemo;

import java.io.Serializable;

public class Student implements Serializable {
      private String hoten;
      private int tuoi;
      private boolean gioiTinh; //true là nam, false là nữ
      private float diemTB;

     public Student() {
     }

     public Student(String hoten, int tuoi, boolean gioiTinh, float diemTB) {
         this.hoten = hoten;
         this.tuoi = tuoi;
         this.gioiTinh = gioiTinh;
         this.diemTB = diemTB;
     }

     public String getHoten() {
         return hoten;
     }
     public void setHoten(String hoten) {
         this.hoten = hoten;
     }
     public int getTuoi() {
         return tuoi;
     }
     public void setTuoi(int tuoi) {
         this.tuoi = tuoi;
     }
     public boolean isGioiTinh() {
         return gioiTinh;
     }
     public void setGioiTinh(boolean gioiTinh) {
         this.gioiTinh = gioiTinh;
     }
     public float getDiemTB() {
         return diemTB;
     }
     public void setDiemTB(float diemTB) {
         this.diemTB = diemTB;
     }

     public String toString() {
         return "Student{" +"hoten='" +hoten+ '\'' +", tuoi=" + tuoi +", gioiTinh=" + gioiTinh +", diemTB=" + diemTB + '}';
     }
}
