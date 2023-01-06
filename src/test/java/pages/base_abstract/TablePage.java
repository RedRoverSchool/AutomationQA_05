package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TablePage<GenericType> extends MainPage<GenericType> {

    //Table Category
    final static String TABLE_CATEGORY_PATH = "//table[@id='category']/tbody/tr/";

    @FindBy(xpath = TABLE_CATEGORY_PATH + "td[1]/a")
    private List<WebElement> namesLinks;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "td[2]/a")
    List<WebElement> topRatedLanguagesLinks;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "th")
    private List<WebElement> tableHeaders;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "td[4]")
    private List<WebElement> commentsColumn;

    @FindBy(xpath = TABLE_CATEGORY_PATH + "td[2]")
    private List<WebElement> authorsColumn;

    //Table Main
    final static String TABLE_MAIN_PATH = "//div[@id='main']/table/tbody/tr";

    @FindBy(xpath = TABLE_MAIN_PATH + "/td/strong")
    private List<WebElement> languageInfoFields;

    @FindBy(xpath = TABLE_MAIN_PATH + "/td[2]")
    private List<WebElement> languageInfoValues;

    @FindBy(xpath = TABLE_MAIN_PATH + "[5]/td[2]/a")
    private WebElement infoLink;

    @FindBy(xpath = "//div[@id='main']/table/tbody/tr/td[1]")
    private List<WebElement> languageInfoDate;

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

    public int getSize() {

        return getListSize(namesLinks);
    }

    public String getMostRatedLanguage() {

        return getListTextInLowerCase(topRatedLanguagesLinks).get(0);
    }

    public List<String> getTableHeaders() {

        return getListText(tableHeaders);
    }

    public List<String> getFirstLettersFromLanguagesNames() {
        List<String> firstLetters = new ArrayList<>();
        for (String languageName : getNamesInUpperCase()) {
            firstLetters.add(languageName.substring(0, 1));
        }

        return firstLetters;
    }

    public List<String> getLanguageInfoFields() {

        return getListText(languageInfoFields);
    }

    public List<String> getLanguageInfoValues() {

        return getListText(languageInfoValues);
    }

    public List<WebElement> getLanguagesLinks() {

        return namesLinks;
    }

    public String getTextFromRandomLink(int r, List<WebElement> elementsList) {

        return getText(elementsList.get(r));
    }

    public String getHrefDeepLink() {

        return getAttribute(infoLink, "href");
    }

    public List<String> getAuthors() {

        return getListText(authorsColumn);
    }

    public List<String> getComments() {

        return getListText(commentsColumn);
    }

    public int getMaxCount(List<String> list) {
        int[] counts = getIntegersFromTexts(list);

        Arrays.sort(counts);

        return counts[counts.length - 1];
    }

    public int getIndexForMaxCount(List<String> list, int number) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(String.valueOf(number))) {

                    return i;
                }
            }
        }

        return -1;
    }

    public void clickRandomLink(int r, List<WebElement> elementsList) {
        click(elementsList.get(r));
    }

    public List<String> languageInfoDates(){

        return getListText(languageInfoDate);
    }
}
