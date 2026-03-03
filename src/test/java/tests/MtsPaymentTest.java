package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.PaymentModalPage;
import pages.PaymentPage;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("MTS Payment")
@Feature("Online Payment Block")
public class MtsPaymentTest {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeEach
    void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches",
                List.of("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);

        // Убираем navigator.webdriver (анти-бот защита)
        ((JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
        );

        driver.get("https://mts.by/");

        paymentPage = new PaymentPage(driver);
        paymentPage.acceptCookiesIfPresent();
    }

    @Test
    @Story("Successful opening payment modal")
    @Severity(SeverityLevel.CRITICAL)
    void fullPaymentTest() {

        // Проверки из пункта 1
        assertTrue(paymentPage.getTitleText()
                .contains("Онлайн пополнение"));

        assertEquals(5, paymentPage.getLogosCount());

        assertTrue(paymentPage.isPhoneFieldVisible());
        assertTrue(paymentPage.isSumFieldVisible());
        assertTrue(paymentPage.isContinueButtonVisible());

        // Действия
        paymentPage.fillPhone("297777777");
        paymentPage.fillSum("10");
        paymentPage.clickContinue();

        System.out.println("IFRAMES COUNT: " +
                driver.findElements(By.tagName("iframe")).size());

        // Проверки после нажатия
        PaymentModalPage modalPage = new PaymentModalPage(driver);
        modalPage.waitForModal();

        assertTrue(modalPage.isCardNumberVisible());
        assertTrue(modalPage.isExpirationVisible());
        assertTrue(modalPage.isCvvVisible());
        assertTrue(modalPage.isCardHolderVisible());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}