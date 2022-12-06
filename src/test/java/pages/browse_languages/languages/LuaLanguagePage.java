package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LuaLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[@title= 'reddit' and @href]")
    private WebElement redditLink;

    public LuaLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickRedditLink() {
        click(redditLink);
    }
}
