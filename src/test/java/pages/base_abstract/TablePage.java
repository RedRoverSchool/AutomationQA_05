package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
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
    private List<WebElement> commentColumn;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "tr/td[2]")
    private List<WebElement> authorColumn;


    final static String TABLE_MAIN_PATH = "//div[@id='main']/table/tbody/tr";

    @FindBy(xpath = TABLE_MAIN_PATH + "/td/strong")
    private List<WebElement> languageInfoFields;

    @FindBy(xpath = TABLE_MAIN_PATH + "/td[2]")
    private List<WebElement> languageInfoValues;

    @FindBy(xpath = TABLE_MAIN_PATH + "[5]/td[2]/a")
    private WebElement infoLink;

    @FindBy(tagName = "a")
    private List<String> links;


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

    public List<String> getVersionsList(WebElement element) {
        click(element);

        return getListTextInLowerCase(namesLinks);
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

    public List<Integer> getIntegerList(List<WebElement> list) {
        List<Integer> integerList = new ArrayList<>();

        if (getListSize(list) > 0) {
            for (WebElement element : list) {
                integerList.add(Integer.valueOf(element.getText()));
            }
        }

        return integerList;
    }

    public List<Integer> getSortedList(List<Integer> list) {
        Collections.sort(list);

        return list;
    }

    public Integer getMaxList(List<Integer> list) {

        return getSortedList(list).get(list.size() - 1);
    }

    public List<Integer> getComments() {

        return getIntegerList(commentColumn);
    }

    public List<String> getAuthors() {

        return getListText(authorColumn);
    }
}
