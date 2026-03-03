package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

public class PaymentPage extends BasePage {

    private final By title = By.cssSelector(".pay__wrapper h2");
    private final By paymentLogos = By.cssSelector(".pay__partners img");

    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By continueButton =
            By.cssSelector("#pay-connection button[type='submit']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return waitUntilVisible(title).getText();
    }

    public int getLogosCount() {
        return driver.findElements(paymentLogos).size();
    }

    // ===== ПРОВЕРКИ (пункт 1) =====

    public boolean isPhoneFieldVisible() {
        return waitUntilVisible(phoneInput).isDisplayed();
    }

    public boolean isSumFieldVisible() {
        return waitUntilVisible(sumInput).isDisplayed();
    }

    public boolean isContinueButtonVisible() {
        return waitUntilVisible(continueButton).isDisplayed();
    }

    // ===== ДЕЙСТВИЯ =====

    @Step("Заполнение телефона: {phone}")
    public void fillPhone(String phone) {
        WebElement input = waitUntilVisible(phoneInput);
        input.clear();
        input.sendKeys(phone);
    }

    @Step("Заполнение суммы: {sum}")
    public void fillSum(String sum) {
        WebElement input = waitUntilVisible(sumInput);
        input.clear();
        input.sendKeys(sum);
    }

    @Step("Нажатие кнопки Продолжить")
    public void clickContinue() {
        WebElement button = waitUntilClickable(continueButton);
        scrollToElement(button);
        jsClick(button);
    }
}
