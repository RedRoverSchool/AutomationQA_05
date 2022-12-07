package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.YabasicLanguagePage;

public class YPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-yabasic-64.html']")
    private WebElement yabasicLink;

    public YPage(WebDriver driver) {
        super(driver);
    }

    public YabasicLanguagePage clickYabasicLink() {
        click(yabasicLink);

        return new YabasicLanguagePage(getDriver());
    }

    public String getYPageURL() {

        return getURL();
    }
}
