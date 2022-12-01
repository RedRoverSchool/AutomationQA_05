package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class TablePage extends MainPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[1]/a")
    private List<WebElement> namesList;

    @FindBy(xpath = "//ul[@id='submenu']/li")
    private List<WebElement> letters;

    @FindBy(xpath = "//div[@id='main']//tbody/tr/td[1]/a")
    private List<WebElement> languageColum;

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
}
