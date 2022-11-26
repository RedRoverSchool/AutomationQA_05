package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@id = 'menu']/li/a[@href = '/search.html']")
    private WebElement searchLanguagesMenu;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchLanguagesMenu() {
        click(searchLanguagesMenu);

        return new SearchLanguagesPage(getDriver());
    }
}
