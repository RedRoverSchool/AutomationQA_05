package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

import java.util.List;

public abstract class StartSubmenuPage extends MainPage<StartPage> {

    private static final String START_SUBMENU_PATH = "//ul[@id='submenu']/li/a";

    @FindBy(xpath = START_SUBMENU_PATH + "[@href='team.html']")
    private WebElement teamSubmenu;

    @FindBy(xpath = START_SUBMENU_PATH + "[@href='lyrics.html']")
    private WebElement songLyricsSubmenu;

    @FindBy(xpath = START_SUBMENU_PATH + "[@href='info.html']")
    private WebElement historySubmenu;

    @FindBy(xpath = START_SUBMENU_PATH + "[@href='impressum.html']")
    private WebElement privacySubmenu;

    @FindBy(xpath = START_SUBMENU_PATH)
    private List<WebElement> startSubmenuButtons;

    @FindBy(xpath = START_SUBMENU_PATH + "[@href]")
    private List<WebElement> submenus;

    public StartSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected StartPage createPage() {

        return new StartPage(getDriver());
    }

    public String getSongLyricsSubmenuText() {

        return getText(songLyricsSubmenu);
    }

    public List<String> getStartSubmenuButtonsText() {

        return getListText(startSubmenuButtons);
    }

    public String getHistorySubmenuText() {

        return getText(historySubmenu);
    }

    public String getHistorySubmenuHref() {

        return getHref(historySubmenu);
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

    public List<WebElement> getStartSubmenus() {

        return startSubmenuButtons;
    }

    public String getTextStartSubmenu(int index) {

        return getTextByIndex(index, startSubmenuButtons);
    }

    public String getHref(int index) {

        return getAttributeByIndex(index, submenus, "href");
    }
}
