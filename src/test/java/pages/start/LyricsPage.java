package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LyricsPage extends StartSubmenuPage {

    @FindBy(xpath = "//div[@id='main']/p")
    private List<WebElement> pTags;

    public LyricsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSongLyrics() {

        return getListText(pTags);
    }
}
