package pages.top_lists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopHitsPage extends TopListsSubmenuPage {

    //   @FindBy (xpath = "//table[@id = 'category']//a[@href ='language-shakespeare-664.html']")
    @FindBy (xpath = "//table[@id = 'category']//a[text() = 'Shakespeare']")
    private WebElement shakespeareLink;

    @FindBy (xpath = "//table[@id = 'category']//a[@href = 'language-whitespace-154.html']")
    private WebElement whitespaceLink;

    public TopHitsPage(WebDriver driver) {
        super(driver);
    }

    public void clickShakespeareLink() {
        click(shakespeareLink);
    }

    public void clickWhitespaceLink() {
        click(whitespaceLink);
    }

    public String getTopHitsPageURL() {

        return getURL();
    }
}
