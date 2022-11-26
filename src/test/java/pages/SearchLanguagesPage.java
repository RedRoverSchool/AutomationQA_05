package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLanguagesPage extends SearchLanguagesSubmenuPage {
    @FindBy(name = "search")
    private WebElement searchForField;

    @FindBy(name = "submitsearch")
    private WebElement goButton;

    private final By SEARCH_FOR_FIELD = By.name("search");
    private final By GO_BUTTON = By.name("submitsearch");

    public SearchLanguagesPage(WebDriver driver) {
        super(driver);
    }

    protected By getSearchForField() {

        return SEARCH_FOR_FIELD;
    }

    protected By getGoButton() {

        return GO_BUTTON;
    }

    public void clickSearchForField() {
        click(getSearchForField());
    }

    public void inputSearchCriteria(String text) {
        input(text, getSearchForField());
    }

    public void clickGoButton() {
        click(getGoButton());
    }

    public SearchLanguagesPage clickSearchForFieldPOM2() {
        click(getSearchForField());

        return this;
    }

    public SearchLanguagesPage inputSearchCriteriaPOM2(String text) {
        input(text, getSearchForField());

        return this;
    }

    public SearchLanguagesPage clickGoButtonPOM2() {
        click(getGoButton());

        return this;
    }

    ////
    public SearchLanguagesPage clickSearchForFieldPOM3() {
        click(searchForField);

        return this;
    }

    public SearchLanguagesPage inputSearchCriteriaPOM3(String text) {
        input(text, searchForField);

        return this;
    }

    public SearchLanguagesPage clickGoButtonPOM3() {
        click(goButton);

        return this;
    }
}
