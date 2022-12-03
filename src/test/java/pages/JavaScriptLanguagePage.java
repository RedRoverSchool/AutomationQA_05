package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptLanguagePage extends BasePage {

    @FindBy(xpath = "//h2[text() = 'Language JavaScript']")
    private WebElement JSH2Header;

    public JavaScriptLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getJavaScriptLanguagePageHeader() {
        String text = getText(JSH2Header);

        return text;
    }
}
