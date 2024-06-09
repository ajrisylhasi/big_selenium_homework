import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuite {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchFlightPage searchFlightPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
        driver.get("https://www.finnair.com/au-en");
        CookieManager.addConsentCookie(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchFlightPage = new SearchFlightPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test(description = "Test Login")
    public void testLogin() {
        loginPage.login("ajrisylhasi@gmail.com", "sylhasi123!");
    }

    @Test(description = "Test Search Flight", dependsOnMethods = {"testLogin"})
    public void testSearchFlight() {
        homePage.goToProfilePage();
        searchFlightPage.searchFlight("Budapest", "Helsinki");
    }

    @Test(description = "Test Logout", dependsOnMethods = {"testSearchFlight"})
    public void testLogout() {
        profilePage.logout();
    }

    @Test(description = "Test Hover Over Element")
    public void testHover() {
        HoverTest.hoverOverElement(driver, By.xpath("//button[@data-test='navigation-menu-signin']"));
    }

    @Test(description = "Test Drag and Drop")
    public void testDragAndDrop() {
        DragAndDropTest.dragAndDrop(driver, By.xpath("//div[@id='source-selector']"), By.xpath("//div[@id='target-selector']"));
    }

    @Test(description = "Test File Upload")
    public void testFileUpload() {
        FileUploadTest.uploadFile(driver, By.xpath("//input[@type='file']"), "path/to/file");
    }

    @Test(description = "Test Navigate Back")
    public void testNavigateBack() {
        HistoryTest.navigateBack(driver);
    }

    @Test(description = "Test JavaScript Executor")
    public void testJavaScriptExecutor() {
        JavaScriptExecutorTest.executeScript(driver, "alert('Test JavaScript Executor');");
    }

    @Test(description = "Test Download Files")
    public void testDownloadFiles() {
        DownloadFilesTest.configureDownload(driver, "path/to/download/folder");
        DownloadFilesTest.downloadFiles(driver, By.xpath("//button[@class='download-button-selector']"));
    }

    @Test(description = "Test with Random Data")
    public void testWithRandomData() {
        String randomEmail = RandomDataTest.getRandomString(10) + "@example.com";
        loginPage.login(randomEmail, "RandomPassword123!");
    }

    @Test(description = "Test Filling Text Input")
    public void testFillTextInput() {
        homePage.fillInputField("input-field-id", "Sample Text");
    }

    @Test(description = "Test Selecting from Dropdown")
    public void testSelectFromDropdown() {
        homePage.selectFromDropdown("dropdown-id", "Option Value");
    }

    @Test(description = "Test Radio Button Selection")
    public void testSelectRadioButton() {
        homePage.selectRadioButton("radio-button-name", "radio-option-value");
    }

    @Test(description = "Test CheckBox Selection")
    public void testCheckBoxSelection() {
        homePage.selectCheckBox("checkbox-id", true); // true to check, false to uncheck
    }

    @Test(description = "Test Contact Form Submission")
    public void testContactFormSubmission() {
        homePage.goToContactUsPage();
        homePage.fillContactForm("Test Name", "test@example.com", "This is a test message.");
        homePage.submitContactForm();
    }

    @Test(description = "Test Feedback Form Submission")
    public void testFeedbackFormSubmission() {
        homePage.goToFeedbackPage();
        homePage.fillFeedbackForm("Test User", "testuser@example.com", "This is a feedback message.", 5);
        homePage.submitFeedbackForm();
    }

    @Test(description = "Test User Registration Form")
    public void testUserRegistrationForm() {
        homePage.goToRegistrationPage();
        homePage.fillRegistrationForm("New User", "newuser@example.com", "Password123!", "Password123!");
        homePage.submitRegistrationForm();
    }

    @Test(description = "Test Login Form Submission in LoginPage")
    public void testLoginFormInLoginPage() {
        loginPage.fillAndSubmitLoginForm("testuser@example.com", "testpassword");
    }

    @Test(description = "Test Profile Update Form Submission in ProfilePage")
    public void testProfileUpdateForm() {
        profilePage.fillAndSubmitProfileForm("John", "Doe", "1234567890");
    }

    @Test(description = "Test Flight Search with Dates in SearchFlightPage")
    public void testSearchFlightWithDates() {
        searchFlightPage.searchFlightWithDates("New York", "Los Angeles", "2024-12-01", "2024-12-15");
    }

    @Test(description = "Test Static Pages")
    public void testStaticPages() {
        List<String> staticPages = ConfigLoader.getStaticPages();
        for (String url : staticPages) {
            driver.get(url);
            boolean isContentPresent = driver.findElements(By.xpath("//*[contains(text(),'Expected Content Text')]")).size() > 0;
            Assert.assertTrue(isContentPresent, "Expected content not found on page: " + url);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
