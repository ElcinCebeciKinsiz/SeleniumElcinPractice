package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButton {
// Radio buttons are the when you select one option the other option will be unselected
//When you tick box for Female, male box will be unselected
/*
    Create the required structure and complete the following task.
    a. Go to the given web page.
    https://facebook.com
    b. Accept cookies
    c. Press the Create an account button
    D. Locate the radio button elements and choose the one that suits you
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
 public static  void teardown(){

}

@Test
 public void test01(){
  driver.get("https://facebook.com");

 WebElement cookies= driver.findElement(By.xpath("//button[@id='u_0_s_Io']"));
 cookies.click();

  driver.findElement(By.xpath("//a[@id='u_0_0_fg']")).click();









}




}
