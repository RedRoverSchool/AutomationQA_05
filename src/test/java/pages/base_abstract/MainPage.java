package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.letters.ABCPage;
import pages.guest_book.ReadGuestbookPage;
import pages.search_languages.SearchLanguagesPage;
import pages.start.StartPage;
import pages.submit_new_language.SubmitNewLanguagePage;
import pages.top_lists.TopListsPage;

import java.util.List;

public abstract class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='header']/h1")
    private WebElement h1LogoHeader;

    @FindBy(xpath = "//div[@id='header']/h2")
    private WebElement h2LogoHeader;

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header;

    @FindBy(xpath = "//div[@id='main']/h3")
    private List<WebElement> h3Header;

    final static String TOP_MENU_PATH = "//ul[@id='menu']/li/a[@href=";

    @FindBy(xpath = TOP_MENU_PATH + "'/']")
    private WebElement startMenu;

    @FindBy(xpath = TOP_MENU_PATH + "'/abc.html']")
    private WebElement browseLanguagesMenu;

    @FindBy(xpath = TOP_MENU_PATH + "'/search.html']")
    private WebElement searchLanguagesMenu;

    @FindBy(xpath = TOP_MENU_PATH + "'/toplist.html']")
    private WebElement topListsMenu;

    @FindBy(xpath = TOP_MENU_PATH + "'/guestbookv2.html']")
    private WebElement guestBookMenu;

    @FindBy(xpath = TOP_MENU_PATH + "'/submitnewlanguage.html']")
    private WebElement submitNewLanguageMenu;

    @FindBy (xpath = "//ul[@id='menu']//li")
    private List<WebElement> menuLinks;

    final static String FOOTER_MENU_PATH = "//div[@id='footer']/p/a[@href=";

    @FindBy(xpath = FOOTER_MENU_PATH + "'/']")
    private WebElement startFooterMenu;

    @FindBy(xpath = FOOTER_MENU_PATH + "'/abc.html']")
    private WebElement browseLanguagesFooterMenu;

    @FindBy(xpath = FOOTER_MENU_PATH + "'/search.html']")
    private WebElement searchLanguagesFooterMenu;

    @FindBy(xpath = FOOTER_MENU_PATH + "'/toplist.html']")
    private WebElement topListFooterMenu;

    @FindBy(xpath = FOOTER_MENU_PATH + "'/guestbookv2.html']")
    private WebElement guestBookFooterMenu;

    @FindBy(xpath = FOOTER_MENU_PATH + "'/submitnewlanguage.html']")
    private WebElement submitNewLanguageFooterMenu;

    @FindBy(tagName = "a")
    private List<WebElement> links;

    @FindBy(tagName = "img")
    private List<WebElement> images;

    @FindBy(id = "main")
    private WebElement mainBody;

    @FindBy(xpath = "//div[@id='main']//p[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//div[@id = 'main']/p")
    private List<WebElement> pTags;

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

    public List<String> getH3HeadersTexts() {

        return getListText(h3Header);
    }

    public WebElement getH2Header() {

        return h2Header;
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

    public ReadGuestbookPage clickGuestbookMenu() {
        click(guestBookMenu);

        return new ReadGuestbookPage(getDriver());
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

    public ReadGuestbookPage clickGuestBookFooterMenu() {
        click(guestBookFooterMenu);

        return new ReadGuestbookPage(getDriver());
    }

    public SubmitNewLanguagePage clickSubmitNewLanguageFooterMenu() {
        click(submitNewLanguageFooterMenu);

        return new SubmitNewLanguagePage(getDriver());
    }

    public List<String> getMenuLinksTextInLowerCase() {

        return getListTextInLowerCase(menuLinks);
    }

    public int getMenuLinksSize() {

        return getListSize(menuLinks);
    }

    public List<WebElement> getLinks() {

        return links;
    }

    public String getPageContext() {

        return mainBody.getText();
    }

    public List<WebElement> getImages() {

        return images;
    }

    public String getFirstParagraphText(){

        return getText(firstParagraph);
    }

    public String getHref(WebElement element) {

        return getAttribute(element, "href");
    }

    public int countParagraphs() {

        return getListSize(pTags);
    }
}