package pages;

import asserts.CustomSoftAssert;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scripts.BaseTest;

import java.time.Duration;

public class BasePage {
    final long EXPLICIT_TIMEOUT = 20;
    protected WebDriver driver;
    WebDriverWait wait;
    @Getter
    CustomSoftAssert csa;

    public BasePage() {
        this.driver = BaseTest.driverThread.get();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
        this.csa = new CustomSoftAssert();
    }

    public void waitForElementAvailable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(WebElement element){
        waitForElementAvailable(element);
        return element.getText();
    }

    public void clickToElement(WebElement element){
        waitForElementAvailable(element);
        element.click();
    }

    public void sendTextToElement (WebElement element, String text){
        waitForElementAvailable(element);
        element.sendKeys(text);
    }
}
