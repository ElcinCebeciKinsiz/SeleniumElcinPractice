package day13_Excel_Screenshoot;

import Utilities.ReusableMethods;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelMethod {
    @Test
    public void Test01() throws IOException {

        String filePath="C:\\Users\\serka\\Downloads\\countries (1).xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(2));

        // we will create a method which prints the value of row and cell
        ReusableMethods.getvalueOfExcelFileUsingRowAndCell(3,2);
        ReusableMethods.getvalueOfExcelFileUsingRowAndCell(15,3);
        ReusableMethods.getvalueOfExcelFileUsingRowAndCell(66,1);

    }
}
