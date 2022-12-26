package pages.submit_new_language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubmitNewLanguagePage extends SubmitNewLanguageSubmenuPage {

    private static final String SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH = "//form[@id='addlanguage']/p/select[@name='category']";

    @FindBy(xpath = "//p/input[@name='submitlanguage']")
    private WebElement submitLanguageButton;

    @FindBy(xpath = "//div[@id='main']/ul/li")
    private List<WebElement> bullets;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH)
    private WebElement category;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH + "/option[text()='esoteric language']")
    private WebElement esotericLanguageOption;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH + "/option")
    private List<WebElement> languageOptions;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH + "/option[@selected]")
    private WebElement languageCategorySelected;

    @FindBy(name = "language")
    private WebElement language;

    @FindBy(name = "author")
    private WebElement author;

    @FindBy(name = "captcha")
    private WebElement captcha;

    @FindBy(name = "code")
    private WebElement code;

    public SubmitNewLanguagePage(WebDriver driver) {
        super(driver);
    }

    public SubmitNewLanguagePage clickSubmitLanguageButton() {
        click(submitLanguageButton);

        return this;
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

    public List<String> getCategoryTexts() {

        return getListText(languageOptions);
    }

    public SubmitNewLanguagePage inputLanguage(String text) {
        input(text, language);

        return this;
    }

    public SubmitNewLanguagePage inputAuthor(String text) {
        input(text, author);

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

        return captcha.getAttribute("style");
    }
}
