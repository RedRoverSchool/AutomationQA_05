package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.ScalaLanguagePage;

public class SPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-scala-2179.html']")
    private WebElement scalaLanguage;

    public SPage(WebDriver driver) {
        super(driver);
    }

    public ScalaLanguagePage clickScalaLanguage() {
        click(scalaLanguage);

        return new ScalaLanguagePage(getDriver());
    }


}
