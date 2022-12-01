package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {
    @FindBy(xpath = "//a[@href='b.html']")
    private WebElement bSubmenu;
    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public BPage clickBSubmenu() {
        click(bSubmenu);

        return new BPage(getDriver());
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }
}
