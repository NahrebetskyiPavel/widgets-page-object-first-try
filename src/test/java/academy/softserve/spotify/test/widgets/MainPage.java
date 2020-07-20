package academy.softserve.spotify.test.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open(String baseURL) {
        driver.get(baseURL);
        return this;
    }


    public SingUpPage singUp(String seconds) {

        new WebDriverWait(driver,Integer.parseInt(seconds)).until(ExpectedConditions.elementToBeClickable(By.linkText("Sign up")));
        driver.findElement(By.linkText("Sign up")).click();

        return new SingUpPage();

    }

}
