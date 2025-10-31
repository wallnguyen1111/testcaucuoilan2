package buoi7;

import org.example.buoi7.KiemTraDiemTB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestKiemTraDiemTB {
    private KiemTraDiemTB kiemTraDiemTB;

    @BeforeEach
    public void setUp() {
        kiemTraDiemTB = new KiemTraDiemTB();
    }

    @Test
    public void testKiemTraDiemTBHopLe() {
        Float diem1 = 9f;
        Float diem2 = 9f;
        Float diem3 = 9f;
        assertEquals(9f, kiemTraDiemTB.checkDiemTb(diem1, diem2, diem3));
    }

    @Test
    public void testKiemTraDiemTBHopLeTren() {
        Float diem1 = 20f;
        Float diem2 = 20f;
        Float diem3 = 20f;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> kiemTraDiemTB.checkDiemTb(diem1, diem2, diem3));
        assertEquals("Diem tb phai lon hon 0 va be hon 10", ex.getMessage());
    }

    @Test
    public void testKiemTraDiemTBHopLeDuoi() {
        Float diem1 = -1f;
        Float diem2 = -1f;
        Float diem3 = -1f;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> kiemTraDiemTB.checkDiemTb(diem1, diem2, diem3));
        assertEquals("Diem tb phai lon hon 0 va be hon 10", ex.getMessage());
    }


    @Test
    public void testKiemTraDiemTBHopLeBienDuoi() {
        Float diem1 = 0f;
        Float diem2 = 0f;
        Float diem3 = 0f;
        assertEquals(0f, kiemTraDiemTB.checkDiemTb(diem1, diem2, diem3));
    }

    @Test
    public void testKiemTraDiemTBHopLeBienTren() {
        Float diem1 = 10f;
        Float diem2 = 10f;
        Float diem3 = 10f;
        assertEquals(10f, kiemTraDiemTB.checkDiemTb(diem1, diem2, diem3));
    }

}
