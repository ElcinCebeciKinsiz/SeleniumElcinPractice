package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLink {
    public static void main(String[] args) throws InterruptedException {
        // Amazon anasayfasina gidin, Giftcards Linkine tiklayin, GiftCard sayfasina gittigini test edin//

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.next.co.uk/");
        WebElement womenLinki= driver.findElement(By.linkText("Women")); //Next sayfasina git
        womenLinki.click();
        //Istenen sayfaya gidildigini test etmek icin title (basligin) Women icerdigini test edebiliriz. Bunun icin
        System.out.println(driver.getTitle()); //sitenin actual title'ini getir/yazdir

        String expectedWord="THE WOMEN'S SHOP";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedWord)) {
            System.out.println("Test PASSED");

        }else{
            System.out.println("Test FAILED");
        }

        Thread.sleep(5000);
        driver.close();

    }
}
