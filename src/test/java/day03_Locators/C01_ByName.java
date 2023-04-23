package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByName {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/"); //Amazon webpage e git
        WebElement aramaKutusu=driver.findElement(By.name("field-keywords")); //Su elemmenti name locater ile bul ve arama kutusuna ata
                                                                              //findElement WebElement turunde data dondurdugu icin aramaKutusu WeElement turunde olusturuldu
                                                                              // field-keywords amazonda nutella+mousesagclik+inspect yazinca asagida name=field-keywords olarak cikti, ordan alip buraya yapistirdik

        aramaKutusu.sendKeys("Nutella"+Keys.ENTER); //Arama kutusuna Nutella yaz ve ENTER'a bas diyoruz
                                                               //Keys.ENTER yerine asagida aramaKutusu.submit() olarakda yapabilirdik
        Thread.sleep(3000);
        driver.close();


    }
}
