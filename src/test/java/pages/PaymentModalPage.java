package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentModalPage extends BasePage {

    private final By allIframes = By.tagName("iframe");

    private final By cardNumber = By.id("cc-number");
    private final By expirationDate = By.cssSelector("input[formcontrolname='expirationDate']");
    private final By cvc = By.cssSelector("input[formcontrolname='cvc']");
    private final By cardHolder = By.cssSelector("input[formcontrolname='holder']");

    public PaymentModalPage(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {

        wait.until(d -> d.findElements(allIframes).size() > 0);

        List<WebElement> iframes = driver.findElements(allIframes);

        boolean switched = false;

        for (WebElement iframe : iframes) {

            driver.switchTo().frame(iframe);

            if (driver.findElements(cardNumber).size() > 0) {
                switched = true;
                break;
            }

            driver.switchTo().defaultContent();
        }

        if (!switched) {
            throw new RuntimeException("Payment iframe not found");
        }

        waitUntilVisible(cardNumber);
    }

    public boolean isCardNumberVisible() {
        return waitUntilVisible(cardNumber).isDisplayed();
    }

    public boolean isExpirationVisible() {
        return waitUntilVisible(expirationDate).isDisplayed();
    }

    public boolean isCvcVisible() {
        return waitUntilVisible(cvc).isDisplayed();
    }

    public boolean isCardHolderVisible() {
        return waitUntilVisible(cardHolder).isDisplayed();
    }

    public void switchBackToMainPage() {
        driver.switchTo().defaultContent();
    }
}