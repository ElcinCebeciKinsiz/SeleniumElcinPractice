package day000_GROUP_PRACTICE.Elcin_Practice;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ECK_ActionsAndSwitch extends TestBase {
    @Test
    public void test() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
         driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapin
        Actions action= new Actions(driver);
        WebElement box= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        action.contextClick(box).perform();
        ReusableMethods.wait(2);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAllert="You selected a context menu";
        String actualAllert= driver.switchTo().alert().getText();  //We switched to allert& get the text
        Assert.assertEquals(expectedAllert,actualAllert);


        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();                        //Coming out of the alert

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement elementSign= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementSign.isDisplayed());
        //


        //PS-Bu sorunun WindowHandleDeger ile cozumu Day09 Class02_ActionClass altinda
    }
}
