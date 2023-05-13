package day08_Authentication_WindowHandle_IFrame;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C02_IFramePractice3 extends TestBase {

    // go to the https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe
    // locate "The iframe element" texted element
    // then print the text of this element
    @Test
    public void test01 () {

    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
    driver.findElement(By.xpath("//div[@id='accept-choices'][1]")).click();
    driver.findElement(By.xpath("//iframe[@id='iframeResult']"));



}

}

