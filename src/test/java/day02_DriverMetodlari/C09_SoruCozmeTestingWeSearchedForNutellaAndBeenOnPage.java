package day02_DriverMetodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_SoruCozmeTestingWeSearchedForNutellaAndBeenOnPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1) go to the https://www.amazon.com
        // 2) search for nutella
        // 3) test that you have searched for nutella

        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();

        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Nutella")) {
            System.out.println("Search for nutella test PASSED");
        } else {
            System.out.println("Search for nutella test FAILED");
            System.out.println(driver.getTitle());
        }

        Thread.sleep(3000);
        driver.close();




    }
}
