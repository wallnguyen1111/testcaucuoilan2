package org.example.buoi2;


public class Sach {
    private String id;
    private String ten;
    private int soTrang;
    private String tenTacGia;
    private int lanTaiBan;

    public Sach() {
    }

    public Sach(String id, String ten, int soTrang, String tenTacGia, int lanTaiBan) {
        this.id = id;
        this.ten = ten;
        this.soTrang = soTrang;
        this.tenTacGia = tenTacGia;
        this.lanTaiBan = lanTaiBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getLanTaiBan() {
        return lanTaiBan;
    }

    public void setLanTaiBan(int lanTaiBan) {
        this.lanTaiBan = lanTaiBan;
    }
}
