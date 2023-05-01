package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Next_ArtificialFlowers {
    public static void main(String[] args) throws InterruptedException {



        // https://www.next.co.uk/ adresine gidin
        // Cookiesleri accept yapin
        // Search button'dan "artifical flowers" aratin
        // Sayfanin isminin "Artifical Deocorative Plants" oldugunu test edin
        // ilk resme tiklayin ve acilan sayfada:
        // a.favourite button'a erisimi test edin
        // b.Cicegin fiatinin £32 oldugunu test edin
        // Anasayfaya donun ve clearance'a gidip 50% off clearance yazisinin gorundugunu test edin

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.next.co.uk/ adresine gidin
        driver.get("https://www.next.co.uk/");

        // Cookiesleri accept yapin
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        // Search button'dan "artifical flowers" aratin
        WebElement searcBox= driver.findElement(By.xpath("//input[@id='header-big-screen-search-box']"));
        searcBox.sendKeys("artifical flowers"+ Keys.ENTER);

       // ilk resme tiklayin ve acilan sayfada:
        driver.findElement(By.xpath("//a[@data-testid='plp-roundels-template-next'][1]")).click();


//span[text()='£32']



        Thread.sleep(4000);
        driver.quit();


    }
}
