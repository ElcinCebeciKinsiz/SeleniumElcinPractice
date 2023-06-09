package day000_GROUP_PRACTICE.GP_140523;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q2 extends TestBase {
    @Test
    public void isEnabled() {

       // 1. Bir class olusturun : EnableTest
       // 2. Bir metod olusturun : isEnabled()
       // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textbox.isEnabled());

       // 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();


        // 6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enableMessage= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(enableMessage.isDisplayed());

       // 7. Textbox’in etkin oldugunu(enabled) dogrulayın

        Assert.assertTrue(enableMessage.isEnabled());


    }
}
