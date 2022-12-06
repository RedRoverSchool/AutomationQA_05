package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TeamPage extends StartSubmenuPage {

    private final String WEBSITE_LINKS_BASE_PATH = "//div[@id='main']/p/a";

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href='http://www.ls-la.net/']")
    private WebElement oliverSchadeWebsiteLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href='http://www.e-taste.org']")
    private WebElement gregorScheithauerWebsiteLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href='http://sts.synflood.de/']")
    private WebElement stefanSchelerWebsiteLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH)
    private List<WebElement> allTeamLinks;

    @FindBy(xpath = "//div[@id='main']/h3")
    private List<WebElement> allTeamNames;

    @FindBy(xpath = "//div[@id ='main']/h2")
    private  WebElement h2Header;

    @FindBy(xpath = "//div[@id='main']/p/img[@src]")
    private List<WebElement> allTeamImages;

    public TeamPage(WebDriver driver) {
        super(driver);
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

    public String getH2HeaderText() {

        return getText(h2Header);
    }

    public List<String> getTeamNames() {

        return getListText(allTeamNames);
    }

    public List<String> getTeamLinks() {

        return getListText(allTeamLinks);
    }

    public int countTeamImages() {

        return getListSize(allTeamImages);
    }
}
