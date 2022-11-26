package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class TablePage extends MainPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[1]/a")
    private List<WebElement> namesList;

    private final By NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    protected By getNamesList() {

        return NAMES_LIST;
    }

    public List<String> getNamesInLowerCase() {

        return getListTextInLowerCase(getNamesList());
    }

    ////
    public List<String> getNamesInLowerCasePOM3() {

        return getListTextInLowerCase(namesList);
    }
}
