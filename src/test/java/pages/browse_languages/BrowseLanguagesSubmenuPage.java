package pages.browse_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.browse_languages.letters.*;

import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href='a.html']")
    private WebElement aSubmenu;

    @FindBy(xpath = "//a[@href='b.html']")
    private WebElement bSubmenu;

    @FindBy(xpath = "//a[@href='c.html']")
    private WebElement cSubmenu;

    @FindBy(xpath = "//a[@href='d.html']")
    private WebElement dSubmenu;

    @FindBy(xpath = "//a[@href='e.html']")
    private WebElement eSubmenu;

    @FindBy(xpath = "//a[@href='j.html']")
    private WebElement jSubmenu;

    @FindBy(xpath = "//a[@href='k.html']")
    private WebElement kSubmenu;

    @FindBy(xpath = "//a[@href='l.html']")
    private WebElement lSubmenu;

    @FindBy(xpath = "//a[@href='m.html']")
    private WebElement mSubmenu;

    @FindBy(xpath = "//a[@href='n.html']")
    private WebElement nSubmenu;

    @FindBy(xpath = "//a[@href='p.html']")
    private WebElement pSubmenu;

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = "//a[@href='z.html']")
    private WebElement zSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li")
    private List<WebElement> letters;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href]")
    private List<WebElement> submenu;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
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

    public void clickNSubmenu() {
        click(nSubmenu);
    }

    public PPage clickPSubmenu() {
        click(pSubmenu);

        return new PPage(getDriver());
    }

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }

    public ZPage clickZSubmenuButton() {
        click(zSubmenu);

        return new ZPage(getDriver());
    }

    public List<String> getSubmenusNames() {

        return getListText(submenu);
    }

    public String getHrefN() {

        return getAttribute(nSubmenu, "href");
    }

    public String getHrefJ() {

        return getAttribute(jSubmenu, "href");
    }
}
