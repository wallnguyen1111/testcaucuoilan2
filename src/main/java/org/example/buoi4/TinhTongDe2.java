package org.example.buoi4;

public class TinhTongDe2 {
    public int tinhTongSoNguyen1den1000(int [] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num < 1 || num > 1000) {
                throw new IllegalArgumentException("so phai lon hon 0 va be hon 1000");
            }
        }

        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
