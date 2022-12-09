package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.PythonLanguagePage;

public class PPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-python-808.html']")
    private WebElement PythonLink;

    public PPage(WebDriver driver) {
        super(driver);
    }

    public PythonLanguagePage clickPythonLink() {
        click(PythonLink);

        return new PythonLanguagePage(getDriver());
    }
}