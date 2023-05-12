package day00_PracticeMehmetSezginHoca;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class W2_Qestion2 extends TestBase {
/*
   Test Case 2: Login User with incorrect email and password
    1- Launch the website https://automationexercise.com/
    2. Verify that home page is visible successfully
    3. Click on 'Signup / Login' button
    4. Verify 'Login to your account' is visible
    5. Enter incorrect email address and password
    6. Click 'login' button
    7. Verify error 'Your email or password is incorrect!' is visible
     */
@Test
public void loginWithIncorrectEmailAndPassword(){
 // 1- Launch the website https://automationexercise.com/
 driver.get("https://automationexercise.com/");

 // 2. Verify that home page is visible successfully
 String titleoFWebsite = driver.getTitle() ;
 Assert.assertEquals("Automation Exercise",titleoFWebsite);

 // 3. Click on 'Signup / Login' button
 WebElement logInButtonMainPage = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
 logInButtonMainPage.click();

 // 4. Verify 'Login to your account' is visible
 WebElement loginToYourAccountText = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
 Assert.assertTrue("Login To Your Account Header Text Is not Displayed",loginToYourAccountText.isDisplayed());

 // 5. Enter incorrect email address and password
 WebElement usernameTextBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
 usernameTextBox.sendKeys("mhmetiszgn@gmail.com");
 WebElement passwordTextBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
 passwordTextBox.sendKeys("ervanaz20");

 // 6. Click 'login' button
 WebElement userLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
 userLoginButton.click();

 // 7. Verify error 'Your email or password is incorrect!' is visible
 WebElement emailAndPasswordWarningMessage =
         driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));

 Assert.assertTrue("The Warning Message is not Visible",emailAndPasswordWarningMessage.isDisplayed());

}
}