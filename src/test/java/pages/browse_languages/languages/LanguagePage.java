package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

import java.util.List;

public abstract class LanguagePage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='voting']/p[2]/a")
    private List<WebElement> externalLinks;

    @FindBy(xpath = "//div[@id='alternatives']/h2")
    private WebElement alternativeVersionsHeader;

    @FindBy(xpath = "//div[@id='comments']/h2")
    private WebElement commentsHeader;

    @FindBy(xpath = "//div[@id='voting']/h2")
    private List<WebElement> votingHeader;

    @FindBy(xpath = "//a[contains(@href,'/download/')]")
    private List<WebElement> downloadSourceLinks;

    @FindBy(xpath = "//a[@title='reddit' and @href]")
    private WebElement redditLink;

    @FindBy(xpath = "//div[@id = 'voting']//input[@name = 'submitcomment']")
    private WebElement voteButton;

    @FindBy(xpath = "//div[@id = 'voting']//form")
    private WebElement votingForm;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[1]")
    private WebElement input1Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[2]")
    private WebElement input2Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//select")
    private WebElement select3Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[3]")
    private WebElement input4Voting;

    @FindBy(xpath = "//div[@id='voting']//option[5]")
    private WebElement niceCodingRate;

    @FindBy(xpath = "//a[@href='#addcomment']")
    private List<WebElement> writeCommentLinks;

    @FindBy(xpath = "//div[@id='addcomments']//a[@href='/submitnewlanguage.html']")
    private WebElement formLink;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getExternalLinks() {

        return getListIfVisible(externalLinks);
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

    public List<String> getWriteCommentLinksTexts() {

        return getListText(writeCommentLinks);
    }

    public List<WebElement> getWriteCommentLinks() {

        return writeCommentLinks;
    }

    public String getAction() {

        return getAttribute(votingForm, "action");
    }

    public String getMethod() {

        return getAttribute(votingForm, "method");
    }

    public String getInput1Value() {

        return getAttribute(input1Voting, "value");
    }

    public String getInput2Value() {

        return getAttribute(input2Voting, "value");
    }

    public String getSelect3Value() {

        return getAttribute(select3Voting, "value");
    }

    public String getInput4Value() {

        return getAttribute(input4Voting, "value");
    }

    public String getInput1Name() {

        return getAttribute(input1Voting, "name");
    }

    public String getInput2Name() {

        return getAttribute(input2Voting, "name");
    }

    public String getSelect3Name() {

        return getAttribute(select3Voting, "name");
    }

    public String getInput4Name() {

        return getAttribute(input4Voting, "name");
    }

    public void clickRedditLink() {
        click(redditLink);
    }

    public void clickVoteButton() {
        click(voteButton);
    }

    public void clickNiceCodingOption() {
        click(niceCodingRate);
    }

    public void clickWriteComment() {
        click(getWriteCommentLinks().get(0));
    }

    public void clickFormLink() {
        click(formLink);
    }
}
