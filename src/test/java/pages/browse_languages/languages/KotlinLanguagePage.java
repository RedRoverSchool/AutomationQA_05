package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.search_languages.SearchLanguagesPage;

import java.util.List;

public class KotlinLanguagePage extends LanguagePage{

    @FindBy(xpath = "//div[@id= 'main']/h2")
    private WebElement h2HeaderLanguageKotlin;

    @FindBy(xpath = "//div[@id= 'main']//tbody/tr/td[1]/strong")
    private List<WebElement> namesInTextTable;

    @FindBy(xpath = "//a[@href = '/download/2901']")
    private List<WebElement> linksDownload;

    @FindBy(xpath = "//a[@href = '#addcomment']")
    private List<WebElement> linksAddComment;


    @FindBy(xpath = "//div[@id = 'alternatives']/h2")
    private WebElement h2HeaderAlternativeVersions;

    @FindBy(xpath = "//div[@id = 'comments']/h2")
    private WebElement h2HeaderComments;

    @FindBy(xpath = "//div[@id = 'voting']//h2")
    private List<WebElement> h2HeaderVoting;

    @FindBy(xpath = "//div[@id = 'voting']//input[@name = 'submitcomment']")
    private WebElement voteButton;

//
    @FindBy(xpath = "//div[@id = 'voting']//form")
    private WebElement searchForm;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[1]")
    private WebElement input1Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[2]")
    private WebElement input2Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//select")
    private WebElement selectVoting;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[3]")
    private WebElement input3Voting;


    @FindBy(id = "main")
    private WebElement mainBody;

    @FindBy(tagName = "a")
    private List<WebElement> links;

    @FindBy(tagName = "img")
    private List<WebElement> images;
//

    public KotlinLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getH2HeaderTextLanguageKotlin() {

        return getText(h2HeaderLanguageKotlin);
    }

    public List<String> getNamesInTextTable() {

        return getListText(namesInTextTable);
    }

    public List<String> getTextlinksDownload() {

        return getListText(linksDownload);
    }

    public List<String> getTextlinksAddComment() {

        return getListText(linksAddComment);
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

    public void clickVoteButton() {

        click(voteButton);
    }

    public String getAction() {
        return getAttribute(searchForm, "action");
    }

    public String getMethod() {
        return getAttribute(searchForm, "method");
    }

    public String getInput1Value() {
        return getAttribute(input1SearchForm, "value");
    }

    public String getInput2Value() {
        return getAttribute(input2SearchForm, "value");
    }

    public String getInput1Name() {
        return getAttribute(input1SearchForm, "name");
    }

    public String getInput2Name() {
        return getAttribute(input2SearchForm, "name");
    }

    public String getPageContext() {

        return mainBody.getText();
    }

    public List<WebElement> getLinks() {

        return links;
    }

    public List<WebElement> getImages() {

        return images;
    }
}
