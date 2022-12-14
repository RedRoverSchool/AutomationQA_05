package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

import java.util.List;

public abstract class StartSubmenuPage extends MainPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='team.html']")
    private WebElement teamSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='lyrics.html']")
    private WebElement songLyricsSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='info.html']")
    private WebElement historySubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='impressum.html']")
    private WebElement privacySubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a")
    private List<WebElement> startSubmenuButtons;

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

    public HistoryPage clickHistorySubmenu() {
        click(historySubmenu);

        return new HistoryPage(getDriver());
    }

    public PrivacyPage clickPrivacySubmenu() {
        click(privacySubmenu);

        return new PrivacyPage(getDriver());
    }

    public String getSongLyricsSubmenuText() {

        return getText(songLyricsSubmenu);
    }

    public List<String> getStartSubmenuButtonsText() {

        return getListText(startSubmenuButtons);
    }

    public WebElement getHistorySubmenu() {

        return historySubmenu;
    }

    public String getHistorySubmenuText() {

        return getText(historySubmenu);
    }
}
