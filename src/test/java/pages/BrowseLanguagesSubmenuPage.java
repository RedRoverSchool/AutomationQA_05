package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = "//div[@id='navigation']/ul/li/a[@href='n.html']")
    private WebElement nSubmenu;

    @FindBy(xpath = "//a[@href='c.html']")
    private WebElement cSubmenu;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }

    public NPage clickNSubmenu() {
        click(nSubmenu);

        return new NPage(getDriver());
    }

    public String getNSubmenuLinkText() {

        return getText(nSubmenu);
    }

    public CPage clickCSubmenu() {
        click(cSubmenu);

        return new CPage(getDriver());
    }
}
