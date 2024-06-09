import org.openqa.selenium.WebDriver;

public class CookieManager {
    public static void addConsentCookie(WebDriver driver) {
        // Replace 'cookie_name' and 'cookie_value' with the actual cookie name and value to avoid consent popup
        org.openqa.selenium.Cookie consentCookie = new org.openqa.selenium.Cookie("cookie_name", "cookie_value");
        driver.manage().addCookie(consentCookie);
    }
}
