package pages.search_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLanguagesPage extends SearchLanguagesSubmenuPage {

    @FindBy(name = "search")
    private WebElement searchForField;

    @FindBy(name = "submitsearch")
    private WebElement goButton;

    @FindBy(id = "searchlanguages")
    private WebElement searchForm;

    @FindBy(xpath = "//form//input[1]")
    private WebElement input1SearchForm;

    @FindBy(xpath = "//form//input[2]")
    private WebElement input2SearchForm;

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
}
