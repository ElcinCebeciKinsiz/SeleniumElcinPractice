package day000_GROUP_PRACTICE.GP_140523;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q3_ExceleVeriGonderme {
    @Test
    public void writeExcelTest() throws IOException {

//Excel'e veri gonderme
//1) Yeni bir Class olusturalim WriteExcel
//2) Yeni bir test method olusturalim writeExcelTest()
//3) Adimlari takip ederek 1.satira kadar gidelim

        String filePath="src/test/java/day000_GROUP_PRACTICE/GP_140523/Q3_CountriesList.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);

//4) 4.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4);

//5) Olusturdugumuz hucreye “Nufus” yazdiralim


    workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

//6) 2.satir nufus kolonuna 1500000 yazdiralim

        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(150000);

//7) 10.satir nufus kolonuna 250000 yazdiralim

        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);

//8) 15.satir nufus kolonuna 54000 yazdiralim

        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(54000);

//9)   0-7'ye Universiteler, 2-7'ye, 4-7'YE odtu Istanbul Teknik yazdir
        workbook.getSheet("Sayfa1").getRow(0).createCell(7).setCellValue("Universiteler");

        workbook.getSheet("Sayfa1").getRow(2).createCell(7).setCellValue("Istanbul Teknik");

        workbook.getSheet("Sayfa1").getRow(4).createCell(7).setCellValue("ODTU");

//9) Dosyayi kaydedelim

        FileOutputStream fos=new FileOutputStream(filePath);
        workbook.write(fos);

//10)Dosyayi kapatalim
        fis.close();
        fos.close();

    }
}