import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
    public static void dragAndDrop(WebDriver driver, By source, By target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(source), driver.findElement(target)).perform();
    }
}
