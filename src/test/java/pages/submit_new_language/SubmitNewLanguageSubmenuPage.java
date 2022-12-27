package pages.submit_new_language;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FormPage;

public abstract class SubmitNewLanguageSubmenuPage extends FormPage<SubmitNewLanguagePage> {

    public SubmitNewLanguageSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected SubmitNewLanguagePage createPage() {

        return new SubmitNewLanguagePage(getDriver());
    }
}
