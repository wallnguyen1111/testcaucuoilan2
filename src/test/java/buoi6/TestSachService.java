package buoi6;


import org.example.buoi6.Sach;
import org.example.buoi6.SachService;
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
    public void testSuaSachHopLe() {
        Sach SachMoi = new Sach("S2", "tens1", "tacgia1", 2000, 10f);
        sachService.update(SachMoi);
        assertEquals(2000, sachService.sach.getNamXuatBan());
    }

    @Test
    public void testSuaSachKoHopLeTren() {
        Sach SachMoi = new Sach("S2", "tens1", "tacgia1", 2026, 10f);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sachService.update(SachMoi));
        assertEquals("Nam xuat ban phai lon hon 1990 va be hon 2025", ex.getMessage());
    }

    @Test
    public void testSuaSachKoHopLeDuoi() {
        Sach SachMoi = new Sach("S2", "tens1", "tacgia1", 1989, 10f);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sachService.update(SachMoi));
        assertEquals("Nam xuat ban phai lon hon 1990 va be hon 2025", ex.getMessage());
    }

    @Test
    public void testSuaSachHopLeTaiBienDuoi() {
        Sach SachMoi = new Sach("S2", "tens1", "tacgia1", 1990, 10f);
        sachService.update(SachMoi);
        assertEquals(1990, sachService.sach.getNamXuatBan());
    }

    @Test
    public void testSuaSachHopLeTaiBienTren() {
        Sach SachMoi = new Sach("S2", "tens1", "tacgia1", 2025, 10f);
        sachService.update(SachMoi);
        assertEquals(2025, sachService.sach.getNamXuatBan());
    }

    @Test
    public void testSuaSachKoHopLeTaiCacTruongNull() {
        Sach SachMoi = new Sach("", "", "", null, null);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sachService.update(SachMoi));
        assertEquals("Cac truong khong duoc null", ex.getMessage());
    }

}
