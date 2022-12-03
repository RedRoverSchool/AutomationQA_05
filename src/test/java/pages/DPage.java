package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id=\"category\"]//a[starts-with(text(),'D')]")
    private List<WebElement> dList;

    public DPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getDLanguagesNames() {
        return getListTextInUpperCase(dList);
    }
}