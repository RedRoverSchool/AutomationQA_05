package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitNewLanguagePage extends SubmitNewLanguageSubmenuPage{

    @FindBy(xpath = "//p/input[@name='language']")
    private WebElement fieldLanguageName;

    @FindBy(xpath = "//p/input[@name='descriptor']")
    private WebElement fieldDescription;

    @FindBy(xpath = "//p/input[@name='submitlanguage']")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='main']/p[@style]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement H2Header;

    public SubmitNewLanguagePage(WebDriver driver) {
        super(driver);
    }

    public SubmitNewLanguagePage clickGoButton() {
        click(goButton);

        return this;
    }

    public String getTextErrorMessage() {

        return getText(errorMessage);
    }

    public SubmitNewLanguagePage clickFieldLanguageName() {
        click(fieldLanguageName);

        return new SubmitNewLanguagePage(getDriver());
    }

    public SubmitNewLanguagePage inputFieldLanguageName(String text) {
        input(text, fieldLanguageName);

        return this;
    }

    public SubmitNewLanguagePage clickFieldDescription() {
        click(fieldDescription);

        return new SubmitNewLanguagePage(getDriver());
    }

    public String getH2HeaderText() {

        return getText(H2Header);
    }
}
