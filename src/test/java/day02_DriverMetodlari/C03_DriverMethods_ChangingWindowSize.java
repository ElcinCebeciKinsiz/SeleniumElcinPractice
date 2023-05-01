package day02_DriverMetodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethods_ChangingWindowSize {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);
        driver.get("https://amazon.com");

        // to maximize the chrome page and to see sizes
        driver.manage().window().maximize();
        System.out.println("miximized sizes : "+driver.manage().window().getSize());
        Thread.sleep(1000);

        // to use fullScreen and to see the sizes
        driver.manage().window().fullscreen();
        System.out.println("fullScreen sizes : "+driver.manage().window().getSize());
        Thread.sleep(1000);

        // to change size and position

        driver.manage().window().setPosition(new Point(400,200));
        driver.manage().window().setSize(new Dimension(300,300));
        Thread.sleep(3000);
        driver.close();




}
}
