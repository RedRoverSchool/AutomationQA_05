package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id = 'category']/tbody/tr/td[1]/a")
    private List<WebElement> mList;

    public MPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getMLanguagesNames() {

        return getListTextInLowerCase(mList);
    }
}
