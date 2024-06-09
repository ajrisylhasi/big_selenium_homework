import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void fillInputField(String fieldId, String text) {
        driver.findElement(By.xpath("//input[@id='" + fieldId + "']")).sendKeys(text);
    }

    public void selectFromDropdown(String dropdownId, String optionValue) {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='" + dropdownId + "']")));
        dropdown.selectByValue(optionValue);
    }

    public void selectRadioButton(String radioName, String optionValue) {
        driver.findElement(By.xpath("//input[@name='" + radioName + "' and @value='" + optionValue + "']")).click();
    }

    public void selectCheckBox(String checkboxId, boolean check) {
        if (check) {
            if (!driver.findElement(By.xpath("//input[@id='" + checkboxId + "']")).isSelected()) {
                driver.findElement(By.xpath("//input[@id='" + checkboxId + "']")).click();
            }
        } else {
            if (driver.findElement(By.xpath("//input[@id='" + checkboxId + "']")).isSelected()) {
                driver.findElement(By.xpath("//input[@id='" + checkboxId + "']")).click();
            }
        }
    }

    public void goToContactUsPage() {
        driver.findElement(By.xpath("//a[@id='contact-us-link']")).click();
    }

    public void fillContactForm(String name, String email, String message) {
        driver.findElement(By.xpath("//input[@id='contact-name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='contact-email']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@id='contact-message']")).sendKeys(message);
    }

    public void submitContactForm() {
        driver.findElement(By.xpath("//button[@id='contact-submit']")).click();
    }

    public void goToFeedbackPage() {
        driver.findElement(By.xpath("//a[@id='feedback-link']")).click();
    }

    public void fillFeedbackForm(String name, String email, String message, int rating) {
        driver.findElement(By.xpath("//input[@id='feedback-name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='feedback-email']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@id='feedback-message']")).sendKeys(message);
        Select ratingDropdown = new Select(driver.findElement(By.xpath("//select[@id='feedback-rating']")));
        ratingDropdown.selectByValue(String.valueOf(rating));
    }

    public void submitFeedbackForm() {
        driver.findElement(By.xpath("//button[@id='feedback-submit']")).click();
    }

    public void goToRegistrationPage() {
        driver.findElement(By.xpath("//a[@id='registration-link']")).click();
    }

    public void fillRegistrationForm(String name, String email, String password, String confirmPassword) {
        driver.findElement(By.xpath("//input[@id='registration-name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='registration-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='registration-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='registration-confirm-password']")).sendKeys(confirmPassword);
    }

    public void submitRegistrationForm() {
        driver.findElement(By.xpath("//button[@id='registration-submit']")).click();
    }
}
