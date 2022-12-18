package pages.submit_new_language;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FormPage;
import pages.start.StartPage;

public abstract class SubmitNewLanguageSubmenuPage extends FormPage<SubmitNewLanguagePage> {

    public SubmitNewLanguageSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected SubmitNewLanguagePage createGeneric() {

        return new SubmitNewLanguagePage(getDriver());
    }
}
