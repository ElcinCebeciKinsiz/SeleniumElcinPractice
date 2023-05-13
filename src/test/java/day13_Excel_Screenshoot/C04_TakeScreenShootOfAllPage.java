package day13_Excel_Screenshoot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class C04_TakeScreenShootOfAllPage extends TestBase {

    @Test
    public void test01() throws IOException {
        // go the amazon.com
        // write Nutella to searchbox
        // and test that result has nutella keyword
        driver.get("https://www.amazon.com");
        // write Nutella to searchbox
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        // and test that result has nutella keyword
        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        String actualResultStr = result.getText();
        String expectedWord = "Nutella";
        Assert.assertTrue(actualResultStr.contains(expectedWord));

        // take a screenshot of the page
//        //1 ) Create a screenshot object
//        TakesScreenshot tss = (TakesScreenshot) driver;
//
//        // creating a file path for our ss(screen shot)
//        String filePath = "target/fullPageSS/ScreenShotSS.jpeg";
//
//        // creating the file
//        File FullPageSS = new File(filePath);
//
//        //creting a tempfile to save ss ( otherwise it does not work, we have to create temporaly file first)
//        File tempFile = tss.getScreenshotAs(OutputType.FILE);
//
//        // copying copy file onto the orinigal file
//        FileUtils.copyFile(tempFile,FullPageSS);

        // let's write all this code to reusable method class
        /*
        when we try to create a method to take ss, we should also send the driver
         */

        ReusableMethods.tumSayfaScreenShoot(driver);
    }
}




