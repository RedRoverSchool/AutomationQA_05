package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABCPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//a[@href ='b.html']")
    private WebElement searchBLink;

    @FindBy(xpath = "//a[@href ='language-bash-98.html']")
    private WebElement searchBashLink;

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement searchBashText;

    public ABCPage(WebDriver driver) {
        super(driver);
    }

    public ABCPage clickBLink() {
        click(searchBLink);

        return this;
    }

    public ABCPage clickBashLink() {
        click(searchBashLink);

        return this;
    }

    public String getTextBASH() {

        return getText(searchBashText);
    }
}