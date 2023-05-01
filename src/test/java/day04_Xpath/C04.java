package day04_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //  1- Go to https://the-internet.herokuapp.com/add_remove_elements/
      //  2- Press the Add Element button
      //  3- Test that the Delete button is visible
     //   4- Press the delete key
     //   5- Test that the text “Add/Remove Elements“ is visible


    }
}
