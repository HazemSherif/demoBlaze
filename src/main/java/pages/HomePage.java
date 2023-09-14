package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagehelpers.PageBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends PageBase {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement signUpLink = driver.findElement(By.xpath("//li[.//a[@id ='signin2']]"));
    WebElement loginButton = driver.findElement(By.id("login2"));

    WebElement phonesCategory = driver.findElement(By.xpath("//a[@onclick = \"byCat('phone')\"]"));
    WebElement phoneList = driver.findElement(By.id("tbodyid"));
    List<WebElement> phoneListsElements = phoneList.findElements(By.xpath("//div[@class = 'card h-100']"));

    WebElement laptopsCategory = driver.findElement(By.xpath("//a[@onclick = \"byCat('notebook')\"]"));
    WebElement laptopList = driver.findElement(By.id("tbodyid"));
    List<WebElement> laptopListsElements = laptopList.findElements(By.xpath("//div[@class = 'card h-100']"));

    WebElement monitorCategory = driver.findElement(By.xpath("//a[@onclick = \"byCat('monitor')\"]"));
    WebElement monitorLists = driver.findElement(By.id("tbodyid"));
    List<WebElement> monitorListsElements = monitorLists.findElements(By.xpath("//div[@class = 'card h-100']"));

    WebElement categoryList = driver.findElement(By.className("list-group"));
    List<WebElement> listOfCategories = categoryList.findElements(By.className("list-group-item"));

    WebElement productList = driver.findElement(By.id("tbodyid"));
    List<WebElement> listOfProducts = productList.findElements(By.tagName("img"));



    public SignUpPage clickOnSignUpLink(){
        clickOnElement(signUpLink);
        return new SignUpPage(driver);
    }
    public LoginPage clickOnLoginButton(){
        clickOnElement(loginButton);
        return new LoginPage(driver);
    }
    public void clickPhonesCategory(){
        clickOnElement(phonesCategory);
    }
    public int phoneCategorySize(){
        return phoneListsElements.size();
    }
    public void clickLaptopCategory(){
        clickOnElement(laptopsCategory);
    }
    public int laptopCategorySize(){
        return laptopListsElements.size();
    }
    public void clickMonitorCategory(){
        clickOnElement(monitorCategory);
    }
    public int monitorCategorySize(){
        return monitorListsElements.size();
    }
    public void randomCategorySelector(){

        List<WebElement> filteredElements = new ArrayList<>();
        for (WebElement element : listOfCategories) {
            if (!element.getText().equals("CATEGORIES")) {
                filteredElements.add(element);
            }
        }
        //Select random category
        Random random = new Random();
        int randomCategory = random.nextInt(filteredElements.size());
        filteredElements.get(randomCategory).click();

    }
    public ProductPage randomProductSelector(){
        Random randomNumber = new Random();
        int randomProduct = randomNumber.nextInt(listOfProducts.size());
        // scroll to center of page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
        listOfProducts.get(randomProduct).click();
        return new ProductPage(driver);
    }








}
