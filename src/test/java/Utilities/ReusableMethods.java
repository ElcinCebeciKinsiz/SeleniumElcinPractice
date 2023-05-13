package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Utilities.TestBase.driver;

public class ReusableMethods {


    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {

        }
    }

    public static void getvalueOfExcelFileUsingRowAndCell(int row, int cell) {
        String filePath = "src/test/java/day12_table_excel/countries.xlsx";
        Workbook workbook = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
        }
        System.out.println(workbook.getSheet("Sayfa1").getRow(row).getCell(cell));

    }


    public static void tumSayfaScreenShoot(WebDriver driver) {
        // Create a screenshot object
        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ltd=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
        String date= ltd.format(dtf);
        String filePath = "target/fullPageSS/ScreenShotSS "+date+".jpeg";

        // creating the file
        File FullPageSS = new File(filePath);

        //creting a tempfile to save ss ( otherwise it does not work, we have to create temporaly file first)
        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        // copying copy file onto the orinigal file
        try {
            FileUtils.copyFile(tempFile, FullPageSS);   //Burda tum duzeltmelerden sonra copy.File alti hala ciziliydi, unghandled exception diyordu
        } catch (
                IOException e) {                      //Onu cozmek icin Line 51'i sectin+code+surrandWith+TryandCath yaptik

        }

    }

    public static void getSSofElement(WebElement result2) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);  // // we have created the date(String date). Now we should add it to the file name ( path) on Line38

        // creating a file path for our ss
        String filePath = "target/SSofDesiredElement/SsDesiredElement" + date + ".jpeg";

        // original picture file
        File elementSS = new File(filePath);
        // temp picture file
        File tempFile = result2.getScreenshotAs(OutputType.FILE);

        // copied  the copy to the original file
        try {
            FileUtils.copyFile(tempFile, elementSS);
        } catch (IOException e) {

        }


    }


}

