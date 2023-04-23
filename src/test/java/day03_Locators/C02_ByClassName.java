package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        //Soru-Amazona gidip, nutellayo aratip, en yuksek fiyati yazdiralim//

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");  //Amazon'a git
        WebElement aramaKutusu = driver.findElement(By.name("field-keywords")); //by.name'i amazonun sayfasindan inspect yaparak bulduk
        // Ve bunu aramaKutusu adini vererek webElement olarak atayalim
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);   //Arama cubuguna Nutella yaz ve Enter'a bas

        List<WebElement> fiyatListesi = driver.findElements(By.className("a-price-whole"));//className "a-price-whole" olarak tanimlanmis tum elementleri bul
        //ve adi fiyatListesi olan WebElement data turunde olan Listeye ata
        //System.out.println(fiyatListesi);    //WebElement List direkt olarak yazdirilamaz. WeElementler String old icin once integer'a cevirmek lazim fiyat karsilastirmasi ypabilmek icin
        //Bu yuzden for each loop kullarak webElementleri tek tek elden gecirecegiz, ve get ile her bir elementin uzerindeki yaziyi al ve yazdir diyecegiz
        for (WebElement each : fiyatListesi
        ) {
            System.out.print(each.getText() + " "); //Her bir elementin uzerindeki yaziyi yazdir
        }
        String elementStr;
        int fiyatInt;
        int enYuksekFiyat = 0;

        for (WebElement each : fiyatListesi
        ) {
            elementStr = each.getText();
            fiyatInt = Integer.parseInt(elementStr);
            if (fiyatInt > enYuksekFiyat) {
                enYuksekFiyat = fiyatInt;
            }
        }

        System.out.println(" ");
        System.out.println("En yuksek Nutella Fiyati:" + enYuksekFiyat);

        Thread.sleep(3000);
        driver.close();


    }
}








