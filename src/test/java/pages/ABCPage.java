package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABCPage extends BrowseLanguagesSubmenuPage {

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement textCategoryA;

    @FindBy(xpath = "//div[@id ='main']/h2[contains(text(), 'A')]")
    private WebElement h2Header;

    public ABCPage(WebDriver driver) {
        super(driver);
    }

    public String getTextH2() {

        return textCategoryA.getText();
    }

    public String getH2Header() {

        return getText(h2Header);
    }
}