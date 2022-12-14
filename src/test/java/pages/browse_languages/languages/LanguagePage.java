package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

import java.util.List;

public abstract class LanguagePage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='voting']/p[2]/a")
    private List<WebElement> externalLinks;

    @FindBy(xpath = "//div[@id='voting']//option[5]")
    private WebElement niceCodingRate;

    @FindBy(xpath = "//div[@id='alternatives']/h2")
    private WebElement alternativeVersionsHeader;

    @FindBy(xpath = "//div[@id='comments']/h2")
    private WebElement commentsHeader;

    @FindBy(xpath = "//div[@id='voting']/h2")
    private List<WebElement> votingHeader;

    @FindBy(xpath = "//a[contains(@href,'/download/')]")
    private List<WebElement> downloadSourceLinks;

    @FindBy(xpath = "//a[@href = '#addcomment']")
    private List<WebElement> writeCommentLinks;

    @FindBy(xpath = "//a[@title= 'reddit' and @href]")
    private WebElement redditLink;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getExternalLinks() {

        return getListIfVisible(externalLinks);
    }

    public LanguagePage clickNiceCodingOption() {
        click(niceCodingRate);

        return this;
    }

    public String getVotingFieldText() {

        return getText(niceCodingRate);
    }

    public String getAlternativeVersionsHeader() {

        return getText(alternativeVersionsHeader);
    }

    public String getCommentsHeader() {

        return getText(commentsHeader);
    }

    public List<String> getVotingHeader() {

        return getListText(votingHeader);
    }

    public List<String> getDownloadSourceLinks() {

        return getListText(downloadSourceLinks);
    }

    public List<String> getWriteCommentLinks() {

        return getListText(writeCommentLinks);
    }

    public void clickRedditLink() {
        click(redditLink);
    }
}
