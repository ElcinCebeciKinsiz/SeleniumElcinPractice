package day06_Annotation_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Assertions_BestBuyTest {
    //1) Create a class: BestBuyAssertions
    //2) Go to https://www.bestbuy.com/ and test the below:
    //		○ Test the page URL is https://www.bestbuy.com/
    //		○ titleTest => Test the title do NOT contain  “Rest”
    //		○ logoTest => Test ththe BestBuy logo is displayed
    //		○ FrancaisLinkTest => Test that Frenck link is displayed



    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/ ");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();

    }
    @Test
    public void urlTest(){
  String expectedURL="https://www.bestbuy.com/";
  String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);
        System.out.println(driver.getCurrentUrl());

}
@Test
    public void titleTest(){

    String title= driver.getTitle();
    String expectedWord="Rest";
    Assert.assertFalse(title.contains(expectedWord));
    System.out.println(driver.getTitle());


}
@Test
    public void logOtEST(){
    WebElement logo= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
    Assert.assertTrue(logo.isDisplayed());

}
@Test
    public void FrancisLinkTest(){
        WebElement francisLink= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francisLink.isDisplayed());
}

}
