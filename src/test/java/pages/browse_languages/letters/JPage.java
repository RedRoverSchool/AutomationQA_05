package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.JRLanguagePage;
import pages.browse_languages.languages.JQueryLanguagePage;
import pages.browse_languages.languages.JavaLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;

public class JPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-java-3.html']")
    private WebElement javaLanguage;

    @FindBy(xpath = "//a[@href='language-javascript-1948.html']")
    private WebElement javaScriptLanguage;

    @FindBy(xpath = "//a[@href='language-jquery-1361.html']")
    private WebElement jQueryLanguage;

    @FindBy(xpath =" //a[@href='language-jr-999.html']")
    private WebElement jRLanguage;

    final static String ACTION = "j.html";
    final static String METHOD = "post";

    @FindBy(id = "main")
    private WebElement mainBody;

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

    public JRLanguagePage clickJrLink() {
        click(jRLanguage);

        return new JRLanguagePage(getDriver());
    }
}
