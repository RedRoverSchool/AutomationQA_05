package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id='category']//td/a[text() = 'Java']")
    private WebElement javaLanguage;

    @FindBy(xpath = "//table[@id='category']//a[@href='language-javascript-1948.html']")
    private WebElement javaScriptLanguage;

    @FindBy(xpath = "//a[@href='language-jquery-1361.html']")
    private WebElement jQueryLink;

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

    public JQueryLanguagePage clickJQueryLink() {
        click(jQueryLink);

        return new JQueryLanguagePage(getDriver());
    }

    public String getJPageURL() {

        return getURL();
    }
}
