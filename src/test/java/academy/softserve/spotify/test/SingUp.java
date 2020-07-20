package academy.softserve.spotify.test;
import academy.softserve.spotify.test.widgets.MainPage;
import academy.softserve.spotify.test.widgets.Saver;
import academy.softserve.spotify.test.widgets.SingUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static academy.softserve.spotify.test.testconfigs.ID.*;
import static academy.softserve.spotify.test.testconfigs.Month.*;
import static academy.softserve.spotify.test.testconfigs.Checkbox.*;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class SingUp {
    private WebDriver driver;
    public static final int random = (int) System.currentTimeMillis() / 1000;

    @BeforeClass
    public void setupTest() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.setProperty("jansi.passthrough", "true");
        System.setProperty("webdriver.chrome.logfile", "C:\\Users\\Pavel\\Documentschromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "false");
    }


    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Saver().screenshot(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("driver teardown");
        }
    }

    @Parameters({"BaseURL", "singUpClickableWaitTime"})
    @Test(groups = {"returnValue"})
    public void test(String URL, String clicableTime) {
        new MainPage(driver).open(URL).
                singUp(clicableTime);
        new SingUpPage().setDriver(driver)
                .setData(AGREMENT_HEADER)
                .setData(EMAIL, "nagrebetski.p" + "+" + random + "@gmail.com")
                .setData(CONFIRM_EMAIL, "nagrebetski.p" + "+" + random + "@gmail.com")
                .setData(PASSWORD, "1234qwerty")
                .setData(PROFILE_NAME, "nagrebetskiPavel")
                .setData(DAY_OF_BIRTH, "23")
                .setData(MONTH_OF_BIRTH, April)
                .setData(YEAR_OF_BIRTH, "1990")
                .setData(NON_BINARY)
                .setData(SHARE)
                .setData(SPAM)
                .setData(AGREEMENT);

        String actualEmail = driver.findElement(By.id(EMAIL.getValue())).getText();
        String expectedConfirmationEmail = driver.findElement(By.id(CONFIRM_EMAIL.getValue())).getText();
        Assert.assertEquals(expectedConfirmationEmail, actualEmail);
    }

}

