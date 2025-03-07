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
class TransferMoney{
    private static ChromeDriver driver;
    private static String expectedResult;
    private static String actualResult;

    // Static as it is desired to keep the Account Numbers created
    private static String savingsAccountNumber;
    private static String checkingsAccountNumber;
    private static String savingsBalance;
    private static String checkingsBalance;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        // Ensure that SetUp is run first
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Clear the database
        cleanDatabase();

        // Precondition: Register Account to be Logged In
        registerAccount();

        // Precondition: Go to Account Page and open a Savings Account and open a Checking Account
        openAccountPageRetrieval();
        openSavingsAccount();
        openCheckingAccount();
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
        driver.findElement(firstNameField).sendKeys("Sarah");

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
        driver.findElement(registrationUsernameField).sendKeys("MasterMasterSarah");

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
                () -> assertEquals("Sarah", actualFirstNameResult, "Wrong First Name Input"),
                () -> assertEquals("Smith", actualLastNameResult, "Wrong Last Name Input"),
                () -> assertEquals("10 Moonview Highway", actualAddressResult, "Wrong Address Input"),
                () -> assertEquals("Melbourne", actualCityResult, "Wrong City Input" ),
                () -> assertEquals("Victoria", actualStateResult, "Wrong State Input"),
                () -> assertEquals("3000", actualZipCodeResult, "Wrong Zip Code Input" ),
                () -> assertEquals("043213415", actualPhoneNumberResult, "Wrong Phone Number Input" ),
                () -> assertEquals("1234567", actualSocialSecurityNumberResult, "Wrong Social Security Number Input" ),
                () -> assertEquals("MasterMasterSarah", actualRegistrationUsernameResult, "Wrong Registration Username Input" ),
                () -> assertEquals("Password1!", actualRegistrationPasswordResult, "Wrong Registration Password Input" ),
                () -> assertEquals("Password1!", actualRegistrationConfirmPasswordResult, "Wrong Registration Confirm Password Input" ),
                () -> assertEquals("ParaBank | Customer Created", actualRegisterRedirectResult, "Wrong Registration Confirm Password Input" )
        );
    }

    public static void openAccountPageRetrieval() {
        // Checks that the Opening Account Page has been reached
        driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");

        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Open Account";

        assertEquals(expectedResult, actualResult, "Could not display Open Accounts Page");
    }

    public static void openSavingsAccount() {

        // Select Savings Option
        WebElement findAccountType= driver.findElement(By.xpath("//*[@id=\"type\"]"));

        // Wait for Account Type Dropdown
        wait.until(ExpectedConditions.visibilityOf(findAccountType));

        Select accountType = new Select(findAccountType);

        // Select the Savings option
        accountType.selectByVisibleText("SAVINGS");

        // Get the selected option
        WebElement selectedOption = accountType.getFirstSelectedOption();

        // Check if the Account Type has been changed
        String actualAccountTypeResult = selectedOption.getText();

        // Select Existing Account
        WebElement findExistingAccount = driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]"));

        // Wait for Dropdown to Load
        wait.until(ExpectedConditions.visibilityOf(findExistingAccount));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"fromAccountId\"]/option"), 0));

        Select existingAccount = new Select(findExistingAccount);

        // Select the Existing Account
        existingAccount.selectByIndex(0);

        WebElement existingAccountSelectedOption = existingAccount.getFirstSelectedOption();

        // Check if the Account Type has been changed
        String actualExistingAccountResult = existingAccountSelectedOption.getText();

        // Get the Existing Account Options again
        existingAccount = new Select(findExistingAccount);

        String expectedExistingAccountResult = existingAccount.getFirstSelectedOption().getText();


        // Find the Open New Account Button and click:
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();

        By successMessage = By.xpath("//*[@id=\"openAccountResult\"]/p[1]");

        WebElement successMessageElement = driver.findElement(successMessage);

        // Wait for the loading of the Success Message
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage));

        // Check that new account able to be created
        String actualSuccessMessageResult = successMessageElement.getText();

        // Get the Savings Account Number to check Balance off, for the future test cases
        WebElement newAccountNumber = driver.findElement(By.xpath("//*[@id=\"newAccountId\"]"));

        savingsAccountNumber = newAccountNumber.getText();



        assertAll(
                () -> assertEquals("SAVINGS", actualAccountTypeResult , "Wrong Type of Account (Not Savings Chosen) being Opened"),
                () -> assertEquals( expectedExistingAccountResult, actualExistingAccountResult, "Wrong Existing Account being Opened"),
                () -> assertEquals("Congratulations, your account is now open.", actualSuccessMessageResult, "New Savings Account was NOT able to be opened")
        );
    }

    public static void openCheckingAccount() {
        // Checks that Open Checking Account has been opened

        // Checks that the Opening Account Page has been reached
        driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");

        String actualOpenAccountPageResult = driver.getTitle();

        // Select Checking Option
        WebElement findAccountType = driver.findElement(By.xpath("//*[@id=\"type\"]"));

        // Wait for Account Type Dropdown
        wait.until(ExpectedConditions.visibilityOf(findAccountType));

        Select accountType = new Select(findAccountType);

        // Select the Checking option
        accountType.selectByVisibleText("CHECKING");

        // Get the selected option
        WebElement selectedOption = accountType.getFirstSelectedOption();

        // Check if the Account Type has been changed
        String actualAccountTypeResult = selectedOption.getText();

        // Select Existing Account
        WebElement findExistingAccount = driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]"));

        // Wait for Dropdown to Load
        wait.until(ExpectedConditions.visibilityOf(findExistingAccount));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"fromAccountId\"]/option"), 0));

        Select existingAccount = new Select(findExistingAccount);

        // Select the Existing Account
        existingAccount.selectByIndex(0);

        WebElement existingAccountSelectedOption = existingAccount.getFirstSelectedOption();

        // Check if the Account Type has been changed
        String actualExistingAccountResult = existingAccountSelectedOption.getText();

        // Get the Existing Account Options again
        existingAccount = new Select(findExistingAccount);

        String expectedExistingAccountResult = existingAccount.getFirstSelectedOption().getText();

        // Find the Open New Account Button and click:
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();

        By successMessage = By.xpath("//*[@id=\"openAccountResult\"]/p[1]");

        WebElement successMessageElement = driver.findElement(successMessage);

        // Wait for the loading of the Success Message
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage));

        // Check that new account able to be created
        String actualSuccessMessageResult = successMessageElement.getText();

        // Get the Checking Account Number to check Balance off, for the later test cases
        WebElement newAccountNumber = driver.findElement(By.xpath("//*[@id=\"newAccountId\"]"));

        checkingsAccountNumber = newAccountNumber.getText();


        assertAll(
                () -> assertEquals("ParaBank | Open Account", actualOpenAccountPageResult, "Could not display Open Accounts Page"),
                () -> assertEquals("CHECKING", actualAccountTypeResult, "Wrong Type of Account (Not Checking Chosen) being Opened"),
                () -> assertEquals(expectedExistingAccountResult, actualExistingAccountResult, "Wrong Existing Account being Opened"),
                () -> assertEquals("Congratulations, your account is now open.", actualSuccessMessageResult, "New Checking Account was NOT able to be opened")
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
    @SpiraTestCase(testCaseId = 17358)
    public void testCheckSavingsAccountBalance() {
        // Check the balance of the Savings Account

        boolean savingsAccountDisplayed = false;

        // Go to the Accounts Overview Page
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");

        By accountsOverviewTable = By.xpath("//*[@id='accountTable']/tbody");

        WebElement accountsOverview = driver.findElement(accountsOverviewTable);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr")));

        // Get the Rows of the Table
        List<WebElement> rows =  accountsOverview.findElements(By.xpath("tr"));




        for (WebElement row: rows) {

            // Get the Account Number Cell
            WebElement accountNumber = row.findElement(By.xpath("./td[1]"));




            // Check if the Account Number matches the New Savings Account Number gotten
            if (accountNumber.getText().equals(savingsAccountNumber)) {
                savingsAccountDisplayed = true;

                // Get the Account Balance
                WebElement accountBalance = row.findElement(By.xpath("./td[2]"));

                savingsBalance = accountBalance.getText().substring(1);



                break;
            }
        }

        assertTrue(savingsAccountDisplayed, "Savings Account created NOT displayed and therefore Savings Account cannot be found");

    }

    @Test
    @Order(2)
    @SpiraTestCase(testCaseId = 17359)
    public void testCheckCheckingAccountBalance() {
        // Check the balance of the Checking Account

        boolean checkingAccountDisplayed = false;

        // Go to the Accounts Overview Page
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");

        By accountsOverviewTable = By.xpath("//*[@id='accountTable']/tbody");

        WebElement accountsOverview = driver.findElement(accountsOverviewTable);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr")));

        // Get the Rows of the Table
        List<WebElement> rows =  accountsOverview.findElements(By.xpath("tr"));




        for (WebElement row: rows) {

            // Get the Account Number Cell
            WebElement accountNumber = row.findElement(By.xpath("./td[1]"));




            // Check if the Account Number matches the New Checking Account Number gotten
            if (accountNumber.getText().equals(checkingsAccountNumber)) {
                checkingAccountDisplayed = true;

                // Get the Account Balance
                WebElement accountBalance = row.findElement(By.xpath("./td[2]"));

                checkingsBalance = accountBalance.getText().substring(1);



                break;
            }
        }

        assertTrue(checkingAccountDisplayed, "Checking Account created NOT displayed and therefore Checking Account cannot be found");
    }

    @Test
    @Order(3)
    @SpiraTestCase(testCaseId = 17360)
    public void testTransferMoneyPageRetrieval() {
        // Checks that the Transfer Money Page has been reached
        driver.get("https://parabank.parasoft.com/parabank/transfer.htm");

        actualResult = driver.getTitle();
        expectedResult = "ParaBank | Transfer Funds";

        assertEquals(expectedResult, actualResult, "Could not display Transfer Money Page");
    }

    @Test
    @Order(4)
    @SpiraTestCase(testCaseId = 17361)
    public void testAmountToTransfer() {
        // Checks that the Amount To Transfer is able to be inputed and displayed correctly

        // Store the X Path as a variable
        By transferAmount = By.xpath("//*[@id=\"amount\"]");

        // Get the Transfer Amount Field and type in the Transfer Amount
        driver.findElement(transferAmount).sendKeys("100");

        actualResult = driver.findElement(transferAmount).getAttribute("value");
        expectedResult = "100";

        assertEquals(expectedResult, actualResult, "Wrong Transfer Amount Input");

    }

    @Test
    @Order(5)
    @SpiraTestCase(testCaseId =  17362)
    public void testSenderAccount() {
        // Check if the Sender Account has been correctly chosen

        WebElement senderAccount = driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]"));

        // Wait for Sender Account Dropdown
        wait.until(ExpectedConditions.visibilityOf(senderAccount));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id='fromAccountId']/option"), 0));

        Select accountType = new Select(senderAccount);



        // Select the Sender Savings Account
        accountType.selectByVisibleText(savingsAccountNumber);

        // Get the selected option
        WebElement selectedOption = accountType.getFirstSelectedOption();

        // Check if the Account Type has been changed
        actualResult = selectedOption.getText();
        expectedResult = savingsAccountNumber;

        assertEquals(expectedResult, actualResult, "Wrong Sender Account Chosen");
    }

    @Test
    @Order(6)
    @SpiraTestCase(testCaseId =  17363)
    public void testReceiverAccount() {
        // Check if the Receiver Account has been correctly chosen

        WebElement receiverAccount = driver.findElement(By.xpath("//*[@id=\"toAccountId\"]"));

        // Wait for Receiver Account Dropdown
        wait.until(ExpectedConditions.visibilityOf(receiverAccount));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id=\"toAccountId\"]/option"), 0));

        Select accountType = new Select(receiverAccount);

        // Select the Receiver Checking Account
        accountType.selectByVisibleText(checkingsAccountNumber);

        // Get the selected option
        WebElement selectedOption = accountType.getFirstSelectedOption();

        // Check if the Account Type has been changed
        actualResult = selectedOption.getText();
        expectedResult = checkingsAccountNumber;

        assertEquals(expectedResult, actualResult, "Wrong Checking Account Chosen");
    }

    @Test
    @Order(7)
    @SpiraTestCase(testCaseId =  17364)
    public void testSuccessTransferMessage() {
        // Check if the Transfer Page is able to display Successful Transfer Message, after successful form submission

        // Find Transfer Button and Click
        driver.findElement(By.xpath("//*[@id=\"transferForm\"]/div[2]/input")).click();

        // Check that we have moved to the Success Message Page
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"showResult\"]/h1"));

        // Wait for loading of Success Message
        wait.until(ExpectedConditions.visibilityOf(successMessage));

        actualResult = successMessage.getText();
        expectedResult = "Transfer Complete!";

        assertEquals(expectedResult, actualResult, "Success Message NOT displayed");
    }

    @Test
    @Order(8)
    @SpiraTestCase(testCaseId =  17365)
    public void testCheckSavingsBalanceAfterTransfer() {
        // Check the balance of the Savings Account after Transfer has occured

        double oldSavingsBalance = Double.parseDouble(savingsBalance);

        // Go to the Accounts Overview Page
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");

        By accountsOverviewTable = By.xpath("//*[@id='accountTable']/tbody");

        WebElement accountsOverview = driver.findElement(accountsOverviewTable);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr")));

        // Get the Rows of the Table
        List<WebElement> rows =  accountsOverview.findElements(By.xpath("tr"));



        for (WebElement row: rows) {

            // Get the Account Number Cell
            WebElement accountNumber = row.findElement(By.xpath("./td[1]"));



            // Check if the Account Number matches the New Savings Account Number gotten
            if (accountNumber.getText().equals(savingsAccountNumber)) {

                // Get the Account Balance
                WebElement accountBalance = row.findElement(By.xpath("./td[2]"));

                // Ignore first character which s "$"
                savingsBalance = accountBalance.getText().substring(1);


                break;
            }
        }

        // Check whether the new Savings Balance reflect the Calculations of the Transfer that has occured
        assertTrue((Double.parseDouble(savingsBalance) == oldSavingsBalance - 100.0), "Savings Account Balance is incorrect");
    }

    @Test
    @Order(9)
    @SpiraTestCase(testCaseId =  17366)
    public void testCheckCheckingBalanceAfterTransfer() {
        // Check the balance of the Checking Account

        double oldCheckingBalance = Double.parseDouble(checkingsBalance);

        // Go to the Accounts Overview Page
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");

        By accountsOverviewTable = By.xpath("//*[@id='accountTable']/tbody");

        WebElement accountsOverview = driver.findElement(accountsOverviewTable);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='accountTable']/tbody/tr")));

        // Get the Rows of the Table
        List<WebElement> rows =  accountsOverview.findElements(By.xpath("tr"));




        for (WebElement row: rows) {

            // Get the Account Number Cell
            WebElement accountNumber = row.findElement(By.xpath("./td[1]"));



            // Check if the Account Number matches the New Checking Account Number gotten
            if (accountNumber.getText().equals(checkingsAccountNumber)) {

                // Get the Account Balance
                WebElement accountBalance = row.findElement(By.xpath("./td[2]"));

                // Ignore First Character which is "$"
                checkingsBalance = accountBalance.getText().substring(1);


                break;
            }
        }

        // Check whether the new Checking Balance reflect the Calculations of the Transfer that has occured
        assertTrue((Double.parseDouble(checkingsBalance) == oldCheckingBalance + 100.0), "Checking Account Balance is Incorrect");
    }
}