package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

import java.util.List;

public abstract class LanguagePage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='voting']/p[2]/a")
    private List<WebElement> externalLinksList;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getExternalLinksList() {

        return getListIfVisible(externalLinksList);
    }
}
