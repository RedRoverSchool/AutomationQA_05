package pages.search_languages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class SearchLanguagesPage extends SearchLanguagesSubmenuPage {

    @FindBy(name = "search")
    private WebElement searchForField;

    @FindBy(name = "submitsearch")
    private WebElement goButton;

    @FindBy(xpath = "//ul[@id = 'submenu']/li/a[@href = './search.html']")
    private WebElement searchSubmenu;

    @FindBy(xpath = "//form")
    private WebElement searchForm;

    @FindBy(xpath = "//form//input[1]")
    private WebElement input1SearchForm;

    @FindBy(xpath = "//form//input[2]")
    private WebElement input2SearchForm;

    @FindBy(id = "main")
    private WebElement mainBody;

    @FindBy(tagName = "a")
    private List<WebElement> links;

    @FindBy(tagName = "img")
    private List<WebElement> images;


    public SearchLanguagesPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchForField() {
        click(searchForField);

        return this;
    }

    public SearchLanguagesPage inputSearchCriteria(String text) {
        input(text, searchForField);

        return this;
    }

    public SearchLanguagesPage clickGoButton() {
        click(goButton);

        return this;
    }

    public SearchLanguagesPage clearSearchForField() {
        clear(searchForField);

        return this;
    }

    public SearchLanguagesPage clickSearchSubmenu() {
        click(searchSubmenu);

        return this;
    }

    public String getAction() {
        return getAttribute(searchForm, "action");
    }

    public String getMethod() {
        return getAttribute(searchForm, "method");
    }

    public String getInput1Value() {
        return getAttribute(input1SearchForm, "value");
    }

    public String getInput2Value() {
        return getAttribute(input2SearchForm, "value");
    }

    public String getInput1Name() {
        return getAttribute(input1SearchForm, "name");
    }

    public String getInput2Name() {
        return getAttribute(input2SearchForm, "name");
    }

    public String getPageContext() {

        return mainBody.getText();
    }

    public List<WebElement> getLinks() {

        return links;
    }

    public List<WebElement> getImages() {

        return images;
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
}
