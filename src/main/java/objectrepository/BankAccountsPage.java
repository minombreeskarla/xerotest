package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BankAccountsPage {
    WebDriver driver;
    public BankAccountsPage(WebDriver driver) {
        this.driver=driver;
    }

    By linkAddBankAccount= By.partialLinkText("Add Bank Account");
    By bankAccountMessage = By.cssSelector("div.message > p");
    By bankName = By.cssSelector("a.bank-name");

    public List<WebElement> listOfBankNames() {
        return driver.findElements(bankName);
    }

    public WebElement getAddedAccount(String addedAccount) {
        for (WebElement selectSpecificAddedAccount : listOfBankNames()) {
            if (selectSpecificAddedAccount.getText().contains(addedAccount)) {
                return selectSpecificAddedAccount;
            }
        }
        return null;
    }

    public WebElement addBankAccount(){ return driver.findElement(linkAddBankAccount); }

    public WebElement getBankAccountMessage(){ return driver.findElement(bankAccountMessage); }
}
