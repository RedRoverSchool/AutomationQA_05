package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

public abstract class LetterPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='main']/p[contains(text(),'All languages')]")
    private WebElement languageDescription;

    public LetterPage(WebDriver driver) {
        super(driver);
    }

    public String getPageDescription() {

        return getText(languageDescription);
    }
}
