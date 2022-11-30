package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id='category']//td/a[text() = 'Java']")
    private WebElement languageJava;

    @FindBy(xpath = "//h2[text() = 'Language Java']")
    private WebElement H2JavaLanguageTitle;

    public JPage(WebDriver driver) {
        super(driver);
    }

    public JPage clickJavaLanguage() {
        click(languageJava);

        return new JPage(getDriver());
    }

    public String getH2JavaTitle() {
        String text = getText(H2JavaLanguageTitle);

        return text;
    }
}
