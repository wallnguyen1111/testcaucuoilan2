import org.example.TinhTrungBinhCong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TestTinhTrungBinhCong {
    private TinhTrungBinhCong service;
    @BeforeEach
    public void setUp()  {service = new TinhTrungBinhCong();}

    @Test
    public void testTinhTrungBinhCong() {
        double exp = 9.5;
        double act = service.tinhbtcong(9.5, 9.5, 9.5);
        Assertions.assertEquals(exp, act);
    }



}
