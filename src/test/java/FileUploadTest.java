import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadTest {
    public static void uploadFile(WebDriver driver, By fileInput, String filePath) {
        driver.findElement(fileInput).sendKeys(filePath);
    }
}
