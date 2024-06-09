import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class RandomDataTest {

    public static void fillAndSubmitRandomForm(WebDriver driver) {
        String randomEmail = getRandomString(10) + "@example.com";
        driver.findElement(By.xpath("//input[@id='random-email']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//input[@id='random-password']")).sendKeys("RandomPassword123!");
        driver.findElement(By.xpath("//button[@id='random-submit']")).click();
    }

    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        while (length > 0) {
            result.append(characters.charAt(random.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }
}
