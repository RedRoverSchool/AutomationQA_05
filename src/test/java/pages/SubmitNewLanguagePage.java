package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubmitNewLanguagePage extends SubmitNewLanguageSubmenuPage{

    @FindBy(xpath = "//p/input[@name='submitlanguage']")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='main']/p[@style]")
    private WebElement errorMessage;

    @FindBy(xpath ="//div[@id='main']/ul/li")
    private List<WebElement> pleaseNoteItems;

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

    public int countPleaseNoteItems() {

        return getListSize(pleaseNoteItems);
    }
}


