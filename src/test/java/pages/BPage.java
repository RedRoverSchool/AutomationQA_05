package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//a[@href ='language-bash-98.html']")
    private WebElement bashLanguageLink;

    public BPage(WebDriver driver) {
        super(driver);
    }

    public BashLanguagePage clickBashLink() {
        click(bashLanguageLink);

        return new BashLanguagePage(getDriver());
    }
}
