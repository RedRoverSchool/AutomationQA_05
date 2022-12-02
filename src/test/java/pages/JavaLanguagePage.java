package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaLanguagePage extends BasePage {

    @FindBy(xpath = "//h2[text() = 'Language Java']")
    private WebElement H2Header;

    public JavaLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getJavaLanguagePageHeader() {
        String text = getText(H2Header);

        return text;
    }
}
