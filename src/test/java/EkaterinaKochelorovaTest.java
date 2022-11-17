import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class EkaterinaKochelorovaTest extends BaseTest {

    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testH2TagText_WhenChooseSubmenuLyrics() {
        String expectedResult = "Lyrics of the song 99 Bottles of Beer";

        getDriver().get(BASE_URL);

        WebElement submenuLyricsLink = getDriver().findElement(
                By.xpath("//ul[@id = 'submenu']/li/a[@href = 'lyrics.html']")
        );
        submenuLyricsLink.click();

        WebElement h2TagText = getDriver().findElement(By.xpath("//div[@id = 'main']/h2"));

        String actualResult = h2TagText.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
