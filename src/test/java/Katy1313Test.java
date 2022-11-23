import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Katy1313Test extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

       return driver.findElement(by);
    }

    private List<WebElement> getListOfElements (By by, WebDriver driver) {
        return driver.findElements(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }

    private int getListSize(List<String> list) {

        return list.size();
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elementsList) {
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    @Test
    public void testSearchLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD,getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());
        int sizeOfLangNamesList = getListSize(getElementsText(LANGUAGES_NAMES_LIST, getDriver()));

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
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

   @Test
    public void testBrowseLanguagesLanguageSelectionH2HeaderTitle_HappyPath() {
       final String BASE_URL = "https://www.99-bottles-of-beer.net/";
       final String LETTER = "j";
       final String LANGUAGE_NAME = "Java";
       final String EXPECTED_RESULT_H2_TITLE = "Language Java";

       getDriver().get(BASE_URL);
       WebElement browseLanguagesMenu = getDriver().findElement(By.xpath("//ul[@id = 'menu']//a[@href = '/abc.html']"));
       browseLanguagesMenu.click();

       WebElement categoryLetter = getDriver().findElement(
               By.xpath("//ul[@id='submenu']//a[@href='"+ LETTER +".html']"));
       categoryLetter.click();

       WebElement languageName = getDriver().findElement(
               By.xpath("//table[@id='category']//td/a[text() = '"+ LANGUAGE_NAME +"']"));
       languageName.click();

       WebElement h2HeaderTitle = getDriver().findElement(By.xpath("//h2[text() = 'Language "+ LANGUAGE_NAME +"']"));

       Assert.assertEquals(h2HeaderTitle.getText(), EXPECTED_RESULT_H2_TITLE);
   }
}
