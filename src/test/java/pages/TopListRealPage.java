package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopListRealPage extends TopListsSubmenuPage {
    @FindBy (xpath = "//table [@id = 'category']/tbody/tr/td[2]/a")
    List <WebElement> topRatedRealLanguesList;
    public TopListRealPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstTextFromTopRatedRealListToLowerCase(List<WebElement> topRatedRealLanguesList) {

        return getFirstTextFromElementsListToLowerCase(topRatedRealLanguesList);
    }
}
