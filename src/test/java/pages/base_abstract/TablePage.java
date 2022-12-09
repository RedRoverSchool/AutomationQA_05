package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class TablePage extends MainPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[1]/a")
    private List<WebElement> namesList;

    @FindBy (xpath = "//table [@id = 'category']/tbody/tr/td[2]/a")
    List <WebElement> topRatedLanguagesList;

    @FindBy(xpath = "//ul[@id='submenu']/li")
    private List<WebElement> letters;

    @FindBy(xpath = "//div[@id='main']//tbody/tr/td[1]/a")
    private List<WebElement> languageColum;

    @FindBy(xpath = "//table[@id = 'category']/tbody/tr/th")
    private List<WebElement> tableHeaderNames;

    @FindBy(xpath = "//*[@id='main']/table/tbody//strong")
    private List<WebElement> tableListNames;

    @FindBy(xpath = "//*[@id='main']/table/tbody//td[2]")
    private List<WebElement> tableListValues;

    @FindBy(tagName = "a")
    private List<String> tableLinksList;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNames() {

        return getListText(namesList);
    }

    public List<String> getNamesInLowerCase() {

        return getListTextInLowerCase(namesList);
    }
    
    public List<String> getNamesInUpperCase() {

        return getListTextInUpperCase(namesList);
    }

    public int getNamesListSize() {

        return getListSize(namesList);
    }

    public String getFirstLanguageFromTheList_NameInLowerCase(List<WebElement> elementList){
        List <String> texts = getListTextInLowerCase(elementList);
        String textResult = "";
        if(texts.size() > 0){
            for (String textResult1 : texts) {
                textResult = texts.get(0);
            }

            return textResult;
        }

        return "";
    }

    public String getFirstLanguageFromTheList_NameInUpperCase(List<WebElement> elementList){
        List <String> texts = getListTextInUpperCase(elementList);
        String textResult = "";
        if(texts.size() > 0){
            for (String textResult1 : texts) {
                textResult = texts.get(0);
            }

            return textResult;
        }

        return "";
    }

    public String getMostRatedLanguage() {

        return getFirstLanguageFromTheList_NameInLowerCase(topRatedLanguagesList);
    }

    public List<String> getSubmenuLettersLowerCase(){
        return getListTextInLowerCase(letters);
    }

    public List<WebElement> getSubmenuLettersElement(){
        return letters;
    }
    public List<String> getColumLanguageList(WebElement element){
        click(element);
        return getListTextInLowerCase(languageColum);
    }

    public List<String> getTableHeaderNames(){

        return getListText(tableHeaderNames);
    }

    public List<String> getTableListNames(){

        return getListText(tableListNames);
    }

    public List<String> getTableListValues(){

        return getListText(tableListValues);
    }

    public List<WebElement> getLanguagesLinks() {

        return namesList;
    }

    public String getTextFromRandomLink(int r, List<WebElement> elementsList) {

        return getText(elementsList.get(r - 1));
    }

    public void clickRandomLink(int r, List<WebElement> elementsList) {

        click(elementsList.get(r - 1));
    }
}
