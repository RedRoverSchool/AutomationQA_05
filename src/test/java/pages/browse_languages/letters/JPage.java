package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.JavaLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;

public class JPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-java-3.html']")
    private WebElement javaLink;

    @FindBy(xpath = "//a[@href='language-javascript-1948.html']")
    private WebElement javaScriptLink;

    @FindBy(xpath = "//a[@href='language-jquery-1361.html']")
    private WebElement jQueryLink;

    public JPage(WebDriver driver) {
        super(driver);
    }

    public JavaLanguagePage clickJavaLink() {
        click(javaLink);

        return new JavaLanguagePage(getDriver());
    }

    public JavaScriptLanguagePage clickJavaScriptLink() {
        click(javaScriptLink);

        return new JavaScriptLanguagePage(getDriver());
    }

    public void clickJQueryLink() {
        click(jQueryLink);
    }

    public String getJPageURL() {

        return getURL();
    }
}
