package day000_GROUP_PRACTICE.GP_070523;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownSoru070523 extends TestBase {
/*
1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    kontrol edin.
*/

    @Test
    public void test01() throws InterruptedException {

//1. http://zero.webappsecurity.com/ Adresine gidin

        driver.get("http://zero.webappsecurity.com/");

//2. Sign in butonuna basin

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

//3.Login kutusuna “username” yazin
        WebElement logInBox = driver.findElement((By.xpath("//input[@id='user_login']")));
        logInBox.sendKeys("username");

//4. Password kutusuna “password.” yazin

        WebElement passwodBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwodBox.sendKeys("password");

//    5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        ReusableMethods.wait(2);

        driver.navigate().back();

        ReusableMethods.wait(2);


        //6. Go to the Pay Bills page
        WebElement onlineBankingMenu = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBankingMenu.click();

        WebElement payBillMenu = driver.findElement(By.xpath("//span[@id='pay_bills_link']"));
        payBillMenu.click();


        //7. Type any amount you want to deposit in the amount
        WebElement amountBox = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountBox.sendKeys("100");

        //8. “Currency” drop down menusunden Eurozone’u secin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        WebElement currencyButton = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currencyButton);
        select.selectByVisibleText("Eurozone (euro)");

        String expected = "Eurozone (euro)";
        String actualtext = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualtext, expected);


        //9. “amount” kutusuna bir sayi girin
        WebElement currencyAmountBox = driver.findElement(By.xpath("//input[@id='pc_amount']"));
        currencyAmountBox.sendKeys("100");

        //10. “US Dollars” in secilmedigini test edin
        WebElement dollarButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(dollarButton.isSelected());

        //11. “Selected currency” butonunu secin

        driver.findElement(By.xpath("(//input[@name='inDollars'])[2]")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //    kontrol edin.
        WebElement resultText=driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(resultText.isDisplayed());

    }
}



