package pages.search_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.browse_languages.letters.ABCPage;
import pages.start.StartPage;

public abstract class SearchLanguagesSubmenuPage extends TablePage<SearchLanguagesPage> {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='./search.html']")
    private WebElement searchSubmenu;

    public SearchLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchSubmenu() {
        click(searchSubmenu);

        return new SearchLanguagesPage(getDriver());
    }

    protected SearchLanguagesPage createGeneric() {

        return new SearchLanguagesPage(getDriver());
    }
}
