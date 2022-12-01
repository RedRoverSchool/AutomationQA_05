package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='main']/h2[contains(text(), 'Category B')]")
    private WebElement h2Header;

    public BPage(WebDriver driver) {
        super(driver);
    }

    public String getH2Header() {

        return getText(h2Header);
    }
}
