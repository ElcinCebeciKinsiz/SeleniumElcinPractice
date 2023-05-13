package Utilities;

public class CookiesReusableMethods extends TestBase {

    public static int cookiesSize(){

        int cookiesSize= driver.manage().getCookies().size();
        return cookiesSize;

    }

    public static void deleteCookies(){

        driver.manage().deleteAllCookies();
    }

    public static void deleteCookiesWithParameter(String cookiesName){

        driver.manage().deleteCookieNamed(cookiesName);
    }
}
