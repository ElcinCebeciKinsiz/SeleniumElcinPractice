package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_2_Ibrahim_Hoca {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");
        //Click the Signin button
        driver.findElement(By.id("signin_button")).click();
        //Write “ username ” in the Login field
        driver.findElement(By.id("user_login")).sendKeys("username");
        //Write “ password ” in the password field
        driver.findElement(By.id("user_password")).sendKeys("password");
        //Click the Sign in button
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
        driver.navigate().back();
        //Go to the Pay Bills page
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //Type any amount you want to deposit in the amount
        driver.findElement(By.id("sp_amount")).sendKeys("10000");
        //Write “2020-0 9 - 10 ” on the 8th date part
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //Click on the Pay button
        driver.findElement(By.id("pay_saved_payees")).click();
        //“The payment was successfully submitted.” test that the it appears
        WebElement paymentMessage = driver.findElement(By.id("alert_content"));
        if (paymentMessage.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        driver.close();




    }
}
