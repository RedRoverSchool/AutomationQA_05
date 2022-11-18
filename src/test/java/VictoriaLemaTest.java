import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class VictoriaLemaTest extends BaseTest {

    static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_NAME = "python";

        getDriver().get(BASE_URL);

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href = '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNameList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );

        Assert.assertTrue(languagesNameList.size() > 0);

        for (int i = 0; i < languagesNameList.size(); i++) {
            Assert.assertTrue(languagesNameList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testIfTopListsReferenceOnTheFooterMenuRedirectsToTheTopListPage_WhenClickingOnIt() {
        String expectedResult = "https://www.99-bottles-of-beer.net/toplist.html";

        getDriver().get(BASE_URL);
        WebElement topListsOnTheFooter = getDriver().findElement(
                By.xpath("//div[@id='footer']/p/a[@href='/toplist.html']")
        );
        topListsOnTheFooter.click();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testIfToplistsFooterMenRedirectsToPageWithInformation_WhenClickingOnIt() {
        final int TOP_LANGUAGES_MINIMAL_QUANTITY = 2;
        getDriver().get(BASE_URL);
        WebElement topListsOnTheFooter = getDriver().findElement(
                By.xpath("//div[@id='footer']/p/a[@href='/toplist.html']")
        );
        topListsOnTheFooter.click();

        List <WebElement> topRatedLanguagesNames = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[2]")
        );

        Assert.assertTrue(topRatedLanguagesNames.size()>0);

        Assert.assertTrue(topRatedLanguagesNames.size()>=TOP_LANGUAGES_MINIMAL_QUANTITY);
    }

    @Test
    public void testLanguageCategories_WhenSubmittingANewLanguage() {
        final int expectedResultNumber = 3;
        final String category1 = "real";
        final String category2 = "esoteric";
        final String category3 = "assembly";
        final String expectedResultCategory = "esoteric language";

        getDriver().get(BASE_URL);
        WebElement submitNewLanguageReference = getDriver().findElement(
                By.xpath("//div[@id='footer']/p/a[@href='/submitnewlanguage.html']")
        );
        submitNewLanguageReference.click();

        WebElement categoryField = getDriver().findElement(
                By.xpath("//form[@id='addlanguage']/p/select[@name='category']")
        );
        categoryField.click();

        String categoryName = getDriver().findElement(By.xpath("//select[@name='category']")).getText();
        List <WebElement> languagesCategories = getDriver().findElements(
                By.xpath("//form[@id='addlanguage']/p/select[@name='category']/option")
        );
        Assert.assertTrue(languagesCategories.size()>0);

        WebElement esotericLanguage = getDriver().findElement(
                By.xpath("//form[@id='addlanguage']/p/select[@name='category']/"
                        + "option[text()='esoteric language']")
        );
        esotericLanguage.click();

        WebElement submitLanguageButton = getDriver().findElement(
                By.xpath("//input[@type='submit'][@name='submitlanguage']")
        );
        submitLanguageButton.click();

        String actualResultCategory = getDriver().findElement(
                By.xpath("//select[@name='category']/option[@selected]")).getText();

        Assert.assertEquals(languagesCategories.size(),expectedResultNumber);
        Assert.assertTrue(categoryName.contains(category1)&& categoryName.contains(category2)
                &&categoryName.contains(category3));
        Assert.assertEquals(actualResultCategory,expectedResultCategory);
    }
}

