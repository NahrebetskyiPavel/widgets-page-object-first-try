package academy.softserve.spotify.test.widgets;

import academy.softserve.spotify.test.testconfigs.Checkbox;
import academy.softserve.spotify.test.testconfigs.ID;
import academy.softserve.spotify.test.testconfigs.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage {
    private static WebDriver driver;
    public static String window;

    public SingUpPage setDriver(WebDriver driver) {
        this.driver = driver;
        window = driver.getWindowHandle();
        return this;
    }

    public SingUpPage setData(ID label, String data) {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.id(label.getValue())));
        //driver.findElement(By.id(label.getValue())).click();
        driver.findElement(By.id(label.getValue())).sendKeys(data);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementValue(By.id(label.getValue()), data));
        return this;
    }

    public SingUpPage setData(ID label, Month month) {
        String xpath = "//option[contains(text(),'" + month + "')]";
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.id(label.getValue())));
        driver.findElement(By.id(label.getValue())).click();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.id(label.getValue())).findElement(By.xpath(xpath)).click();
        return this;
    }

    public SingUpPage setData(Checkbox checkbox) {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.xpath(checkbox.getValue())));
        driver.findElement(By.xpath(checkbox.getValue())).click();
        return this;
    }
}
