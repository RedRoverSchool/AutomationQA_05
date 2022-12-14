package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.YabasicLanguagePage;
import pages.browse_languages.languages.YacasLanguagePage;

public class YPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-yabasic-64.html']")
    private WebElement yabasicLink;

    @FindBy(xpath = "//a[@href='language-yacas-65.html']")
    private WebElement yacasLink;

    public YPage(WebDriver driver) {
        super(driver);
    }

    public YabasicLanguagePage clickYabasicLink() {
        click(yabasicLink);

        return new YabasicLanguagePage(getDriver());
    }

    public YacasLanguagePage clickYacasLink() {
        click(yacasLink);

        return new YacasLanguagePage(getDriver());
    }
}
