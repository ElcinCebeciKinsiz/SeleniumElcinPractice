package day00_PracticeMehmetSezginHoca;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class W2_1AutomationExercise extends TestBase {
    /*

Test Case 1: Verify the Login Functionality
1- Launch the website https://automationexercise.com/
2- Click on the "Login" button on the top right corner of the page
3- Enter a valid email address and password in the respective fields
4- Click on the "Sign in" button
5- Verify that the user is logged in by checking if the "My account" page is displayed
6- Logout of the website
 */

    @Test
    public void logInFunctionality() {
        // 1- Launch the website https://automationexercise.com/
        driver.get("https://automationexercise.com/");
        // 2- Click on the "Login" button on the top right corner of the page
        WebElement logInButtonMainPage = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        logInButtonMainPage.click();

        // 3- Enter a valid email address and password in the respective fields
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        usernameTextBox.sendKeys("mhmetaliszgn@gmail.com");
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordTextBox.sendKeys("ervanaz2012");

        // 4- Click on the "Sign in" button
        WebElement userLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        userLoginButton.click();
        // 5- Verify that the user is logged in by checking if the "Logout" button is displayed
        WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        Assert.assertTrue("Log out Button is not Displayed", logoutButton.isDisplayed());
        driver.quit();

    }

}



