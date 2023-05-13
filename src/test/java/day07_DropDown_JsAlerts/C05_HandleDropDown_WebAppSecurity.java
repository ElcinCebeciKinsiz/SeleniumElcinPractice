package day07_DropDown_JsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_HandleDropDown_WebAppSecurity {
  /*
  1. http://zero.webappsecurity.com/ Adresine gidin
  2. Sign in butonuna basin
  3. Login kutusuna “username” yazin
  4. Password kutusuna “password.” yazin
  5. Sign in tusuna basin
  6. Pay Bills sayfasina gidin
  7. “Purchase Foreign Currency” tusuna basin
  8. “Currency” drop down menusunden Eurozone’u secin
  9. “amount” kutusuna bir sayi girin
  10. “US Dollars” in secilmedigini test edin
  11. “Selected currency” butonunu secin
  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
  13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
   */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void treardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test01(){
    driver.get("http://zero.webappsecurity.com/");
    driver.findElement(By.xpath("//button[@id='signin_button']")).click();
    driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username"+ Keys.ENTER);
    driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password"+Keys.ENTER);
    driver.findElement(By.xpath("//input[@name='submit']")).click();
    driver.navigate().back();
    driver.findElement(By.xpath("//li[@id='onlineBankingMenu']//div//strong")).click();




    }





}
