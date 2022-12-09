package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KPage extends LetterPage {

    @FindBy(xpath = "//a[@href = 'language-kotlin-2901.html']")
    private WebElement kotlinLink;

    public KPage(WebDriver driver) {
        super(driver);
    }

    public void clickKotlinLink() {
        click(kotlinLink);
    }

    public String getKPageURL() {

        return getURL();
    }
}
