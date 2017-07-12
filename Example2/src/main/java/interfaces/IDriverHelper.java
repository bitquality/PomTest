package interfaces;

import org.openqa.selenium.WebDriver;

/**
 * Created by GKM on 7/10/2017.
 * Interface to define the contract of the framework
 */
public abstract class IDriverHelper {
    protected static WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver(){
        if(null!=driver){
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getDriver(){
        if(null==driver){
            startService();
            createDriver();
        }
        return driver;
    }
}
