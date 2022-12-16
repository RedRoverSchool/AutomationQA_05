package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.YabasicLanguagePage;
import pages.browse_languages.languages.YacasLanguagePage;

public class YPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-yabasic-64.html']")
    private WebElement yabasicLanguage;

    @FindBy(xpath = "//a[@href='language-yacas-65.html']")
    private WebElement yacasLanguage;

    public YPage(WebDriver driver) {
        super(driver);
    }

    public YabasicLanguagePage clickYabasicLanguage() {
        click(yabasicLanguage);

        return new YabasicLanguagePage(getDriver());
    }

    public YacasLanguagePage clickYacasLanguage() {
        click(yacasLanguage);

        return new YacasLanguagePage(getDriver());
    }
}
