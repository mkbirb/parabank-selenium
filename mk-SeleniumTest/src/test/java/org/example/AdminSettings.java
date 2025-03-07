package org.example;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpiraTestConfiguration(
//following are REQUIRED
        url = "https://rmit.spiraservice.net/",
        login = "s4008599",
        rssToken = "{324F3E19-71FE-4D34-A67B-1098F8B7F561}",
        projectId = 442
)


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminSettings {
    private static ChromeDriver driver;
    private static String expectedResult;
    private static String actualResult;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        // Ensure that SetUp is run first
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));


        // These Preconditions are done to check whether the Admin Settings have successfully been applied to the application
        // Clear the database
        cleanDatabase();

        // Precondition: Register Account to be Logged In
        registerAccount();

        // Precondition: User should be logged out
        accountLogout();
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

    public static void accountLogout() {
        // Checks if able to Log Out of the signed in Account

        // Find the Log Out and click
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();

        // Check that we have moved to the Login Page
        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Welcome | Online Banking";

        assertEquals(expectedResult, actualResult, "Logout NOT successful");
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
    @SpiraTestCase(testCaseId = 17475)
    public void testSuccessAdminPage() {
        // Checks that the Admin Page is able to be displayed

        driver.get("https://parabank.parasoft.com/parabank/admin.htm");

        actualResult = "ParaBank | Administration";
        expectedResult = driver.getTitle();

        assertEquals(expectedResult, actualResult, "Could not get Admin Page");
    }

    @Test
    @Order(2)
    @SpiraTestCase(testCaseId = 17486)
    public void testChangeDataAccessMode() {
        // Check that the Data Access Mode has been changed to SOAP

        // Get the desired Radio Button
        By soapRadio = By.xpath("//*[@id=\"accessMode1\"]");

        WebElement soapRadioButton = driver.findElement(soapRadio);

        // Select the desired Radio Button of SOAP
        soapRadioButton.click();

        // Wait until the Soap Radio Button has been selected
        wait.until(ExpectedConditions.elementToBeSelected(soapRadio));

        assertTrue(soapRadioButton.isSelected(), "SOAP Radio Button is selected");

    }

    @Test
    @Order(3)
    @SpiraTestCase(testCaseId = 17489)
    public void testEmptySoapEndpoint() {
        // Check that the SOAP Endpoint of Web Service is empty as desired

        By soapEndpoint = By.xpath("//*[@id=\"soapEndpoint\"]");

        WebElement soapEndpointField = driver.findElement(soapEndpoint);

        // Wait for the Field to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(soapEndpoint));

        // Get the Soap Endpoint Field and make sure its empty
        soapEndpointField.clear();

        actualResult = driver.findElement(soapEndpoint).getAttribute("value");
        expectedResult = "";

        assertEquals(expectedResult, actualResult, "Soap Endpoint of Web Service NOT Empty");
    }

    @Test
    @Order(4)
    @SpiraTestCase(testCaseId = 17492)
    public void testEmptyRestEndpoint() {
        // Check that the Rest Endpoint of Web Service is empty as desired

        By restEndpoint = By.xpath("//*[@id=\"restEndpoint\"]");

        WebElement restEndpointField = driver.findElement(restEndpoint);

        // Wait for the Field to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(restEndpoint));

        // Get the Rest Endpoint Field and make sure its empty
        restEndpointField.clear();

        actualResult = driver.findElement(restEndpoint).getAttribute("value");
        expectedResult = "";

        assertEquals(expectedResult, actualResult, "Rest Endpoint of Web Service NOT Empty");
    }

    @Test
    @Order(5)
    @SpiraTestCase(testCaseId = 17496)
    public void testEmptyLoanProcessorServiceEndpoint() {
        // Check that the Loan Processor Service of Web Service is empty as desired

        By proccessorServiceEndpoint = By.xpath("//*[@id=\"endpoint\"]");

        WebElement processorEndpointField = driver.findElement(proccessorServiceEndpoint);

        // Wait for the Field to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(proccessorServiceEndpoint));

        // Get the Loan Processor Service Field and make sure its empty
        processorEndpointField.clear();

        actualResult = driver.findElement(proccessorServiceEndpoint).getAttribute("value");
        expectedResult = "";

        assertEquals(expectedResult, actualResult, "Loan Processor Service of Web Service NOT Empty");
    }

    @Test
    @Order(6)
    @SpiraTestCase(testCaseId = 17497)
    public void testInitialBalance() {
        // Checks that the desired initial balance has been set

        By initialBalance = By.xpath("//*[@id=\"initialBalance\"]");

        WebElement initialBalanceField = driver.findElement(initialBalance);

        // Wait for the Field to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(initialBalance));

        // Make sure the field is empty first, before sending the desired amount
        initialBalanceField.clear();

        // Type the desired amount
        initialBalanceField.sendKeys("600");

        actualResult = driver.findElement(initialBalance).getAttribute("value");
        expectedResult = "600";

        assertEquals(expectedResult, actualResult, "Initial Balance Incorrectly Set");
    }

    @Test
    @Order(7)
    @SpiraTestCase(testCaseId = 17500)
    public void testMinimumBalance() {
        // Checks that the desired minimum balance has been set

        By minimumBalance = By.xpath("//*[@id=\"minimumBalance\"]");

        WebElement minimumBalanceField = driver.findElement(minimumBalance);

        // Wait for the Field to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(minimumBalance));

        // Make sure the field is empty first, before sending the desired amount
        minimumBalanceField.clear();

        /// Type the desired amount
        minimumBalanceField.sendKeys("200");

        actualResult = driver.findElement(minimumBalance).getAttribute("value");
        expectedResult = "200";

        assertEquals(expectedResult, actualResult, "Minimum Balance Incorrectly Set");
    }

    @Test
    @Order(8)
    @SpiraTestCase(testCaseId = 17503)
    public void testLoanProvider() {
        // Checks that the desired Loan Provider is selected

        WebElement loanProviderElement = driver.findElement(By.xpath("//*[@id=\"loanProvider\"]"));

        // Wait for Loan Provider Dropdown
        wait.until(ExpectedConditions.visibilityOf(loanProviderElement));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"loanProvider\"]/option"), 0));

        Select loanProvider = new Select(loanProviderElement);

        // Select the Local option
        loanProvider.selectByVisibleText("Local");

        // Get the selected option
        WebElement selectedOption = loanProvider.getFirstSelectedOption();

        // Check if the Loan Provider has been changed
        actualResult = selectedOption.getText();
        expectedResult = "Local";

        assertEquals(expectedResult, actualResult, "Wrong Type of Loan Provider selected");
    }

    @Test
    @Order(9)
    @SpiraTestCase(testCaseId = 17504)
    public void testLoanProcessor() {
        // Checks that the desired Loan Proccesor is selected

        WebElement loanProccesorElement = driver.findElement(By.xpath("//*[@id=\"loanProcessor\"]"));

        // Wait for Loan Proccesor Dropdown
        wait.until(ExpectedConditions.visibilityOf(loanProccesorElement));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"loanProcessor\"]/option"), 0));

        Select loanProccesor = new Select(loanProccesorElement);

        // Select the Local option
        loanProccesor.selectByVisibleText("Combined");

        // Get the selected option
        WebElement selectedOption = loanProccesor.getFirstSelectedOption();

        // Check if the Loan Proccesor has been changed
        actualResult = selectedOption.getText();
        expectedResult = "Combined";

        assertEquals(expectedResult, actualResult, "Wrong Type of Loan Proccesor selected");
    }

    @Test
    @Order(10)
    @SpiraTestCase(testCaseId = 17507)
    public void testCheckThreshold() {
        // Checks that the desired Threshold has been set

        By threshold = By.xpath("//*[@id=\"loanProcessorThreshold\"]");

        WebElement thresholdField = driver.findElement(threshold);

        // Wait for the Field to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(threshold));

        // Make sure the field is empty first, before sending the desired Threshold
        thresholdField.clear();

        /// Type the desired amount
        thresholdField.sendKeys("10");

        actualResult = driver.findElement(threshold).getAttribute("value");
        expectedResult = "10";

        assertEquals(expectedResult, actualResult, "Threshold Incorrectly Set");
    }

    @Test
    @Order(11)
    @SpiraTestCase(testCaseId = 17509)
    public void testAdminFormSubmission() {
        // Checks that the Admin Form is able to be submitted.

        // Find the Submit button and click:
        driver.findElement(By.xpath("//*[@id=\"adminForm\"]/input")).click();

        By successMessage = By.xpath("//*[@id=\"rightPanel\"]/p/b");

        // Find the Success Message
        WebElement successMessageElement = driver.findElement(successMessage);

        // Wait for the Success Message to load after Form Submission
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage));

        actualResult = successMessageElement.getText();
        expectedResult = "Settings saved successfully.";

        assertEquals(expectedResult, actualResult, "Admin Settings NOT saved");
    }

    @Test
    @Order(12)
    @SpiraTestCase(testCaseId = 17511)
    public void testCheckOpeningAccountMinimumBalance() {
        // Checks that the Opening Account Minimum Balance is $200

        // Do the Login first to check whether Minimum Balance for Opening Account has been changed
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        String actualLoginPageResult = "ParaBank | Welcome | Online Banking";
        String expectedLoginPageResult = driver.getTitle();

        By usernameField = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
        driver.findElement(usernameField).sendKeys("MasterMasterMark");

        By passwordField = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
        // Get the Password Field and make sure it has the valid Password
        driver.findElement(passwordField).sendKeys("Password1!");

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();

        // Wait for the loading of the Accounts Overview Page
        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/overview.htm"));

        String actualOverviewPageResult = "ParaBank | Accounts Overview";
        String expectedOverviewPageResult = driver.getTitle();

        driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");

        String actualOpenAccountPageResult = driver.getTitle();
        String expectedOpenAccountPageResult = "ParaBank | Open Account";

        // Now check whether the Message contains the new Opening Account Balance of $200
        By minimumBalanceMessage = By.xpath("//*[@id=\"openAccountForm\"]/form/p[2]/b");

        // Find the Minimum Balance Message
        WebElement minimumBalanceMessageElement = driver.findElement(minimumBalanceMessage);

        // Wait for the Minimum Balance Message to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(minimumBalanceMessage));

        // Use assertAll to group the assertions
        assertAll(
                () -> assertEquals("ParaBank | Welcome | Online Banking", actualLoginPageResult, "Could not display Login Page"),
                () -> assertEquals("ParaBank | Accounts Overview", actualOverviewPageResult, "Login NOT Successful"),
                () -> assertEquals("ParaBank | Open Account", actualOpenAccountPageResult, "Could not display Open Accounts Page"),
                () -> assertTrue(minimumBalanceMessageElement.getText().contains("$200"), "Minimum Balance Message does NOT contain $200 as desired")
        );
    }

}