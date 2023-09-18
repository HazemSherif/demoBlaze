package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected HomePage homePage;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
    @BeforeMethod
    public HomePage launchApp() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        driver.get("https://demoblaze.com/");
        return homePage;
    }

    @AfterMethod
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
