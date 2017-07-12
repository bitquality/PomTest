import enums.BrowserType;
import helper.ChromeDriverHelper;
import helper.DriverHelperFactory;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import pom.*;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by GKM on 7/10/2017.
 */



public class Question2 {

    private static WebDriver webDriver;

    static WalmartSignInPage walmartSignInPage;
    static MyAccountPage myAccountPage;
    static PersonalSettingsPage personalSettingsPage;
    static AddressesPage addressesPage;
    static MyAutoSavePage myAutoSavePage;
    static CreditCardsPage creditCardsPage;
    static OrderHistoryPage orderHistoryPage;

    @BeforeClass
    public static void InitializeDriver() {
       webDriver = DriverHelperFactory.getDriverHelper(BrowserType.CHROME);
       walmartSignInPage = new WalmartSignInPage(webDriver);
       myAccountPage = new MyAccountPage(webDriver);
        personalSettingsPage = new PersonalSettingsPage(webDriver);
        addressesPage = new AddressesPage(webDriver);
        myAutoSavePage = new MyAutoSavePage(webDriver);
        creditCardsPage = new CreditCardsPage(webDriver);
        orderHistoryPage = new OrderHistoryPage(webDriver);

    }

    @Test(priority=1)
    public void LaunchWalmartMyAccountPage() {
        walmartSignInPage.Launch("https://www.walmart.ca/my-account");

    }

    @Test(priority=2)
    public void Login() {
        walmartSignInPage.SignIn("testuser0710@outlook.com","Tu123456");

    }

    @Test(priority=3)
    public void VerifyMyAccountPage() {

        Assert.assertTrue(myAccountPage.GetMainContentText().contains("My Account"));
    }

    @Test(priority=4)
    public void OpenPersonalSettings() {

        myAccountPage.OpenPersonalSettings();
    }
    @Test(priority=5)
    public void VerifyPersonalSettingsPage() {

        Assert.assertTrue(personalSettingsPage.GetMainContentText().contains("Personal Settings"));
    }

    @Test(priority=6)
    public void OpenAddressesPage() {
        personalSettingsPage.OpenAddresses();
    }

    @Test(priority=7)
    public void VerifyAddressPage() {
        System.out.println(addressesPage.GetMainContentText());
        Assert.assertTrue(addressesPage.GetMainContentText().contains("Address"));
    }

    @Test(priority=8)
    public void OpenAutoSavePage() {
        addressesPage.OpenAutoSave();
    }

    @Test(priority=9)
    public void VerifyMyAutoSavePage() {
        Assert.assertTrue(myAutoSavePage.GetMainContentText().contains("My AutoSave"));
    }

    @Test(priority=10)
    public void OpenCreditCardsPage() {
        myAutoSavePage.openCreditCards();
    }

    @Test(priority=11)
    public void VerifyCreditCardsPage() {
        Assert.assertTrue(creditCardsPage.GetMainContentText().toLowerCase().contains("credit cards"));
    }

    @Test(priority=12)
    public void OpenOrderHistoryPage() {
        creditCardsPage.OpenOrderHistory();
    }

    @Test(priority=13)
    public void VerifyOrderHistoryPage() {
        Assert.assertTrue(orderHistoryPage.GetMainContentText().contains("Order History"));
    }


    @AfterMethod
    public void SyncPage()
    {
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public  static void Cleanup() {
       webDriver.quit();
    }

}
