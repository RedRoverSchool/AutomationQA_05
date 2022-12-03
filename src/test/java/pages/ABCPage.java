package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABCPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id ='main']/h2")
    private WebElement h2Header;

    public ABCPage(WebDriver driver) {
        super(driver);
    }

    public String getH2HeaderText() {

        return getText(h2Header);
    }
}