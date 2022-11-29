package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEx;
import url.Urls;

public class DropDown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            //Navigate to the dropdown page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.DROPDOWN_SLUG));

            //Locate the select tag / Dropdown
            WebElement dropdownElem = driver.findElement(By.cssSelector("#dropdown"));
             //C1: Select select = new Select(dropdownElem);
             //C2:
            SelectEx select = new SelectEx(dropdownElem);

            //Select by visible text
             // C1:
             //select.selectByVisibleText("Option 1");
             // C2:
            select.selectOption01();
            Thread.sleep(1000);

            //Select by index
            select.selectByIndex(2);
            Thread.sleep(2000);

            //Select by value
            select.selectByValue("1");

            //Debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
