import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFilesTest {
    public static void configureDownload(WebDriver driver, String downloadFilePath) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("download.default_directory=" + downloadFilePath);
    }

    public static void downloadFiles(WebDriver driver, By downloadButton) {
        driver.findElement(downloadButton).click();
    }
}