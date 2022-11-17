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
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
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



