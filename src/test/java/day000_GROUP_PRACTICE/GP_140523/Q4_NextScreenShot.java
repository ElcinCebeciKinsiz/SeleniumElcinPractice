package day000_GROUP_PRACTICE.GP_140523;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Q4_NextScreenShot extends TestBase {

    @Test
    public void test01(){

    //Next ana sayfasina gidip sayfaya gittiginizi test edip screenshot alin

    driver.get("https://www.next.co.uk/");
    String expectedURL="https://www.next.co.uk/";
    String actualURL=driver.getCurrentUrl();
        Assert.assertTrue(expectedURL.equals(actualURL));
        System.out.println("Actual URL="+ actualURL);
        System.out.println("Expected URL="+ expectedURL);

        TakesScreenshot screenshot= (TakesScreenshot)driver;
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter time=DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
        String dateTime=date.format(time);
        String filePath="target/fullPagesSS/Amazon"+dateTime+ ".jpeg";
        File fullPageSS=new File(filePath);
        File tempFile=screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempFile,fullPageSS);        //FileUtils.copyFile(tempFile,fullPageSS) yazinca "copy.File" alti kizardi.
        } catch (IOException e) {                           //Bizde surround with yaparak try/catch olusturduk, ama throw yaptigi
                                                            //"throw new RuntimeException(e);" kismi sildik
        }

    }
}
