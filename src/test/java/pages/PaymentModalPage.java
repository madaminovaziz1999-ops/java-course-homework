package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentModalPage extends BasePage {

    private final By iframeLocator =
            By.cssSelector("iframe[src*='bepaid']");

    private final By cardNumber =
            By.cssSelector("input[id='cc-number']");

    private final By expirationDate =
            By.cssSelector("input[formcontrolname='expirationDate']");

    private final By cvc =
            By.cssSelector("input[formcontrolname='cvc']");

    private final By cardHolder =
            By.cssSelector("input[formcontrolname='holder']");

    public PaymentModalPage(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {

        // Ждём iframe bePaid
        wait.until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(iframeLocator));

        // Ждём поле карты
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(cardNumber));
    }

    public boolean isCardNumberVisible() {
        return driver.findElement(cardNumber).isDisplayed();
    }

    public boolean isExpirationVisible() {
        return driver.findElement(expirationDate).isDisplayed();
    }

    public boolean isCvvVisible() {
        return driver.findElement(cvc).isDisplayed();
    }

    public boolean isCardHolderVisible() {
        return driver.findElement(cardHolder).isDisplayed();
    }
}