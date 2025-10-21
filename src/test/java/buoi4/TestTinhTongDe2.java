package buoi4;

import org.example.buoi4.TinhTongDe2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTinhTongDe2 {
    private TinhTongDe2 tinhTongDe2;

    @BeforeEach
    public void setUp() {
        tinhTongDe2 = new TinhTongDe2();
    }

    @Test
    public void testTinhTongDe2VoiTongHop() {
        int [] arr = {1,2,3,4};
        assertEquals(10, tinhTongDe2.tinhTongSoNguyen1den1000(arr));
    }

    @Test
    public void testTinhTongDe2VoiSoNguyenNgoaiPV() {
        int [] arr = {1,2,3,-4};
        assertThrows(IllegalArgumentException.class, () -> tinhTongDe2.tinhTongSoNguyen1den1000(arr));
    }

    @Test
    public void testTinhTongDe2VoiSoNguyenBeTaiBienDuoiVaBienTren() {
        int [] arr = {1, 1000};
       assertEquals(1000, tinhTongDe2.tinhTongSoNguyen1den1000(arr));
    }

    @Test
    public void testTinhTongDe2VoiSoNguyenBeTaiBienTren() {
        int [] arr = {2, 999};
        assertEquals(1001, tinhTongDe2.tinhTongSoNguyen1den1000(arr));
    }




}
