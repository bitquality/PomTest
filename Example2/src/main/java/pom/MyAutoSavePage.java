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
 * POM for MyAutoSave page. Maintain all the objects here.
 */
public class MyAutoSavePage {
    private WebDriver webDriver;


    public MyAutoSavePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String GetMainContentText()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.urlContains("subscriptions"));
        return myAccountMainContent.getText();
    }

    //my-account-main-content
    @FindBy(id = "my-account-content")
    private WebElement myAccountMainContent;


    @FindBy(id = "og-msi")
    private WebElement myAutoSaveContent;

    @FindBy(linkText = "Credit Cards")
    private WebElement creditCards;

    public void openCreditCards()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(creditCards));
        creditCards.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
