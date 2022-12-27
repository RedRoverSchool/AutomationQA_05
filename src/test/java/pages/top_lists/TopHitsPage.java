package pages.top_lists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopHitsPage extends TopListsSubmenuPage {

    private static final String LANGUAGE_PATH = "//table[@id='category']";

    @FindBy(xpath = LANGUAGE_PATH + "//a[text()='Shakespeare']")
    private WebElement shakespeareLanguage;

    @FindBy(xpath = LANGUAGE_PATH + "//a[text()='Whitespace')]")
    private WebElement whitespaceLanguage;

    public TopHitsPage(WebDriver driver) {
        super(driver);
    }

    public void clickShakespeareLanguage() {
        click(shakespeareLanguage);
    }

    public void clickWhitespaceLanguage() {
        click(whitespaceLanguage);
    }
}
