package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PythonLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[@href='http://www.python.org/']")
    private WebElement PythonLanguageInfoLink;

    public PythonLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickPythonLanguageInfoLink() {
        click(PythonLanguageInfoLink);
    }
}