package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id='category']/tbody//a")
    private List<WebElement> pList;

    public PPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPLanguagesNames() {

        return getListTextInLowerCase(pList);
    }
}
