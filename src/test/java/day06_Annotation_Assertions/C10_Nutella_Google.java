package day06_Annotation_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_Nutella_Google {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- Create a class named C01_RepeatTest

        //2- Go to https://www.google.com/
        driver.get("https://www.google.com/");

        //3- Accept and close the cookies warning
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();

        //4- Test if the page title contains the phrase "Google"
        String expectedWord = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedWord));

        //5- Search by typing “Nutella” in the search bar
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        //6- Print the number of results found
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String resultStr = result.getText();
        String[] resultArr = resultStr.split(" ");
        String returnedQuantity = resultArr[1];
        int actualReturnQuantity = Integer.parseInt(returnedQuantity.replaceAll(",", ""));
        System.out.println("Number of results found: " + actualReturnQuantity);

        //7- Test if the number of results is more than 10 million
        int expectedResult = 10000000;
        if (actualReturnQuantity > expectedResult) {
            System.out.println("Quantity Test PASSED");
        } else {
            System.out.println("Quantity Test FAILED");
        }

        //8- Close the page
        driver.quit();

    }
}



