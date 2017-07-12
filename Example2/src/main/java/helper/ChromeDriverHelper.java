package helper;

import interfaces.IDriverHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

/**
 * Created by GKM on 7/10/2017.
 * Creates ChromeDriverInstance for consumption by factory using Dependency Injection.
 */
public class ChromeDriverHelper extends IDriverHelper{

    private ChromeDriverService chromeDriverServiceService;

    protected void startService() {
        if(null==chromeDriverServiceService){
            try{

                chromeDriverServiceService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("user.dir") + "\\target\\classes\\executables\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                chromeDriverServiceService.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    protected void stopService() {
        if(null!=chromeDriverServiceService && chromeDriverServiceService.isRunning())
            chromeDriverServiceService.stop();
    }

    protected void createDriver() {
        Capabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");

        driver = new RemoteWebDriver(chromeDriverServiceService.getUrl(),capabilities);
    }
}
