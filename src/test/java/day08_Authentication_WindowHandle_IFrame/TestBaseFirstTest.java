package day08_Authentication_WindowHandle_IFrame;


import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;


    public class TestBaseFirstTest extends TestBase {


        @Test
        public void test01(){

            // go to amazon.com
            // test that url has amazon keyword

            driver.get("https://amazon.com");

            String actualUrl= driver.getCurrentUrl();
            String expectedUrlWord= "amazon";

            Assert.assertTrue(actualUrl.contains(expectedUrlWord));
        }

    }
    Footer
© 2023 GitHub, Inc.
}
