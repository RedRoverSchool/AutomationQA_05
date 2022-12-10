package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.BasePage;

public class JavaScriptLanguagePage extends LanguagePage {

    @FindBy(xpath = "//*[@id='main']//a[contains(text(), 'http://en.wikipedia.org/wiki/Javascript')]")
    private WebElement JavaScriptDeepLink;

    public JavaScriptLanguagePage(WebDriver driver) {
        super(driver);
    }

    public JavaScriptLanguagePage clickJavaScriptDeepLink() {
        click(JavaScriptDeepLink);

        return new JavaScriptLanguagePage(getDriver());
    }
}
