package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }
}
