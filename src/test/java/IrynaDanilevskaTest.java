import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;
import java.util.Locale;

public class IrynaDanilevskaTest extends BaseTest {

    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

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

        WebElement browseLanguageMenu = getDriver().findElement(
                By.xpath("//div[@id='navigation']/ul//a[@href='/abc.html']")
        );
        browseLanguageMenu.click();

        WebElement submenuElementLettersNumbers = getDriver().findElement(
                By.xpath(String.format("//ul[@id='submenu']//a[@href='%s.html']", LETTER))
        );
        submenuElementLettersNumbers.click();

        WebElement categoryByLetter = getDriver().findElement(
                By.xpath(String.format("//h2[normalize-space()='Category %s']", LETTER.toUpperCase()))
        );
        Assert.assertTrue(categoryByLetter.getText().toLowerCase().endsWith(LETTER));

        WebElement textWithSelectedLetter = getDriver().findElement(
                By.xpath(String.format("//strong[normalize-space()='%s']", LETTER.toUpperCase()))
        );
        Assert.assertTrue(textWithSelectedLetter.getText().toLowerCase().contains(LETTER));

        List<WebElement> languageListByLetter = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertFalse(languageListByLetter.isEmpty());

        for (WebElement webElement : languageListByLetter) {
            Assert.assertTrue(webElement.getText().toLowerCase().startsWith(LETTER));
        }
    }
}



