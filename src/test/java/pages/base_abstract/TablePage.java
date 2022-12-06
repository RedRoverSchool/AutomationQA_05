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
//        return getListTextInLowerCase(letters);
        return getListText(letters);
    }

    public List<WebElement> getSubmenuLettersElement(){
        return letters;
    }
    public List<String> getColumLanguageList(){

        return getListTextInUpperCase(languageColum);
    }

    public List<String> getTableHeaderNames(){

        return getListText(tableHeaderNames);
    }
}
