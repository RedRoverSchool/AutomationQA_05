package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import java.util.List;


public class MaxIasko99Test extends BaseTest {
    final static String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGE_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FIELD_SEARCH = By.name("search");
    final static By SEARCH_SUBMIT = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    final static By SEARCH_ABC_LINK_FOOTER = By.xpath("//a[@href='/abc.html']");
    final static By SEARCH_B_LINK = By.xpath("//a[@href ='b.html']");
    final static By SEARCH_BASH_LINK = By.xpath("//a[@href='language-bash-1815.html']");
    final static By SEARCH_BASH_TEXT = By.xpath("//div[@id='main']/h2");

    private void click(By by) {
        getDriver().findElement(by).click();
    }

    private void sendKeys(By by, String Keys) {
        WebElement searchForField = getDriver().findElement(SEARCH_FIELD_SEARCH);
        searchForField.click();
        searchForField.sendKeys(Keys);
    }

    @Test
    public void testSearchForLanguage_HappyPath() {
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        click(SEARCH_LANGUAGE_MENU);
        sendKeys(SEARCH_FIELD_SEARCH, LANGUAGE_NAME);
        click(SEARCH_SUBMIT);

        List<WebElement> languagesNamesList = getDriver().findElements(LANGUAGES_NAMES_LIST);

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (WebElement webElement : languagesNamesList) {
            Assert.assertTrue(webElement.getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyingFooterChoosingLanguage_HappyPath() {
        final String LANGUAGE_NAME = "BASH";

        getDriver().get(BASE_URL);

        click(SEARCH_ABC_LINK_FOOTER);
        click(SEARCH_B_LINK);
        click(SEARCH_BASH_LINK);

        WebElement name = getDriver().findElement(SEARCH_BASH_TEXT);

        Assert.assertTrue(name.getText().contains(LANGUAGE_NAME));
    }
}
