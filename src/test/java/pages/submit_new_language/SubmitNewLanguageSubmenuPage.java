package pages.submit_new_language;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FormPage;

import java.util.List;

public abstract class SubmitNewLanguageSubmenuPage extends FormPage<SubmitNewLanguagePage> {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href]")
    private List<WebElement> submenus;

    @FindBy(xpath = "//ul[@id='submenu']/li")
    private List<WebElement> newLanguage;

    public SubmitNewLanguageSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected SubmitNewLanguagePage createPage() {

        return new SubmitNewLanguagePage(getDriver());
    }

    public List<WebElement> getSubmenus() {

        return submenus;
    }

    public String getTextSubmenu(int index) {

        return getTextByIndex(index, newLanguage);
    }

    public String getHref(int index) {

        return getAttributeByIndex(index, submenus, "href");
    }
}
