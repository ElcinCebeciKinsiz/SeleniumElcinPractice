package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TEST {

    public static void main(String[] args) throws InterruptedException {

        System.err.println(WebDriverManager.chromedriver());
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");



        //2. Signin buttonuna tiklayin
     driver.findElement(By.xpath("//button[@id='signin_button']")).click();



        //3. Login alanina  “username” yazdirin
      WebElement userName= driver.findElement(By.xpath("//input[@id='user_login']")); //yanlislikla oldu kusura bakmayin :)))
      userName.sendKeys("username"+ Keys.ENTER);


        //4. Password alanine “password” yazdirin
        WebElement passWord= driver.findElement(By.xpath("//input[@id='user_password']"));
        passWord.sendKeys("password"+Keys.ENTER);




        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();


        //6. navigate back yapip,online banking menusunden Pay Bills sayfasina gidin
        driver.navigate().back();
Thread.sleep(2000);

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement onlineClick=driver.findElement(By.id("onlineBankingMenu"));  //Buraya Bak
        onlineClick.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        WebElement payAmount= driver.findElement(By.xpath("//input[@id='sp_amount']"));
        payAmount.sendKeys("100");

        //8. tarih kismina “2020-09-10” yazdirin
       driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");


        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        String expectedWord="The payment was successfully submitted.";
        String actualWord=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']")).getText();
        Assert.assertTrue(expectedWord.equals(actualWord));




        driver.close();
    }
}










