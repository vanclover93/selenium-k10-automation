package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
import url.Urls;

public class JsExecutor implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to the target page
            driver.get(HEROKU_BASE_URL.concat(FLOATING_MENUS_SLUG));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            PageHelper pageHelper = new PageHelper(jsExecutor);

            //Scroll to bottom
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            //Debug purpose only
            Thread.sleep(2000);

            //Scroll to top
            jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

            //Debug purpose only
            Thread.sleep(2000);

            //Go to dynamic control page
            driver.get(HEROKU_BASE_URL.concat(DYNAMIC_CONTROL_SLUG));
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");
            WebElement checkboxFornElem = driver.findElement(checkboxFormSel);
            WebElement inputFormElem = driver.findElement(inputFormSel);
            pageHelper.removeElement(inputFormElem);
            pageHelper.changeElemStyleToFocusMode(checkboxFornElem);

            //Debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
