package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.DelphiLanguagePage;

public class DPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-delphi-867.html']")
    private WebElement delphiLink;

    public DPage(WebDriver driver) {
        super(driver);
    }

    public DelphiLanguagePage clickDelphiLink() {
        click(delphiLink);

        return new DelphiLanguagePage(getDriver());
    }

    public String getDPageUPL() {

        return getURL();
    }
}