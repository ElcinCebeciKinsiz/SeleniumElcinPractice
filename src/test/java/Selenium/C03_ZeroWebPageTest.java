package Selenium;

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
        driver.get("http://zero.webappsecurity.com");

        //Click oon the signing in button
        driver.findElement(By.id("signin_button")).click();

        //Put ''username" on login box
        WebElement loginTextBox= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginTextBox.sendKeys("username"+ Keys.ENTER);

        // 4. Please pur "surname" on passwaord box
     WebElement passwordBox=driver.findElement(By.id("user_password"));
     passwordBox.sendKeys("password"+Keys.ENTER);

        //5. Click on enter button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //plesae do navigate back and select Pay Bills from Banking tab

        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //Enter the amount you like to pay on the amount box


        //Put the date of ""


        //Enter the pay button


        //Test the mesagge of "The payment was succesfully submitted" is displayed




        Thread.sleep(3000);
        driver.close();


    }

    public static class C03_ZeroWebPageOnlineBankingTest {

        public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //1. http://zero.webappsecurity.com sayfasina gidin
            driver.get("http://zero.webappsecurity.com");
            //2. Signin buttonuna tiklayin
            driver.findElement(By.id("signin_button")).click();
            //3. Login alanina  “username” yazdirin
            driver.findElement(By.id("user_login")).sendKeys("username");
            //4. Password alanine “password” yazdirin
            driver.findElement(By.id("user_password")).sendKeys("password");
            //5. Sign in buttonuna tiklayin
            driver.findElement(By.xpath("//input[@name='submit']")).click();
            //6. navigate back yapip,online banking menusunden Pay Bills sayfasina gidin
            driver.navigate().back();
            driver.findElement(By.id("onlineBankingMenu")).click();
            driver.findElement(By.id("pay_bills_link")).click();
            //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
            driver.findElement(By.id("sp_amount")).sendKeys("200");
            //8. tarih kismina “2020-09-10” yazdirin
            driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
            //9. Pay buttonuna tiklayin
            driver.findElement(By.id("pay_saved_payees")).click();
            //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
            WebElement succesfullyElementi= driver.findElement(By.id("alert_content"));

            if (succesfullyElementi.isDisplayed()){
                System.out.println("Test PASSED");
            }else{
                System.out.println("Test FAILED");
            }

            driver.close();
        }
    }
}
