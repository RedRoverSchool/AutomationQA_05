package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.AdaLanguagePage;

public class APage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-ada-19.html']")
    private WebElement adaLanguageLink;

    public APage(WebDriver driver) {
        super(driver);
    }

    public AdaLanguagePage clickAdaLanguageLink() {
        click(adaLanguageLink);

        return new AdaLanguagePage(getDriver());
    }
}
