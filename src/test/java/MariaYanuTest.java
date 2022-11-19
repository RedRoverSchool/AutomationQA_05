import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class MariaYanuTest extends BaseTest {
    @Test
    public void testHeaderOnTheStartPage() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String START_URL = "https://www.99-bottles-of-beer.net/";
        final String HEADER_TEXT = "Welcome to 99 Bottles of Beer";

        getDriver().get(BASE_URL);

        WebElement startLink = getDriver().findElement(
                By.xpath("//div[@id='navigation']//a[text()='Start']")
        );
        startLink.click();

        Assert.assertEquals(getDriver().getCurrentUrl(),START_URL);

        WebElement header = getDriver().findElement(
                By.xpath("//div[@id='main']//h2")
        );

        Assert.assertEquals(header.getText(), HEADER_TEXT);
    }
}
