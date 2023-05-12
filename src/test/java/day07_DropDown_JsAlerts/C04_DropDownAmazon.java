package day07_DropDown_JsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C07_DropDownAmazon {

   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // set up the driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void teardown() {
        // close the driver
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

    //Q1-a.Go to amazon webpage
    //  -b.From the dropdown menu next to searc box select "book"
    //  -c.Enter "Java" onthe searh box
    //  -d.Test if title contains Java

        // navigate to the Amazon homepage
        driver.get("https://www.amazon.com/");

        // find the dropdown box element and create a Select object
        WebElement dropDownBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownBox);

        // select an option from the dropdown by its value
        //Bunu 3 sekilde yapabiliriz select.selectByValue() or Select.selectByIndex() or select.selectByVisibleText() ile yapabiliriz
        select.selectByValue("search-alias=stripbooks-intl-ship");
/*
       select.selectByValue("search-alias=stripbooks-intl-ship");

        select.selectByIndex(5); //inspect yaptiginda en ustteki option'un oldugu text 0.index, sonraki 1. index oluyor ve boyle devam ediyor
        ook ise 5.indeksdeymis

        select.selectByVisibleText("Books");
*/
        //-c.Enter "Java" onthe searh box
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

        //  -d.Test if title contains Java
        String expectedWord="Java";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedWord));

        //from the dropdow menu test if "Books" option was selected

        dropDownBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownBox);
        select.selectByIndex(5);

        String actualSelectedOption=select.getFirstSelectedOption().getText();  //bu bize ilk secileni text olarak getirir yani "Books"
        String expectedSelectedOption="Books";
        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);


        Thread.sleep(2000);
    }
}






