package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C07_DropDown_Books_Java {

    // 1) locate the webElement
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement dropDownWebElement =driver.findElement(By.id("searchDropdownBox"));
        // selenium developers have created a select class for us. By using this class we can handle dropDowns
        // If we face a problem shown by a redline, we can always hold down ctrl key and left click on it to understand
        // When we create a select object, we have to write dropDown webelement in normal brackets
        Select select = new Select(dropDownWebElement);
        // to select an option from the drop down we can use visible text
        select.selectByVisibleText("Books");
        // getFirstSelectedOption retunrs the selected option
        String expectedSelectedObjectText = "Books";
        String actualSelectedObjectText = select.getFirstSelectedOption().getText();  // Books
        Assert.assertEquals(expectedSelectedObjectText,actualSelectedObjectText);
        select.selectByIndex(7); // because of this number, it chose 7th option staring from zero
        select.selectByValue("search-alias=digital-music");
        // search for Java in digital-music section and test that title has Java word
        // refreshing the page
        driver.navigate().refresh();
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);
        String expectedWord = "nutella";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedWord));
        Thread.sleep(15000);
    }
}



