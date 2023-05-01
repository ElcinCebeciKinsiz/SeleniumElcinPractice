package day02_DriverMetodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleDegeri {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();

        driver.manage().window().maximize();
        String windowsHandeValue =driver.getWindowHandle();
        // every tap in a browser has a different value, we use these values to jump between tabs
        // getWindowHandle() will only take the tab's handle value that you are using.
        System.out.println(windowsHandeValue); //  9AAC558AF4EF80FFF86DDC4797C5201C
        // 94960BD4C54DD6789A5AD27F133C5202
        // 34ABC5E1C1CD512E1BC8E97CCD93BA23
        Thread.sleep(3000);
        driver.close();
    }
}






