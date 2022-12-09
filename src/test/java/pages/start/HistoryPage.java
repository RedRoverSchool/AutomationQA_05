package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

import java.util.List;

public class HistoryPage extends StartSubmenuPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='info.html']")
    private WebElement historySubmenu;

    @FindBy(xpath = "//div[@id='main']//p[1]")
    private WebElement regularText;

    @FindBy(xpath = "//div[@id='main']//a/img[@src]")
    private List<WebElement> imagesHistoryPage;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public String getHref(String attribute) {

        return getAttribute(historySubmenu, "href");
    }
    public String getRegularText(){

        return getText(regularText);
    }

    public String getHistorySubmenuText() {

        return historySubmenu.getText();
    }

    public int countHistoryPageImages() {

        return getListSize(imagesHistoryPage);
    }
}
