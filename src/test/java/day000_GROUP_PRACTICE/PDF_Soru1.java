package day000_GROUP_PRACTICE;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PDF_Soru1 extends TestBase {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //kontrol edin.

    WebDriver driver;
    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown () {
        driver.close();
    }
    @Test
    public void test01 () throws InterruptedException {
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(1000);

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(1000);

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(1000);

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(1000);

        //5. Sign in tusuna basin ve geri gidin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        //5a more services butonuna tiklayin
        driver.findElement(By.id("online-banking")).click();
        Thread.sleep(1000);

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();
        Thread.sleep(1000);

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        Thread.sleep(1000);

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement menu = driver.findElement(By.id("pc_currency"));
        Select currencyMenu = new Select(menu);
        currencyMenu.selectByValue("EUR");
        Thread.sleep(1000);

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("10000");
        Thread.sleep(1000);

        //10. “US Dollars” in secilmedigini test edin
        WebElement dollarButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollarButton.isSelected());
        Thread.sleep(1000);

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(1000);

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(1000);

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String actual = driver.findElement(By.id("alert_content")).getText();
        String expected = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expected, actual);
        Thread.sleep(1000);
    }


}



