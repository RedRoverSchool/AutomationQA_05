package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YacasLanguagePage extends LanguagePage{

    @FindBy(xpath = "//div[@id = 'voting']//option[5]")
    private WebElement niceCodingRate;

    public YacasLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getVotingFieldText() {

        return clickNiceCoding().getText(niceCodingRate);
    }
}
