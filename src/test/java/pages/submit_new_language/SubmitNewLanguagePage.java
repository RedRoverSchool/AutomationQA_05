package pages.submit_new_language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubmitNewLanguagePage extends SubmitNewLanguageSubmenuPage {

    @FindBy(xpath = "//p/input[@name='submitlanguage']")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='main']/p[@style]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='main']/ul/li")
    private List<WebElement> bullets;

    @FindBy(xpath = "//form[@id='addlanguage']/p/select[@name='category']")
    private WebElement category;

    @FindBy(xpath = "//form[@id='addlanguage']/p/select[@name='category']/option")
    private WebElement categoriesOptions;

    @FindBy(xpath = "//form[@id='addlanguage']/p/select[@name='category']/option[text()='esoteric language']")
    private WebElement esotericLanguageOption;

    @FindBy(xpath = "//select[@name='category']/option[@selected]")
    private WebElement languageCategorySelected;

    @FindBy(name = "language")
    private WebElement language;

    @FindBy(name = "author")
    private WebElement author;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "captcha")
    private WebElement captcha;

    @FindBy(name = "code")
    private WebElement code;

    final String STYLE = "style";

    public SubmitNewLanguagePage(WebDriver driver) {
        super(driver);
    }

    public SubmitNewLanguagePage clickGoButton() {
        click(goButton);

        return this;
    }

    public String getErrorMessage() {

        return getText(errorMessage);
    }

    public int countBullets() {

        return getListSize(bullets);
    }

    public SubmitNewLanguagePage clickCategoryField() {
        click(category);

        return this;
    }

    public SubmitNewLanguagePage clickEsotericLanguageOption() {
        click(esotericLanguageOption);

        return this;
    }

    public String getSelectedLanguageCategory() {

        return getText(languageCategorySelected);
    }

    public SubmitNewLanguagePage inputLanguage(String text) {
        input(text, language);

        return this;
    }

    public SubmitNewLanguagePage inputAuthor(String text) {
        input(text, author);

        return this;
    }

    public SubmitNewLanguagePage inputEmail(String text) {
        input(text, email);

        return this;
    }

    public SubmitNewLanguagePage inputCaptcha(String text) {
        input(text, captcha);

        return this;
    }

    public SubmitNewLanguagePage inputCode(String text) {
        input(text, code);

        return this;
    }

    public String getCaptchaStyle() {

        return captcha.getAttribute(STYLE);
    }
}



