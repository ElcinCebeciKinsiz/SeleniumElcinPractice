package day000_GROUP_PRACTICE.GP_080523;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q_080523 extends TestBase {
 //go to https://www.techlistic.com/p/selenium-practice-form.html
 //Fill the first name
 //Fill the surname
 //choose gender
 //choose the experience
 //fill the date
 //Choose your professions-->Automation Tester
 //Choose your tool-->Selenium Webdriver
 //Choose your continent-->Europe
 //Choose your command-->Browser Command
 //Click submit button

   @Test
   public void test01() {

   //go to https://www.techlistic.com/p/selenium-practice-form.html
       driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

       driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();



       //Fill the first name
       WebElement nameBox= driver.findElement(By.xpath("//input[@name='firstname']"));
       nameBox.sendKeys("Elcin"+ Keys.ENTER);

       //Fill the surname
       WebElement surnameBox= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
       surnameBox.sendKeys("Kirmizi"+Keys.ENTER);

       //choose gender
       driver.findElement(By.id("sex-1")).click();

       //choose the experience
       driver.findElement(By.xpath("//input[@id='exp-2']")).click();

       //fill the date
       WebElement date= driver.findElement(By.xpath("//input[@id='datepicker']"));
       date.sendKeys("08/05/2023"+Keys.ENTER);


       //Choose your professions-->Automation Tester
       driver.findElement(By.id("profession-1")).click();


       //Choose your tool-->Selenium Webdriver
       driver.findElement(By.xpath("//input[@id='tool-2']")).click();


       //Choose your continent-->Europe
       WebElement continentDropDown= driver.findElement(By.xpath("//select[@id='continents']"));
       Select select=new Select(continentDropDown);
       select.selectByVisibleText("Europe");

       //Choose your command-->Browser Command
       WebElement command=driver.findElement(By.xpath("//select[@id='selenium_commands']"));
       Select select1=new Select(command);
       select1.selectByVisibleText("Browser Commands");

       //Click submit button
       driver.findElement(By.xpath("//button[@id='submit']")).click();




   }


}
