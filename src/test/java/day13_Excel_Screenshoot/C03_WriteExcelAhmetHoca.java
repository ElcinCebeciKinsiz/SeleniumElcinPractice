package day13_Excel_Screenshoot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcelAhmetHoca {

    @Test
    public void test01() throws IOException {
    //On Excel you have to make sure document is closed, otherwise dosya bozulur.
    //Day13'deki countries excelsheet'de 5. sutun'u Nufus basligi olarak olustur
    //Once calisacagimiz dosyaya ulasip, Workbook ile copy dosya olusturalim uzerinde calismak icin (Line 19-22)

    String dosyaPath="src/test/java/day13_Excel_Screenshoot/countries (2).xlsx";
    FileInputStream fis=new FileInputStream(dosyaPath);
    Workbook workbook= WorkbookFactory.create(fis);

    //5.sutun olaraka Nufus baslikli bir sutun (column) olusturalim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");



    //3.satirdaki nufus bilgisini 1500000 yapalim
        workbook.getSheet("Sayfa1").getRow(3).createCell(4).setCellValue("15000000");



    //7. satirdaki nufus bilgisini 3000000 yapalim
        workbook.getSheet("Sayfa1").getRow(6) .createCell(4).setCellValue("3000000");


    //Yaptigimiz degisiklikler bizim copy olan Excel dosyamizda. Simdi bu degisiklikleri asil Excel'e kaydetmemiz/gondermemmiz lazim

        FileOutputStream fos=new FileOutputStream(dosyaPath);  //Burda yaptigimiz islemleri nereye gonderecegimizi yazdik
        workbook.write(fos);                                   //Degisiklikleri kaydet dedik :)

        workbook.close();
        fis.close();
        fos.close();
    }
}
