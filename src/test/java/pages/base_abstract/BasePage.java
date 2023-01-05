package pages.base_abstract;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

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

    public void clear(WebElement element) {
        if (!getText(element).isEmpty()) {
            clear(element);
        }
    }

    public void input(String text, WebElement element) {
        element.sendKeys(text);
    }

    public String getText(WebElement element) {

        return element.getText();
    }

    public String getAttribute(WebElement element, String attribute) {

        return element.getAttribute(attribute);
    }

    public String getTextByIndex(int index, List<WebElement> elements) {

        return elements.get(index).getText();
    }

    public String getAttributeByIndex(int index, List<WebElement> elements, String attribute) {

        return elements.get(index).getAttribute(attribute);
    }

    public int getListSize(List<WebElement> list) {

        return list.size();
    }

    public List<String> getListText(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if (getListSize(list) > 0) {

            for (WebElement element : list) {
                textList.add(element.getText());
            }
        }

        return textList;
    }

    public List<String> getListTextInLowerCase(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if (getListSize(list) > 0) {

            for (WebElement element : list) {
                textList.add(element.getText().toLowerCase());
            }
        }

        return textList;
    }

    public List<String> getListTextInUpperCase(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if (getListSize(list) > 0) {

            for (WebElement element : list) {
                textList.add(element.getText().toUpperCase());
            }
        }

        return textList;
    }

    public List<WebElement> getListIfVisible(List<WebElement> list) {
        List<WebElement> visibleList = new ArrayList<>();

        if (list.size() > 0) {
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    visibleList.add(element);
                }
            }
        }

        if (list.size() != visibleList.size()) {

            return new ArrayList<>();
        }

        return visibleList;
    }

    public int[] getIntegersFromTexts(List<String> list) {
        int[] numbers;

        if (list.size() > 0) {
            numbers = new int[list.size()];

            for (int i = 0; i < numbers.length; i++) {
                try {
                    numbers[i] = Integer.parseInt(list.get(i));
                } catch (Exception e) {
                    Reporter.log("String is not parsable");
                }
            }

            return numbers;
        }

        return new int[0];
    }

    public boolean isImageDisplayed(WebElement image) {
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) getDriver())
                    .executeScript(
                            "return (typeof arguments[0].naturalWidth !=\"undefined\" " +
                                    "&& arguments[0].naturalWidth > 0);", image
                    );
            if (imageDisplayed) {

                return true;
            } else {
                Reporter.log(image + "image is broken ", true);
            }
        } catch (Exception e) {
            System.out.println("Image not loading");
        }

        return false;
    }

    protected void scrollByVisibleElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getURL() {

        return getDriver().getCurrentUrl();
    }

    public String getTitle() {

        return getDriver().getTitle();
    }
}
