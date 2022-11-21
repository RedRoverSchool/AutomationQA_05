import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class KseniyaKudrinaTest extends BaseTest {

    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href= '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id ='category']/tbody/tr/td[1]/a");

    private void openBaseURL(WebDriver driver){
        driver.get(BASE_URL);
    }
    private WebElement getElement(By by, WebDriver driver){

        return driver.findElement(by);
    }
    private List<WebElement> getListOfElements(By by, WebDriver driver){

        return driver.findElements(by);
    }
    private void click(By by, WebDriver driver){
        getElement(by,driver).click();
    }
    private void input(String text, By by, WebDriver driver){
        getElement(by, driver).sendKeys(text);
    }
    private int getListSize(By by, WebDriver driver){

        return getListOfElements(by,driver).size();
    }
    private int getListSize(List <String> list){

        return list.size();
    }
    private List<String> getElementsText(By by, WebDriver driver){
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for(WebElement element : elementsList){
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {
        final String LANGUAGE_PYTHON = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_PYTHON, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_PYTHON));
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
    @Test
    public void testConfirmNewTitleOfPagePiet_HappyPath() {
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String CONFIRM_TITLE = "DM's Esoteric Programming Languages - Piet";

        getDriver().get(BASE_URL);
        WebElement topListMenu = getDriver().findElement(
                By.xpath("//ul[@id = 'menu']//li/a[@href = '/toplist.html']   ")
        );
        topListMenu.click();

        WebElement languagePietTable = getDriver().findElement(
                By.xpath("//table[@id = 'category']/tbody//tr/td/a[contains(text(),'Piet')]")
        );
        languagePietTable.click();

        WebElement infoLanguagePietLink = getDriver().findElement(
                By.xpath("//div[@id = 'main']/table/tbody//tr//td/a[@href = 'http://www.dangermouse.net/esoteric/piet.html']")
        );
        infoLanguagePietLink.click();

        Assert.assertEquals(getDriver().getTitle(),CONFIRM_TITLE);
    }
}
