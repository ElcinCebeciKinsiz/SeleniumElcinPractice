package day09_ActionFakers;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C07_KeysMouseActionPractice extends TestBase {

    @Test
    public void Test01(){

        //2 - Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3 - Type Book1 using actions methods in the search box and press Enter to search

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions
                .click(searchBox)
                .keyDown(Keys.SHIFT)  //Buyuk harfle yazmak icin Capslock icin Key down yapip sonra harfi yazip, key up
                .sendKeys("b")        //yapmak gerekiyor (Line 25-26-27)
                .keyUp(Keys.SHIFT)
                .sendKeys("ook1")
                .sendKeys(Keys.ENTER)
                .perform();
        ReusableMethods.wait(2);



        //4 - test that the search is completed in amazon website

        WebElement result= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String expectedResult="Book1";
        String actualResult=result.getText().replaceAll("\"","");
       //String actualResult=result.getText().substring(1,6);  // 2. Yol-Ayse hocanin yontemi, substring olarak

        System.out.println(expectedResult);
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.equals(expectedResult));

    }

}
