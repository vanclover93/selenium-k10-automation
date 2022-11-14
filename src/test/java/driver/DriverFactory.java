package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation;

        if (OS.isFamilyMac()) {
            chromeDriverLocation = "/src/test/resources/drivers/chromedriver";
        } else if (OS.isFamilyWindows()) {
            chromeDriverLocation = "\\src\\test\\resources\\drivers\\chromedriver";
        } else {
            throw new RuntimeException("[ERR] Couldn't detect th OS");
        }
        String chromeAbsoluteLocation = currentProjectLocation.concat(chromeDriverLocation);
        System.setProperty("webdriver.chrome.driver", chromeAbsoluteLocation);
        System.out.println(chromeDriverLocation);
        //Set up Chrome Optiopns | Optional
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));

        return driver;
    }

}
