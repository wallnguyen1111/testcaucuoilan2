package buoi5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class seleumbuoi5 {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @ParameterizedTest
    @CsvSource({
            "user@example.com, MyPassword123"
    })
    public void loginTest(String email, String password) {
        driver.get("https://vitimex.com.vn/account/login");

        driver.findElement(By.id("customer_email")).sendKeys(email);
        driver.findElement(By.id("customer_password")).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // selector chính xác cho input submit bạn vừa gửi
        By dangNhap = By.cssSelector("input.btn-vtm.btn-signin[type='submit'][value='Đăng nhập']");

        // chờ tồn tại + có thể click (cushion để trang render JS)
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(dangNhap));
        wait.until(ExpectedConditions.elementToBeClickable(dangNhap));

        // scroll + Actions click, nếu bị chặn thì JS click
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
            new org.openqa.selenium.interactions.Actions(driver)
                    .moveToElement(loginBtn)
                    .pause(Duration.ofMillis(150))
                    .click()
                    .perform();
        } catch ( org.openqa.selenium.WebDriverException ex) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
        }

        // chờ redirect / landing
        wait.until(ExpectedConditions.urlContains("https://vitimex.com.vn"));
    }

    @ParameterizedTest
    @CsvSource({
            "Nguyen, Tuong, Nam, 10/02/1995, user@example.com, MyPassword123"
    })
    public void registration(String ho, String ten, String gioiTinh, String ngaySinh,
                             String email, String password) {

        driver.get("https://vitimex.com.vn/account/register");

        // Họ & Tên
        driver.findElement(By.id("last_name")).sendKeys(ho);
        driver.findElement(By.id("first_name")).sendKeys(ten);

        // Giới tính
        if (gioiTinh.equalsIgnoreCase("nam")) {
            driver.findElement(By.id("radio1")).click();
        } else {
            driver.findElement(By.id("radio2")).click();
        }

        // Ngày sinh
        driver.findElement(By.name("customer[birthday]")).sendKeys(ngaySinh);

        // Email & Mật khẩu
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // chờ overlay datepicker/tooltip ẩn (nếu có)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ui-state-default")));

        By dangKy = By.cssSelector("input[type='submit'][value='Đăng ký']");
        wait.until(ExpectedConditions.elementToBeClickable(dangKy)).click();

        wait.until(ExpectedConditions.urlContains("/account"));
    }

    @ParameterizedTest
    @CsvSource({
            "skipdi"
    })
    public void checktimkiem(String keyword) {
        driver.get("https://vitimex.com.vn/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By chontimkiem = By.xpath("M21 21.624L17.5001 18.124M20 12.124C20 16.8184 16.1944 20.624 11.5 20.624C6.80558 20.624 3 16.8184 3 12.124C3 7.4296 6.80558 3.62402 11.5 3.62402C16.1944 3.62402 20 7.4296 20 12.124Z");
        wait.until(ExpectedConditions.elementToBeClickable(chontimkiem)).click();

        // Họ & Tên
        driver.findElement(By.id("inputSearchAuto")).sendKeys(keyword);

        // chờ overlay datepicker/tooltip ẩn (nếu có)

        By dangKy = By.xpath("M21 21.624L17.5001 18.124M20 12.124C20 16.8184 16.1944 20.624 11.5 20.624C6.80558 20.624 3 16.8184 3 12.124C3 7.4296 6.80558 3.62402 11.5 3.62402C16.1944 3.62402 20 7.4296 20 12.124Z");
        wait.until(ExpectedConditions.elementToBeClickable(dangKy)).click();

        wait.until(ExpectedConditions.urlContains("/account"));
    }



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
