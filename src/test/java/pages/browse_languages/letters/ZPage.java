package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.ZimLanguagePage;

public class ZPage extends LetterPage {

    @FindBy(xpath = "//a[@href = 'language-zim-718.html']")
    private WebElement zimLink;

    public ZPage(WebDriver driver) {
        super(driver);
    }

    public ZimLanguagePage clickZimLink() {
        click(zimLink);

        return new ZimLanguagePage(getDriver());
    }
}
