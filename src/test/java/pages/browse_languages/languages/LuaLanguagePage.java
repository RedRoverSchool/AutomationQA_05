package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LuaLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[contains(@href, 'http://jove.prohosting.com/')]")
    private WebElement luaLanguageInfoLink;

    public LuaLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickLuaLanguageInfoLink() {
        click(luaLanguageInfoLink);
    }
}
