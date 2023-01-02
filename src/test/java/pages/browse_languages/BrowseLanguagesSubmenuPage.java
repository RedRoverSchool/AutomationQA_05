package pages.browse_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.browse_languages.letters.*;

import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage<ABCPage> {

    final static String LETTERS_SUBMENU_PATH = "//div[@id='navigation']/ul[@id='submenu']";

    final static String LETTERS_SUBMENU_PATH_HREF = LETTERS_SUBMENU_PATH + "/li/a[@href=";

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'0.html']")
    private WebElement zeroSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'a.html']")
    private WebElement aSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'b.html']")
    private WebElement bSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'c.html']")
    private WebElement cSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'d.html']")
    private WebElement dSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'e.html']")
    private WebElement eSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'f.html']")
    private WebElement fSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'g.html']")
    private WebElement gSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'h.html']")
    private WebElement hSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'i.html']")
    private WebElement iSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'j.html']")
    private WebElement jSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'k.html']")
    private WebElement kSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'l.html']")
    private WebElement lSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'m.html']")
    private WebElement mSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'n.html']")
    private WebElement nSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'o.html']")
    private WebElement oSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'p.html']")
    private WebElement pSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'q.html']")
    private WebElement qSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'r.html']")
    private WebElement rSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'s.html']")
    private WebElement sSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'t.html']")
    private WebElement tSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'u.html']")
    private WebElement uSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'v.html']")
    private WebElement vSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'w.html']")
    private WebElement wSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'x.html']")
    private WebElement xSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH_HREF + "'z.html']")
    private WebElement zSubmenu;

    @FindBy(xpath = LETTERS_SUBMENU_PATH + "/li")
    private List<WebElement> letters;

    @FindBy(xpath = LETTERS_SUBMENU_PATH + "/li/a[@href]")
    private List<WebElement> submenus;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected ABCPage createPage() {

        return new ABCPage(getDriver());
    }

    public List<WebElement> getSubmenus() {

        return submenus;
    }

    public List<String> getSubmenusNames() {

        return getListText(submenus);
    }

    public String getJHref() {

        return getAttribute(jSubmenu, "href");
    }

    public List<WebElement> getLetters() {

        return letters;
    }

    public String getTextSymbol(int index) {

        return getTextByIndex(index, submenus);
    }

    public String getHref(int index) {

        return getAttributeByIndex(index, submenus, "href");
    }

    public APage clickASubmenu() {
        click(aSubmenu);

        return new APage(getDriver());
    }

    public BPage clickBSubmenu() {
        click(bSubmenu);

        return new BPage(getDriver());
    }

    public CPage clickCSubmenu() {
        click(cSubmenu);

        return new CPage(getDriver());
    }

    public DPage clickDSubmenu() {
        click(dSubmenu);

        return new DPage(getDriver());
    }

    public EPage clickESubmenu() {
        click(eSubmenu);

        return new EPage(getDriver());
    }

    public FPage clickFSubmenu() {
        click(fSubmenu);

        return new FPage(getDriver());
    }

    public GPage clickGSubmenu() {
        click(gSubmenu);

        return new GPage(getDriver());
    }

    public JPage clickJSubmenu() {
        click(jSubmenu);

        return new JPage(getDriver());
    }

    public KPage clickKSubmenu() {
        click(kSubmenu);

        return new KPage(getDriver());
    }

    public LPage clickLSubmenu() {
        click(lSubmenu);

        return new LPage(getDriver());
    }

    public MPage clickMSubmenu() {
        click(mSubmenu);

        return new MPage(getDriver());
    }

    public NPage clickNSubmenu() {
        click(nSubmenu);

        return new NPage(getDriver());
    }

    public PPage clickPSubmenu() {
        click(pSubmenu);

        return new PPage(getDriver());
    }

    public SPage clickSSubmenu() {
        click(sSubmenu);

        return new SPage(getDriver());
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }

    public ZPage clickZSubmenu() {
        click(zSubmenu);

        return new ZPage(getDriver());
    }
}
