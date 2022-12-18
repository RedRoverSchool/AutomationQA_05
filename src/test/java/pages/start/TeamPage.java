package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TeamPage extends StartSubmenuPage {

    private static final String TEAM_PAGE_LINKS_PATH = "//div[@id='main']/p/a";

    @FindBy(xpath = TEAM_PAGE_LINKS_PATH)
    private List<WebElement> allTeamLinks;

    @FindBy(xpath = TEAM_PAGE_LINKS_PATH + "[@href='http://www.ls-la.net/']")
    private WebElement oliverSchadeWebsiteLink;

    @FindBy(xpath = TEAM_PAGE_LINKS_PATH + "[@href='http://www.e-taste.org']")
    private WebElement gregorScheithauerWebsiteLink;

    @FindBy(xpath = TEAM_PAGE_LINKS_PATH + "[@href='http://sts.synflood.de/']")
    private WebElement stefanSchelerWebsiteLink;

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesOfTeamMembers() {

        return getH3HeadersTexts();
    }

    public List<String> getTeamLinks() {

        return getListText(allTeamLinks);
    }

    public int countTeamImages() {

        return getListSize(getImages());
    }

    public void clickOliverSchadeWebsiteLink() {
        click(oliverSchadeWebsiteLink);
    }

    public void clickGregorScheithauerWebsiteLink() {
        click(gregorScheithauerWebsiteLink);
    }

    public void clickStefanSchelerWebsiteLink() {
        click(stefanSchelerWebsiteLink);
    }
}
