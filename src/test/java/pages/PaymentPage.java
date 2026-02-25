package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void fillPhone(String phone) {

        WebElement input = waitUntilVisible(phoneInput);

        input.clear();

        input.sendKeys(phone);

        input.sendKeys(org.openqa.selenium.Keys.TAB);
    }

    public void fillSum(String sum) {
        waitUntilVisible(sumInput).sendKeys(sum);
    }

    public void clickContinue() {

        WebElement button = waitUntilClickable(continueButton);

        scrollToElement(button);

        jsClick(button);

        wait.until(d -> driver.findElements(By.tagName("iframe")).size() > 0);
    }

}
