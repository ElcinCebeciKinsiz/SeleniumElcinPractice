package day09_ActionFakers;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


    public class C06_FakerClass extends TestBase {

        // 1 - Go to https://www.facebook.com
        //2 - Let's press the create new account button
        //3 - Write the value in the name, surname, e-mail and password boxes and press the register button
        //4 - Let's hit the sign up button

        @Test
        public void test01(){

            // 1 - Go to https://www.facebook.com
            driver.get("https://www.facebook.com ");

            //2 - Let's press the create new account button
            driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

            //3 - Write the value in the name, surname, e-mail and password boxes and press the register button
            driver.findElement(By.name("firstname")).click();
            Actions actions = new Actions(driver);

            //Actions Class, Java Selenium'da fareyi hareket ettirmek için kullanılır.
            // Actions Class, fare hareketlerini (tıklama, sağ tıklama, sürükle ve bırak, vb.)
            // ve klavye eylemlerini (tuşa basma, tuş bırakma, vb.) yapmak için kullanılabilir.
            Faker faker = new Faker();

            //Faker Class, Java Selenium'da sahte veriler oluşturmak için kullanılan bir kütüphanedir.
            // Bu kütüphane, rastgele isimler, adresler, e-posta adresleri, telefon numaraları ve
            // diğer birçok sahte veri türü oluşturabilir.

            System.out.println(faker.internet().emailAddress());
            String fakeEmail = faker.internet().emailAddress();

            //aşağıda ikinci confirmation olarak aynı email'i yazmamız gerektiğinden yukarıda String olarak atandı
            actions.sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(fakeEmail)//1.email
                    //aşağıda ikinci confirmation olarak aynı email'i yazmamız gerektiğinden
                    // yukarıda String olarak atanan veriyi kullandık
                    .sendKeys(Keys.TAB)
                    .sendKeys(fakeEmail)//2.si de confirmation email
                    //burda da aynı email'i kullandığımız için yukarıdaki String atamasını yaptık
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().password())
                    .sendKeys(Keys.TAB) // to jump to the next box, we need to press tab twice
                    .sendKeys(Keys.TAB)
                    .sendKeys("15")
                    .sendKeys(Keys.TAB)
                    .sendKeys("May")
                    .sendKeys(Keys.TAB)
                    .sendKeys("1999")
                    .sendKeys(Keys.TAB) // to jump to the next box, we need to press tab twice
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.ARROW_RIGHT)//tab'dan çıkış yapmak için
                    .perform();
            driver.findElement(By.name("websubmit")).click();
            ReusableMethods.wait(30);
        }
    }



