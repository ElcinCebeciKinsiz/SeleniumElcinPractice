package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Amazon'a gidin https://www.amazon.com/

        driver.get("https://www.amazon.com/");

        //2. Arama kutusunu locate edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //3. "Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER); //Arama Kutusuna Samsung headphones yaz ve enter yap komutu veriyoruz

        //4. Bulunan sonuc sayisini yazdirin (kac tane samsung headphones geldi)
        WebElement sonucElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println();
















     driver.close();

    }
}
