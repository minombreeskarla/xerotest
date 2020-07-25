import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utilities.Utilities.createRandomNumber;
import static utilities.Utilities.createRandomString;

public class AddBankAccount {
    public WebDriver driver;
    Properties prop;
    ArrayList<String> accounts;

    @BeforeClass
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        prop=new Properties();
        FileInputStream fis =new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
        prop.load(fis);
        prop.load(fis);
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod
    public void Login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.txtEmail().sendKeys(prop.getProperty("email"));
        loginPage.txtPassword().sendKeys(prop.getProperty("password"));
        loginPage.btnSignin().click();
        Thread.sleep(5000);
    }

    //Given I login as a user from Demo Company
    //When I add a single ANZ Bank Account with CC as account type
    //Then I verify that the bank account is added successfully
    @Test
    public void addSingleANZBankAccount() throws InterruptedException {

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.menuAccounting().click();
        headerPage.submenuBankAccounts().click();

        BankAccountsPage bankAccountPage = new BankAccountsPage(driver);
        bankAccountPage.addBankAccount().click();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.searchBank().sendKeys("ANZ");
        Thread.sleep(1000);
        accountPage.getBank("ANZ (NZ)").click();

        accountPage.accountName().sendKeys("Company " + createRandomString(3));
        String accountname =  accountPage.accountName().getAttribute("value");
        accountPage.accountType().click();
        accountPage.getAccountType("Credit Card").click();
        accountPage.txtCCAccountNumber().sendKeys(createRandomNumber(4));
        accountPage.continueButton().click();

        //Verify that the bank account is added successfully
        Thread.sleep(3000);
        BankAccountsPage bankAccountsPage = new BankAccountsPage(driver);
        Assert.assertTrue(bankAccountsPage.getBankAccountMessage().getText().contains(accountname + " has been added."));
        Assert.assertTrue(bankAccountsPage.getAddedAccount(accountname).getText().contains(accountname));
    }

    //Given I login as a user from Demo Company
    //When I add multiple ANZ Bank Accounts with different account types
    //Then I verify that each bank account is added successfully
    @Test
    public void addMultipleANZBankAccounts() throws InterruptedException {
        accounts = new ArrayList<>();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.menuAccounting().click();
        headerPage.submenuBankAccounts().click();

        BankAccountsPage bankAccountPage = new BankAccountsPage(driver);
        bankAccountPage.addBankAccount().click();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.searchBank().sendKeys("ANZ");
        Thread.sleep(1000);
        accountPage.getBank("ANZ (NZ)").click();

        for(int i=0; i<=3; i++) {
            accountPage.listOfAccountName().get(i).sendKeys("Company " + createRandomString(3));
            accounts.add(accountPage.listOfAccountName().get(i).getAttribute("value"));
            accountPage.listOfAccounts().get(i).click();
            if(i == 0)
            accountPage.getAccountType("Everyday (day-to-day)").click();
            else if(i == 1)
            accountPage.getAccountType("Other").click();
            else if(i == 2)
            accountPage.getAccountType("Loan").click();
            else if(i == 3)
            accountPage.getAccountType("Term Deposit").click();

            accountPage.listOfAccountNumbers().get(i).sendKeys("1234567890" + createRandomNumber(3));

            if(i != 3)
            accountPage.addAnotherAccount().click();
        }

        accountPage.continueButton().click();

        //Verify that each bank account is added successfully
        BankAccountsPage bankAccountsPage = new BankAccountsPage(driver);
        Thread.sleep(3000);
        for (String eachAccount : accounts) {
            Assert.assertTrue(bankAccountsPage.getAddedAccount(eachAccount).getText().contains(eachAccount));
        }
    }

    @AfterMethod
    public void Logout() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.avatar().click();
        headerPage.logout().click();
    }

    public void tearDown(){
        driver.quit();
    }
}
