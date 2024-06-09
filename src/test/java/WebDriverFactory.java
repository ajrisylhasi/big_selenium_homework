import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getDriver() {
        // Update this path to the actual location of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erti Beselica\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-notifications");

        return new ChromeDriver(options);
    }
}
