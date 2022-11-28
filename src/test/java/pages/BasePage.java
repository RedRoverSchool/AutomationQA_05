package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {

        return driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void input(String text, WebElement element) {
        element.sendKeys(text);
    }

    public int getListSize(List<WebElement> list) {

        return list.size();
    }

    public List<String> getListText(List<WebElement> list) {
        if (getListSize(list) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : list) {
                textList.add(element.getText());
            }

            return textList;
        }

        return null;
    }

    public List<String> getListTextInLowerCase(List<WebElement> list) {
        if (list.size() > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : list) {
                textList.add(element.getText().toLowerCase());
            }

            return textList;
        }

        return null;
    }

    public String getText(WebElement element) {

        return element.getText();
    }

    public String getAttribute(WebElement element, String attribute) {

        return element.getAttribute(attribute);
    }
}
