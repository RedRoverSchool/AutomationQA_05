package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.LiLiLanguagePage;

public class LPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-lili-1603.html']")
    private WebElement liliLanguage;

    public LPage(WebDriver driver) {
        super(driver);
    }

    public LiLiLanguagePage clickLiLiLanguage() {
        scrollByVisibleElement(liliLanguage);
        click(liliLanguage);

        return new LiLiLanguagePage(getDriver());
    }
}
