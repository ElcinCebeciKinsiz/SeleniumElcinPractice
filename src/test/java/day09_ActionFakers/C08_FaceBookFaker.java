package day09_ActionFakers;


import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class C08_FaceBookFaker extends TestBase {


   @Test
   public void test01() throws InterruptedException {
    driver.get("https://en-gb.facebook.com/");
    driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']")).click();
    WebElement accountCreateButton= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
    accountCreateButton.click();

    WebElement firstNameBox= driver.findElement(By.xpath("//input[@name='firstname']"));
    Actions actions=new Actions(driver);
    Faker faker=new Faker();

    String emailAdresi=faker.internet().emailAddress(); //Fake-kutuphanesinden bir email adress uret ve bunu emailAdres
       // olarak kaydet dedik. Cunku email address kaydederken genelde confirm etmek icin email addressi ikinci kez yazmak
       // zorunda oluruz, ama fake kutuphane ayni email adresi iki kere vermez, o yuzden burda olusturup kaydettikki
       // kez kullanabilelim

    actions.click(firstNameBox)    //Name kutusuna click yaptik.sendKeys(faker.name().firstName())     //Isim kutusuna gercek isim degilde, faker class'indan,isim turunde
                                                    //ilk isim olacak bir isim yolla diyoruz
            .sendKeys(Keys.TAB)                     //Yukarida kutuphaneden alinan ismi gonder(enter tabina basmak gibi dusun)
            .sendKeys(faker.name().lastName())      //Faker kutuphanseinden isim turunde olan bir syisim yolla diyoruz
            .sendKeys(Keys.TAB)                     //Tab a bas
            .sendKeys(emailAdresi)                  //Bunu line 26'da olusturmustuk zaten ordan aldik
            .sendKeys(Keys.TAB)                     //email icin taba bas dedik
            .sendKeys(emailAdresi)                  //Bir daha email adresi yolladik (confirmation boxa)
            .sendKeys(Keys.TAB)                     //email icn tab a bas dedik
            .sendKeys(faker.internet().password())  //Sifre icin faker kutuphanresinden, internet kismindan, sifre olustur dedik
            .sendKeys(Keys.TAB)                     //Sifre icin Tab a bas dedik
            .sendKeys("12")                         //Tarihin gun option'i icin
            .sendKeys(Keys.TAB)
            .sendKeys("Oct")
            .sendKeys(Keys.TAB)
            .sendKeys("1978")
            .sendKeys(Keys.TAB)             //Yil boxundan gender olana gecene kadar iki kez tab yapmak gerekiyor
            .sendKeys(Keys.TAB)             //O yuzden iki kere tab yaptik burda Line 49-50
            .sendKeys(Keys.ARROW_RIGHT)     //Bu erkek olanin ustune gidiyor
            .sendKeys(Keys.ARROW_LEFT)      //Kadin olani secmek icin once erkege gidip, sonra sol yapip kadini secebiliyoruz
            .sendKeys(Keys.TAB);             //Kadin icin tab yapyik
       //Burdan sonra sign up button'a gelene kadar 5x SendKeys(Keys.TAB) yapmamiz lazim, yada ikinci yol action'i sonlandirip
       //O sekilde SignUp'a basabiliriz. Biz kisa yolu secip action'i sonlandiriyoruz asagidaki ile

       //Sign Up button'a basiniz
             WebElement signUpButton= driver.findElement(By.name("websubmit"));
             signUpButton.click();

Thread.sleep(900000);
       //Kaydolamadiginizi test edin


   }



}
