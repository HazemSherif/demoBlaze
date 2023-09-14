package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pagehelpers.PageBase;
import pages.HomePage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    HomePage homePage;
    PageBase pageBase;

    @BeforeTest
    public void startDriver(){

        driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        pageBase = new PageBase(driver);

    }

    @AfterTest
    public void stopDriver() {
        if (null != driver) {
            driver.close();
        }
    }

    public String generateRandomString() {
        String uuid = UUID.randomUUID().toString();
        // Remove hyphens and convert to lowercase
        return uuid.replaceAll("-", "").toLowerCase();
    }
}
