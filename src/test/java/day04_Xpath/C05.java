package day04_Xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05 {
    public static void main(String[] args) {
   /*
        1- create a class
        2- Go to https://www.amazon.com/
        3- Make the browser full page
        4- Refresh the page
        5- Test if the page title contains the phrase “Spend less”
        6- Press the Gift Cards tab
        7- Press the Birthday button
        8- Click the first product from the Best Seller section
        9- Select $25 from Gift card details
        10-Test the product price is $25
        11-Close the page
*/
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();









    }
}
