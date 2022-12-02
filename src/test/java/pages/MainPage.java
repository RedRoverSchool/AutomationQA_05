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

    @FindBy(xpath = "//ul[@id= 'menu']//li/a[@href='/submitnewlanguage.html']")
    private WebElement submitNewLanguageMenu;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='lyrics.html']")
    private WebElement songLyricsSubmenuButton;

    @FindBy(xpath = "//ul[@id='menu']/li/a[@href='/']")
    private WebElement startMenu;

     @FindBy(xpath = "//div[@id = 'navigation']//a[@href = '/guestbookv2.html']")
    private WebElement guestbook;

    @FindBy(xpath = "//div[@id = 'footer']/p/a[@href='/abc.html']")
    private WebElement browseLanguagesFooterMenu;

    @FindBy(xpath = "//ul[@id= 'menu']//li/a[@href='/toplist.html']")
    private WebElement topListsMenu;

    @FindBy(xpath = "//div[@id='header']/h1")
    private WebElement h1Header;

    @FindBy(xpath = "//div[@id='header']/h2")
    private WebElement h2Header;

    @FindBy(xpath = "//ul[@id='submenu']/li//a[contains(text(), 'Z')]")
    private WebElement ZSubmenuButton;

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

    public SubmitNewLanguagePage clickSubmitNewLanguageMenu() {
        click(submitNewLanguageMenu);

        return new SubmitNewLanguagePage(getDriver());
    }

    public SongLyricsSubmenuPage clickSongLyricsSubmenuButton() {
        click(songLyricsSubmenuButton);

        return new SongLyricsSubmenuPage(getDriver());
    }

    public StartPage clickStartMenu() {
        click(startMenu);

        return new StartPage(getDriver());
    }

    public TopListsPage clickTopListsMenu() {
        click(topListsMenu);

        return new TopListsPage(getDriver());
    }
    
    public ABCPage clickBrowseLanguagesFooterMenu() {
        click(browseLanguagesFooterMenu);

        return new ABCPage(getDriver());
    }

    public GuestBookV2Page clickGuestbook() {
        click(guestbook);

        return new GuestBookV2Page(getDriver());
    }

        public String getSongLyricsSubmenuText () {

            return getText(songLyricsSubmenuButton);
        }

        public String getH1HeaderText () {

            return getText(h1Header);
        }

        public String getH2HeaderText () {

            return getText(h2Header);
        }

        public ZPage clickZSubmenuButton () {
            click(ZSubmenuButton);

            return new ZPage(getDriver());
        }
    }