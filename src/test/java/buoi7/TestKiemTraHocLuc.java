package buoi7;

import org.example.buoi7.KiemTraHocLuc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestKiemTraHocLuc {
    private KiemTraHocLuc kiemTraHocLuc;

    @BeforeEach
    public void setUp() {
        kiemTraHocLuc = new KiemTraHocLuc();
    }

    @Test
    public void testKiemTraHocLucSuatSac() {
        Float diem = 10f;
        assertEquals("Xuất sắc", kiemTraHocLuc.HocLuc(diem));
    }

    @Test
    public void testKiemTraHocLucSuatSacBienDuoi() {
        Float diem = 9f;
        assertEquals("Xuất sắc", kiemTraHocLuc.HocLuc(diem));
    }

    @Test
    public void testKiemTraHocLucGioi() {
        Float diem = 8.9f;
        assertEquals("Giỏi", kiemTraHocLuc.HocLuc(diem));
    }

    @Test
    public void testKiemTraHocLucGioiBienDuoi() {
        Float diem = 7f;
        assertEquals("Giỏi", kiemTraHocLuc.HocLuc(diem));
    }


    @Test
    public void testKiemTraHocLucTb() {
        Float diem = 6.9f;
        assertEquals("Trung Bình", kiemTraHocLuc.HocLuc(diem));
    }

    @Test
    public void testKiemTraHocLucTBBienDuoi() {
        Float diem = 5f;
        assertEquals("Trung Bình", kiemTraHocLuc.HocLuc(diem));
    }

    @Test
    public void testKiemTraHocLucYeu() {
        Float diem = 4.9f;
        assertEquals("Yếu", kiemTraHocLuc.HocLuc(diem));
    }

}
