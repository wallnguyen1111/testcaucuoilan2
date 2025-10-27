package org.example.buoi5;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    List<SanPham> list = new ArrayList<SanPham>();
    SanPham sanPham = new SanPham("BN1", "ten 1", 1999, 9.9f, 10, "dm1");


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
}
