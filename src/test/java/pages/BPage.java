package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//a[@href ='language-bash-98.html']")
    private WebElement bashLanguageLink;

    @FindBy(xpath = "//div[@id='main']/h2[contains(text(), 'Category B')]")
    private WebElement h2Header;

    public BPage(WebDriver driver) {
        super(driver);
    }

    public BashLanguagePage clickBashLanguageLink() {
        click(bashLanguageLink);

        return new BashLanguagePage(getDriver());
    }

    public String getH2Header() {

        return getText(h2Header);
    }
}
