package com.example.qlydatphongks;

public class phong {

    String ten;
    String mota;
    String giatien;
    String hinhanh;

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public String getGiatien() {
        return giatien;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public phong(String ten, String mota, int giatien, String hinhanh) {
        this.ten = ten;
        this.mota = mota;
        this.giatien = "Giá tiền: " +  giatien;
        this.hinhanh = hinhanh;
    }
}
