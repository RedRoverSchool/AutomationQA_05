package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//table[@id='category']//td/a[text() = 'Java']")
    private WebElement javaLanguage;

    public JPage(WebDriver driver) {
        super(driver);
    }

    public JavaLanguagePage clickJavaLanguage() {
        click(javaLanguage);

        return new JavaLanguagePage(getDriver());
    }
}
