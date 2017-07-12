package pom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by GKM on 7/10/2017.
 * POM for MyAccount page. Maintain all the objects here.
 */
//https://www.walmart.ca//my-account
public class MyAccountPage {
    private WebDriver webDriver;


    public MyAccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String GetMainContentText()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(addRecentOrder));
        return myAccountMainContent.getText();
    }


    @FindBy(id = "my-account-main-content")
    @CacheLookup
    private WebElement myAccountMainContent;


    @FindBy(id = "add-recent-order")
    private WebElement addRecentOrder;

    @FindBy(linkText = "Personal Settings")
    private WebElement personalSettings;

    public void OpenPersonalSettings()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(personalSettings));
        personalSettings.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}