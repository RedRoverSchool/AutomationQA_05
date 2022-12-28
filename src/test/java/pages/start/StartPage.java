package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.guest_book.ReadGuestbookPage;
import pages.submit_new_language.SubmitNewLanguagePage;

import java.util.List;

public class StartPage extends StartSubmenuPage {

    private static final String START_PAGE_LINKS_PATH = "//div[@id='main']/p/a";

    @FindBy(xpath = START_PAGE_LINKS_PATH + "[@href]")
    private List<WebElement> textsWithLinks;

    @FindBy(xpath = START_PAGE_LINKS_PATH + "[@href='./info.html']")
    private WebElement historicInformationLink;

    @FindBy(xpath = START_PAGE_LINKS_PATH + "[@href='./lyrics.html']")
    private WebElement hereLink;

    @FindBy(xpath = START_PAGE_LINKS_PATH + "[@href='./submitnewlanguage.html']")
    private WebElement submitYourOwnPieceOfCodeLink;

    @FindBy(xpath = START_PAGE_LINKS_PATH + "[@href='./guestbookv2.html']")
    private WebElement guestbookLink;

    @FindBy(xpath = START_PAGE_LINKS_PATH + "[@href='./team.html']")
    private WebElement teamMembersLink;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTextsWithLinks() {

        return getListText(textsWithLinks);
    }

    public HistoryPage clickHistoricInformationLink() {
        click(historicInformationLink);

        return new HistoryPage(getDriver());
    }

    public LyricsPage clickHereLink() {
        click(hereLink);

        return new LyricsPage(getDriver());
    }

    public SubmitNewLanguagePage clickSubmitYourOwnPieceOfCodeLink() {
        click(submitYourOwnPieceOfCodeLink);

        return new SubmitNewLanguagePage(getDriver());
    }

    public ReadGuestbookPage clickGuestbookLink() {
        click(guestbookLink);

        return new ReadGuestbookPage(getDriver());
    }

    public TeamPage clickTeamMembersLink() {
        click(teamMembersLink);

        return new TeamPage(getDriver());
    }
}
