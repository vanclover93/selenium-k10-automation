package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import javax.swing.*;
import java.util.List;

public class MouseHover {

    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to the hover page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.HOVERS_SLUG));

            //Locate all image elems
            List<WebElement> figuresElem = driver.findElements(figureSel);
            if (figuresElem.isEmpty()){
                throw new RuntimeException("[ERR] There is no figure to test!");
            }

            //Mouse hover and locate the username and profile links
            Actions actions = new Actions(driver);
            for (WebElement figureElem :figuresElem){
                WebElement profileNameElem = figureElem.findElement(profileNameSel);
                WebElement profileLinkElem = figureElem.findElement(profileLinkSel);

                //Before mouse hover
                System.out.println((profileNameElem.getText() + ": " + profileLinkElem.isDisplayed()));

                //Mouse hover
                actions.moveToElement(figureElem).perform();

                System.out.println("========AFTER mouse hover=======");
                //After mouse hover
                System.out.println((profileNameElem.getText() + ": " + profileLinkElem.isDisplayed()));

                //Debug purpose only
                Thread.sleep(2000);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
