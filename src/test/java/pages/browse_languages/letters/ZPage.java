package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZPage extends LetterPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[@bgcolor='#efefef']/a")
    private List<WebElement> zList;

    public ZPage(WebDriver driver) { super(driver); }

    public List<String> getZLanguagesNames() {

        return getListTextInLowerCase(zList);
    }
}
