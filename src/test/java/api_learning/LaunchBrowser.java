package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) {
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
        driver.get("https://learn.sdetpro.com");

        //DEBUG PURPOSE ONLY
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {}
        driver.quit();
    }
}
