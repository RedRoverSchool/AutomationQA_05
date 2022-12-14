package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

import java.util.List;

public abstract class LanguagePage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='voting']/p[2]/a")
    private List<WebElement> externalLinksList;

    @FindBy(xpath = "//div[@id = 'voting']//option[5]")
    private WebElement niceCodingRate;

    @FindBy(xpath = "//div[@id = 'alternatives']/h2")
    private WebElement h2HeaderAlternativeVersions;

    @FindBy(xpath = "//div[@id = 'comments']/h2")
    private WebElement h2HeaderComments;

    @FindBy(xpath = "//div[@id = 'voting']//h2")
    private List<WebElement> h2HeaderVoting;

    @FindBy(xpath = "//a[@href = '/download/2901']")
    private List<WebElement> linksDownload;

    @FindBy(xpath = "//a[@href = '#addcomment']")
    private List<WebElement> linksAddComment;

    @FindBy(xpath = "//a[@title= 'reddit' and @href]")
    private WebElement redditLink;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getExternalLinksList() {

        return getListIfVisible(externalLinksList);
    }

    public LanguagePage clickNiceCoding() {
        click(niceCodingRate);

        return this;
    }

    public String getVotingFieldText() {

        return clickNiceCoding().getText(niceCodingRate);
    }

    public String getH2HeaderTextAlternativeVersions() {

        return getText(h2HeaderAlternativeVersions);
    }

    public String getH2HeaderTextComments() {

        return getText(h2HeaderComments);
    }

    public List<String> getH2HeaderTextVoting() {

        return getListText(h2HeaderVoting);
    }

    public List<String> getTextlinksDownload() {

        return getListText(linksDownload);
    }

    public List<String> getTextlinksAddComment() {

        return getListText(linksAddComment);
    }

    public void clickRedditLink() {
        click(redditLink);
    }
}
