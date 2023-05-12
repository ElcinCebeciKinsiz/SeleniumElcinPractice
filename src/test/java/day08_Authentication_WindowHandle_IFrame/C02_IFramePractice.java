package day07_DropDown_JsAlerts;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_IFramePractice extends TestBase {
    // İframe: Eğer locate ettiğiniz WebElement'in kodun eminsiniz ama no such element exception'ı verdiğinde
    //   acaba bu element iframe içinde mi diye konttrol etmeliyiz.Bu durumda ilk olarak iframe elementini locate edilir.
    //  ve frame'e aşağıdaki yapı ile geçiş yaparım
    //  driver.switchTo().frame("aşağıdaki 3 maddeden biri ")
    //   1)locate ettiğim web element
    //   2)birden fazla frame var ve index'ini biliyorsanız
    //  3)String olarak ismini ya da id'sini yazabilirsiniz--->en çok kullanılan
    //    bunu yaparak


    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulup, 10 oldugunu test edin
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //(https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test01()  {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidinizdriver.get("https://demo.guru99.com/test/guru99home/");WebElement cookiesFrame = driver.findElement(By.id("gdpr-consent-notice"));driver.switchTo().frame(cookiesFrame);driver.findElement(By.xpath("//button[@id='save']")).click();driver.switchTo().defaultContent();ReusableMethods.waitFor(1);
        //2) sayfadaki iframe sayısını bulunuz.int actualIFrameNumbers = driver.findElements(By.tagName("iframe")).size();System.out.println("Number of Frames : " + actualIFrameNumbers);

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeFrame = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeFrame);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        ReusableMethods.waitFor(3);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement jMeterMadeEasyFrame = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(jMeterMadeEasyFrame);
        driver.findElement(By.tagName("a")).click();
        ReusableMethods.waitFor(3);





    }
}