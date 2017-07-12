package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by s1196522 on 7/11/2017.
 * POM for Address page. Maintain all the objects here.
 */
public class AddressesPage {
    private WebDriver webDriver;


    public AddressesPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String GetMainContentText()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.textToBePresentInElement(myAccountMainContent,"Address"));
        return myAccountMainContent.getText();

    }


    @FindBy(id = "my-account-main-content")
    private WebElement myAccountMainContent;


    @FindBy(id = "addresses-form")
    private WebElement addressForm;

    @FindBy(xpath = "(//a[contains(text(),'My AutoSave')])[3]")
    private WebElement myAutoSave;

    public void OpenAutoSave()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(myAutoSave));
        myAutoSave.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
