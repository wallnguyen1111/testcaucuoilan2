package buoi7;

import org.example.buoi7.BaiHat;
import org.example.buoi7.BaiHatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBaiHatService {
    private BaiHatService baiHatService;

    @BeforeEach
    public void setUp() {
        baiHatService = new BaiHatService();
    }

    @Test
    public void TestThemBaihatHopLe() {
        BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 140f, "thelaoi1");
        baiHatService.add(baiHat);
        assertEquals(140f, baiHatService.baiHat.getThoiLuong());
    }

    @Test
    public void TestThemBaihatKoHopLeTren() {
        BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 350f, "thelaoi1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->  baiHatService.add(baiHat));
        assertEquals("Thoi luong tu 2p00 den 5p59", ex.getMessage());
    }

    @Test
    public void TestThemBaihatKoHopLeDuoi() {
        BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 100f, "thelaoi1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->  baiHatService.add(baiHat));
        assertEquals("Thoi luong tu 2p00 den 5p59", ex.getMessage());
    }

    @Test
    public void TestThemBaihatKoHopLeTrung() {
        BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 140f, "thelaoi1");
        baiHatService.add(baiHat);
        BaiHat baiHat2= new BaiHat("b1", "ten1", "tencasi1", 140f, "thelaoi1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->  baiHatService.add(baiHat2));
        assertEquals("Ma ko duoc trung", ex.getMessage());
    }

    @Test
    public void TestThemBaihatHopLeBienDuoi() {
        BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 120f, "thelaoi1");
        baiHatService.add(baiHat);
    }

    @Test
    public void TestThemBaihatHopLeBienTren() {
        BaiHat baiHat = new BaiHat("b1", "ten1", "tencasi1", 299f, "thelaoi1");
        baiHatService.add(baiHat);
    }
}
