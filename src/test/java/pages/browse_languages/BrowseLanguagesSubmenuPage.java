package pages.browse_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.browse_languages.letters.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

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

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
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

    public BrowseLanguagesSubmenuPage clickOnSymdolOnSubmenu(String text) {
        if (getListSize(symbolsInSubmenu) > 0) {
            for(WebElement element : symbolsInSubmenu)
                if(element.getAttribute("innerText").contains(text)) {
                    click(element);
                    break;
                }
            switch (text) {
                case "0-9":
                    return new ZeroPage(getDriver());
                case "A":
                    return new APage(getDriver());
                case "B":
                    return new BPage(getDriver());
                case "C":
                    return new CPage(getDriver());
                case "D":
                    return new DPage(getDriver());
                case "E":
                    return new EPage(getDriver());
                case "F":
                    return new FPage(getDriver());
                case "G":
                    return new GPage(getDriver());
                case "H":
                    return new HPage(getDriver());
                case "I":
                    return new IPage(getDriver());
                case "J":
                    return new JPage(getDriver());
                case "K":
                    return new KPage(getDriver());
                case "L":
                    return new LPage(getDriver());
                case "M":
                    return new MPage(getDriver());
                case "N":
                    return new NPage(getDriver());
                case "O":
                    return new OPage(getDriver());
                case "P":
                    return new PPage(getDriver());
                case "Q":
                    return new QPage(getDriver());
                case "R":
                    return new RPage(getDriver());
                case "S":
                    return new SPage(getDriver());
                case "T":
                    return new TPage(getDriver());
                case "U":
                    return new UPage(getDriver());
                case "V":
                    return new VPage(getDriver());
                case "W":
                    return new WPage(getDriver());
                case "X":
                    return new XPage(getDriver());
                case "Y":
                    return new YPage(getDriver());
                case "Z":
                    return new ZPage(getDriver());
                default:
                    return null;
            }
        }
        return null;
    }
}
