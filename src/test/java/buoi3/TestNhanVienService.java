package buoi3;

import org.example.buoi3.NhanVien;
import org.example.buoi3.NhanVienService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNhanVienService {
    private NhanVienService service;

    @BeforeEach
    public void setUp() {
        service = new NhanVienService();
    }


    //assertTrue de them thanh cong
    @Test
    public void testNhanVienServiceHopLe() {
        NhanVien nhanVien = new NhanVien("nv1", "Nguyen Huu Canh Tuong", 18, 10.00, "phong ke toan");
        assertTrue(service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoiLuongBeHon0() {
        NhanVien nhanVien = new NhanVien("nv2", "Nguyen Huu Canh duc", 20, -1.0, "phong hanh chinh");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoiLuongLonHon100tr() {
        NhanVien nhanVien = new NhanVien("nv3", "Nguyen Huu Canh minh", 21, 101.000000, "phong hanh chinh");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoiMaVnDetrong() {
        NhanVien nhanVien = new NhanVien("", "Nguyen Huu Canh beo", 21, 100.000000, "phong hanh chinh");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoiTenVnDetrong() {
        NhanVien nhanVien = new NhanVien("nv4", "", 21, 100.000000, "phong hanh chinh");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoituoiDetrong() {
        NhanVien nhanVien = new NhanVien("nv4", "Nguyen Huu Canh beo", null, 100.000000, "phong hanh chinh");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoiluongDetrong() {
        NhanVien nhanVien = new NhanVien("nv5", "Nguyen Huu Canh tuongg", 20, null, "phong hanh chinh");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }

    @Test
    public void testNhanVienServiceVoiPhongBanDetrong() {
        NhanVien nhanVien = new NhanVien("nv5", "Nguyen Huu Canh tuongg", 20, 100.000000, "");
        assertThrows(IllegalArgumentException.class, () -> service.addNhanVien(nhanVien));
    }
}
