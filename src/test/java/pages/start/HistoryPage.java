package pages.start;

import org.openqa.selenium.WebDriver;

public class HistoryPage extends StartSubmenuPage {

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public int countHistoryPageImages() {

        return getListSize(getImages());
    }
}
