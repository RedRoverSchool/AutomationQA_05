package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class TopListsSubmenuPage extends TablePage {

    @FindBy(xpath = "//div[@id = 'navigation']/ul[@id = 'submenu']//li/a[@href = './newcomments.html']")
    private WebElement newCommentsSubmenu;

    @FindBy(xpath = "//ul[@id = 'submenu']//a[@href = './toplist_real.html']")
    private WebElement topRatedRealSubMenu;

    public TopListsSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public NewCommentsPage clickNewCommentsSubmenuMenu() {
        click(newCommentsSubmenu);

        return new NewCommentsPage(getDriver());
    }
    public TopListRealPage clickTopRatedRealSubmenuMenu() {
        click(topRatedRealSubMenu);

        return new TopListRealPage(getDriver());
    }
}
