package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.submit_new_language.SubmitNewLanguagePage;

import java.util.List;

public class StartPage extends StartSubmenuPage {

    private final String WEBSITE_LINKS_BASE_PATH = "//div[@id='main']/p/a";

    @FindBy(xpath = "//div[@id = 'main']/p[1]")
    private WebElement verifyText;

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header1;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href]")
    private List<WebElement> textsWithLinks;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href ='./info.html']")
    private WebElement historicInformationLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href ='./lyrics.html']")
    private WebElement hereLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href ='./submitnewlanguage.html']")
    private WebElement submitYourOwnPieceOfCodeLink;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getTeamWishes() {

        return getText(verifyText);
    }

    public String getH2() {

        return getText(h2Header1);
    }

    public List<String> getTextsWithLinks() {

        return getListText(textsWithLinks);
    }

    public String getStartPageURL() {

        return getURL();
    }

    public HistoryPage clickHistoricInformationLink() {
        click(historicInformationLink);

        return new HistoryPage(getDriver());
    }

    public LyricsPage clickHereLink() {
        click(hereLink);

        return new LyricsPage(getDriver());
    }

    public SubmitNewLanguagePage clickSubmitYourOwnPieceOfCodeLink () {
        click(submitYourOwnPieceOfCodeLink);

        return new SubmitNewLanguagePage(getDriver());
    }
}
