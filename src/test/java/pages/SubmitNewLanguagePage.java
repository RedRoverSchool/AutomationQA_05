package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitNewLanguagePage extends SubmitNewLanguageSubmenuPage{

    @FindBy(xpath = "//p/input[@name='submitlanguage']")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='main']/p[@style]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement H2Header;

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

    public String getTextErrorMessage() {

        return getText(errorMessage);
    }

    public String getH2HeaderText() {

        return getText(H2Header);
    }

    public SubmitNewLanguagePage clickCategoryField() {
        click(category);

        return this;
    }

    public SubmitNewLanguagePage clickEsotericLanguageOption() {
        click(esotericLanguageOption);

        return this;
    }

    public String getLanguageCategorySelected() {

        return getText(languageCategorySelected);
    }
}
