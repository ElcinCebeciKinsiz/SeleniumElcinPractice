package day000_GROUP_PRACTICE;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Q1_080523_FakerIleCozum extends TestBase {
    @Test
    public void Test01() throws InterruptedException {


        driver.get("https://www.techlistic.com/p/selenium-practice-form.html?utm_content=cmp-true");
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        //driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        //driver.findElement(By.xpath("//div[@id='ez-video-ez-stuck-close']")).click();
        //driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();
        WebElement firstName = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB)
                .sendKeys("2022")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .perform();
        Thread.sleep(3000);
        WebElement dropdownElement = driver.findElement(By.id("continents"));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Europe");
/*
        WebElement dropdownElemen2=driver.findElement(By.xpath("//*[text()='Browser Commands"));
        Select select1 =new Select(dropdownElemen2);
        select.selectByVisibleText("Browser Command");
 */
        driver.findElement(By.xpath("//*[text()='Browser Commands']")).click();
       WebElement submitbutton= driver.findElement(By.id("submit"));
       submitbutton.click();
        Thread.sleep(5000);
    }
}