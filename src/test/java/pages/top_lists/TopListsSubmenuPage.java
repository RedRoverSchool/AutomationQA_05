package pages.top_lists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.start.StartPage;

import java.util.List;

public abstract class TopListsSubmenuPage extends TablePage<TopRatedPage> {

    final static String TOP_LISTS_PATH = "//ul[@id='submenu']//a[@href=";

    @FindBy(xpath = TOP_LISTS_PATH + "'./toplist_real.html']")
    private WebElement topRatedRealSubmenu;

    @FindBy(xpath = TOP_LISTS_PATH + "'./toplist_esoteric.html']")
    private WebElement topRatedEsotericSubmenu;

    @FindBy(xpath = TOP_LISTS_PATH + "'./newcomments.html']")
    private WebElement newCommentsSubmenu;

    @FindBy(xpath = TOP_LISTS_PATH + "'./tophits.html']")
    private WebElement topHitsSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a")
    private List<WebElement> topListSubmenus;

    @FindBy(xpath = "//ul[@id = 'submenu']//a[@href='./toplist_assembly.html']")
    private WebElement topRatedAssembly;

    public TopListsSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected TopRatedPage createGeneric() {

        return new TopRatedPage(getDriver());
    }

    public List<String> getSubmenusTexts() {

        return getListText(topListSubmenus);
    }

    public String getHref() {

        return getAttribute(topRatedRealSubmenu, "href");
    }

    public TopRatedRealPage clickTopRatedRealSubmenu() {
        click(topRatedRealSubmenu);

        return new TopRatedRealPage(getDriver());
    }

    public TopRatedEsotericPage clickTopRatedEsotericSubmenu() {
        click(topRatedEsotericSubmenu);

        return new TopRatedEsotericPage(getDriver());
    }

    public NewCommentsPage clickNewCommentsSubmenu() {
        click(newCommentsSubmenu);

        return new NewCommentsPage(getDriver());
    }

    public TopHitsPage clickTopHitsSubmenu() {
        click(topHitsSubmenu);

        return new TopHitsPage(getDriver());
    }

    public TopRatedAssemblyPage clickTopRatedAssemblyPageSubmenu() {
        click(topRatedAssembly);

        return new TopRatedAssemblyPage(getDriver());
    }

    public String getTopListAssemblyPageURL() {
        return getURL();
    }

}
