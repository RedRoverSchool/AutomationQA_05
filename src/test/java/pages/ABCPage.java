package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABCPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id ='main']/h2[contains(text(), 'A')]")
    private WebElement h2Category;

    public ABCPage(WebDriver driver) {
        super(driver);
    }

    public String getH2Text() {

        return getText(h2Category);
    }
}