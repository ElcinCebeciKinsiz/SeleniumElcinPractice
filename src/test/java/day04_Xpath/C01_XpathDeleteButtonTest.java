package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathDeleteButtonTest {
    public static void main(String[] args) throws InterruptedException {
        //Q1
        //1.https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //2.Add element butonuna basin
        //3.Delete butonu'nun gorunur oldugiunu test edin
        //4.Delete tusuna basin
        //5."Add/Remove Elements" yazisinin gorunur oldugunu tespit edin

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("//the-internet.herokuapp.com/add_remove_elements/"); //1.Adrese gittik
        driver.findElement(By.xpath("//*[text()='Add Element'")).click(); //2.Delete Click yaptik

        WebElement deleteButon = driver.findElement(By.xpath("//*[text()='Delete']"));// Delete button gorunuyor mu testi
        if (deleteButon.isDisplayed()) {
            System.out.println("Button display test PASSED");
        } else {
            System.out.println("Button display test failed");
        }
        driver.findElement(By.xpath("//*[text()='Delete']")).click(); //4.Delete button'una bas

        WebElement addRemoveYazi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")); //5.Addd/Remove Yazi Gorunuyor mu
        if (addRemoveYazi.isDisplayed()) {
            System.out.println("Add/Remove Yazi Testi PASSED");
    }else {
            System.out.println("Add/Remove Yazi Testi FAILED");

        }

        Thread.sleep(3000);
        driver.close();
    }
}
