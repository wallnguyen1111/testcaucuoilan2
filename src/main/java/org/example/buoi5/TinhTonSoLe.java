package org.example.buoi5;

public class TinhTonSoLe {
    public Integer tinhTongSoLe(Integer number) {

        if (number < 1  || number > 1000) {
            throw new IllegalArgumentException("So phai lon hon 1 va be hon 1000");
        }

        int sum = 0;
        for (int i = 0; i <= number; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
