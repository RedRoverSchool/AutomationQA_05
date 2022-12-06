package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends StartSubmenuPage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'main']/p[1]")
    private WebElement verifyText;

    public String getTeamWishes () {

        return getText(verifyText);
    }

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header1;

    public String getH2() {

        return getText(h2Header1);
    }
}
