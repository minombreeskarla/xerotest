package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    WebDriver driver;
    public HeaderPage(WebDriver driver) {
        this.driver=driver;
    }

    By menuAccounting= By.xpath("//button[@name='navigation-menu/accounting']");
    By submenuBankAccounts = By.xpath("//a[contains(text(),'Bank accounts')]");
    By avatar = By.cssSelector("button.xrh-button > div > abbr");
    By logout = By.partialLinkText("Log out");


    public WebElement menuAccounting(){
        return driver.findElement(menuAccounting);
    }

    public WebElement submenuBankAccounts(){
        return driver.findElement(submenuBankAccounts);
    }

    public WebElement avatar(){
        return driver.findElement(avatar);
    }

    public WebElement logout(){
        return driver.findElement(logout);
    }

}
