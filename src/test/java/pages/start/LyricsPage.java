package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LyricsPage extends StartSubmenuPage {

    @FindBy(xpath = "//div[@id = 'main']/h2")
    private WebElement h2Header;

    @FindBy(xpath = "//div[@id = 'main']/p")
    private List<WebElement> pTags;

    @FindBy(xpath = "//a[@href='lyrics.html']")
    private WebElement lyricsLink;

    public LyricsPage(WebDriver driver) {
        super(driver);
    }

    public String getH2HeaderText() {

        return getText(h2Header);
    }

    public int getAmountOfPTags() {

        return getListSize(pTags);
    }

    public void clickLyricsLink() {
        click(lyricsLink);
    }

    public String getLyricsPageURL() {

        return getURL();
    }
}
