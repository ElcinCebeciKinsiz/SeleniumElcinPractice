package day02_DriverMetodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_GettingPageSource {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        String pageSource = driver.getPageSource();
        String expectedWord = "accordion";
        System.out.println(pageSource);
        if (pageSource.contains(expectedWord)){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");

        }
        System.out.println(driver.getTitle());
        driver.close();
    }
}

