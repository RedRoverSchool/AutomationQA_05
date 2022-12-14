package pages.top_lists;

import org.openqa.selenium.WebDriver;

public class TopRatedEsotericPage extends TopListsSubmenuPage {

    public TopRatedEsotericPage(WebDriver driver) {
        super(driver);
    }

    public String getMostRatedEsotericLanguage() {

        return getMostRatedLanguage();
    }
}
