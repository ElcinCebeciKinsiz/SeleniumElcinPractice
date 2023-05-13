package day000_GROUP_PRACTICE.GP_070523;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Question_060523 extends TestBase {

/*
Test Case 5: Contact Us Form
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
 */

@Test
public void test01(){
// 2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");

// 3. Verify that home page is visible successfully
    String actualTitle= driver.getTitle();
    String expectedTitle="Automation Exercise";

    Assert.assertTrue(expectedTitle.equals(actualTitle));

//4.Click on 'Contact Us' button
   driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

//5. Verify 'GET IN TOUCH' is visible
WebElement getInTouchSign= driver.findElement(By.xpath("//body/div[@id='contact-page']/div[1]/div[1]/div[1]/h2[1]"));
    System.out.println(getInTouchSign);
    getInTouchSign.isDisplayed();



}






}
