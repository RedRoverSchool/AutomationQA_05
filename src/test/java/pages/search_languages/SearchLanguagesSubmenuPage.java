package pages.search_languages;

import TestData.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base_abstract.TablePage;
import pages.start.StartPage;

import java.util.List;

public abstract class SearchLanguagesSubmenuPage extends TablePage<SearchLanguagesPage> {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='./search.html']")
    private WebElement searchSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href]")
    private List<WebElement> submanus;

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

        return submanus;
    }

    public String getTextSearchLanguagesSubmenu(int index) {

        return submanus.get(index).getText();
    }

}
