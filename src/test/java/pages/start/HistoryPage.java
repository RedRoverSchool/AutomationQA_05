package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

public class HistoryPage extends MainPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[text() = 'History']")
    private WebElement historySubmenu;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public String getHref(String attribute) {

        return getAttribute(historySubmenu, "href");
    }
}
