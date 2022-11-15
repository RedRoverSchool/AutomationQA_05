import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class KseniyaKudrinaTest extends BaseTest {
    @Test
    public void testSearchForLanguageByName_HappyPath(){
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String LANGUAGE_PYTHON = "python";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href= '/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(
                By.name("search")
        );
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_PYTHON);

        WebElement goButton = getDriver().findElement(
                By.name("submitsearch")
        );
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id ='category']/tbody/tr/td[1]/a")
        );
        Assert.assertTrue(languagesNamesList.size() > 0);
        for(int i = 0; i <languagesNamesList.size(); i++){
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_PYTHON));
        }
    }
    @Test
    public void testConfirmThatAddCommentOnPage_HappyPath(){
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String CONFIRM_COMMENT = "Add Comment";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/abc.html']    ")
        );
        searchLanguagesMenu.click();

        WebElement searchLetterHSubMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'submenu']//li/a[@href = 'h.html']")
        );
        searchLetterHSubMenu.click();

        WebElement searchLanguageHeraOnTable = getDriver().findElement(
                By.xpath("//table[@id = 'category']/tbody/tr/td/a[contains(text(),'HERA')] ")
        );
        searchLanguageHeraOnTable.click();

        WebElement addCommentLink = getDriver().findElement(
                By.linkText("Write Comment")
        );
        addCommentLink.click();

        WebElement addCommentOnThePageField = getDriver().findElement(
                By.xpath("//div[@id  ='addcomments']/h2[text() = 'Add Comment']")
        );
        Assert.assertEquals(addCommentOnThePageField.getText(),CONFIRM_COMMENT);
    }
}
