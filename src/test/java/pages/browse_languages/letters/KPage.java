package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.KotlinLanguagePage;

public class KPage extends LetterPage {

    @FindBy(xpath = "//a[@href = 'language-kotlin-2901.html']")
    private WebElement kotlinLink;

    public KPage(WebDriver driver) {
        super(driver);
    }

    public KotlinLanguagePage clickKotlinLink() {
        click(kotlinLink);

        return new KotlinLanguagePage(getDriver());
    }
}
