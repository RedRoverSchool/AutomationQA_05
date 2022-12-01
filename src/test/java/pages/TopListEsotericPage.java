package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopListEsotericPage extends TopListsSubmenuPage {
    @FindBy (xpath = "//table [@id = 'category']/tbody/tr/td[2]/a")
    List<WebElement> topRatedEsotericLanguagesList;

    public TopListEsotericPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTextFromTopRatedEsotericListToLowerCase() {

        return getFirstTextFromElementsListToLowerCase(topRatedEsotericLanguagesList);
    }
}
