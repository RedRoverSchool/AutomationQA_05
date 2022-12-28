package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.MagnumLanguagePage;

public class MPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-magnum-654.html']")
    private WebElement magnumLanguage;

    public MPage(WebDriver driver) {
        super(driver);
    }

    public MagnumLanguagePage clickMagnumLanguage() {
        click(magnumLanguage);

        return new MagnumLanguagePage(getDriver());
    }
}
