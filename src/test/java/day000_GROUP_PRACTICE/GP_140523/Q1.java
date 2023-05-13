package day000_GROUP_PRACTICE.GP_140523;

import Utilities.TestBase;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Q1 extends TestBase {
    @Test
public void readExcel2() throws IOException {


   //1. Yeni bir test method olusturalim readExcel2( )

        String filePath="C:\\Users\\serka\\Downloads\\countries (1).xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis); //// created a copy of the excel file


   //2. 1.satirdaki 2.hucreye gidelim ve yazdiralim

        workbook.getSheet("Sayfa1").getRow(192).createCell(3).setCellValue("ISTANBUL");
        System.out.println(workbook);

   //3. 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim


   //4. 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualCity= workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedCity="Kabil";
        Assert.assertTrue(expectedCity.equals(actualCity));


   //5. Satir sayisini bulalim

   //6.  Fiziki olarak kullanilan satir sayisini bulun

   //7.   Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim



    }
}
