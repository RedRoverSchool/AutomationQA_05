package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = "//a[@href ='b.html']")
    private WebElement BSubmenu;

    @FindBy(xpath = "//a[@href='c.html']")
    private WebElement cSubmenu;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }

    public BPage clickBSubmenu() {
        click(BSubmenu);

        return new BPage(getDriver());
    }

    public CPage clickCSubmenu() {
        click(cSubmenu);

        return new CPage(getDriver());
    }
}
