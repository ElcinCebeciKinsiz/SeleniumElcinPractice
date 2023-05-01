package day02_DriverMetodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_SendingSomethingToSearchBox {
    public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // 1) go to the https://www.amazon.com
            // 2) search for nutella
            // 3) test that you have searched for nutella

            // 1) go to the https://www.amazon.com
            driver.get("https://www.amazon.com");
            // 2) search for nutella
            // we have stored where the search box is
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("Java");
            Thread.sleep(1000);
            searchBox.clear();
            Thread.sleep(1000);
            searchBox.sendKeys("Nutella");
            searchBox.submit();
            Thread.sleep(1000);
            // 3) test that you have searched for nutella
            String pageSource = driver.getPageSource();
            String expectedText = "1-48 of 52 results for";
            if (pageSource.contains(expectedText)){
                System.out.println("Test PASSED");
            }else {
                System.out.println("Test FAILED");
            }
            Thread.sleep(1000);
            WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
            amazonLogo.click();
            Thread.sleep(1000);
            driver.close();
        }
    }


