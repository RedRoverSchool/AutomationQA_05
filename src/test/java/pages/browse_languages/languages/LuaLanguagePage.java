package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LuaLanguagePage extends LanguagePage {

    @FindBy(xpath = "//a[@href='http://jove.prohosting.com/~philho/']")
    private WebElement luaLanguageInfoLink;

    public LuaLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickLuaLanguageInfoLink() {
        click(luaLanguageInfoLink);
    }
}
