package org.example.buoi3;


import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    private List<NhanVien> nhanVienList = new ArrayList<NhanVien>();

    public boolean addNhanVien(NhanVien nhanVien) {


        if (nhanVien.getMaNV() == "") {
            throw new IllegalArgumentException("MaNV nhanVien khong duoc null");
        }

        if (nhanVien.getTenNV() == "") {
            throw new IllegalArgumentException("TenNV nhanVien khong duoc null");
        }


        if (nhanVien.getTuoi() == null) {
            throw new IllegalArgumentException("Tuoi nhanVien khong duoc null");
        }

        if (nhanVien.getLuong() == null) {
            throw new IllegalArgumentException("Tuoi nhanVien khong duoc null");
        }

        if (nhanVien.getPhongBan() == "") {
            throw new IllegalArgumentException("phong ban nhanVien khong duoc null");
        }

        if (nhanVien.getLuong() < 0 || nhanVien.getLuong() >= 100) {
            throw new IllegalArgumentException("Luong nhanVien phai lon hon 0 va be hon 100");
        }


        nhanVienList.add(nhanVien);
        return true;
    }
}
