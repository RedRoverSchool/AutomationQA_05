package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

public abstract class StartSubmenuPage extends MainPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='team.html']")
    private WebElement teamSubmenu;

    @FindBy(xpath = "//ul[@id = 'submenu']/li/a[@href = 'lyrics.html']")
    private WebElement songLyricsSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='info.html']")
    private WebElement historySubMenu;

    @FindBy(xpath = "//ul[@id ='submenu']/li/a[@href = 'impressum.html']")
    private WebElement privacySubmenu;

    public StartSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public TeamPage clickTeamSubmenu() {
        click(teamSubmenu);

        return new TeamPage(getDriver());
    }

    public LyricsPage clickSongLyricsSubmenu() {
        click(songLyricsSubmenu);

        return new LyricsPage(getDriver());
    }

    public PrivacyPage clickPrivacySubmenu() {
        click(privacySubmenu);

        return new PrivacyPage(getDriver());
    }
}
