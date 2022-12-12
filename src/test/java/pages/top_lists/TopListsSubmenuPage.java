package pages.top_lists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base_abstract.TablePage;

import java.util.ArrayList;
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

    public TopListsSubmenuPage clickTopListsSubmenuLinks(){
        ArrayList<String> subMenuListLinks = new ArrayList<String>();

        List<String> expectedSubmenuH2HeaderTexts = new ArrayList<>();
        expectedSubmenuH2HeaderTexts.add("Top Rated");
        expectedSubmenuH2HeaderTexts.add("Top Rated Real Languages");
        expectedSubmenuH2HeaderTexts.add("Top Rated Esoteric Languages");
        expectedSubmenuH2HeaderTexts.add("Top Rated Assembly Languages");
        expectedSubmenuH2HeaderTexts.add("Top Hits");
        expectedSubmenuH2HeaderTexts.add("New Languages this month");
        expectedSubmenuH2HeaderTexts.add("New Comments");
        
        
        
        TopListsPage topListsPage = new TopListsPage(getDriver());

        for (WebElement topSubMenu : topListSubmenus) {

            System.out.println(topSubMenu.getText()); // used to get text present between the anchor tags
            System.out.println(topSubMenu.getAttribute("href"));
            subMenuListLinks.add(topSubMenu.getAttribute("href"));
            System.out.println("*************************************");
        }

        for (String subMenuLink : subMenuListLinks) {
            getDriver().navigate().to(subMenuLink);
            String actualSubmenuText = topListsPage.getH2HeaderText();
            for (int i = 0; i < expectedSubmenuH2HeaderTexts.size(); i++) {
                Assert.assertEquals(expectedSubmenuH2HeaderTexts.get(i),actualSubmenuText );
            }
          //  Assert
        //    System.out.println((++i)+": navigated to URL with subMenuLink: "+subMenuLink);
        }

        return this;
    }
}
