import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Katy1313Test extends BaseTest {

    @Test
    public void testSearchLanguageByName_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

        Assert.assertTrue(languagesNamesList.size() > 0);

        for (int i = 0; i < languagesNamesList.size(); i++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

   @Test
    public void testBrowseLanguagesDefaultValue_HappyPath() {
       final String BASE_URL = "https://www.99-bottles-of-beer.net/";
       final String BROWSE_LANGUAGES_DEFAULT_VALUE = "Category A";

       getDriver().get(BASE_URL);
       WebElement browseLanguagesMenu = getDriver().findElement(By.xpath("//ul[@id = 'menu']//a[@href = '/abc.html']"));
       browseLanguagesMenu.click();

       WebElement h2Category = getDriver().findElement(By.xpath("//div[@id ='main']/h2[contains(text(), 'A')]"));
       Assert.assertEquals(h2Category.getText(), BROWSE_LANGUAGES_DEFAULT_VALUE);
   }

   @Test
    public void testBrowseLanguagesLanguagesSortedAscending_HappyPath()  {
       final String BASE_URL = "https://www.99-bottles-of-beer.net/";

       getDriver().get(BASE_URL);
       WebElement browseLanguagesMenu = getDriver().findElement(By.xpath("//ul[@id = 'menu']//a[@href = '/abc.html']"));
       browseLanguagesMenu.click();

       WebElement categoryLetter = getDriver().findElement(By.xpath("//ul[@id='submenu']//a[@href='p.html']"));
       categoryLetter.click();

       List<String> displayed = new ArrayList<String>();
       List<String> sorted = new ArrayList<String>();
       List<WebElement> languagesNamesListDisplayed = getDriver().findElements(By.xpath("//table[@id='category']/tbody//a"));

       Assert.assertTrue(languagesNamesListDisplayed.size() > 0);

       for (int i = 0; i < languagesNamesListDisplayed.size(); i++) {
          String listOfElements;
          listOfElements = languagesNamesListDisplayed.get(i).getText().toLowerCase();
          displayed.add(listOfElements);
          sorted.add(listOfElements);
       }

       Collections.sort(sorted);
       Assert.assertEquals(displayed,sorted);
   }
}
