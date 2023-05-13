package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
   //1. https://www.amazon.com adresine gidi
   //2. Yeni bir tab'da wisequarter.com'a gidin ve gittiginizi test edin
   //3.
   driver.get("https://www.amazon.com");
   driver.get("https://wisequarter.com/");
   driver.switchTo().newWindow(WindowType.TAB); //soru yeni tabda ac dedigi icin tab, yeni Windowda ac deseydi WindoType.WINDOW olacakti
   Thread.sleep(2000);
   driver.get("https://www.amazon.com");
   driver.get("https://www.next.co.uk/");
   driver.switchTo().newWindow(WindowType.WINDOW);
   Thread.sleep(2000);

    }







}
