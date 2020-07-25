package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage {
    WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver=driver;
    }

    By txtSearchBank= By.id("xui-searchfield-1018-inputEl");
    By selectBank = By.cssSelector("li.ba-banklist--item");
    By txtAccountName = By.xpath("//input[@placeholder='e.g Business Account']");
    By selectAccountType = By.xpath("//input[@placeholder='Please select one']");
    By comboAccountTypes = By.cssSelector("li.ba-combo-list-item");

    By txtAccountNumber = By.cssSelector("div[id^='accountDetailGeneric']  >* input[id^='accountnumber-'][name$='-inputEl']");
    By txtCCAccountNumber = By.cssSelector("input[id^='accountnumber-'][name$='-inputEl'][placeholder='1234']");
    By btnContinueButton = By.cssSelector("a[data-automationid='continueButton']");

    By btnAddAnotherAccount = By.partialLinkText("+ Add another ANZ (NZ) account");

    public List<WebElement> listOfBanks() {
        return driver.findElements(By.cssSelector("li.ba-banklist--item"));
    }

    // check if search result contains the specific bank name
    public WebElement getBank(String bankName) {
        for (WebElement searchSpecificBank : listOfBanks()) {
            if (searchSpecificBank.getText().contains(bankName)) {
                return searchSpecificBank;
            }
        }
        return null;
    }

    public List<WebElement> listOfAccountName() {
        return driver.findElements(txtAccountName);
    }

    public List<WebElement> listOfAccounts() {
        return driver.findElements(selectAccountType);
    }

    // check if search result contains the specific account name
    public WebElement getAccountName(String accountName) {
        for (WebElement selectSpecificAccountname : listOfAccountName()) {
            if (selectSpecificAccountname.getText().contains(accountName)) {
                return selectSpecificAccountname;
            }
        }
        return null;
    }

    public List<WebElement> listOfAccountTypes() {
        return driver.findElements(comboAccountTypes);
    }

    // check if search result contains the specific accountType
    public WebElement getAccountType(String accountType) {
        for (WebElement selectSpecificAccountType : listOfAccountTypes()) {
            if (selectSpecificAccountType.getText().contains(accountType)) {
                return selectSpecificAccountType;
            }
        }
        return null;
    }

    public List<WebElement> listOfAccountNumbers() { return driver.findElements(txtAccountNumber); }

    public List<WebElement> selectAccountType() { return driver.findElements(comboAccountTypes); }

    public WebElement searchBank(){ return driver.findElement(txtSearchBank); }

    public WebElement selectBank(){ return driver.findElement(selectBank); }

    public WebElement accountName() { return driver.findElement(txtAccountName); }

    public WebElement accountType() { return driver.findElement(selectAccountType); }

    public WebElement accountNumber() { return driver.findElement(txtAccountNumber); }

    public WebElement txtCCAccountNumber(){ return driver.findElement(txtCCAccountNumber); }

    public WebElement continueButton() { return driver.findElement(btnContinueButton); }

    public WebElement addAnotherAccount() { return driver.findElement(btnAddAnotherAccount); }

}
