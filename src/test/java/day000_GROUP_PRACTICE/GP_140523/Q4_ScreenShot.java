package day000_GROUP_PRACTICE.GP_140523;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Q4_ScreenShot extends TestBase {
    @Test
    public void test01()  {

        // 1- ebay.com anasayfaya gidin

        driver.get("https://www.ebay.com/");

        //   2- ebay anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String expectedURL="https://www.ebay.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(expectedURL.contains(actualUrl));



        TakesScreenshot pictureOfElement= (TakesScreenshot)driver;//driver'i takesctreenshot clas'i ile introduce yapiyoruz
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter time=DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
        String dateTime=date.format(time);

        String filePath="target/fullPagesSS/pictureOfElement"+dateTime+ ".jpeg";    //png-logo gibi kullanirken resme odakli, jpeg direk screenshot
        File fullPageSS=new File(filePath);

        File temFile = pictureOfElement.getScreenshotAs(OutputType.FILE);//Burasini fotograf makinesi olarak dusun, screenshot'ı burda dosyaya cevirdi


        try {
            FileUtils.copyFile(temFile, fullPageSS);   //Temp file olusturdugumuz kisim burasi, yukarida olusturdugumuz file'i buraya kopyaladik
        } catch (IOException e) {                      // // alti kizarinca copyFile'in try/ catch olusturduk. Bunun icin Line 41 copy yaptik
                                                       // surround with ile try/ cath olusturduk (benimki more actions altinda surround with)
        }

        // 3- Nokia 3310 icin arama yapin
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("Nokia3310"+ Keys.ENTER);

        String filePath1="target/fullPagesSS/pictureOfElement1"+dateTime+ ".jpeg";    //png-logo gibi kullanirken resme odakli, jpeg direk screenshot
        File fullPageSS1=new File(filePath1);

        File temFile1 = pictureOfElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temFile1, fullPageSS1);
        } catch (IOException e) {

        }

    }
}
