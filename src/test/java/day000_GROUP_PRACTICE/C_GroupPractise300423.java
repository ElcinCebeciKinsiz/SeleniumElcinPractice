package day000_GROUP_PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C_GroupPractise300423 {
    public static void main(String[] args) throws InterruptedException {


        // https://www.next.co.uk/ adresine gidin
        // Cookiesleri accept yapin
        // Search button'dan "artifical flowers" aratin
        // Sayfanin isminin "Artifical Deocorative Plants" oldugunu test edin
        // ilk resme tiklayin ve acilan sayfada:
        // a.favourite button'a erisimi test edin
        // b.Cicegin fiatinin £32 oldugunu test edin
        // Anasayfaya donun ve anasayfada oldugunuzu test edin
        // Clearance button'un tiklayin
        // Clearence'a tikladiktan sonra 50% indirim yazisinin gorunurlugunu test edin

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.next.co.uk/ adresine gidin
        driver.get(" https://www.next.co.uk/");
        //driver.navigate().to("https://www.google.com");  get sayfa acmak icin, navigate sayfalar arasinda dolasmak icin kullanilir

        //  Cookiesleri accept yapin
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        // Search button'dan "artifical flowers" aratin
        WebElement searhButton = driver.findElement(By.xpath("//input[@id='header-big-screen-search-box']"));
        searhButton.sendKeys("artificial flowers" + Keys.ENTER);
        String expectedNoame = "Artifical Deocorative Plants";
        String actualName = driver.getTitle();
        if (expectedNoame.equals(actualName)) {
            System.out.println("Name test PASSED");

        } else {
            System.out.println("Name test FAILED");
        }

        // Sayfanin isminin "Artifical Deocorative Plants" oldugunu test edin


// ilk resme tiklayin ve acilan sayfada:
        driver.findElement(By.xpath("//img[@data-testid='product_summary_image_266756']")).click();

// a.favourite button'a erisimi test edin
        WebElement favouriteButton = driver.findElement(By.xpath("//strong[@id='favText']"));
        favouriteButton.isEnabled();
        if (favouriteButton.isEnabled()) {
            System.out.println("Fav Button Test Passed");
        } else {
            System.out.println("Fav Button Test Failed");
        }

// b.Cicegin fiatinin £32 oldugunu test edin

        WebElement flowerPrice = driver.findElement(By.xpath("//div[@class='nowPrice branded-markdown']"));
        System.out.println(flowerPrice.getText());
        String expectedPrice = "£32";
        if (expectedPrice.equals(flowerPrice.getText())) {
            System.out.println("Flower Price Test PASSED");
        } else {
            System.out.println("Flower Price Test FAILED");
        }


// Anasayfaya donun ve Anasayfada oldugunu test et
        driver.navigate().to("https://www.next.co.uk/");
        if (driver.getCurrentUrl().equals("https://www.next.co.uk/")) {
            System.out.println("URL test PASSED");
        } else {
            System.out.println("URL test FAILED");
        }


//Clearance'a tiklayin

        driver.findElement(By.xpath("//div[text()='clearance']")).click();

// 50% indirim yazisinin gorundugunu test edin
//ASAGIDAKI KISMA BAKMAMIZ GEREKIYOR
//WebElement indrimYazisi= driver.findElement(By.xpath("//img[@title='Clearance - At least 50% off most sale Items*']"));
//if(indrimYazisi.isDisplayed()){
 //       System.out.println("50% Indirim Yazisi Gorunurluk Test PASSED");
//}else{
//    System.out.println("50% Indirim Yazisi Gorunurluk Test Failed");


        Thread.sleep(1000);
        driver.quit();

    }
}