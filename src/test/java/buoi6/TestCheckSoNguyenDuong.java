package buoi6;

import org.example.buoi6.CheckSoNguyenDuong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCheckSoNguyenDuong {
    CheckSoNguyenDuong checkSoNguyenDuong;

    @BeforeEach
    public void setUp() {
        checkSoNguyenDuong = new CheckSoNguyenDuong();
    }

    @Test
    public void testCheckSoNguyenDuongHopLe() {
        float num = 10;
        assertEquals(10, checkSoNguyenDuong.ktrasonguyendung(num));
    }

    @Test
    public void testCheckSoNguyenDuongKoHopLe() {
        float num = 10.5f;
        assertThrows(IllegalArgumentException.class, () -> checkSoNguyenDuong.ktrasonguyendung(num));
    }

    @Test
    public void testCheckSoNguyenDuongKoHopLeTren() {
        float num = 101f;
        assertThrows(IllegalArgumentException.class, () -> checkSoNguyenDuong.ktrasonguyendung(num));
    }

    @Test
    public void testCheckSoNguyenDuongKoHopLeDuoi() {
        float num = -1f;
        assertThrows(IllegalArgumentException.class, () -> checkSoNguyenDuong.ktrasonguyendung(num));
    }

    @Test
    public void testCheckSoNguyenDuongTaiBienDuoi() {
        float num = 1f;
        assertEquals(1, checkSoNguyenDuong.ktrasonguyendung(num));
    }

    @Test
    public void testCheckSoNguyenDuongTaiBienTren() {
        float num = 100f;
        assertEquals(100f, checkSoNguyenDuong.ktrasonguyendung(num));
    }

}
