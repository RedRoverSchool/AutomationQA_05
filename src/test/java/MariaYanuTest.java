import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class MariaYanuTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final String START_URL = "https://www.99-bottles-of-beer.net/";
    final String HEADER_TEXT = "Welcome to 99 Bottles of Beer";
    final static By START_LINK = By.xpath("//div[@id='navigation']//a[text()='Start']");
    final static By HEADER = By.xpath("//div[@id='main']//h2");

    public void openBaseUrl(WebDriver driver) {
        getDriver().get(BASE_URL);
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    public String getElementText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }
    @Test
    public void testHeaderOnTheStartPage_HappyPath() {

        openBaseUrl(getDriver());
        click(START_LINK);

        Assert.assertEquals(getDriver().getCurrentUrl(),START_URL);

        String currentHeader = getElementText(HEADER, getDriver());

        Assert.assertEquals(currentHeader, HEADER_TEXT);
    }
}
