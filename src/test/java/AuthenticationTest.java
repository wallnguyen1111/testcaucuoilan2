import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

public class AuthenticationTest {
    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @ParameterizedTest
    @CsvSource({
            "Nguyen Tuong Minh,minhducbui1107@gmail.com,Minhduc2007"
    })
    public void registration(String name, String email, String password) {
        driver.get("https://hoctotlamhay.vn/register");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://hoctotlamhay.vn"));
    }

    @ParameterizedTest
    @CsvSource({
            "minhducbui1107@gmail.com,Minhduc2007,Nguyen Tuong Minh"
    })
    public void loginTest(String email, String password, String expectedName) {
        driver.get("https://hoctotlamhay.vn/login");
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://hoctotlamhay.vn"));

        WebElement nameElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + expectedName + "')]"))
        );
        assertTrue(nameElement.isDisplayed(), "Không tìm thấy tên: " + expectedName);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
