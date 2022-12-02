package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy(xpath = "//a[@href='b.html']")
    private WebElement bSubmenu;

    @FindBy(xpath = "//a[@href='y.html']")
    private WebElement ySubmenu;

    @FindBy(xpath = "//ul[@id='submenu']//a[@href='p.html']")
    private WebElement pSubmenu;

    @FindBy(xpath = "//ul[@id='submenu']//a[@href='j.html']")
    private WebElement jSubmenu;

    @FindBy(xpath = "//div[@id='navigation']/ul/li/a[@href='n.html']")
    private WebElement nSubmenu;

    @FindBy(xpath = "//a[@href='c.html']")
    private WebElement cSubmenu;

    @FindBy(xpath = "//div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href]")
    private List<WebElement> symbolInSubmenu;

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

    public String getNSubmenuLinkText() {

        return getText(nSubmenu);
    }

    public CPage clickCSubmenu() {
        click(cSubmenu);

        return new CPage(getDriver());
    }

    public List<String> getListSymbolsInSubmenu() {

        return getListText(symbolInSubmenu);
    }

    public String getLinkBySymbol(String symbol) {
        int indexOfSymbol = getListSymbolsInSubmenu().indexOf(symbol);
        if (getListSize(symbolInSubmenu) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : symbolInSubmenu) {
                textList.add(element.getAttribute("href"));
            }

            return textList.get(indexOfSymbol);
        }

        return null;
    }
}
