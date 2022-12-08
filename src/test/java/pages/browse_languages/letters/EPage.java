package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.EnglishLanguagePage;

public class EPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-english-966.html']")
    private WebElement englishLink;

    public EPage(WebDriver driver) {
        super(driver);
    }

    public EnglishLanguagePage clickEnglishLink() {
        click(englishLink);

        return new EnglishLanguagePage(getDriver());
    }

    public String getEPageURL() {

        return getURL();
    }

    public String getEPageTitle() {

        return getTitle();
    }
}
