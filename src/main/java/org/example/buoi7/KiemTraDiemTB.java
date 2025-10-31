package org.example.buoi7;

public class KiemTraDiemTB {
    public Float checkDiemTb(Float diem1, Float diem2, Float diem3) {
        if (diem1 < 0 || diem1 > 10 || diem2 < 0 || diem2 > 10 || diem3 < 0 || diem3 > 10) {
            throw new IllegalArgumentException("Diem tb phai lon hon 0 va be hon 10");
        }
        float tong = (diem1 + diem2 + diem3)/3;
        return tong;
    }
}
