package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AbcPage extends TablePage{

    @FindBy(xpath = "//ul[@id = 'submenu']//a[text() = 'Y']")
    private WebElement submenuY;

    @FindBy(xpath = "//table[@id = 'category']//a[starts-with(text(), 'Y')]")
    private List<WebElement> languageYList;

    public AbcPage(WebDriver driver) {
        super(driver);
    }

    public AbcPage clickYSubmenu() {
        click(submenuY);

        return new Y_SubmenuPage(getDriver());
    }

    public List<String> getYLanguagesNames() {

        return getListTextInLowerCase(languageYList);
    }
}
