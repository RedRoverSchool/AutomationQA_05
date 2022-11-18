import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class AramH20Test extends BaseTest {

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id=\"menu\"]/li/a[@href='/search.html']"));
        searchLanguagesMenu.click();

        WebElement searchForeField = getDriver().findElement(By.name("search"));
        searchForeField.click();
        searchForeField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id=\"category\"]/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }


    final static String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static String URL_KEY_VALUE = "guest";
    private void click(By by, WebDriver driver){
        driver.findElement(by).click();
    }
    @Test
    public void test_MainFooterGuestBookv2(){
        getDriver().get(BASE_URL);
        By Menu_Guestbook = By.xpath("//ul[@id='menu']/li[5]/a");//
        click(Menu_Guestbook, getDriver());
        Assert.assertTrue(getDriver().getCurrentUrl().toLowerCase().contains(URL_KEY_VALUE));
    }
}
