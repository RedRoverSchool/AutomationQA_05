package pages.top_lists;

import org.openqa.selenium.WebDriver;

public class TopRatedRealPage extends TopListsSubmenuPage {

    public TopRatedRealPage(WebDriver driver) {
        super(driver);
    }

    public String getMostRatedRealLanguage() {

        return getMostRatedLanguage();
    }
}
