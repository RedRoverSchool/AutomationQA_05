package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.CheetahLanguagePage;

public class CPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-cheetah-1179.html']")
    private WebElement cheetahLink;

    public CPage(WebDriver driver) {
        super(driver);
    }

    public CheetahLanguagePage clickCheetahLink() {
        click(cheetahLink);

        return new CheetahLanguagePage(getDriver());
    }

    public String getCPageURL() {

        return getURL();
    }
}
