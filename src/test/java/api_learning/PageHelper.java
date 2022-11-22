package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class PageHelper {

    private final static String SCROLL_TO_BOTTOM_SCRIPT = "window.scrollTo(0, document.body.scrollHeight)";
    private final static String SCROLL_TO_TOP_SCRIPT = "window.scrollTo(document.body.scrollHeight, 0)";

    private JavascriptExecutor javascriptExecutor;

    public PageHelper(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public void scrollToBottom() {
        javascriptExecutor.executeScript(SCROLL_TO_BOTTOM_SCRIPT);
    }

    public void scrollToTop() {
        javascriptExecutor.executeScript(SCROLL_TO_TOP_SCRIPT);
    }

    public void removeElement(WebElement toBeRemovedElem) {
        javascriptExecutor.executeScript("arguments[0].remove()", toBeRemovedElem);
    }

    public void changeElemStyleToFocusMode(WebElement toBeChangedElem) {
        javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px solid red;')", toBeChangedElem);
    }

    public void changeElemStyleToFocusMode(WebElement toBeChangedElem, String customStyle) {
    }
}
