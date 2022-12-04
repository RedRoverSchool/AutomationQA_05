package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

public class HistoryPage extends MainPage {

    private static final String INFO_URL = "https://www.99-bottles-of-beer.net/info.html";

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='info.html']")
    private WebElement InfoSubMenuPageTitle;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public static String getInfoSubmenuUrl() {

        return INFO_URL;
    }

    public String getInfoSubMenuLabelText() {

        return getText(InfoSubMenuPageTitle);
    }
}
