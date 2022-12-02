package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TeamPage extends StartSubmenuPage {

    private final String WEBSITE_LINKS_BASE_PATH = "//div[@id='main']/p/a";

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href='http://www.ls-la.net/']")
    private WebElement OliverSchadeWebsiteLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href='http://www.e-taste.org']")
    private WebElement GregorScheithauerWebsiteLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH + "[@href='http://sts.synflood.de/']")
    private WebElement StefanSchelerWebsiteLink;

    @FindBy(xpath = WEBSITE_LINKS_BASE_PATH)
    private WebElement AllTeamLinks;

    @FindBy(xpath = "//div[@id='main']/h3")
    private WebElement AllTeamNames;

    @FindBy(xpath = "//div[@id ='main']/h2")
    private  WebElement H2Header;

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public void clickOliverSchadeWebsiteLink() {
        click(OliverSchadeWebsiteLink);
    }

    public void clickGregorScheithauerWebsiteLink() {
        click(GregorScheithauerWebsiteLink);
    }

    public void clickStefanSchelerWebsiteLink() {
        click(StefanSchelerWebsiteLink);
    }

    public String getH2HeaderText() {

        return getText(H2Header);
    }
}
