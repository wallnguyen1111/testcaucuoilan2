package org.example.buoi2;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SachService {
    private List<Sach> sachList = new ArrayList<Sach>();

    public boolean addSach(Sach sach) {
        if (sach == null) {
            throw new NullPointerException("sach khong duoc null");
        }

        if (sach.getSoTrang() < 1 || sach.getSoTrang() > 50) {
            throw new IllegalArgumentException("So trang phai lon hon 1 va be hon 50");
        }

        if (!Pattern.matches("^[a-zA-Z0-9\\s]+$", sach.getTen())) {
            throw new IllegalArgumentException("Ten sach khong duoc chua ki tu dac biet");
        }
        sachList.add(sach);
        return true;
    }


    public List<Sach> timKiemSachTenTacGia(String tenTacGia) {
        List<Sach> ketqua = new ArrayList<>();
        for (Sach sachtimkiem : sachList) {
            if (sachtimkiem.getTen().equals(tenTacGia)) {
                ketqua.add(sachtimkiem);
            }
        }
        return ketqua;
    }

    public boolean sua(String id, Sach sachMoi) {
        Sach sachSua = null;
        for (Sach s : sachList) {
            if (s.getId().equals(id)) {
                sachSua = s;
                break;
            }
        }

        if(sachMoi == null) {
            throw new NullPointerException("sua khong duoc null");
        }

        if (sachMoi.getSoTrang() < 1 || sachMoi.getSoTrang() > 10) {
            throw new IllegalArgumentException("So trang phai lon hon 1 va be hon 10");
        }

        if (!Pattern.matches("^[a-zA-Z0-9\\s]+$", sachMoi.getTen())) {
            throw new IllegalArgumentException("Ten khi sua khong duoc chua ki tu dac biet");
        }

        sachSua.setTen(sachMoi.getTen());
        sachSua.setSoTrang(sachMoi.getSoTrang());
        sachSua.setId(sachMoi.getId());
        sachSua.setTenTacGia(sachMoi.getTenTacGia());
        sachSua.setLanTaiBan(sachMoi.getLanTaiBan());

        return true;
    }
}
