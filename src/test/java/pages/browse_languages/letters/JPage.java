package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.JQueryLanguagePage;
import pages.browse_languages.languages.JavaLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;
import pages.browse_languages.languages.ScalaLanguagePage;

public class JPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-java-3.html']")
    private WebElement javaLanguage;

    @FindBy(xpath = "//a[@href='language-javascript-1948.html']")
    private WebElement javaScriptLanguage;

    @FindBy(xpath = "//a[@href='language-jquery-1361.html']")
    private WebElement jQueryLanguage;
    
    public JPage(WebDriver driver) {
        super(driver);
    }

    public JavaLanguagePage clickJavaLanguage() {
        click(javaLanguage);

        return new JavaLanguagePage(getDriver());
    }

    public JavaScriptLanguagePage clickJavaScriptLanguage() {
        click(javaScriptLanguage);

        return new JavaScriptLanguagePage(getDriver());
    }

    public JQueryLanguagePage clickJQueryLanguage() {
        click(jQueryLanguage);

        return new JQueryLanguagePage(getDriver());
    }

}
