package org.example.buoi5;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    List<SanPham> list = new ArrayList<SanPham>();
    public SanPham sanPham = new SanPham("BN1", "ten 1", 1999, 9.9f, 10, "dm1");


    public void them(SanPham sanPham) {

        if (sanPham.getSoLuong() < 1 || sanPham.getSoLuong() > 100) {
            throw new IllegalArgumentException("So luong phai lon hon 1 va be hon 100");
        }

        for (int i =0 ; i < list.size() ; i++) {
            if(list.get(i).getMa().equals(sanPham.getMa())) {
                throw new IllegalArgumentException("San Pham da ton tai");
            }
        }

        list.add(sanPham);
    }

    public void sua(SanPham sanPhamMoi) {
        if (sanPhamMoi == null) {
            throw new IllegalArgumentException("SanPham moi khong duoc null");
        }

        if (sanPhamMoi.getSoLuong() < 1 || sanPhamMoi.getSoLuong() > 100) {
            throw new IllegalArgumentException("So luong phai lon hon 1 va be hon 100");
        }

        sanPham.setMa(sanPhamMoi.getMa());
        sanPham.setTen(sanPhamMoi.getTen());
        sanPham.setSoLuong(sanPhamMoi.getSoLuong());
        sanPham.setNamBaoHanh(sanPhamMoi.getNamBaoHanh());
        sanPham.setGia(sanPhamMoi.getGia());
        sanPham.setDanhMuc(sanPhamMoi.getDanhMuc());
    }
}
