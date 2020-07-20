package academy.softserve.spotify.test.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;


public class Browser {
    public static void getBack(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;


        new WebDriverWait(driver, 10).until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(originalWindow);
                break;
            }
        }
    }
}
