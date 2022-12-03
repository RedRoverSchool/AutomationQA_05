package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BashLanguagePage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header;

    @FindBy(xpath = "//div[@id='voting']/p[2]/a")
    private List<WebElement> externalLinksList;

    public BashLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getH2HeaderText() {

        return getText(h2Header);
    }

    public List<WebElement> getExternalLinksList() {

        return getListIfVisible(externalLinksList);
    }
}
