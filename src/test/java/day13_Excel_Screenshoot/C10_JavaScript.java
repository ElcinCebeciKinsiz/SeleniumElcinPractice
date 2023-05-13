package day13_Excel_Screenshoot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C10_JavaScript extends TestBase {
 @Test
 public void test01(){
 //Birseye bir turlu click yapamiyorsak java script kullanarak yapabiliriz ("arguments[0].click();",element);
// JavaC    Script click yapmak icin, scroll down yapmak icin

   //1. JaveScript ile Click
     //Amazona gidin

     driver.get("https://amazon.com");

     //sell linkine JavaScript kullanarak click yapin
     WebElement sellLinki= driver.findElement(By.xpath("//a[text()='Sell']"));
     JavascriptExecutor jse= (JavascriptExecutor) driver;
     jse.executeScript("arguments[0].click()",sellLinki);



     jse.executeScript("alert('Bu is tamamdir Elcinnnnn');");  // Ekrana bu uyariyi verir
     ReusableMethods.wait(3000);

     driver.quit();


     //2. JavaScript Ile ScrollDown


 }

}
