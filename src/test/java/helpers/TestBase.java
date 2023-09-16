package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    protected HomePage homePage;
    @BeforeSuite
    public void setupDriver(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);

    }
    @BeforeMethod
    public void startDriver(){
        driver.get("https://demoblaze.com/");
    }

    @AfterSuite
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
