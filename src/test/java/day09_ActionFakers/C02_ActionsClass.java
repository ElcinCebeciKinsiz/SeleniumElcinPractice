package day09_ActionFakers;



  import Utilities.ReusableMethods;
  import Utilities.TestBase;
  import org.bouncycastle.math.ec.custom.sec.SecT113Field;
  import org.junit.Assert;
  import org.junit.Test;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.interactions.Actions;


import java.util.Set;

    public class C02_ActionsClass extends TestBase {

        //1- Let's create a new class: MouseActions1
        //2- Go to https://the-internet.herokuapp.com/context_menu
        //3- Right click on the drawn area
        //4- Test that the text in Alert is “You selected a context menu”.
        //5- Let's close the alert by saying OK
        //6- Click on Elemental Selenium link
        //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.

        @Test
        public void test01(){



            //2- Go to https://the-internet.herokuapp.com/context_menu
            driver.get("https://the-internet.herokuapp.com/context_menu");

            //3- Right click on the drawn area
            WebElement rightClickArea = driver.findElement(By.id("hot-spot"));

            // to use pre-made methods from Actions class we need to create an object from it
            Actions actions = new Actions(driver);

            ReusableMethods.wait(1);

            // to right click on a webelement : contextClick(WebElement)
            // to use aciton class in action, at the end we need to write perform() method
            actions.contextClick(rightClickArea).perform();
            ReusableMethods.wait(1);

            //4- Test that the text in Alert is “You selected a context menu”. Alert de ki yazinin bu oldugunu
            // test edebilmek icin alertte switch yapmamiz lazim, isimiz orda bitincede tekra switch ile alert'un
            // icinden cikmamiz lazim .

            String actualAlertText =driver.switchTo().alert().getText(); //Burda alert'un icine girdik ve ordaki cikan yaziyi aldik
            String expectedAlertText ="You selected a context menu";

            Assert.assertEquals(expectedAlertText,actualAlertText);

            ReusableMethods.wait(1);

            //5- Let's close the alert by clicking OK
            driver.switchTo().alert().accept();   //burda alert icinden cikiyoruz

            //6- Click on Elemental Selenium link

            String firstPageWHD = driver.getWindowHandle(); // this will take the handle value of the tab that driver still inside

            driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click(); //Buna tiklayinca yeni bir sayfa acildi
            //O yuzden buna tiklamadan once ilk sayfanin WindowHandleDegerini almam lazim. Bunu Line 64'de yaptik


            //7- On the new page you opened test that h1 tag is "Elemental Selenium"

            Set<String> handleValuesSet = driver.getWindowHandles(); // this set will store all handle values from all tabs

            String secondTabHW="";                             //Ilk sayfanin WindowHandleDeg biliyoruz , o zaman
            for (String each: handleValuesSet                  //bilmedigimiz ikinci sayfanin degeri olur
            ) {

                if (!each.equals(firstPageWHD)){  //Eger karsilastirdigimiz whd ilk sayfanin whd'ne esit degilse,
                    secondTabHW = each;          // o zaman bu deger ikinci sayfanin whd'dir

                }
            }

            //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
            // bu using second tab's handle value, driver will jump to the second tab

            driver.switchTo().window(secondTabHW); //Artik ikinci sayfadayim

            WebElement elementalSelenium = driver.findElement(By.tagName("h1"));
            String actualText = elementalSelenium.getText();
            String expectedText = "Elemental Selenium";

            Assert.assertEquals(expectedText,actualText);

        }

    }


