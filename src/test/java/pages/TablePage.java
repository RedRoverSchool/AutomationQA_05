package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class TablePage extends MainPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[1]/a")
    private List<WebElement> namesList;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesInLowerCase() {

        return getListTextInLowerCase(namesList);
    }

    public int getListSizeFromTable() {

        return getListSize(namesList);
    }
    
    public List<String> getNamesInUpperCase() {

        return getListTextInUpperCase(namesList);
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
}
