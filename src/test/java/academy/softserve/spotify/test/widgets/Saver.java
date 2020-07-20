package academy.softserve.spotify.test.widgets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saver {
    public void screenshot(WebDriver driver)  {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String screenshotName = formatter.format(date).replace(":","-").replace("\\s+","-");
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Pavel\\Pictures\\Selenium\\Selenium" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
