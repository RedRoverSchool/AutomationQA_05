import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class EkaterinaLizinaTest extends BaseTest {
    final static String BASE_URL = "http://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href ='/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table [@id = 'category']/tbody/tr/td[1]/a");
    private void openBaseURL(WebDriver driver){
       driver.get(BASE_URL);
    }
    private void click(By by, WebDriver driver){
        getElement(by, driver).click();
    }
    public void input(String text, By by, WebDriver driver){
        getElement(by, driver).sendKeys(text);
    }
    private WebElement getElement (By by, WebDriver driver){

        return driver.findElement(by);
    }
    private List<WebElement> getListOfElements (By by, WebDriver driver){

        return driver.findElements(by);
    }
    private int getListSize(By by, WebDriver driver){

        return getListOfElements(by, driver).size();
    }
    private int getListSize(List<String> list){

        return list.size();
    }
    @Ignore
    private List<String> getElementsText1(By by, WebDriver driver){
       List <WebElement> elementsList = getListOfElements(by, driver);
       // пересохраняем во временную переменную
        // т.к мы будем проходить по каждому эл-у. Мы берем лист, его И-тый эл-т
        // и c каждого эл-та считали текст и нам нужно его сохранить куда-то
        // мы сохраним его в лист Стринговый
        //ArrayList - для него не нужет четкий размер
        //мы используем метод .add и он складывает в ячейку textList
        // инфо из каждого эл-та из листа elementsList
       List<String> textList = new ArrayList<>();
//        for(int i = 0; i < elementsList.size(); i++){
//            textList.add(elementsList.get(i).getText().toLowerCase());
//        }

        for(WebElement element : elementsList){
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }
    private List<String> getElementsText(By by, WebDriver driver){
        List <WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();

        for(WebElement element : elementsList){
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath(){
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME,SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST,getDriver());

        int sizeOfLanguagesNamesList = getListSize(languageNames);

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }
    @Ignore
    @Test
    public void testSearchForLanguageByNameComments_HappyPath(){
        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME,SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());
        //мы считали все
        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST,getDriver());

        int sizeOfLanguagesNamesList = getListSize(languageNames);

        Assert.assertTrue(languageNames.size() > 0);
        //в каждом languageName мы сравниваем есть ли в нем LANGUAGE_NAME (Python)
        for (String languageName : languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }
}
