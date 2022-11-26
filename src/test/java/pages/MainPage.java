package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@id = 'menu']/li/a[@href = '/search.html']")
    private WebElement searchLanguagesMenu;

    private final By SEARCH_LANGUAGES_MENU =  By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    protected By getSearchLanguagesMenu() {

        return SEARCH_LANGUAGES_MENU;
    }

    public void clickSearchLanguagesMenu() {
        click(getSearchLanguagesMenu());
    }

    public SearchLanguagesPage clickSearchLanguagesMenuPOM2() {
        click(getSearchLanguagesMenu());

        return new SearchLanguagesPage(getDriver());
    }

    ////
    public SearchLanguagesPage clickSearchLanguagesMenuPOM3() {
        click(searchLanguagesMenu);

        return new SearchLanguagesPage(getDriver());
    }
}
