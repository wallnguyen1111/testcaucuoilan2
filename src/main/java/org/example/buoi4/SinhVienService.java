package org.example.buoi4;

import org.example.buoi2.Sach;
import org.example.buoi3.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    public List<SinhVien> ListSinhVien = new ArrayList<>();

    public Boolean addSinhVien(SinhVien sinhVien) {
        if (sinhVien.getMaSV() == "" || sinhVien.getTen() == "" || sinhVien.getTuoi() == null || sinhVien.getDiemTrungBinh() == null || sinhVien.getKyHoc() == null || sinhVien.getChuyenNghanh() == "") {
                throw new IllegalArgumentException("Cac truong khong duoc de trong");
        }
        ListSinhVien.add(sinhVien);
        return true;
    }


    public Boolean suaSinhVien(String MaSV, SinhVien sinhVienMoi ) {
        SinhVien sinhVienSua = null;
        for (SinhVien sv : ListSinhVien) {
          if (sv.getMaSV().equals(sinhVienMoi.getMaSV())) {
              sinhVienSua = sv;
              break;
          }
        }
        if (sinhVienMoi.getMaSV() == "" || sinhVienMoi.getTen() == "" || sinhVienMoi.getTuoi() == null || sinhVienMoi.getDiemTrungBinh() == null || sinhVienMoi.getKyHoc() == null || sinhVienMoi.getChuyenNghanh() == "") {
            throw new IllegalArgumentException("Cac truong khong duoc de trong");
        }

        if (sinhVienMoi.getDiemTrungBinh() < 0 || sinhVienMoi.getDiemTrungBinh() > 10) {
            throw new IllegalArgumentException("DiemTRung sinh vien pahi lon hon 0 va be hon 10");
        }
        sinhVienSua.setMaSV(sinhVienMoi.getMaSV());
        sinhVienSua.setTen(sinhVienMoi.getTen());
        sinhVienSua.setTuoi(sinhVienMoi.getTuoi());
        sinhVienSua.setKyHoc(sinhVienMoi.getKyHoc());
        sinhVienSua.setDiemTrungBinh(sinhVienMoi.getDiemTrungBinh());
        sinhVienSua.setChuyenNghanh(sinhVienMoi.getChuyenNghanh());
        return true;
    }
}
