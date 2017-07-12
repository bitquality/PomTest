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
 * POM for CreditCards page. Maintain all the objects here.
 */
public class CreditCardsPage {
    private WebDriver webDriver;


    public CreditCardsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String GetMainContentText()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.urlContains("credit-cards"));
        return myAccountMainContent.getText();
    }


    @FindBy(id = "my-account-content")
    private WebElement myAccountMainContent;


    @FindBy(linkText = "Order History")
    private WebElement orderHistory;

    public void OpenOrderHistory()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(orderHistory));
        orderHistory.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
