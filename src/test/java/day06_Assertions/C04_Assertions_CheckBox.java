package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions_CheckBox {
    //Create a necessary body and complete the tests listed below
    //1. Go to https://the-internet.herokuapp.com/checkboxes
    //2. Locate Checkbox1 and Checkbox2
    //3. If Checkbox1 is not selected click on on the select boX and test it is selected (ticked)
    //4. If Checkbox2 is not selected click on on the select boX and test it is selected (ticked)

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //2. Locate Checkbox1 and Checkbox2

        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //3. If Checkbox1 is not selected click on on the select boX and test it is selected (ticked)
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        Assert.assertTrue(checkBox1.isSelected());
        //4. If Checkbox2 is not selected click on the select boX and test it is selected (ticked)

        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        Assert.assertTrue(checkBox2.isSelected());
    }

}


















