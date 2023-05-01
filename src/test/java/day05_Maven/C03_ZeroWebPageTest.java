package day05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebPageTest {
    public static void main(String[] args) throws InterruptedException {

        System.err.println(WebDriverManager.chromedriver());
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




        //Go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com ");

        //Click oon the signing in button
        driver.findElement(By.id("signin_button")).click();

        //Put ''username" on login box
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username"+ Keys.ENTER);

        // Please pur "surname" on passwaord box
      driver.findElement(By.id("user_password")). sendKeys("password"+Keys.ENTER);

        //Click on enter button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //plesae do natigate back and select Pay Bills from Bankins tab

        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //Enter the amount you like to pay on the amount box


        //Put the date of "30-04-2023"


        //Enter the pay button


        //Test the mesagge of "The payment was succesfully submitted" is displayed




        Thread.sleep(3000);
        driver.close();


    }
}
