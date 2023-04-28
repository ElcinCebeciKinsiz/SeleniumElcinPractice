package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Go to page https://www.diemol.com/selenium-4-demo/relative-locators-demo.html

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2. Berlin'i 3 farkli locater ile locate edin
        //2a. Sailor'un ustundeki Berlin olarak locate yapmak icin
        WebElement sailorElement = driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement bostonElement= driver.findElement(By.xpath("//p[text()='Boston']"));
        WebElement nycElement= driver.findElement(By.xpath("//p[text()='NYC']"));

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElement));
        WebElement berlin2= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElement));//Burda Berlin'i Boston uzerind
        WebElement berlin3=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nycElement)); //NYC'nin altindaki elemani ariyorum demek
        WebElement berlin4=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nycElement).toRightOf(bostonElement).above(sailorElement));


        String expectedDeger="pid7_thumb";
       // String actualDeger = berlin1.getAttribute("Id");

        //String actualDeger = berlin2.getAttribute("Id");

        //String actualDeger=berlin3.getAttribute("Id");

        String actualDeger=berlin4.getAttribute("Id");

        if (expectedDeger.equals(actualDeger)) {
            System.out.println("Relative Locater test PASSED");
        } else {
            System.out.println("Relative Locater Tes FAILED");
            System.out.println(actualDeger);
        }

            Thread.sleep(3000);
            driver.close();


        }
    }
