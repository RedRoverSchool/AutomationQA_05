package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.JRLanguagePage;
import pages.browse_languages.languages.JavaLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;

public class JPage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-java-3.html']")
    private WebElement javaLink;

    @FindBy(xpath = "//a[@href='language-javascript-1948.html']")
    private WebElement javaScriptLink;

    @FindBy(xpath = "//a[@href='language-jquery-1361.html']")
    private WebElement jQueryLink;

    final static String ACTION = "j.html";
    final static String METHOD = "post";

    @FindBy(id = "main")
    private WebElement mainBody;

    @FindBy(xpath =" //a[@href='language-jr-999.html']")
    private WebElement JRLink;

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

    public String getPageContext() {

        return mainBody.getText();
    }

    public JRLanguagePage clickJrLink() {
        click(JRLink);

        return new JRLanguagePage(getDriver());
    }
}
