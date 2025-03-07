package org.example;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpiraTestConfiguration(
//following are REQUIRED
        url = "https://rmit.spiraservice.net/",
        login = "s4008599",
        rssToken = "{324F3E19-71FE-4D34-A67B-1098F8B7F561}",
        projectId = 442
)


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Logout {
    private static ChromeDriver driver;
    private static String expectedResult;
    private static String actualResult;
    private static WebDriverWait wait;


    @BeforeEach
    public void setUpWait() {
        // Wait for the Website to Load
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @BeforeAll
    public static void setUp() {
        // Ensure that SetUp is run first
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Clear the database
        cleanDatabase();

        // Precondition: Register Account to be Logged In
        registerAccount();
    }

    public static void cleanDatabase() {
        // Clean the Database so you can register a new account
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/admin.htm"));

        // Find the Database Clean Button and click
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/table/tbody/tr/td[1]/form/table/tbody/tr/td[2]/button")).click();
    }

    public static void registerAccount() {

        // Precondition: Register Account
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/register.htm"));

        String actualRegisterPageResult = driver.getTitle();


        // Store the X Path as a variable
        By firstNameField = By.xpath("//*[@id='customer.firstName']");

        // Wait until the elements like the First Name Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstNameField));


        // Get the First Name Field and type in the Firstname
        driver.findElement(firstNameField).sendKeys("Mark");

        String actualFirstNameResult = driver.findElement(firstNameField).getAttribute("value");


        // Store the X Path as a variable
        By lastNameField = By.xpath("//*[@id=\"customer.lastName\"]");

        // Wait until the elements like the Last Name Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lastNameField));


        // Get the Last Name Field and type in the Last Name
        driver.findElement(lastNameField).sendKeys("Smith");

        String actualLastNameResult = driver.findElement(lastNameField).getAttribute("value");


        // Checks that the Address is able to be inputted

        // Store the X Path as a variable
        By addressField = By.xpath("//*[@id=\"customer.address.street\"]");

        // Wait until the elements like the Address Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addressField));


        // Get the Address Field and type in the Address
        driver.findElement(addressField).sendKeys("10 Moonview Highway");

        String actualAddressResult = driver.findElement(addressField).getAttribute("value");

        // Store the X Path as a variable
        By cityField = By.xpath("//*[@id=\"customer.address.city\"]");
        // Wait until the elements like the City Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cityField));


        // Get the City Field and type in the City
        driver.findElement(cityField).sendKeys("Melbourne");

        String actualCityResult = driver.findElement(cityField).getAttribute("value");

        // Checks that the State is able to be inputted

        // Store the X Path as a variable
        By stateField = By.xpath("//*[@id=\"customer.address.state\"]");

        // Wait until the elements like the State Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stateField));


        // Get the State Field and type in the State
        driver.findElement(stateField).sendKeys("Victoria");

        String actualStateResult = driver.findElement(stateField).getAttribute("value");


        // Checks that the Zip Code is able to be inputted

        // Store the X Path as a variable
        By zipCodeField = By.xpath("//*[@id=\"customer.address.zipCode\"]");

        // Get the Zip Code Field and type in the Zip Code
        driver.findElement(zipCodeField).sendKeys("3000");

        String actualZipCodeResult = driver.findElement(zipCodeField).getAttribute("value");


        // Checks that the Phone Number is able to be inputted

        // Store the X Path as a variable
        By phoneNumberField = By.xpath("//*[@id=\"customer.phoneNumber\"]");

        // Wait until the elements like the Phone Number Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(phoneNumberField));


        // Get the Phone Number Field and type in the Phone Number
        driver.findElement(phoneNumberField).sendKeys("043213415");

        String actualPhoneNumberResult = driver.findElement(phoneNumberField).getAttribute("value");

        // Checks that the Social Security Number is able to be inputted

        // Store the X Path as a variable
        By socialSecurityNumberField = By.xpath("//*[@id=\"customer.ssn\"]");

        // Wait until the elements like the Social Security Number Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(socialSecurityNumberField));


        // Get the Social Security Number and type in the Social Security Number
        driver.findElement(socialSecurityNumberField).sendKeys("1234567");

        String actualSocialSecurityNumberResult = driver.findElement(socialSecurityNumberField).getAttribute("value");


        // Checks that the Registration Username is able to be inputted

        // Store the X Path as a variable
        By registrationUsernameField = By.xpath("//*[@id=\"customer.username\"]");

        // Wait until the elements like the Registration Username Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registrationUsernameField));


        // Get the  Registration Username Field and type in the Registration Username
        driver.findElement(registrationUsernameField).sendKeys("MasterMasterMark");

        String actualRegistrationUsernameResult = driver.findElement(registrationUsernameField).getAttribute("value");

        // Checks that the Registration Password is able to be inputted

        // Store the X Path as a variable
        By registrationPasswordField = By.xpath("//*[@id=\"customer.password\"]");

        // Wait until the elements like the Registration Password Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registrationPasswordField));


        // Get the  Registration Password Field and type in the Registration Password
        driver.findElement(registrationPasswordField).sendKeys("Password1!");

        String actualRegistrationPasswordResult = driver.findElement(registrationPasswordField).getAttribute("value");

        // Checks that the Registration Confirmation Password is able to be inputted

        // Store the X Path as a variable
        By registrationConfirmPasswordField = By.name("repeatedPassword");

        // Wait until the elements like the Registration Confirm Password Field appears
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(registrationConfirmPasswordField));


        // Get the  Registration Confirm Password Field and type in the Registration Confirm Password
        driver.findElement(registrationConfirmPasswordField).sendKeys("Password1!");

        String actualRegistrationConfirmPasswordResult = driver.findElement(registrationConfirmPasswordField).getAttribute("value");

        // Checks that the Register Button leads to correct Customer Created Page

        // Find the Register Button and click:
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/register.htm"));

        // Check that we have moved to the Customer Created Page
        String actualRegisterRedirectResult = driver.getTitle();


        assertAll(
                () -> assertEquals("ParaBank | Register for Free Online Account Access", actualRegisterPageResult , "Could not get to Registration Page"),
                () -> assertEquals("Mark", actualFirstNameResult, "Wrong First Name Input"),
                () -> assertEquals("Smith", actualLastNameResult, "Wrong Last Name Input"),
                () -> assertEquals("10 Moonview Highway", actualAddressResult, "Wrong Address Input"),
                () -> assertEquals("Melbourne", actualCityResult, "Wrong City Input" ),
                () -> assertEquals("Victoria", actualStateResult, "Wrong State Input"),
                () -> assertEquals("3000", actualZipCodeResult, "Wrong Zip Code Input" ),
                () -> assertEquals("043213415", actualPhoneNumberResult, "Wrong Phone Number Input" ),
                () -> assertEquals("1234567", actualSocialSecurityNumberResult, "Wrong Social Security Number Input" ),
                () -> assertEquals("MasterMasterMark", actualRegistrationUsernameResult, "Wrong Registration Username Input" ),
                () -> assertEquals("Password1!", actualRegistrationPasswordResult, "Wrong Registration Password Input" ),
                () -> assertEquals("Password1!", actualRegistrationConfirmPasswordResult, "Wrong Registration Confirm Password Input" ),
                () -> assertEquals("ParaBank | Customer Created", actualRegisterRedirectResult, "Wrong Registration Redirect" )
        );
    }


    @AfterAll
    public static void CloseBrowser() {

        driver.close();
    }

    @Test
    @Order(1)
    @SpiraTestCase(testCaseId = 17534)
    public void testAccountLogout() {
        // Checks if able to Log Out of the signed in Account

        // Find the Log Out and click
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();

        // Check that we have moved to the Login Page
        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Welcome | Online Banking";

        assertEquals(expectedResult, actualResult, "Logout NOT successful");
    }

}