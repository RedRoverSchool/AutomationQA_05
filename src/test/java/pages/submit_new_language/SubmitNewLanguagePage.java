package pages.submit_new_language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SubmitNewLanguagePage extends SubmitNewLanguageSubmenuPage {

    private static final String SUBMIT_NEW_LANGUAGE_PAGE_P_PATH = "//form[@id='addlanguage']/p";
    private static final String SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH = "//form[@id='addlanguage']/p/select[@name='category']";

    @FindBy(xpath = "//p/input[@name='submitlanguage']")
    private WebElement submitLanguageButton;

    @FindBy(xpath = "//div[@id='main']/ul/li")
    private List<WebElement> bullets;

    @FindBy(xpath = "//div[@id='main']/ul/li/span/b")
    private WebElement spanImportant;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH)
    private WebElement category;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH + "/option[text()='esoteric language']")
    private WebElement esotericLanguageOption;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH + "/option")
    private List<WebElement> languageOptions;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_CATEGORY_PATH + "/option[@selected]")
    private WebElement languageCategorySelected;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_P_PATH + "/input[@style]")
    private List<WebElement> inputStyle;

    @FindBy(xpath = SUBMIT_NEW_LANGUAGE_PAGE_P_PATH + "/textarea[@style]")
    private List<WebElement> textareaStyle;


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

    @FindBy(id = "addlanguage")
    private WebElement addlanguageform;

    @FindBy(xpath = "//form//input[1]")
    private WebElement input1Submitlanguage;

    @FindBy(xpath = "//form//input[2]")
    private WebElement input2Submitlanguage;

    @FindBy(xpath = "//form//input[3]")
    private WebElement input3Submitlanguage;

    @FindBy(xpath = "//form//input[4]")
    private WebElement input4Submitlanguage;

    @FindBy(xpath = "//form//input[5]")
    private WebElement input5Submitlanguage;

    @FindBy(xpath = "//form//input[6]")
    private WebElement input6Submitlanguage;

    @FindBy(xpath = "//form//input[7]")
    private WebElement input7Submitlanguage;

    @FindBy(xpath = "//form//input[8]")
    private WebElement input8Submitlanguage;

    @FindBy(xpath = "//form//select[1]")
    private WebElement select1Submitlanguage;

    @FindBy(xpath = "//form//textarea[1]")
    private WebElement textarea1Submitlanguage;

    @FindBy(xpath = "//form//textarea[2]")
    private WebElement textarea2Submitlanguage;

    public SubmitNewLanguagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getFieldsWithRedBorder() {
        List<WebElement> borders = new ArrayList<>();
        borders.addAll(inputStyle);
        borders.addAll(textareaStyle);

        return borders;
    }

    public int countRequiredFields() {

        return getListSize(getFieldsWithRedBorder());
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

    public String getImportantText() {

        return getText(spanImportant);
    }

    public String getImportantFont() {

        return getFontSize(spanImportant);
    }

    public String getImportantBackgroundColor() {

        return getBackgroundColor(spanImportant);
    }

    public String getImportantColor() {

        return getColor(spanImportant);
    }

    public String getLanguageBorder() {

        return getBorder(language);
    }

    public String getAuthorBorder() {

        return getBorder(author);
    }

    public String getEmailBorder() {

        return getBorder(email);
    }

    public String getCaptchaBorder() {

        return getBorder(captcha);
    }

    public String getCodeBorder() {

        return getBorder(code);
    }

    public String getAction() {

        return getAttribute(addlanguageform, "action");
    }

    public String getMethod() {

        return getAttribute(addlanguageform, "method");
    }

    public String getFormText() {

        return getText(addlanguageform);
    }

    public String getInput1Name() {

        return getAttribute(input1Submitlanguage, "name");
    }

    public String getInput2Name() {

        return getAttribute(input2Submitlanguage, "name");
    }

    public String getInput3Name() {

        return getAttribute(input3Submitlanguage, "name");
    }

    public String getInput4Name() {

        return getAttribute(input4Submitlanguage, "name");
    }

    public String getInput5Name() {

        return getAttribute(input5Submitlanguage, "name");
    }

    public String getInput6Name() {

        return getAttribute(input6Submitlanguage, "name");
    }

    public String getInput7Name() {

        return getAttribute(input7Submitlanguage, "name");
    }

    public String getInput8Value() {

        return getAttribute(input8Submitlanguage, "value");
    }

    public String getSelect1Name() {

        return getAttribute(select1Submitlanguage, "name");
    }

    public String getTextarea1Name() {

        return getAttribute(textarea1Submitlanguage, "name");
    }

    public String getTextarea2Name() {

        return getAttribute(textarea2Submitlanguage, "name");
    }
}
