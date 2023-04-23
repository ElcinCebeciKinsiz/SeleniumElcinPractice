package day02_DriverMetodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethods_TamSayfaYapma {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize(); //Sayfayi buyutmek icin biz grenelde maximize kullaniriz
        System.out.println("Maximize window boyutlari"+driver.manage().window().getSize());


        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("Fullsecreen windows boyutlari"+ driver.manage().window().getSize());

        Thread.sleep(3000);
        driver.close();




    }
}
