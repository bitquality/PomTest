package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by GKM on 7/10/2017.
 * POM for Sign page.//https://www.walmart.ca//my-account Maintain all the objects here.
 */

public class WalmartSignInPage {
    private WebDriver webDriver;


    public WalmartSignInPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }



    @FindBy(name = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "account-signin-btn")
    @CacheLookup
    private WebElement signInBtn;

    public void SignIn(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.signInBtn.click();

    }

    public void Launch(String url)
    {
        this.webDriver.get(url);
    }


    public String getTitle() {
        return webDriver.getTitle();
    }
}