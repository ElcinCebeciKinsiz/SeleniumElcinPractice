package day13_Excel_Screenshoot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C05_TakeFullPageSS extends TestBase {
    @Test
    public void test01(){
        // wisequarter ana sayfaya gidin
        // test that you are in wisequarter
        // take a SS
        // wisequarter
        driver.get("https://www.wisequarter.com");

        // test that you are in wisequarter
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedUrlWord));

        // take a SS(Screen shot)
        ReusableMethods.tumSayfaScreenShoot(driver);
    }
}




