package day11_Cookies_Tables;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class C04_WebTables extends TestBase {

    @Test
    public void test(){

      //amazon adresine gidin
      driver.get("https://amazon.com");

      //Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();  //sendKeys(Keys.END) sayfanin en sonuna gotururu bizi

      //WebTable tum body'sini yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));


      //Web tabledaki satir sayisinin 10 oldugunu test edin
        List<WebElement> satirListesi=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirListesi.size());
        System.out.println(satirListesi);


      //Tum satirlari yazdirin

        for (WebElement eachRow:satirListesi
             ) {
            System.out.println(eachRow.getText());

        }


        ReusableMethods.wait(5);
    }



}
