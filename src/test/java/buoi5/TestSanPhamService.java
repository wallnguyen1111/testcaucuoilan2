package buoi5;

import org.example.buoi5.SanPham;
import org.example.buoi5.SanPhamService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestSanPhamService {
    private SanPhamService sanPhamService;
     private SanPham sanPham;

    @BeforeEach
    public void setUp() {
        sanPhamService = new SanPhamService();
    }

    @Test
    public void testAddSanPhamHopLe() {
        SanPham sanPham = new SanPham("BN1", "ten 1", 1999, 9.9f, 10, "dm1");
        sanPhamService.them(sanPham);
    }

    @Test
    public void testAddSanPhamKOHopLe() {
        SanPham sanPham = new SanPham("BN2", "ten 1", 1999, 9.9f, 101, "dm1");
        assertThrows(IllegalArgumentException.class, () -> sanPhamService.them(sanPham));
    }

    @Test
    public void testAddSanPhamBienTren() {
        SanPham sanPham = new SanPham("BN2", "ten 1", 1999, 9.9f, 100, "dm1");
        sanPhamService.them(sanPham);
    }

    @Test
    public void testAddSanPhamBienDuoi() {
        SanPham sanPham = new SanPham("BN2", "ten 1", 1999, 9.9f, 1, "dm1");
        sanPhamService.them(sanPham);
    }

    @Test
    public void testAddSanPhamTrung() {
        SanPham sanPham = new SanPham("BN1", "ten 1", 1999, 9.9f, 10, "dm1");
        sanPhamService.them(sanPham);
        SanPham sanPham1 = new SanPham("BN1", "ten 1", 1999, 9.9f, 10, "dm1");
        assertThrows(IllegalArgumentException.class, () -> sanPhamService.them(sanPham1));
    }

}
