package lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mts.by");

        closeCookiesIfPresent();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    // Закрытие cookie-баннера
    private void closeCookiesIfPresent() {
        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))
            );
            cookieButton.click();
        } catch (Exception ignored) {
        }
    }

    // 1. Проверка названия блока
    @Test
    void checkBlockTitle() {
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".pay__wrapper h2")
                )
        );

        assertTrue(title.getText().contains("Онлайн пополнение"));
    }

    // 2. Проверка логотипов платёжных систем
    @Test
    void checkPaymentLogos() {
        List<WebElement> logos = driver.findElements(
                By.cssSelector(".pay__partners img")
        );

        assertEquals(5, logos.size());
    }

    // 3. Проверка ссылки "Подробнее о сервисе"
    @Test
    void checkMoreDetailsLink() {
        WebElement link = driver.findElement(
                By.linkText("Подробнее о сервисе")
        );

        link.click();

        wait.until(ExpectedConditions.urlContains("help"));

        assertTrue(driver.getCurrentUrl().contains("help"));
    }

    // 4. Проверка заполнения формы (Услуги связи)
    @Test
    void checkFormFilling() {

        // Проверяем выбранный пункт
        Select select = new Select(driver.findElement(By.id("pay")));
        assertEquals("Услуги связи", select.getFirstSelectedOption().getText());

        // Ввод номера
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.sendKeys("297777777");

        // Ввод суммы
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys("10");

        // Проверка кнопки
        WebElement button = driver.findElement(
                By.cssSelector("#pay-connection button[type='submit']")
        );

        assertTrue(button.isEnabled());
    }
}
