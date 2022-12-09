package pages.top_lists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;

import java.util.List;

public abstract class TopListsSubmenuPage extends TablePage {

    @FindBy(xpath = "//ul[@id = 'submenu']//a[@href = './toplist_real.html']")
    private WebElement topRatedRealSubmenu;

    @FindBy(xpath = "//ul[@id = 'submenu']//a[@href ='./toplist_esoteric.html']")
    private WebElement topRatedEsotericSubmenu;

    @FindBy(xpath = "//div[@id = 'navigation']/ul[@id = 'submenu']//li/a[@href = './newcomments.html']")
    private WebElement newCommentsSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a")
    private List<WebElement> topListSubmenus;

    @FindBy(xpath = "//ul[@id = 'submenu']//a[@href ='./toplist.html']")
    private WebElement topHitsSubmenu;

    public TopListsSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public TopListRealPage clickTopRatedRealSubmenu() {
        click(topRatedRealSubmenu);

        return new TopListRealPage(getDriver());
    }

    public TopListEsotericPage clickTopRatedEsotericSubmenu() {
        click(topRatedEsotericSubmenu);

        return new TopListEsotericPage(getDriver());
    }

    public NewCommentsPage clickNewCommentsSubmenu() {
        click(newCommentsSubmenu);

        return new NewCommentsPage(getDriver());
    }

    public List<String> getSubmenusTexts() {

        return getListText(topListSubmenus);
    }

    public TopHitsPage clickTopHitsSubmenu() {
        click(topHitsSubmenu);

        return new TopHitsPage(getDriver());
    }
}
