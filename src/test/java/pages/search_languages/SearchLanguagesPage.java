package pages.search_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLanguagesPage extends SearchLanguagesSubmenuPage {

    @FindBy(name = "search")
    private WebElement searchForField;

    @FindBy(name = "submitsearch")
    private WebElement goButton;

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
}
