package day06_Annotation_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {
    /*

    a. Go to the given web page.
    https://the-internet.herokuapp.com/checkboxes
    b. Locate the checkbox1 and checkbox2 elements.
    c. Click the checkbox if Checkbox1 is not selected
    D. Click the checkbox if Checkbox2 is not selected
    Collapse

*/

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

        WebElement firstCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement secondCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!firstCheckBox.isSelected()){
            firstCheckBox.click();
        }
        if (!secondCheckBox.isSelected()){
            secondCheckBox.isSelected();
        }

    }


    }
