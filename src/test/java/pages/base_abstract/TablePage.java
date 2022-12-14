package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TablePage extends MainPage {

    final static String TABLE_CATEGORY_PATH = "//table[@id='category']/tbody/tr/";

    @FindBy(xpath = TABLE_CATEGORY_PATH + "td[1]/a")
    private List<WebElement> namesLinks;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "td[2]/a")
    List<WebElement> topRatedLanguagesLinks;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "tr/th")
    private List<WebElement> tableHeaders;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "tr/td[4]")
    private List<WebElement> commentsColumn;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "tr/td[2]")
    private List<WebElement> authorsColumn;


    final static String TABLE_MAIN_PATH = "//div[@id='main']/table/tbody/tr";

    @FindBy(xpath = TABLE_MAIN_PATH + "/td/strong")
    private List<WebElement> languageInfoFields;

    @FindBy(xpath = TABLE_MAIN_PATH + "/td[2]")
    private List<WebElement> languageInfoValues;

    @FindBy(xpath = TABLE_MAIN_PATH + "[5]/td[2]/a")
    private WebElement infoLink;


    public TablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNames() {

        return getListText(namesLinks);
    }

    public List<String> getNamesInLowerCase() {

        return getListTextInLowerCase(namesLinks);
    }

    public List<String> getNamesInUpperCase() {

        return getListTextInUpperCase(namesLinks);
    }

    public int getNamesListSize() {

        return getListSize(namesLinks);
    }

    public String getMostRatedLanguage() {

        return getListTextInLowerCase(topRatedLanguagesLinks).get(0);
    }

    public List<String> getHeaders() {

        return getListText(tableHeaders);
    }

    public List<String> getFirstsLetterFromLanguagesNames(){
        List<String> firstLetters = new ArrayList<>();
        for (String languageName: getNamesInUpperCase()){
            firstLetters.add(languageName.substring(0, 1));
        }

        return firstLetters;
    }

    public List<String> getLanguageInfoFields(){

        return getListText(languageInfoFields);
    }

    public List<String> getLanguageInfoValues() {

        return getListText(languageInfoValues);
    }

    public List<WebElement> getLanguagesLinks() {

        return namesLinks;
    }

    public String getTextFromRandomLink(int r, List<WebElement> elementsList) {

        return getText(elementsList.get(r - 1));
    }

    public void clickRandomLink(int r, List<WebElement> elementsList) {

        click(elementsList.get(r - 1));
    }

    public String getHrefDeepLink() {

        return getAttribute(infoLink, "href");
    }

    public Integer getCommentWithMaxCount() {
        Integer[] commentsCount = (Integer[]) getListIntegersFromTexts(commentsColumn).toArray();
        Arrays.sort(commentsCount);

        return commentsCount[commentsCount.length - 1];
    }

    public List<WebElement> getComments() {

        return commentsColumn;
    }

    public List<String> getAuthors() {

        return getListText(authorsColumn);
    }
}
