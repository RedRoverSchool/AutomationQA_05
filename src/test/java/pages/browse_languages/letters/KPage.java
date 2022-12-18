package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.KalkulonLanguagePage;
import pages.browse_languages.languages.KotlinLanguagePage;

public class KPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-kotlin-2901.html']")
    private WebElement kotlinLanguage;

    @FindBy(xpath = "//a[@href='language-kalkulon-740.html' ]")
    private WebElement kalkulonLanguage;

    public KPage(WebDriver driver) {
        super(driver);
    }

    public KotlinLanguagePage clickKotlinLanguage() {
        click(kotlinLanguage);

        return new KotlinLanguagePage(getDriver());
    }

    public KalkulonLanguagePage clickKalkulonLanguage() {
        click(kalkulonLanguage);

        return new KalkulonLanguagePage(getDriver());
    }
}
