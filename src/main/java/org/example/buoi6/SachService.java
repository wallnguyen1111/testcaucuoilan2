package org.example.buoi6;

import java.util.ArrayList;
import java.util.List;

public class SachService {
    public List<Sach> list = new ArrayList<Sach>();

    public Sach sach = new Sach("S1", "tens1", "tacgia1", 1999, 10f);

    public void addsach(Sach sach) {
        if (sach.getMaSach() == null || sach.getTenSach() == null || sach.getTacGia() == null || sach.getNamXuatBan() == null || sach.getGia() == null) {
            throw new IllegalArgumentException("Cac truong khong duoc null");
        }
        list.add(sach);
    }

    public void update(Sach sachMoi) {
        if (sachMoi.getMaSach() == null  || sachMoi.getTenSach() == null || sachMoi.getTacGia() == null || sachMoi.getNamXuatBan() == null || sachMoi.getGia() == null) {
            throw new IllegalArgumentException("Cac truong khong duoc null");
        }

        if (sachMoi.getNamXuatBan() < 1990 || sachMoi.getNamXuatBan() > 2025) {
            throw new IllegalArgumentException("Nam xuat ban phai lon hon 1990 va be hon 2025");
        }
        sach.setMaSach(sachMoi.getMaSach());
        sach.setTenSach(sachMoi.getTenSach());
        sach.setTacGia(sachMoi.getTacGia());
        sach.setNamXuatBan(sachMoi.getNamXuatBan());
        sach.setGia(sachMoi.getGia());
    }
}
