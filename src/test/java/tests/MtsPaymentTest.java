package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import pages.PaymentPage;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTest {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeEach
    void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches",
                new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);

        driver.get("https://mts.by");

        paymentPage = new PaymentPage(driver);
        paymentPage.acceptCookiesIfPresent();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void fullPaymentTest() {

        assertTrue(paymentPage.getTitleText()
                .contains("Онлайн пополнение"));

        assertEquals(5, paymentPage.getLogosCount());

        paymentPage.fillPhone("297777777");
        paymentPage.fillSum("10");

        paymentPage.clickContinue();


        assertTrue(driver.findElements(By.tagName("iframe")).size() >= 0);
    }
}
