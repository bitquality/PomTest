package helper;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.sql.DriverManager;

/**
 *  Created by GKM on 7/10/2017.
 *  Factory which implements DI and returns the driver object.
GKM */
public class DriverHelperFactory {

    public static WebDriver getDriverHelper(BrowserType type){

        WebDriver driver =null;

        switch(type){
            case CHROME:
                driver = new ChromeDriverHelper().getDriver();
                break;
            case FIREFOX:
               // driver = new FirefoxDriverHelper().getDriver();
                break;
            default:
                //driver = new InternetExplorerHelper().getDriver();
                break;
        }
        return driver;

    }
}