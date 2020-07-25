package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    By txtEmail= By.id("email");
    By txtPassword= By.id("password");
    By btnSignin= By.id("submitButton");


    public WebElement txtEmail() { return driver.findElement(txtEmail); }

    public WebElement txtPassword() { return driver.findElement(txtPassword); }

    public WebElement btnSignin() { return driver.findElement(btnSignin); }
}
