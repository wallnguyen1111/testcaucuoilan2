package org.example;

public class TinhTrungBinhCong {
    public Double tinhbtcong(Double diem1, Double diem2, Double diem3) {
        if(diem1 < 0  || diem1 > 10
        || diem2 < 0  || diem2 > 10
        || diem3 < 0  || diem3 > 10) {
            throw new IllegalArgumentException("diem1 is out of range");
        }
        return (diem1+diem2+diem3)/3;
    }

    // arithmeticexception dung cho null va so 0

    // illegalargumentexception la dung cho ngoai le ngoai phan vung
}
