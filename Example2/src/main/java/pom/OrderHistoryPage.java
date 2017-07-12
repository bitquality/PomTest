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
 * POM for OrderHistory page. Maintain all the objects here.
 */
public class OrderHistoryPage {
    private WebDriver webDriver;


    public OrderHistoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String GetMainContentText()
    {
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.urlContains("order-history"));
        return myAccountMainContent.getText();
    }

    //my-account-main-content
    @FindBy(id = "my-account-main-content")
    private WebElement myAccountMainContent;


    @FindBy(id = "order-details-container")
    private WebElement orderSection;



    public String getTitle() {
        return webDriver.getTitle();
    }
}
