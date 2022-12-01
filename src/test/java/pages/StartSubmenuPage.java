package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class StartSubmenuPage extends MainPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='team.html']")
    private WebElement teamSubmenu;

    @FindBy(xpath="//ul[@id = 'submenu']/li/a[@href = 'impressum.html']")
    private WebElement privacySubmenu;

    public StartSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public TeamPage clickTeamSubmenu() {
        click(teamSubmenu);

        return new TeamPage(getDriver());
    }

    public ImpressumPage clickPrivacySubmenu() {
        click(privacySubmenu);

        return new ImpressumPage(getDriver());
    }
}
