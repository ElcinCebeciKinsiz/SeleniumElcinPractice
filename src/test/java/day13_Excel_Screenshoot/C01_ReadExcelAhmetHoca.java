package day13_Excel_Screenshoot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcelAhmetHoca {
    @Test
    public void test01() throws IOException {
     //Excel dosyamiz proje icindeyse direkt dosya youlunu(path) veriyorus.(Contet Root olan path)
     // Ama bilgisayardan falan ulasmaya calissaydik
     //o zaman system.getproperty(String) diyerek basta herkes icin degiskenolan kisim(bizim user.home olan kisma kadar olan kismi)
     //sonrasida herkes icin ortahk olan kismi yazarak dosyaye ulasiriz

     //

 String dosyaYolu="src/test/java/day13_Excel_Screenshoot/countries (2).xlsx";

 FileInputStream fis= new FileInputStream(dosyaYolu); //Git dosyaYolu yukarida verilen dosyayi oku diyoruz/
                                                      //FileInputStream'un alti kizardi ya bulamazsam diye, bulursun dedik add exception olusturttu
 Workbook workbook= WorkbookFactory.create(fis);      // Line 23 ile calisacagimiz dosyaya ulasmistik. Simdi Line 23'de o dosyanin bir
                                                      //kopyasini olusturuyoruz ki onun ustunde calisalim. create'in aldi kizarmist, yaparsin sen dedik ve add exception olusturduk

 workbook.getSheet("Sayfa1").getRow(5).getCell(2);    //sayfa1'de bulunan, 5. indexe sahip satirinin, 2. indexse sahip cell bilgisini
                                                            // bize getir

 System.out.println(workbook.getSheet("Sayfa1").getRow(5).getCell(2));  //Angola yazdirdi
        System.out.println("..............");

 //METOD OLARAK OLUSTURMA
 //Simdi yuikaridakileri metod olarak olustutralim bu sayfada
 //Bunun icin satir ve sutun bilgisini parametre olarak alip o hucredeki bilgiyi yazdiran metodu olusturalim

        exceldeDataYazdir(25,2);        //exceldeDataYazdir(25,2) yazinca kizardi metod, create dedik Line 45'i olusturdu
        exceldeDataYazdir(12,3);        // Bizde yukaridakileri alip (Line 20-30 arasini) Line 45'in altina yapistirdik
        exceldeDataYazdir(17,1);       // Simdi Line 47'de parametreleri (satir, sutun) olarak update ediyoruzki metod dynamic olsun
        exceldeDataYazdir(45,2);       // Line 55'de getRow icine (satir), get cell icinede (sutun) yazdik
        exceldeDataYazdir(2,3);         // Satir, sutun diye update yazinca Line 37. de update oldu

        System.out.println(".............");
    }

    private void exceldeDataYazdir(int satir, int sutun) throws IOException {
        String dosyaYolu="src/test/java/day13_Excel_Screenshoot/countries (2).xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));  //Burda getRow icine satir, get cell icinede sutun yazdik


    }
}
