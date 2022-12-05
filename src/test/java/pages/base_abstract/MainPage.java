package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.letters.ABCPage;
import pages.guest_book.GuestBookV2Page;
import pages.search_languages.SearchLanguagesPage;
import pages.start.StartPage;
import pages.submit_new_language.SubmitNewLanguagePage;
import pages.top_lists.TopListsPage;

public abstract class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='header']/h1")
    private WebElement h1LogoHeader;

    @FindBy(xpath = "//div[@id='header']/h2")
    private WebElement h2LogoHeader;

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header;


    @FindBy(xpath = "//ul[@id='menu']/li/a[@href='/']")
    private WebElement startMenu;

    @FindBy(xpath = "//ul[@id='menu']/li/a[@href='/abc.html']")
    private WebElement browseLanguagesMenu;

    @FindBy(xpath = "//ul[@id = 'menu']/li/a[@href = '/search.html']")
    private WebElement searchLanguagesMenu;

    @FindBy(xpath = "//ul[@id = 'menu']/li/a[@href = '/toplist.html']")
    private WebElement topListsMenu;

    @FindBy(xpath = "//ul[@id = 'menu']/li/a[@href = '/guestbookv2.html']")
    private WebElement guestBookMenu;

    @FindBy(xpath = "//ul[@id= 'menu']/li/a[@href='/submitnewlanguage.html']")
    private WebElement submitNewLanguageMenu;


    @FindBy(xpath = "//div[@id='footer']/p/a[@href='/']")
    private WebElement startFooterMenu;

    @FindBy(xpath = "//div[@id='footer']/p/a[@href='/abc.html']")
    private WebElement browseLanguagesFooterMenu;

    @FindBy(xpath = "//div[@id='footer']/p/a[@href='/search.html']")
    private WebElement searchLanguagesFooterMenu;

    @FindBy(xpath = "//div[@id='footer']/p/a[@href='/toplist.html']")
    private WebElement topListFooterMenu;

    @FindBy(xpath = "//div[@id='footer']/p/a[@href='/guestbookv2.html']")
    private WebElement guestBookFooterMenu;

    @FindBy(xpath = "//div[@id='footer']/p/a[@href='/submitnewlanguage.html']")
    private WebElement submitNewLanguageFooterMenu;

    @FindBy(xpath = "//div[@id = 'header']/h2")
    private WebElement headerH2;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getH1LogoHeaderText() {

        return getText(h1LogoHeader);
    }

    public String getH2LogoHeaderText() {

        return getText(h2LogoHeader);
    }

    public String getH2HeaderText() {

        return getText(h2Header);
    }

    public StartPage clickStartMenu() {
        click(startMenu);

        return new StartPage(getDriver());
    }

    public ABCPage clickBrowseLanguagesMenu() {
        click(browseLanguagesMenu);

        return new ABCPage(getDriver());
    }

    public SearchLanguagesPage clickSearchLanguagesMenu() {
        click(searchLanguagesMenu);

        return new SearchLanguagesPage(getDriver());
    }

    public TopListsPage clickTopListsMenu() {
        click(topListsMenu);

        return new TopListsPage(getDriver());
    }

    public GuestBookV2Page clickGuestbookMenu() {
        click(guestBookMenu);

        return new GuestBookV2Page(getDriver());
    }

    public SubmitNewLanguagePage clickSubmitNewLanguageMenu() {
        click(submitNewLanguageMenu);

        return new SubmitNewLanguagePage(getDriver());
    }

    public StartPage clickStartFooterMenu() {
        click(startFooterMenu);

        return new StartPage(getDriver());
    }

    public ABCPage clickBrowseLanguagesFooterMenu() {
        click(browseLanguagesFooterMenu);

        return new ABCPage(getDriver());
    }

    public SearchLanguagesPage clickSearchLanguagesFooterMenu() {
        click(searchLanguagesFooterMenu);

        return new SearchLanguagesPage(getDriver());
    }

    public TopListsPage clickTopListFooterMenu() {
        click(topListFooterMenu);

        return new TopListsPage(getDriver());
    }

    public GuestBookV2Page clickGuestBookFooterMenu() {
        click(guestBookFooterMenu);

        return new GuestBookV2Page(getDriver());
    }

    public SubmitNewLanguagePage clickSubmitNewLanguageFooterMenu() {
        click(submitNewLanguageFooterMenu);

        return new SubmitNewLanguagePage(getDriver());
    }
}