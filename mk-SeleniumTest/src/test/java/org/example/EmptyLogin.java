package org.example;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpiraTestConfiguration(
//following are REQUIRED
        url = "https://rmit.spiraservice.net/",
        login = "s4008599",
        rssToken = "{324F3E19-71FE-4D34-A67B-1098F8B7F561}",
        projectId = 442
)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmptyLogin {
    private static ChromeDriver driver;
    private String expectedResult;
    private String actualResult;
    private WebElement element;
    private WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void setUpWait() {
        // Wait for the Website to Load
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @AfterAll
    public static void CloseBrowser() {
        driver.close();
    }

    @Test
    @Order(1)
    @SpiraTestCase(testCaseId = 17058)
    public void testLoginPageRetrieval() {
        // Checks that the Login Page is able to be displayed

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        actualResult = "ParaBank | Welcome | Online Banking";
        expectedResult = driver.getTitle();

        assertEquals(expectedResult, actualResult, "Could not get Login Page");
    }

    @Test
    @Order(2)
    @SpiraTestCase(testCaseId = 16992)
    public void testEmptyUsernameFieldInput() {
        // Checks that the Username Field is empty

        // Wait until the elements like the Username Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));
        // Get the Username Field and make sure its empty
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).clear();

        actualResult = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).getAttribute("value");
        expectedResult = "";

        assertEquals(expectedResult, actualResult, "Username Field NOT Empty");

    }

    @Test
    @Order(3)
    @SpiraTestCase(testCaseId = 17059)
    public void testEmptyPasswordFieldInput() {
        // Checks that the Password Field is empty

        // Wait until the elements like the Password Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("password")));

        // Get the Password Field and make sure its Null
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).clear();

        actualResult = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).getAttribute("value");
        expectedResult = "";

        assertEquals(expectedResult, actualResult, "Password Field NOT Empty");
    }

    @Test
    @Order(4)
    @SpiraTestCase(testCaseId = 17060)
    public void testSignInButton() {
        // Checks that the Sign In Button leads to correct Error Page

        // Find the Log In Button and click:
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();

        // Check that we have moved to the Error Page
        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Error";

        assertEquals(expectedResult, actualResult, "Error Page NOT reached");

    }

    @Test
    @Order(5)
    @SpiraTestCase(testCaseId = 17061)
    public void testIncorrectCredentialsDisplay() {
        // Checks that an Error Message appears indicating how Username and Password needs to be added
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));

        actualResult = errorMessage.getText();
        expectedResult = "Please enter a username and password.";

        assertEquals(expectedResult, actualResult, "Incorrect Credentials Message NOT displayed");
    }
}
