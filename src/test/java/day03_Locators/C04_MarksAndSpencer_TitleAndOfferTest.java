package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_MarksAndSpencer_TitleAndOfferTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.marksandspencer.com/?gad=1 adresine gidin
        //Search button'ina Men yazip tiklayin
        //4 for 3 on selected suits yazisinin oldugunu test edin

        driver.get("https://www.marksandspencer.com/?gad=1");
        driver.findElement(By.xpath("//button[@id='cookie-banner-close-button']")).click();
        driver.findElement(By.xpath("//li[@class='catId-lKA1zWFyThJfXfWAA3BrJt top-nav-category-list-item css-ndddy9 e11ebbf13']")).click();
        String pageSource = driver.getPageSource();
        String expectedSource = "4 for 3 on selected suits";

        if (pageSource.contains(expectedSource)) {
            System.out.println("4 for 3 Test PASSED");

        } else {
            System.out.println("4 for 3 Test FAILED");
        }
        System.out.println("............");

        driver.findElement(By.xpath("//h2[text()='Holiday Shop']")).click();
        String expectedTitle="Men's Holiday Clothes";
        String actualTitle=driver.getTitle();
        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Test Passed");
        }else {
            System.out.println("Title Test Failed");
            System.out.println(driver.getTitle());
        }

        Thread.sleep(2000);
        driver.quit();
        }
}






