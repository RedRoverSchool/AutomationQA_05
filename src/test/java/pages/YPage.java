package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id = 'category']//a[starts-with(text(), 'Y')]")
    private List<WebElement> yList;

    public YPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getYLanguagesNames() {

        return getListTextInLowerCase(yList);
    }
}
