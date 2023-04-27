package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPathBirthdayCard {
    public static void main(String[] args) throws InterruptedException {
    //1. Gerekli ayarlari yapin
    System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //2. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

    //3. Browser'i tam sayfa yapin
    driver.manage().window().maximize();

    //4. Sayfayi refresh yapin
        driver.navigate().refresh();

    //5. Sayfa basliginin "Spend Less" ifadesi icerdigini test edin.

        String expectedTitle="Spend less";
        String actualTitle= driver.getTitle();
        System.out.println("Actual Title:"+ actualTitle); // Bunu sadece gormek icin yaptim, actual title neymis diye

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Name test passed");
        }else {
            System.out.println("Name Test Failed");
        }
        //6. Giftcard segmesine basin
            driver.findElement(By.linkText("Gift Cards")).click();

        //7. Birthday buton'una basin
        driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();

        //8. Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[1]")).click();

        //9. Gift Card Details'den $25'luk gifti secin
        driver.findElement(By.xpath("//button [@id='gc-mini-picker-amount-1']")).click();

        //10. Urunun ucretinin $25 oldugunu test edin
        WebElement urunUcreti= driver.findElement(By.xpath("//span[text()='$25.00'][1]"));
        System.out.println(urunUcreti);

        String expectedUcret="$25.00";
         String actualUcret=urunUcreti.getText();

         if (expectedUcret.equals(actualUcret)){
             System.out.println("Ucret Testi Passed");
         }else{
             System.out.println("Ucret Testi Failed");
         }
        //10. Sayfayi Kapatin
        Thread.sleep(3000);
         driver.close();









    }
}
