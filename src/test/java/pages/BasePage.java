package pages;

import org.openqa.selenium.By;
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

    private WebElement getElement(By by) {

        return getDriver().findElement(by);
    }

    public void click(By by) {
        getElement(by).click();
    }

    public void input(String text, By by) {
        getElement(by).sendKeys(text);
    }

    private List<WebElement> getElements(By by) {

        return getDriver().findElements(by);
    }

    public int getListSize(By by) {

        return getElements(by).size();
    }

    public List<String> getListText(By by) {
        if (getListSize(by) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : getElements(by)) {
                textList.add(element.getText());
            }

            return textList;
        }

        return null;
    }

    public List<String> getListTextInLowerCase(By by) {
        if (getListSize(by) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : getElements(by)) {
                textList.add(element.getText().toLowerCase());
            }

            return textList;
        }

        return null;
    }


    ///POM3
    public void click(WebElement element) {
        element.click();
    }

    public void input(String text, WebElement element) {
        element.sendKeys(text);
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


}
