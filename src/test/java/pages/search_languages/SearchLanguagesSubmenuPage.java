package pages.search_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;

import java.util.List;

public abstract class SearchLanguagesSubmenuPage extends TablePage<SearchLanguagesPage> {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='./search.html']")
    private WebElement searchSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href]")
    private List<WebElement> submenus;

    public SearchLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected SearchLanguagesPage createPage() {

        return new SearchLanguagesPage(getDriver());
    }

    public SearchLanguagesPage clickSearchSubmenu() {
        click(searchSubmenu);

        return new SearchLanguagesPage(getDriver());
    }

    public List<WebElement> getSearchLanguagesSubmenu() {

        return submenus;
    }

    public String getTextSearchLanguagesSubmenu(int index) {

        return getTextByIndex(index, submenus);
    }
}
