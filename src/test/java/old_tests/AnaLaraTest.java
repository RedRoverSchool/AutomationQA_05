package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.List;

public class AnaLaraTest extends BaseTest {

    @Test
    public void testSearchLanguageField_HappyPath() {

        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(By.xpath("//ul[@id='menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a")
        );
        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }
        @Test
        public void testNavigationToLyricsSubmenu_HappyPath() {

            final String BASE_URL2 = "https://www.99-bottles-of-beer.net/";
            final String EXPECTED_URL = "https://www.99-bottles-of-beer.net/lyrics.html";

            getDriver().get(BASE_URL2);

            WebElement searchSongLyricsSubmenu = getDriver().findElement(By.xpath(
                    "//ul[@id='submenu']/li/a[@href='lyrics.html']")
            );
            searchSongLyricsSubmenu.click();

            String ACTUAL_URL = getDriver().getCurrentUrl();

            Assert.assertEquals(ACTUAL_URL, EXPECTED_URL);
        }
    }

