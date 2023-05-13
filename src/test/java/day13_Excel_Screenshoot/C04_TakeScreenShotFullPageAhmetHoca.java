package day13_Excel_Screenshoot;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class C04_TakeScreenShotFullPageAhmetHoca extends TestBase {
    @Test
    public void test01() throws IOException {
    //Amazona gidip, Nutella aratip, arama sonuclarinin Nutella icerdigini test edip, tum sayfanin screenshot'unu alin

    driver.get("https://www.amazon.com");
    WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("Nutella"+ Keys.ENTER);

    WebElement result=driver.findElement(By.xpath("//span[text()='Nutella']"));
    String actualResult= result.getText();
    String expected="Nutella";
    Assert.assertTrue(actualResult.contains(expected));

    TakesScreenshot tss= (TakesScreenshot) driver;   //TakeScreenShot objesi olusturduk ve cast yaptik driver'i alti kizarinca
    File tumSayfaScreenShot=new File("target/ekranResimleri/tumEkranScreenShoot.jpeg"); //Resmi son olarak kaydedecegimiz dosyayi olusturuyoruz. Genelde Target altimda olusturulur
                                                                                                  //path target, biz / yaparak klasorler olusturduk /ekranresimleri altinda/tum ekraScreenShoot clasotru icinde.jpeg tarzinda screenshotlar saklanacac
    File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);


    }
}
