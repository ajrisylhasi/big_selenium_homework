import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFlightPage extends BasePage {

    public SearchFlightPage(WebDriver driver) {
        super(driver);
    }

    public void searchFlight(String departure, String destination) {
        driver.findElement(By.xpath("//input[@id='departure-field-id']")).sendKeys(departure);
        driver.findElement(By.xpath("//input[@id='destination-field-id']")).sendKeys(destination);
        driver.findElement(By.xpath("//button[@id='search-button-id']")).click();
    }
    
    public void searchFlightWithDates(String departure, String destination, String departDate, String returnDate) {
        driver.findElement(By.xpath("//input[@id='departure-field']")).sendKeys(departure);
        driver.findElement(By.xpath("//input[@id='destination-field']")).sendKeys(destination);
        driver.findElement(By.xpath("//input[@id='depart-date']")).sendKeys(departDate);
        driver.findElement(By.xpath("//input[@id='return-date']")).sendKeys(returnDate);
        driver.findElement(By.xpath("//button[@id='search-submit']")).click();
    }
}
