package buoi4;

import org.example.buoi4.SinhVien;
import org.example.buoi4.SinhVienService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSinhVienService {
    private SinhVienService service;

    @BeforeEach
    public void setUp() {
        service = new SinhVienService();
    }

    @Test
    public void testSuaSinhVienHopLe() {
        SinhVien sinhVien = new SinhVien("SV1", "NguyenHuuCanhTuong", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV1", "NguyenHuuCanhTuongsdfsf", 18, 9.9f, 5, "CNTT");
        assertTrue(service.suaSinhVien("SV1", sinhVienMoi));
    }

    @Test
    public void testSuaSinhVienVoiKhongCoId() {
        SinhVien sinhVien = new SinhVien("SV2", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("", "NguyenHuuCanhTuongsdfsf", 0, 9.9f, 5, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("", sinhVienMoi));
    }

    @Test
    public void testSuaSinhVienVoiDiemTBNgoaiPhanVung() {
        SinhVien sinhVien = new SinhVien("SV3", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV3", "NguyenHuuCanhTuongsdfsf", 18, -9.9f, 5, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("SV3", sinhVienMoi));
    }

    @Test
    public void testSuaSinhVienVoiDiemKhiBoTrongTen() {
        SinhVien sinhVien = new SinhVien("SV4", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV4", "", 18, 9.9f, 5, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("SV4", sinhVienMoi));
    }


    @Test
    public void testSuaSinhVienVoiDiemKhiBoTrongTuoi() {
        SinhVien sinhVien = new SinhVien("SV5", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV5", "NguyenHuuCanhTuong2", null, 9.9f, 5, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("SV5", sinhVienMoi));
    }

    @Test
    public void testSuaSinhVienVoiDiemKhiBoTrongDiemTB() {
        SinhVien sinhVien = new SinhVien("SV6", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV6", "NguyenHuuCanhTuong2", 18, null, 5, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("SV6", sinhVienMoi));
    }

    @Test
    public void testSuaSinhVienVoiDiemKhiBoTrongKy() {
        SinhVien sinhVien = new SinhVien("SV6", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV6", "NguyenHuuCanhTuong2", 18, 9.9f, null, "CNTT");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("SV6", sinhVienMoi));
    }

    @Test
    public void testSuaSinhVienVoiDiemKhiBoTrongChuyenNganh() {
        SinhVien sinhVien = new SinhVien("SV7", "NguyenHuuCanhTuong2", 18, 9.9f, 5, "CNTT");
        service.addSinhVien(sinhVien);
        SinhVien sinhVienMoi = new SinhVien("SV7", "NguyenHuuCanhTuong2", 18, 9.9f, 6, "");
        assertThrows(IllegalArgumentException.class, () -> service.suaSinhVien("SV7", sinhVienMoi));
    }

}
