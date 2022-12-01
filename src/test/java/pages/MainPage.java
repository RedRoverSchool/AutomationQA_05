package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@id = 'menu']/li/a[@href = '/search.html']")
    private WebElement searchLanguagesMenu;

    @FindBy(xpath = "//div[@id = 'navigation']/ul[@id = 'menu']//li/a[@href = '/toplist.html']")
    private WebElement topListMenu;

    @FindBy(xpath = "//div[@id = 'main']/h2")
    private WebElement h2;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='info.html']")
    private WebElement infoSubMenuButton;

    @FindBy(xpath = "//ul[@id='menu']/li/a[@href='/abc.html']")
    private WebElement browseLanguagesMenu;

    @FindBy(xpath = "//div[@id = 'navigation']//a[@href = '/guestbookv2.html']")
    private WebElement guestbook;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchLanguagesMenu() {
        click(searchLanguagesMenu);

        return new SearchLanguagesPage(getDriver());
    }

    public TopListsPage clickTopListMenu() {
        click(topListMenu);

        return new TopListsPage(getDriver());
    }

    public String getTextH2() {

        return getText(h2);
    }

    public InfoSubmenuPage clickInfoSubmenuPage() {
        click(infoSubMenuButton);

        return new InfoSubmenuPage(getDriver());
    }

    public String getSubmenuInfoLink(String attribute)  {

        return getAttribute(infoSubMenuButton, attribute);
    }

    public ABCPage clickBrowseLanguagesMenu() {
        click(browseLanguagesMenu);

        return new ABCPage(getDriver());
    }
    public GuestBookV2Page clickGuestbook() {
        click(guestbook);

        return new GuestBookV2Page(getDriver());
    }
}
