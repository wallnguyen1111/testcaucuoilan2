package org.example.buoi3;

import java.util.ArrayList;
import java.util.List;

public class TinhTongSoNguyen {
    public Integer tongSoNguyen(int [] arr) {
        if (arr == null) {
            throw new NullPointerException("mang ko duoc rong");
        }

        for (int num : arr) {
            if (num < 0 || num > 100) {
                throw new IllegalArgumentException("so phai lon hon 0 va nho hon 100");
            }
        }

        int sum =0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
