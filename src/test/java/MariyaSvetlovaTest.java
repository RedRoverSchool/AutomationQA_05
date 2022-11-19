import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class MariyaSvetlovaTest extends BaseTest {

    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testVerifyHeaderH1OnStartPage() {
        final String HEADER_H1 = "99 Bottles of Beer";

        getDriver().get(BASE_URL);

        WebElement headerH1 = getDriver().findElement(
                By.xpath("//div[@id='header']/h1")
        );

        Assert.assertEquals(headerH1.getText(),HEADER_H1);
    }

    @Test
    public void testVerifyHeaderH2OnStartPage() {
        final String HEADER_H2 = "one program in 1500 variations";

        getDriver().get(BASE_URL);

        WebElement headerH1 = getDriver().findElement(
                By.xpath("//div[@id='header']/h2")
        );

        Assert.assertEquals(headerH1.getText(),HEADER_H2);
    }
}
