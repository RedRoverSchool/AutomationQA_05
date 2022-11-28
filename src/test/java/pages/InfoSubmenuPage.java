package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoSubmenuPage extends MainPage {

    private static final String INFO_URL = "https://www.99-bottles-of-beer.net/info.html";

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='info.html']")
    private WebElement InfoSubMenuPageTitle;

    public InfoSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public static String getInfoSubmenuUrl() {

        return INFO_URL;
    }

    public String getInfoSubMenuLabelText() {

        return getText(InfoSubMenuPageTitle);
    }
}
