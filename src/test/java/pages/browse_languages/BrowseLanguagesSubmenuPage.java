package pages.browse_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.browse_languages.letters.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href = 'a.html']")
    private WebElement aSubmenu;

    @FindBy(xpath = "//a[@href='b.html']")
    private WebElement bSubmenu;

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = "//a[@href='p.html']")
    private WebElement pSubmenu;

    @FindBy(xpath = "//a[@href='j.html']")
    private WebElement jSubmenu;

    @FindBy(xpath = "//a[@href='n.html']")
    private WebElement nSubmenu;

    @FindBy(xpath = "//a[@href='c.html']")
    private WebElement cSubmenu;

    @FindBy(xpath = "//a[@href='d.html']")
    private WebElement dSubmenu;

    @FindBy(xpath = "//a[@href='m.html']")
    private WebElement mSubmenu;

    @FindBy(xpath = "//a[@href='k.html']")
    private WebElement kSubmenu;

    @FindBy(xpath = "//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href]")
    private List<WebElement> symbolsInSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']/li//a[contains(text(), 'Z')]")
    private WebElement ZSubmenu;

    @FindBy(xpath = "//a[@href = 'l.html']")
    private WebElement lSubmenu;

    @FindBy(xpath = "//a[@href = 'e.html']")
    private WebElement eSubmenu;

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

    public YPage clickYSubmenu() {
        click(ySubmenu);

        return new YPage(getDriver());
    }

    public PPage clickPSubmenu() {
        click(pSubmenu);

        return new PPage(getDriver());
    }

    public JPage clickJSubmenu() {
        click(jSubmenu);

        return new JPage(getDriver());
    }

    public NPage clickNSubmenu() {
        click(nSubmenu);

        return new NPage(getDriver());
    }

    public String getNSubmenu() {

        return getText(nSubmenu);
    }

    public CPage clickCSubmenu() {
        click(cSubmenu);

        return new CPage(getDriver());
    }

    public DPage clickDSubmenu() {
        click(dSubmenu);

        return new DPage(getDriver());
    }

    public MPage clickMSubmenu() {
        click(mSubmenu);

        return new MPage(getDriver());
    }

    public KPage clickKSubmenu() {
        click(kSubmenu);

        return new KPage(getDriver());
    }

    public EPage clickESubmenu() {
        click(eSubmenu);

        return new EPage(getDriver());
    }

    public ZPage clickZSubmenuButton() {
        click(ZSubmenu);

        return new ZPage(getDriver());
    }

    public List<String> getListSymbolsInSubmenu() {

        return getListText(symbolsInSubmenu);
    }

    public String getLinkBySymbol(String symbol) {
        int indexOfSymbol = getListSymbolsInSubmenu().indexOf(symbol);
        if (getListSize(symbolsInSubmenu) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : symbolsInSubmenu) {
                textList.add(element.getAttribute("href"));
            }

            return textList.get(indexOfSymbol);
        }

        return null;
    }

    public LPage clickLSubmenu() {
        click(lSubmenu);

        return new LPage(getDriver());
    }

    public String getHrefN(String attribute) {

        return getAttribute(nSubmenu, "href");
    }

    public Boolean clickSymdolSubmenuTrue() {
        String beforURL = getURL();
        if (getListSize(symbolsInSubmenu) > 0) {
            for (int i = 0; i < symbolsInSubmenu.size(); i++)
                symbolsInSubmenu.get(i).click();
                String afterURL = getURL();
                if (!beforURL.equals(afterURL)) {

                    return true;
                } else {

                    return false;
                }
        }

        return false;
    }
    public String getHrefJ(String attribute) {

        return getAttribute(jSubmenu, "href");
    }
}