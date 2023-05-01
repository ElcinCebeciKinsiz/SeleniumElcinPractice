package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators2 {


        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //1) Go to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
            //2 ) Locate Berlin with 3 different relative locators
            //3 ) Test that the Relative locators are working correctly
            //1) Go to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
            driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
            // to locate berlin, we know that it is at the rigth side of Boston
            // first we need to locate Boston
            WebElement boston = driver.findElement(By.id("pid6_thumb"));
            WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston));
            WebElement sailer = driver.findElement(By.id("pid11_thumb"));
            WebElement berlin2 =driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailer));
            WebElement berlin3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston).above(sailer));


            String expectedValue = "pid7_thumb";
            String actualIDofBerlin =berlin3.getAttribute("Id");  //pid7_thumb
            if (expectedValue.equals(actualIDofBerlin)){
                System.out.println("Test PASSED");
            }else {
                System.out.println("FAILED");
            }
            driver.close();
        }
    }
