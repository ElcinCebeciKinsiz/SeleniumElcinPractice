package day13_Excel_Screenshoot;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
public class C08_GetScreenShotOfElement(WebElement result2) {

    LocalDateTime ldt = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String date = ldt.format(dtf);
    // we have created the date. Now we should add it to the file name ( path)
    // creating a file path for our ss
    String filePath = "target/SSofDesiredElement/SsDesiredElement"+ date  +".jpeg";
    // original picture file
    File elementSS = new File(filePath);
    // temp picture file
    File tempFile = result2.getScreenshotAs(OutputType.FILE);
    // copied  the copy to the original file
        try {
        FileUtils.copyFile(tempFile,elementSS);
    } catch (IOException e) {
    }
}
*/