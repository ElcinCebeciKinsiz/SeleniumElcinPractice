package day13_Excel_Screenshoot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C11_JavaScriptScrollDown extends TestBase {
  @Test
  public void test01(){
      // Go to wise quarter and scrollDown to Career button by using JavaScript

      driver.get("https://wisequarter.com");
      WebElement careerButton= driver.findElement(By.xpath("//div[contains(@data-id,'fcbdfbb')]//div//div//div//a"));
      JavascriptExecutor jse= (JavascriptExecutor) driver;
      jse.executeScript("arguments[0].scrollIntoView()", careerButton);
      ReusableMethods.wait(1000);

      driver.quit();

  }



}
