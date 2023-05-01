package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_SpecialOfferDisplayedMi {
    public static void main(String[] args) throws InterruptedException {
        //1- Create a test class and set the relevant settings
        // 2- Go to https://www.automationexercise.com/
        // 3- Test that there are 147 links on the page.
        // 4- Click on Products link
        //5- Test that the special offer text appears
        //6- Close the page

//1- Create a test class and set the relevant settings
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- Go to https://www.automationexercise.com/
        driver.get("https://www.automationexercise.com");

        // 3- Test that there are 147 links on the page.
        List<WebElement> allLinksElements=driver.findElements(By.tagName("a"));
        System.out.println(allLinksElements.size());
        if (allLinksElements.size()==147) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        // 4- Click on Products link-Bunu iki sekilde yapabiliriz
       // WebElement productsLink= driver.findElement(By.partialLinkText("Products"));
       // productsLink.click();

        driver.findElement(By.partialLinkText("Products")).click();


        //5- Test that the special offer text appears
        WebElement specialOfferTextElement= driver.findElement(By.id("sale_image"));
        if (specialOfferTextElement.isDisplayed()) {
            System.out.println("Special Offer Displayed Test PASSED");
        }else {
            System.out.println("Special Offer Displayed Test FAILED");
        }

        //6- Close the page
        Thread.sleep(2000);
        driver.quit();













    }
}
