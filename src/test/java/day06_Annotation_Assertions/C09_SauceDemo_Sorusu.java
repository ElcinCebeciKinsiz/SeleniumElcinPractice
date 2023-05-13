package day06_Annotation_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_SauceDemo_Sorusu {
  /*
1.“https://www.saucedemo.xn--com-9o0a Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin

   */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread.sleep(1000);
        driver.close();
    }
    @Test
    public void test01(){

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        WebElement usernameBox=driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameBox.sendKeys("standard_user"+ Keys.ENTER);

        //3. Password kutusuna "secret_sauce" yazdirin
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce"+Keys.ENTER);

        //4. Login tusuna basin
        WebElement logIn=driver.findElement(By.xpath("//input[@id='login-button']"));
        logIn.click();

        //5. Ilk urunun ismini kaydedip yazdırın ve bu urunun sayfasina gidin
        WebElement firstProduct=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        System.out.println(firstProduct.getText());
        firstProduct.click();

        //6. Add to Cart butonuna basin
        WebElement addToCart=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();

        //7. Alisveris sepetine tiklayin
        WebElement shoppingBask=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingBask.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement product=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        Assert.assertTrue(product.isDisplayed());

    }

}
