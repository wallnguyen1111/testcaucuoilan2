package org.example.buoi7;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    public List<BaiHat> list = new ArrayList<BaiHat>();

    public BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 140f, "thelaoi1");

    public List<BaiHat> getBaiHat() {
        return list;
    }

    public void add(BaiHat baiHat) {
        if (baiHat.getThoiLuong() < 120 || baiHat.getThoiLuong() >= 300) {
            throw new IllegalArgumentException("Thoi luong tu 2p00 den 5p59");
        }

        if (baiHat.getMa() == null || baiHat.getTen() == null || baiHat.getTenCaSi() == null || baiHat.getThoiLuong() == null || baiHat.getTheLoai() == null) {
            throw new IllegalArgumentException("Cac truong ko duoc de bo trong");
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(baiHat.getMa())) {
                throw new IllegalArgumentException("Ma ko duoc trung");
            }
        }
        list.add(baiHat);
    }


    public void sua(BaiHat baiHatMoi) {
        if (baiHatMoi.getThoiLuong() < 120 || baiHatMoi.getThoiLuong() >= 300) {
            throw new IllegalArgumentException("Thoi luong tu 2p00 den 5p59");
        }
        baiHat.setMa(baiHatMoi.getMa());
        baiHat.setTen(baiHatMoi.getTen());
        baiHat.setTenCaSi(baiHatMoi.getTenCaSi());
        baiHat.setThoiLuong(baiHatMoi.getThoiLuong());
        baiHat.setTheLoai(baiHatMoi.getTheLoai());
    }
}
