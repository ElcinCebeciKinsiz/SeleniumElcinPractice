package day000_GROUP_PRACTICE.GP_100523;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static Utilities.CookiesReusableMethods.*;

public class Question_100523 extends TestBase {
    @Test
    public void test01() {
        //Create a new class : cookiesAutomation
        //1- Go to Amazon homepage
        driver.get("https://www.amazon.com");

        //2- Put all cookies in list
        Set<Cookie> cookieSet=driver.manage().getCookies();
        int number=1;
        for (Cookie eachCookie:cookieSet
             ) {
            System.out.println(number+": "+ eachCookie);
            number++;

        }
        int cookies= driver.manage().getCookies().size();
        Assert.assertTrue(cookies==8);

        //3- Test that the number of cookies on the page is greater than 5
        Assert.assertTrue(cookiesSize()>5);

        //4- Test the value of the cookie with the name i18n-prefs is USD
        String expectedCookie="USD";
        String actualList=" ";
        String expectedName="i18n-prefs";
        for (Cookie eachCookie:cookieSet
             ) {
            if(eachCookie.getName().equals(expectedName)){
                actualList= eachCookie.getValue();
            }
        }

        Assert.assertEquals(expectedCookie,actualList);

        //5- Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
        Cookie newCookie = new Cookie("myFavouriteCookie", "chocolate");
        driver.manage().addCookie(newCookie);


        //6- test that the cookie you added is added to the page
        cookieSet =driver.manage().getCookies();
        String addedCookie = "myFavouriteCookie";
        String actualCookie = "";

        for (Cookie eachCookie:cookieSet
        ) {
            if(eachCookie.getName().equals(addedCookie)){
                actualCookie= eachCookie.getName();
            }
        }
        Assert.assertEquals(addedCookie,actualCookie);

        //7- Delete the cookie whose name is skin and test it is deleted
        deleteCookiesWithParameter("skin");     //We called this method from cookies in utilities

        //8- delete all cookies and test if they are deleted
        deleteCookies();                                  //We called this method from cookies in utilities

        Assert.assertEquals(0,cookiesSize());     //We called this method from cookies in utilities

    }
}