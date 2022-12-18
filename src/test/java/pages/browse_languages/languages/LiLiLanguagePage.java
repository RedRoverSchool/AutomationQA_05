package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LiLiLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[@href='http://littlisp.sourceforge.net']")
    private WebElement liliLanguageInfoLink;

    public LiLiLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickLiLiLanguageInfoLink() {
        click(liliLanguageInfoLink);
    }
}
