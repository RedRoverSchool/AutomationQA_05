package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class StartSubmenuPage extends MainPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='team.html']")
    private WebElement teamSubmenu;

    @FindBy(xpath="//ul[@id = 'submenu']/li/a[@href = 'impressum.html']")
    private WebElement privacySubmenu;

    @FindBy(xpath = "//ul[@id = 'submenu']/li/a[@href = 'lyrics.html']")
    private WebElement songLyricsSubmenu;

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

    public LyricsPage clickSongLyricsSubmenu() {
        click(songLyricsSubmenu);

        return new LyricsPage(getDriver());
    }
}
