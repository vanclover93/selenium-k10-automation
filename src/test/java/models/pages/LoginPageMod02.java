package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMod02 {

    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static By loginBtnSel = By.cssSelector("button[type='submit']");

    public LoginPageMod02(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsernameElem(String username){
        driver.findElement(usernameSel).sendKeys(username);
    }

    public void inputPasswordElem(String password){
        driver.findElement(passwordSel).sendKeys(password);
    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtnSel).click();
    }
}
