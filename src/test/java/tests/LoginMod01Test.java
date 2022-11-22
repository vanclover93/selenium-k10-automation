package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class LoginMod01Test implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            // Input login creds
            LoginPageMod01 loginPage = new LoginPageMod01(driver);
            loginPage.usernameElem().sendKeys("Teo");
            loginPage.passwordElem().sendKeys("12345678");
            loginPage.loginBtnElem().click();

            // Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
