package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongLyricsSubmenuPage extends MainPage {
    
    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='lyrics.html']")
    private WebElement SongLyricsSubmenuPageTitle;
    public SongLyricsSubmenuPage(WebDriver driver) { super(driver); }

    public static String getSongLyricsSubmenuUrl() {

        return LYRICS_URL;
    }
    public String getSongLyricsSubmenuLabelText() {

        return getText(SongLyricsSubmenuPageTitle);
    }
}
