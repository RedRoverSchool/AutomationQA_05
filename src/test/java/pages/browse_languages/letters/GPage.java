package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.GapLanguagePage;

public class GPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-gap-275.html']")
    private WebElement gapLanguage;

    public GPage(WebDriver driver) {
        super(driver);
    }

    public GapLanguagePage clickGapLanguage() {
        click(gapLanguage);

        return new GapLanguagePage(getDriver());
    }
}
