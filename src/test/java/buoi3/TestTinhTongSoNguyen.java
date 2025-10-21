package buoi3;

import org.example.buoi3.TinhTongSoNguyen;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTinhTongSoNguyen {
    private TinhTongSoNguyen tinhTongSoNguyen;
    @BeforeEach
    public void setUp() {
        tinhTongSoNguyen = new TinhTongSoNguyen();
    }

    @Test
    public void testTinhTongSoNguyenHopLe() {
        int [] arr = {1, 2, 3, 4};
        assertEquals(10, tinhTongSoNguyen.tongSoNguyen(arr));
    }

    @Test
    public void testTinhTongSoNguyenMaMangNull() {
        int [] arr = null;
       assertThrows(NullPointerException.class, () -> tinhTongSoNguyen.tongSoNguyen(arr));
    }

    @Test
    public void testTinhTongSoNguyenMaMangChuaSoAm() {
        int [] arr = {1, -2, 3, 4};
        assertThrows(IllegalArgumentException.class, () -> tinhTongSoNguyen.tongSoNguyen(arr));
    }

    @Test
    public void testTinhTongSoNguyenMaMangChuaSoLonHon100() {
        int [] arr = {1, 2, 3, 400};
        assertThrows(IllegalArgumentException.class, () ->tinhTongSoNguyen.tongSoNguyen(arr));
    }


}
