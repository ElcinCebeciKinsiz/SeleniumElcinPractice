package day02_DriverMetodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMetodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.drivers","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com/");  //Amazon'a gitmesini soyluyoruz

   //     Thread.sleep(5000); //Gittigi sayfa en az 5 saniye acik kalsin diye bunu yaptik, yani hemen acilip kapanmasin, gorelim.
                                 // Am sleep'in alti kizardi, ya bekleyemezsem diyor
                                 // Bizde sleep'in ustune gelip tiklayip add exception to methods deyince yukari throws exception koydu
                                 //ve calisti
    //    driver.close(); // Acilan driver kapasin diye bunu koyuyoruz

        //Acilan sayfanin basliginin amazon icerdigini test edin//
        String expectedWord="amazon";
        String actualResult= driver.getTitle();
        if (actualResult.contains(expectedWord)) {
            System.out.println("Title test passed");
        }else{
            System.out.println("Title test failed, title do not contain amazon");
            System.out.println(driver.getTitle());
        }

        Thread.sleep(5000);
        driver.close();

    }
}
