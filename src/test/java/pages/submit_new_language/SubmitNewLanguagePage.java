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

    @FindBy(xpath ="//div[@id='main']/ul/li")
    private List<WebElement> bullets;

    @FindBy(xpath = "//form[@id='addlanguage']/p/select[@name='category']")
    private WebElement category;

    @FindBy(xpath = "//form[@id='addlanguage']/p/select[@name='category']/option")
    private WebElement categoriesOptions;

    @FindBy(xpath = "//form[@id='addlanguage']/p/select[@name='category']/option[text()='esoteric language']")
    private WebElement esotericLanguageOption;

    @FindBy(xpath = "//select[@name='category']/option[@selected]")
    private WebElement languageCategorySelected;

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
}


