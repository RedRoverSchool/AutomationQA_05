package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
