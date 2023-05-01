package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_CheckingCategoriesSectionQuestion {
    public static void main(String[] args) {

        //1- Create a test class and set the relevant settings
        //2- Go to https://www.automationexercise.com/
        //3- Locate the elements in the category section
        //4- Test that there are 3 elements in the Category section
        //5- Print the category names
        //6- Close the page

        //1- Create a test class and set the relevant settings
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- Go to https://www.automationexercise.com/
        driver.get("https://www.automationexercise.com/");

        //3- Locate the elements in the category section
        List<WebElement> categoryElements = driver.findElements(By.className("panel-title"));

        //4- Test that there are 3 elements in the Category section
        if (categoryElements.size()==3){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");

        }
        //5- Print the category names
        for (int i = 0; i <categoryElements.size() ; i++) {
            System.out.println(categoryElements.get(i).getText());
        }
        //6- Close the page
        driver.close();
    }
}






