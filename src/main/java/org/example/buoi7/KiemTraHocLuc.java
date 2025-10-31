package org.example.buoi7;

public class KiemTraHocLuc {
    public String HocLuc(Float diem) {
        if (diem >= 9f) {
            return "Xuất sắc";
        }else if (diem >= 7f && diem < 9f) {
            return "Giỏi";
        }else if (diem >= 5f && diem < 7f) {
            return "Trung Bình";
        }else {
            return "Yếu";
        }
    }
}
