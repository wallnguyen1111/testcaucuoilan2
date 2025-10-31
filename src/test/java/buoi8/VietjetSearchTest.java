package buoi8;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VietjetSearchTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    @Test
    @Order(1)
    void testTimKiemChuyenBay() {
        driver.get("https://www.vietjetair.com/vi/ve-may-bay/bay-dang-cap-boss-gia-chi-eco-uu-dai-20-ngay-20-hang-thang/");

        By[] cookieSelectors = new By[] {
                By.xpath("//button[contains(@onclick,'ldr_accept_cookie_policy')]"),
                By.xpath("//button[contains(.,'Đồng ý') and contains(@class,'MuiButton')]"),
                By.xpath("//button[contains(.,'Đồng ý')]")
        };
        for (By sel : cookieSelectors) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(sel));
                btn.click();
                break;
            } catch (Exception ignored) {}
        }

        WebElement from = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder*='Điểm khởi hành'], input[placeholder*='From']")
        ));
        from.click();
        from.clear();
        from.sendKeys("Hà Nội");
        try { wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li, .ac-item, .dropdown-item"))); } catch (Exception ignored) {}
        from.sendKeys(Keys.ENTER);

        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder*='Điểm đến'], input[placeholder*='To']")
        ));
        to.click();
        to.clear();
        to.sendKeys("Đà Nẵng");
        try { wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li, .ac-item, .dropdown-item"))); } catch (Exception ignored) {}
        to.sendKeys(Keys.ENTER);
        try {
            String depart = "30/10/2025";
            String ret = "30/10/2025";
            js.executeScript("let p1 = document.getElementById('input-calendar_1'); if(p1){ p1.innerText = arguments[0]; p1.dispatchEvent(new Event('change')); }", depart);
            js.executeScript("let p2 = document.getElementById('input-calendar_2'); if(p2){ p2.innerText = arguments[0]; p2.dispatchEvent(new Event('change')); }", ret);
            js.executeScript(
                    "let in1 = document.querySelector(\"input[name*='depart'], input[id*='depart'], input[type='date']\");" +
                            "if(in1){ try{ in1.value = arguments[0]; in1.dispatchEvent(new Event('input')); in1.dispatchEvent(new Event('change')); }catch(e){} }",
                    "2025-10-30"
            );
            js.executeScript(
                    "let in2 = document.querySelector(\"input[name*='return'], input[id*='return'], input[type='date']\");" +
                            "if(in2){ try{ in2.value = arguments[0]; in2.dispatchEvent(new Event('input')); in2.dispatchEvent(new Event('change')); }catch(e){} }",
                    "2025-10-30"
            );
        } catch (Exception ignored) {}

        try {
            WebElement pax = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-passenger-mb")));
            scrollIntoView(pax);
            try { pax.click(); } catch (Exception ignored) {}
            js.executeScript("let p = document.getElementById('input-passenger-mb'); if(p){ p.value = arguments[0]; p.dispatchEvent(new Event('input')); }", "2 người lớn");
        } catch (Exception ignored) {}

        try {
            WebElement promo = wait.until(ExpectedConditions.elementToBeClickable(By.id("ldr_promoCode")));
            promo.click();
            promo.clear();
            promo.sendKeys("PROMO2025");
        } catch (Exception ignored) {}

        try {
            WebElement cheap = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flexCheckDefault")));
            if (!cheap.isSelected()) {
                scrollIntoView(cheap);
                try { cheap.click(); } catch (Exception e) {
                    // fallback via JS
                    js.executeScript("arguments[0].click();", cheap);
                }
            }
        } catch (Exception ignored) {}

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'Tìm chuyến') or contains(.,'TÌM') or contains(.,'Tìm vé') or contains(.,'Search')]")
        ));
        search.click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("search"),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Chuyến bay') or contains(text(),'Flights')]"))
        ));

        assertTrue(
                driver.getCurrentUrl().contains("search") ||
                        driver.getPageSource().contains("Chuyến bay") ||
                        driver.getPageSource().contains("Flight"),
                "Không thấy trang kết quả chuyến bay!"
        );
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    private void scrollIntoView(WebElement el) {
        try { js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", el); } catch (Exception ignored) {}
    }
}
