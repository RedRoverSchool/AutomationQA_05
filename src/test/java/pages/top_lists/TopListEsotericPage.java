package pages.top_lists;

import org.openqa.selenium.WebDriver;

public class TopListEsotericPage extends TopListsSubmenuPage {

    public TopListEsotericPage(WebDriver driver) {
        super(driver);
    }

    public String getMostRatedEsotericLanguage() {

        return getMostRatedLanguage();
    }
}
