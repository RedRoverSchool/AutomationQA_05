package pages.top_lists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopHitsPage extends TopListsSubmenuPage {

    public TopHitsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@href ='language-shakespeare-664.html']")
    private WebElement shakespeareLink;

    public void clickShakespeareLink() {
        click(shakespeareLink);
    }

    public String getTopHitsPageURL() {

        return getURL();
    }
}
