package pages.top_lists;

import org.openqa.selenium.WebDriver;

public class TopListRealPage extends TopListsSubmenuPage {

    public TopListRealPage(WebDriver driver) {
        super(driver);
    }

    public String getMostRatedRealLanguage() {

        return getMostRatedLanguage();
    }

    public String getH2HeaderColor() {

        return getH2Header().getCssValue("color");
    }
}
