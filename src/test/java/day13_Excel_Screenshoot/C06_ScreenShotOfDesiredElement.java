package day13_Excel_Screenshoot;

import Utilities.ReusableMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.LocalDateTime;

import static Utilities.TestBase.driver;

public class C06_ScreenShotOfDesiredElement {

    @Test
    public void test01() throws IOException {
        // go the amazon.com
        // write Nutella to searchbox
        // and test that result has nutella keyword
        driver.get("https://www.amazon.com");
        // write Nutella to searchbox
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        // and test that result has nutella keyword
        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        String actualResultStr = result.getText();
        String expectedWord = "Nutella";
        Assert.assertTrue(actualResultStr.contains(expectedWord));

        // take a SS of result element
        WebElement result2 = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
//        LocalDateTime ldt = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        String date = ldt.format(dtf);  // // we have created the date(String date). Now we should add it to the file name ( path) on Line38
//
//
//        // creating a file path for our ss
//        String filePath = "target/SSofDesiredElement/SsDesiredElement"+ date  +".jpeg";
//
//        // original picture file
//        File elementSS = new File(filePath);
//        // temp picture file
//        File tempFile = result2.getScreenshotAs(OutputType.FILE);
//
//        // copied  the copy to the original file
//        FileUtils.copyFile(tempFile,elementSS);

        ReusableMethods.getSSofElement(result2);
    }
}



