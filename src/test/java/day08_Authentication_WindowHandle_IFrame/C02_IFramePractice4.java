package day08_Authentication_WindowHandle_IFrame;


import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


    public class C02_IFramePractice4 extends TestBase {

        // go to the https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe

        // locate "The iframe element" texted element

        // then print the text of this element

        @Test
        public void test01(){

            // go to the https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

            // locate "The iframe element" texted element

            //1 ) first locate the iframe then use it in switch to method // I ,myself, prefer using this method
            WebElement iframe = driver.findElement(By.id("iframeResult"));
            driver.switchTo().frame(iframe);

            //2) we can use index of iframe
//        driver.switchTo().frame(1);

//        //3) we can use iframe id to switch to it
//        driver.switchTo().frame("iframeResult");

            WebElement iFrameText = driver.findElement(By.xpath("//h1[text()='The iframe element']"));

            // then print the text of this element
            System.out.println(iFrameText.getText());



        }





    }


