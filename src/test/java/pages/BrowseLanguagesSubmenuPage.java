package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = "//ul[@id='submenu']//a[@href='p.html']")
    private WebElement letterP;

    @FindBy(xpath = "//ul[@id='submenu']//a[@href='j.html']")
    private WebElement letterJ;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }

    public PPage clickPSubmenu() {
        click(letterP);

        return new PPage(getDriver());
    }

    public JPage clickJSubmenu() {
        click(letterJ);

        return new JPage(getDriver());
    }
}
