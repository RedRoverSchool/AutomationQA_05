package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ABCPage extends BrowseLanguagesSubmenuPage {
    @FindBy(xpath = "//ul[@id='submenu']/li")
    private List<WebElement> letters;

    @FindBy(xpath = "//div[@id ='main']/h2[contains(text(), 'A')]")
    private WebElement h2Header;

    public ABCPage(WebDriver driver) {
        super(driver);
    }

    public ABCPage clickBrowseLanguagesSubmenuLetter(int i) throws InterruptedException {
        click(letters.get(i));

        return this;
    }
    
 }