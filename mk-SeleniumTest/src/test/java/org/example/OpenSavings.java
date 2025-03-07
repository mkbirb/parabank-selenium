package org.example;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpiraTestConfiguration(
//following are REQUIRED
        url = "https://rmit.spiraservice.net/",
        login = "s4008599",
        rssToken = "{324F3E19-71FE-4D34-A67B-1098F8B7F561}",
        projectId = 442
)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OpenSavings {
    private static ChromeDriver driver;
    private static String expectedResult;
    private static String actualResult;
    // Store the New Savings Account created
    private String newSavingsAccount;
    private static WebDriverWait wait;
    private static Registration registration;


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
        driver.findElement(socialSecurityNumberField).sendKeys("7654321");

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
                () -> assertEquals("7654321", actualSocialSecurityNumberResult, "Wrong Social Security Number Input" ),
                () -> assertEquals("MasterMasterMark", actualRegistrationUsernameResult, "Wrong Registration Username Input" ),
                () -> assertEquals("Password1!", actualRegistrationPasswordResult, "Wrong Registration Password Input" ),
                () -> assertEquals("Password1!", actualRegistrationConfirmPasswordResult, "Wrong Registration Confirm Password Input" ),
                () -> assertEquals("ParaBank | Customer Created", actualRegisterRedirectResult, "Wrong Registration Confirm Password Input" )
        );
    }

    @BeforeEach
    public void setUpWait() {
        // Wait for the Website to Load
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @AfterAll
    public static void CloseBrowser() {

        driver.close();
    }




    @Test
    @Order(1)
    @SpiraTestCase(testCaseId = 17148)
    public void testOpenAccountPageRetrieval() {
        // Checks that the Opening Account Page has been reached

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/register.htm"));

        WebElement openAccountLink = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));

        wait.until(ExpectedConditions.visibilityOf(openAccountLink));


        // Click the button that leads to Open Account Page
        openAccountLink.click();

        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/openaccount.htm"));

        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Open Account";

        assertEquals(expectedResult, actualResult, "Could not display Open Accounts Page");
    }

    @Test
    @Order(2)
    @SpiraTestCase(testCaseId = 17149)
    public void testSavingsAccountOption() {
        // Check if the Savings Account has been created for Account Creation

        WebElement findAccountType= driver.findElement(By.xpath("//*[@id=\"type\"]"));

        // Wait for Account Type Dropdown
        wait.until(ExpectedConditions.visibilityOf(findAccountType));

        Select accountType = new Select(findAccountType);

        // Select the Savings option
        accountType.selectByVisibleText("SAVINGS");

        // Get the selected option
        WebElement selectedOption = accountType.getFirstSelectedOption();

        // Check if the Account Type has been changed
        actualResult = selectedOption.getText();
        expectedResult = "SAVINGS";

        assertEquals(expectedResult, actualResult, "Wrong Type of Account being Opened");
    }

    @Test
    @Order(3)
    @SpiraTestCase(testCaseId = 17150)
    public void testExistingAccountOption() {
        // Check if the Existing Account has been selected for Account Creation
        WebElement findExistingAccount = driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]"));

        // Wait for Dropdown to Load
        wait.until(ExpectedConditions.visibilityOf(findExistingAccount));

        Select existingAccount = new Select(findExistingAccount);

        // Select the Existing Account option
        existingAccount.selectByIndex(0);

        // Get the selected option
        WebElement selectedOption = existingAccount.getFirstSelectedOption();

        // Check if the Account Type has been changed
        actualResult = selectedOption.getText();

        // Get the Existing Account Options again
        existingAccount = new Select(findExistingAccount);

        expectedResult = existingAccount.getFirstSelectedOption().getText();

        assertEquals(expectedResult, actualResult, "Wrong Existing Account being Opened");
    }

    @Test
    @Order(4)
    @SpiraTestCase(testCaseId = 17151)
    public void testOpenNewAccountSubmit() {
        // Check if the submission of the New Account is able to be done

        // Find the Open New Account Button and click:
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();

        By successMessage = By.xpath("//*[@id=\"openAccountResult\"]/p[1]");

        WebElement successMessageElement = driver.findElement(successMessage);

        // Wait for the loading of the Success Message
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage));

        // Check that new account able to be created
        actualResult = successMessageElement.getText();
        expectedResult = "Congratulations, your account is now open.";

        assertEquals(expectedResult, actualResult, "New Account was NOT able to be opened");
    }

    @Test
    @Order(5)
    @SpiraTestCase(testCaseId = 17152)
    public void testNewSavingsAccountDisplayed() throws InterruptedException {
        // Check if the new savings account created is displayed in the Accounts Overview

        // Holds whether New Savings Account is found to be displayed or not
        boolean newAccountDisplayed = false;

        WebElement newAccountNumber = driver.findElement(By.xpath("//*[@id=\"newAccountId\"]"));

        newSavingsAccount = newAccountNumber.getText();



        // Go to the Accounts Overview Page
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");

        // Wait for the loading of the Accounts Overview Page
        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/overview.htm"));

        By accountsOverviewTable = By.xpath("//*[@id='accountTable']/tbody");

        WebElement accountsOverview = driver.findElement(accountsOverviewTable);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr")));

        // Get the Rows of the Table
        List<WebElement> rows =  accountsOverview.findElements(By.xpath("tr"));



        for (WebElement row: rows) {

            // Get the Account Number Cell
            WebElement accountNumber = row.findElement(By.xpath("./td[1]"));



            // Check if the Account Number matches the New Savings Account Number displayed
            if (accountNumber.getText().equals(newSavingsAccount)) {
                newAccountDisplayed = true;
                break;
            }
        }

        assertTrue(newAccountDisplayed, "New Savings Account NOT displayed");
    }
}