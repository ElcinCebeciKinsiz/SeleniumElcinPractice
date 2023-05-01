package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_EnYuksekFiatliElbise_MarkAndSpencer {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.marksandspencer.com");
        WebElement kidsButton = driver.findElement(By.xpath("//a[text()='Kids']"));
//çocuk butonunu tanımladık

        kidsButton.click();
        WebElement dressesButton = driver.findElement(By.xpath("//h2[text()='Dresses']"));
        dressesButton.click();

        List<WebElement> listOfPrice = driver.findElements(By.xpath("//span[@class='css-v38gg3 et8tcrz0']"));
        for (int i = 0; i < listOfPrice.size() ; i++) {
            System.out.print(listOfPrice.get(i).getText()+" ");

        }
        int highestPrice = 0;
        String strNumber = "";
        int number = 0;


        for (int i = 0; i < listOfPrice.size(); i++) {
            strNumber = listOfPrice.get(i).getText().substring(1, 3);
            number = Integer.parseInt(strNumber);


            if (highestPrice < number) {
                highestPrice = number;
                System.out.println("");
            }
        }

        System.out.println("Highest price is:" + highestPrice);

        driver.close();

    }
}



