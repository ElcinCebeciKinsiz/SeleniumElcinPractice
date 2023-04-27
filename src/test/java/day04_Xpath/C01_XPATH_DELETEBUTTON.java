package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPATH_DELETEBUTTON {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. https://the-internet.herokuapp.com/add remove elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2. Add Element buton'una basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        //3. Delete buton'unun gorunur oldugunu test edin //Bununla ilgili test yapacak oldugumuz icin web element olustruralim
        WebElement deteteButton = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deteteButton.isDisplayed()) {
            System.out.println("Goruntulemre testi passed");
        } else {
            System.out.println("Goruntuleme testi failed");

        }
        Thread.sleep(3000);// Cok hizli geciyordu, delete butona bastigini gormek icin bekleme suresi koyduk buraya

        //4. Delete tusuna basin
        deteteButton.click();
        //5. "Add/Remove Elements" yazisinin gorunur oldugunu test edin. Test edin dedigi icin WebElement olustracagiz
        WebElement addRemoveButton= driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (addRemoveButton.isDisplayed()) {
            System.out.println("AddRemoveButton gorunurluk test passed");
        }else {
            System.out.println("AddRemoveButton gorunurluk test failed");

        }

            Thread.sleep(3000);
            driver.close();


        }
    }

