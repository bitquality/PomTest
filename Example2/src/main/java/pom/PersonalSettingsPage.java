package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by GKM on 7/11/2017.
 * POM for PersonalSettings page. Maintain all the objects here.
 */
public class PersonalSettingsPage {
    private WebDriver webDriver;


    public PersonalSettingsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String GetMainContentText()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.textToBePresentInElement(myAccountMainContent,"Personal Settings"));
        return myAccountMainContent.getText();
    }

    //my-account-main-content
    @FindBy(id = "my-account-main-content")

    private WebElement myAccountMainContent;


    @FindBy(id = "set-edit-info")
    private WebElement editPersonalInfo;

    @FindBy(linkText = "Addresses")
    private WebElement addresses;

    public void OpenAddresses()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(addresses));
        addresses.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
