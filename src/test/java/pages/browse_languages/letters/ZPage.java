package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.ZimLanguagePage;

import java.util.List;

public class ZPage extends LetterPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[@bgcolor='#efefef']/a")
    private List<WebElement> zList;
    @FindBy(xpath = "//a[@href = 'language-zim-718.html']")
    private WebElement zimLink;

    public ZPage(WebDriver driver) { super(driver); }

    public List<String> getZLanguagesNames() {

        return getListTextInLowerCase(zList);
    }
    public void  clickZimLink() {
        click(zimLink);
    }
    public String getZPageURL() {

        return getURL();
    }
}
