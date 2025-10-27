package buoi5;

import org.example.buoi5.TinhTonSoLe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTinhTonSoLe {
    private TinhTonSoLe tinhTonSoLe;

    @BeforeEach
    public void setUp() {
        tinhTonSoLe = new TinhTonSoLe();
    }

    @Test
    public void testTinhTonSoLeHopLe() {
        int num = 10;
        assertEquals(25, tinhTonSoLe.tinhTongSoLe(num));
    }

    @Test
    public void testTinhTonBienDuoi() {
        int num = 1;
        assertEquals(1, tinhTonSoLe.tinhTongSoLe(num));
    }

    @Test
    public void testTinhTonBienTrenn() {
        int num = 1000;
        assertEquals(250000, tinhTonSoLe.tinhTongSoLe(num));
    }

    @Test
    public void testTinhTonKoHopLeBienTren() {
        int num = 1001;
        assertThrows(IllegalArgumentException.class, () -> tinhTonSoLe.tinhTongSoLe(num));
    }

    @Test
    public void testTinhTonDuoibienTren() {
        int num = 999;
        assertEquals(250000, tinhTonSoLe.tinhTongSoLe(num));
    }

    @Test
    public void testTinhTonKoHopLeDuoiBien() {
        int num = -1;
        assertThrows(IllegalArgumentException.class, () -> tinhTonSoLe.tinhTongSoLe(num));
    }

    @Test
    public void testTinhTonTrenBienDuoi() {
        int num = 2;
        assertEquals(1, tinhTonSoLe.tinhTongSoLe(num));
    }
}
