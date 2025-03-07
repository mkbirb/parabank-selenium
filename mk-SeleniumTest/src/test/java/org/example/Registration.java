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
class Registration {
    private static ChromeDriver driver;
    private String expectedResult;
    private String actualResult;
    private WebElement element;
    private static WebDriverWait wait;

    private static Registration registration;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Precondition: Database must be cleaned
        cleanDatabase();
    }

    @BeforeEach
    public void setUpWait() {
        // Wait for the Website to Load
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public static void cleanDatabase() {
        // Clean the Database so you can register a new account
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/admin.htm"));

        // Find the Database Clean Button and click
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/table/tbody/tr/td[1]/form/table/tbody/tr/td[2]/button")).click();
    }


    @AfterAll
    public static void CloseBrowser() {
        driver.close();
    }



    @Test
    @Order(1)
    @SpiraTestCase(testCaseId = 17063)
    public void testRegistrationPageRetrieval() {
        // Checks that the Registration Page is able to be displayed
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/register.htm"));

        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Register for Free Online Account Access";

        assertEquals(expectedResult, actualResult, "Could not get to Registration Page");
    }

    @Test
    @Order(2)
    @SpiraTestCase(testCaseId = 17064)
    public void testFirstNameFieldInput() {
        // Checks that the First Name is able to be inputted

        // Store the X Path as a variable
        By firstNameField = By.xpath("//*[@id='customer.firstName']");

        // Wait until the elements like the First Name Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstNameField));


        // Get the First Name Field and type in the Firstname
        driver.findElement(firstNameField).sendKeys("Mark");

        actualResult = driver.findElement(firstNameField).getAttribute("value");
        expectedResult = "Mark";

        assertEquals(expectedResult, actualResult, "Wrong First Name Input");
    }

    @Test
    @Order(3)
    @SpiraTestCase(testCaseId = 17066)
    public void testLastNameFieldInput() {
        // Checks that the Last Name is able to be inputted

        // Store the X Path as a variable
        By lastNameField = By.xpath("//*[@id=\"customer.lastName\"]");

        // Wait until the elements like the Last Name Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lastNameField));


        // Get the Last Name Field and type in the Last Name
        driver.findElement(lastNameField).sendKeys("Smith");

        actualResult = driver.findElement(lastNameField).getAttribute("value");
        expectedResult = "Smith";

        assertEquals(expectedResult, actualResult, "Wrong Last Name Input");
    }

    @Test
    @Order(4)
    @SpiraTestCase(testCaseId = 17067)
    public void testAddressFieldInput() {
        // Checks that the Address is able to be inputted

        // Store the X Path as a variable
        By addressField = By.xpath("//*[@id=\"customer.address.street\"]");

        // Wait until the elements like the Address Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addressField));


        // Get the Address Field and type in the Address
        driver.findElement(addressField).sendKeys("10 Moonview Highway");

        actualResult = driver.findElement(addressField).getAttribute("value");
        expectedResult = "10 Moonview Highway";

        assertEquals(expectedResult, actualResult, "Wrong Address Input");
    }

    @Test
    @Order(5)
    @SpiraTestCase(testCaseId = 17068)
    public void testCityInput() {
        // Checks that the City is able to be inputted

        // Store the X Path as a variable
        By cityField = By.xpath("//*[@id=\"customer.address.city\"]");
        // Wait until the elements like the City Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cityField));


        // Get the City Field and type in the City
        driver.findElement(cityField).sendKeys("Melbourne");

        actualResult = driver.findElement(cityField).getAttribute("value");
        expectedResult = "Melbourne";

        assertEquals(expectedResult, actualResult, "Wrong City Input" );
    }

    @Test
    @Order(6)
    @SpiraTestCase(testCaseId = 17069)
    public void testStateInput() {
        // Checks that the State is able to be inputted

        // Store the X Path as a variable
        By stateField = By.xpath("//*[@id=\"customer.address.state\"]");

        // Wait until the elements like the State Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stateField));


        // Get the State Field and type in the State
        driver.findElement(stateField).sendKeys("Victoria");

        actualResult = driver.findElement(stateField).getAttribute("value");
        expectedResult = "Victoria";

        assertEquals(expectedResult, actualResult, "Wrong State Input");
    }

    @Test
    @Order(7)
    @SpiraTestCase(testCaseId = 17070)
    public void testZipCodeInput() {
        // Checks that the Zip Code is able to be inputted

        // Store the X Path as a variable
        By zipCodeField = By.xpath("//*[@id=\"customer.address.zipCode\"]");

        // Get the Zip Code Field and type in the Zip Code
        driver.findElement(zipCodeField).sendKeys("3000");

        actualResult = driver.findElement(zipCodeField).getAttribute("value");
        expectedResult = "3000";

        assertEquals(expectedResult, actualResult, "Wrong Zip Code Input");
    }

    @Test
    @Order(8)
    @SpiraTestCase(testCaseId = 17071)
    public void testPhoneNumberInput() {
        // Checks that the Phone Number is able to be inputted

        // Store the X Path as a variable
        By phoneNumberField = By.xpath("//*[@id=\"customer.phoneNumber\"]");

        // Wait until the elements like the Phone Number Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(phoneNumberField));


        // Get the Phone Number Field and type in the Phone Number
        driver.findElement(phoneNumberField).sendKeys("043213415");

        actualResult = driver.findElement(phoneNumberField).getAttribute("value");
        expectedResult = "043213415";

        assertEquals(expectedResult, actualResult, "Wrong Phone Number Input");
    }

    @Test
    @Order(9)
    @SpiraTestCase(testCaseId = 17072)
    public void testSocialSecurityNumberInput() {
        // Checks that the Social Security Number is able to be inputted

        // Store the X Path as a variable
        By socialSecurityNumberField = By.xpath("//*[@id=\"customer.ssn\"]");

        // Wait until the elements like the Social Security Number Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(socialSecurityNumberField));


        // Get the Social Security Number and type in the Social Security Number
        driver.findElement(socialSecurityNumberField).sendKeys("1234567");

        actualResult = driver.findElement(socialSecurityNumberField).getAttribute("value");
        expectedResult = "1234567";

        assertEquals(expectedResult, actualResult, "Wrong Social Security Number Input");
    }

    @Test
    @Order(10)
    @SpiraTestCase(testCaseId = 17073)
    public void testRegistrationUsernameInput() {
        // Checks that the Registration Username is able to be inputted

        // Store the X Path as a variable
        By registrationUsernameField = By.xpath("//*[@id=\"customer.username\"]");

        // Wait until the elements like the Registration Username Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registrationUsernameField));


        // Get the  Registration Username Field and type in the Registration Username
        driver.findElement(registrationUsernameField).sendKeys("MasterMasterMark");

        actualResult = driver.findElement(registrationUsernameField).getAttribute("value");
        expectedResult = "MasterMasterMark";

        assertEquals(expectedResult, actualResult, "Wrong Registration Username Input");
    }

    @Test
    @Order(11)
    @SpiraTestCase(testCaseId = 17074)
    public void testRegistrationPasswordInput() {
        // Checks that the Registration Password is able to be inputted

        // Store the X Path as a variable
        By registrationPasswordField = By.xpath("//*[@id=\"customer.password\"]");

        // Wait until the elements like the Registration Password Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registrationPasswordField));


        // Get the  Registration Password Field and type in the Registration Password
        driver.findElement(registrationPasswordField).sendKeys("Password1!");

        actualResult = driver.findElement(registrationPasswordField).getAttribute("value");
        expectedResult = "Password1!";

        assertEquals(expectedResult, actualResult, "Wrong Registration Password Input");
    }

    @Test
    @Order(12)
    @SpiraTestCase(testCaseId = 17075)
    public void testRegistrationConfirmPasswordInput() {
        // Checks that the Registration Confirmation Password is able to be inputted

        // Store the X Path as a variable
        By registrationConfirmPasswordField = By.name("repeatedPassword");

        // Wait until the elements like the Registration Confirm Password Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registrationConfirmPasswordField));


        // Get the  Registration Confirm Password Field and type in the Registration Confirm Password
        driver.findElement(registrationConfirmPasswordField).sendKeys("Password1!");

        actualResult = driver.findElement(registrationConfirmPasswordField).getAttribute("value");
        expectedResult = "Password1!";

        assertEquals(expectedResult, actualResult, "Wrong Registration Confirm Password Input");
    }

    @Test
    @Order(13)
    @SpiraTestCase(testCaseId = 17076)
    public void testSuccessRegistrationRedirect() {
        // Checks that the Register Button leads to correct Customer Created Page

        // Find the Register Button and click:
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();

        // Check that we have moved to the Customer Created Page
        actualResult = "ParaBank | Customer Created";
        expectedResult = driver.getTitle();

        assertEquals(expectedResult, actualResult, "Wrong Page displayed after Registration Submitted");
    }
}