package org.example.buoi6;

public class CheckSoNguyenDuong {
    public Float ktrasonguyendung(Float  number) {
        // check so thap phan
        if (number % 1 != 0) {
            throw new IllegalArgumentException("So phai la so nguyen duong");
        }

        if (number == null) {
            throw new IllegalArgumentException("so khong duoc null");
        }

        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("So phai lon hon 1 va be hon 100");
        }
        return number;
    }
}
