import org.example.buoi2.Sach;
import org.example.buoi2.SachService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSachService {

    private SachService sachService;

    @BeforeEach
    public void setUp() {
        sachService = new SachService();
    }

    @Test
    public void testThemSachHop() {
        Sach sach = new Sach("S1", "sach1", 25, "Trong minh duc", 1);
        assertTrue(sachService.addSach(sach));
    }

    @Test
    public void testThemVoiSoTrangbang0() {
        Sach sach = new Sach("S2", "sach2", 0, "Trong minh duc an cut", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.addSach(sach));
    }

    @Test
    public void testThemVoiSoTrangLonHon50() {
        Sach sach = new Sach("S4", "sach4", 51, "Trong minh duc an cut tao", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.addSach(sach));
    }

    @Test
    public void testThemNulL() {
        assertThrows(NullPointerException.class, () -> sachService.addSach(null));
    }

    @Test
    public void testThemSachVoiTenChuaKiTuDacBiet() {
        Sach sach = new Sach("S5", "sach5@%$%$", 36, "Trong minh duc an cut tao", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.addSach(sach));
    }


    @Test
    public void testSuaSachKhongTimThayId() {
        Sach sachmoi = new Sach("S1", "sach1", 25, "Trong minh duc", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.sua("khongtimthay", sachmoi));
    }

    @Test
    public void testSuaSachVoiSoTrangBeHon1() {
        Sach sach = new Sach("S2", "sach2", 2, "Trong minh duc an cut", 1);
        sachService.addSach(sach);

        Sach sachmoi = new Sach("S2", "sach2", 0, "Trong minh duc an cut", 2);
        assertThrows(IllegalArgumentException.class, () -> sachService.sua("S2", sachmoi));
    }

    @Test
    public void testSuaSachNull() {
        assertThrows(NullPointerException.class, () -> sachService.sua("", null));
    }

    @Test
    public void testSuaSachVoiSoTrangLonHon50() {
        Sach sach = new Sach("S4", "sach4", 50, "Trong minh duc an cut tao", 1);
        sachService.addSach(sach);

        Sach sachmoi = new Sach("S4", "sach4", 51, "Trong minh duc an cut tao", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.sua("S4", sachmoi));
    }

    @Test
    public void testSuaSachVoiTenChuaKiTuDacBiet() {
        Sach sach = new Sach("S5", "sach5", 36, "Trong minh duc an cut tao", 1);
        sachService.addSach(sach);

        Sach sachmoi = new Sach("S5", "sach5@%$%$", 36, "Trong minh duc an cut tao", 1);
        assertThrows(IllegalArgumentException.class, () -> sachService.sua("S5", sachmoi));
    }



}
