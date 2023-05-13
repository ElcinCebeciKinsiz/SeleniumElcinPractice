      package day07_DropDown_JsAlerts;


      import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

      public class C02_JsAlerts {
        // set required options
        // go to the https://the-internet.herokuapp.com/javascript_alerts
        // create 3 different methods to click jsAlerts
        // handle them
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
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            WebElement jsFirstButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
            jsFirstButton.click();
            Thread.sleep(2000);

            // when we see an js allert we need to swicth our driver to that alert
            // to accept the jsAlert
            //driver.switchTo().alert().accept();
            //Test that jsAlert thext is "I am a JS Alert"
            String actualTextOfJsAlert = driver.switchTo().alert().getText();
            String expectedTextOfJsAlert =  "I am a JS Alert";
            Assert.assertEquals(expectedTextOfJsAlert,actualTextOfJsAlert);
            driver.switchTo().alert().accept();
        }
        @Test
        public void test02(){
            // test that after clicking jsConfirmButton and accepting it
            // result text will be "You clicked: Ok
            // test that after clicking jsConfirmButton and canceling it
            // result text will be "You clicked: Cancel
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            jsConfirmButton.click();
            driver.switchTo().alert().accept();
            WebElement resultText = driver.findElement(By.id("result"));
            String actualText = resultText.getText();
            String expectedText = "You clicked: Ok";
            Assert.assertEquals(expectedText,actualText);
        }
    }





