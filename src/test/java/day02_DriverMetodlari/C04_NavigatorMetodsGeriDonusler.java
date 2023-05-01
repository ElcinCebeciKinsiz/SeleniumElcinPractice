package day02_DriverMetodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_NavigatorMetodsGeriDonusler {
    public static void main(String[] args) throws InterruptedException {

     System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize(); //Acilan sayfayi tamsayfa yapsin diye bunu koyuyoruz

        //navigation sayfalar arasind gecisi sagliyor. Once amazonu ac,3000sn kal sonra Wisequarter'a git 2000sn kal

        driver.navigate().to("https://www.amazon.com"); // get ile ayni isi yapiyor. Amazon sayfasini getir diyoruz
        Thread.sleep(3000);

        driver.get("https://wisequarter.com"); //Amazonu ac, 3sn kal, sonra Wisequatrter'a git ordada 3 sn kal
        Thread.sleep(2000);

        driver.navigate().back(); //Wisequarterdan sonra bir oncekine geri don (yani amazona) orda 4sn kal
        Thread.sleep(4000);

        driver.navigate().forward();// simdi amazondayken tekrar Wisequartera tekrar git ve 4sn kalip quit yap
        Thread.sleep(4000);
        driver.quit();




    }
}
