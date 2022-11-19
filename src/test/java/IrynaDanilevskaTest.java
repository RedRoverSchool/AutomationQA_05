import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class IrynaDanilevskaTest extends BaseTest {

    private final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final By BROWSE_LANGUAGE_MENU = By.xpath("//div[@id='navigation']/ul//a[@href='/abc.html']");
    final By SEARCH_LANGUAGE_MENU = By.xpath("//ul[@id='menu']/li/a[@href='/search.html']");
    final By GO_BUTTON = By.name("submitsearch");

    private void clickOnElement(By by, WebDriver driver) {
        driver.findElement(by).click();
    }
    private void clickOnElement(WebElement webElement) {
        webElement.click();
    }
    private WebElement getSubmenuElementLettersNumbers(String letter, WebDriver driver) {
        return driver.findElement(
                By.xpath(String.format("//ul[@id='submenu']//a[@href='%s.html']", letter)));
    }
    private void clickAndEnterInputIntoField(WebDriver driver, String text) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.click();
        searchInput.sendKeys(text);
    }
    private WebElement getCategoryByLetter(String letter, WebDriver driver) {
        return driver.findElement(
                By.xpath(String.format("//h2[normalize-space()='Category %s']", letter.toUpperCase())));
    }
    private WebElement getTextWithSelectedLetter(String letter, WebDriver driver) {
        return driver.findElement(
                By.xpath(String.format("//strong[normalize-space()='%s']", letter.toUpperCase())));
    }
    private List<WebElement> getListOfLanguages(WebDriver driver) {
        return driver.findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));
    }


    @Test
    public void testSearchLanguageField_HappyPath() {
       String languageName = "python";

        getDriver().get(BASE_URL);
        clickOnElement(SEARCH_LANGUAGE_MENU, getDriver());
        clickAndEnterInputIntoField(getDriver(), languageName);
        clickOnElement(GO_BUTTON, getDriver());

        List<WebElement> languageListByName = getListOfLanguages(getDriver());

        Assert.assertFalse(languageListByName.isEmpty());

        for (int i = 0; i < languageListByName.size(); i++) {
            Assert.assertTrue(languageListByName.get(i).getText().toLowerCase().contains(languageName));
        }
    }

    @Test
    public void testSortingLanguagesByLetter_AfterSelectingLetterInSubmenu_HappyPath() {
        final String LETTER = "b";

        getDriver().get(BASE_URL);
        clickOnElement(BROWSE_LANGUAGE_MENU, getDriver());

        clickOnElement(getSubmenuElementLettersNumbers(LETTER, getDriver()));

        WebElement categoryByLetter = getCategoryByLetter(LETTER, getDriver());
        Assert.assertTrue(categoryByLetter.getText().toLowerCase().endsWith(LETTER));

        WebElement textWithSelectedLetter = getTextWithSelectedLetter(LETTER, getDriver());
        Assert.assertTrue(textWithSelectedLetter.getText().toLowerCase().contains(LETTER));

        List<WebElement> languageListByLetter = getListOfLanguages(getDriver());

        Assert.assertFalse(languageListByLetter.isEmpty());

        for (WebElement webElement : languageListByLetter) {
            Assert.assertTrue(webElement.getText().toLowerCase().startsWith(LETTER));
        }
    }

    @Test
    public void testDefaultStateOfABCPage_AfterNavigatingOnPage_HappyPath() {
        final String DEFAULT_LETTER = "a";

        getDriver().get(BASE_URL);

        WebElement browseLanguageMenu = getDriver().findElement(
                By.xpath("//div[@id='navigation']/ul//a[@href='/abc.html']")
        );
        browseLanguageMenu.click();

        WebElement categoryByDefaultLetter = getDriver().findElement(
                By.xpath(String.format("//h2[normalize-space()='Category %s']", DEFAULT_LETTER.toUpperCase()))
        );
        Assert.assertTrue(categoryByDefaultLetter.getText().toLowerCase().endsWith(DEFAULT_LETTER));

        WebElement textWithDefaultLetter = getDriver().findElement(
                By.xpath(String.format("//strong[normalize-space()='%s']", DEFAULT_LETTER.toUpperCase()))
        );
        Assert.assertTrue(textWithDefaultLetter.getText().toLowerCase().contains(DEFAULT_LETTER));

        List<WebElement> languageListByDefaultLetter = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );
        Assert.assertFalse(languageListByDefaultLetter.isEmpty());

        for (WebElement webElement : languageListByDefaultLetter) {
            Assert.assertTrue(webElement.getText().toLowerCase().startsWith(DEFAULT_LETTER));
        }
    }
}



