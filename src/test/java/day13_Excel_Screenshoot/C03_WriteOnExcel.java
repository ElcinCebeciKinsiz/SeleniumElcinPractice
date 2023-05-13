package day13_Excel_Screenshoot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteOnExcel {

    @Test
    public void test01() throws IOException {
        String filePath="C:\\Users\\serka\\Downloads\\countries (1).xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis); //// created a copy of the excel file
        workbook.getSheet("Sayfa1").getRow(0).createCell(3).setCellValue("Products");
        System.out.println(workbook);

        //Burda copya olan excel'in Sayfa1indeki (tab1) 1.Row(0.index) 4.column(3.index)'una Products yazdiriyoruz
        // when we make a change in workbook, actually we are changing something in the copy of the original file
        //Excel'inde degisklik, ekleme cikarma yaparken actaul excel'in mutlaka kaapali olmasi lazim, sen kopya ustunde oynarken

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("Apple");
        workbook.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("Windows");
        workbook.getSheet("Sayfa1").getRow(5).createCell(4).setCellValue("Java");

        //// changed a lot of cells in this copy
        //// to save the copy file to original one
        // now we will take something out of the project so we will use fileoutputStream

        FileOutputStream fos = new FileOutputStream(filePath);
        // to write all changes to the original file, workbook.write
        // so we will save this copy to the original file.

        workbook.write(fos); //bunu yaparak kopyada yaptigin tum degisiklikleri asil coyp'e ekleyip kaydettin
    }
}


