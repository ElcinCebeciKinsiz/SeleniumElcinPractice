package day02_DriverMetodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_AmazonURLTestin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //Soru-Amazonun URL'inin https://www.amazon.com/  olup olmadigini test edin

        String expectedURL = "https://www.amazon.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("URL Test Passed");
        } else {
            System.out.println("URL Test FAILED");
            System.out.println(driver.getCurrentUrl()); //bunu eger false donerse esas URL neymis onu gormek icin yazdirdik
        }
        Thread.sleep(5000); // 5sn amazon sayfasinda kalsin istedik
        driver.close();
    }
    }

