import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void updateProfile(String firstName, String lastName, String phone) {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//button[@id='profile-submit']")).click();
    }

    public void fillAndSubmitProfileForm(String firstName, String lastName, String phone) {
        driver.findElement(By.xpath("//input[@id='profile-first-name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='profile-last-name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='profile-phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//button[@id='profile-submit']")).click();
    }
}
