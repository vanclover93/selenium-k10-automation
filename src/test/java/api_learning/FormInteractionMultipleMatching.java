package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormInteractionMultipleMatching {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector values
             // Interact with first field in List
            By inputFieldsSel = By.tagName("input");
            WebElement usernameElem = driver.findElement(inputFieldsSel);
             // Interact with fields in list
            List<WebElement> inputFieldsElem = driver.findElements(inputFieldsSel);
            if(inputFieldsElem.isEmpty()){
                throw new RuntimeException("[ERROR] There is no input fields");
            }
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 0;
            inputFieldsElem.get(USERNAME_INDEX).sendKeys("teo");
            inputFieldsElem.get(PASSWORD_INDEX).sendKeys("12345678");

             //Note: Neu selector sai hoac tim khong ra thi findElement se ra loi = No such Element
            // con findElements thi k ra loi ma chi tra ve list rong
            // =>  truoc khi tuong tac can check ki bang doan if

            // Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

