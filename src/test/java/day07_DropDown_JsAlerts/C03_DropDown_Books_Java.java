package day07_DropDown_JsAlerts;

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
import java.util.List;

public class C03_DropDown_Books_Java {

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
        /*
        1. Due the necessary adjustments
        2. Go to https://www.amazon.com
        3. Select the Books option from the dropdown box located next to search box
        4. Test that Books has been selected from the dropdown menu
        5. Place Java on searchbox and search for Java
        6. Test the title contains Java
        7. Dropdown box daki secenek sayisinin 27 oldugunu test edin

        */
        //
        // 2. Go to https://www.amazon.com
        driver.get("https://www.amazon.com");
        //3. Select the Books option from the dropdown box located next to search box
        WebElement dropDownWebElement =driver.findElement(By.id("searchDropdownBox"));

        //4. Test that Books has been selected from the dropdown menu
        Select select = new Select(dropDownWebElement);  // selenium developers have created a select class for us. By using this class we can handle dropDowns
                                                         // If we face a problem shown by a redline, we can always hold down ctrl key and left click on it to understand
                                                         // When we create a select object, we have to write dropDown webelement in normal brackets
        select.selectByVisibleText("Books");
        String expectedSelectedObjectText = "Books";
        String actualSelectedObjectText = select.getFirstSelectedOption().getText();  //Books  // getFirstSelectedOption retunrs the selected option
        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals(expectedSelectedObjectText,actualSelectedObjectText);

        //select.selectByIndex(5); // because of this number, it chose 5th option starting from zero. We could use this method instead VisibleText
        // select.selectByValue("search-alias=stripbooks-intl-ship"); We could also use instead of ByVisibleText or ByIndex Method

        driver.navigate().refresh();
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);
        String expectedWord = "Java";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedWord));
        Thread.sleep(1500);

        //  7. Dropdown box daki secenek sayisinin 27 oldugunu test edin
        // select.getOptions();   //get.Options() List dondurdugu icin List olusturmamiz lazim. bir WebElement olusturalim

    driver.navigate().back();
    //driver.get("https://www.amazon.com");
    dropDownWebElement =driver.findElement(By.id("searchDropdownBox"));
    select = new Select(dropDownWebElement);
    List<WebElement> dropdownOptionsWebElementListesi =select.getOptions();
    int actualDropdownOptionElementSayisi=dropdownOptionsWebElementListesi.size();
    System.out.println(actualDropdownOptionElementSayisi);

    int expectedDropdownOptionElementSayisi=28;
    Assert.assertEquals(expectedDropdownOptionElementSayisi,actualDropdownOptionElementSayisi);


    }
}



