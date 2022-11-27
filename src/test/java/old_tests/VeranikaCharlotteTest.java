package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;


public class VeranikaCharlotteTest extends BaseTest{
        final String BASE_URL="https://www.99-bottles-of-beer.net/";
        final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id='menu']/li/a[@href='/search.html']");
        final static By SEARCH_FOR_FIELD = By.name("search");
        final static By GO_BUTTON = By.name("submitsearch");
        final static By LANGUAGES_NAMES_LIST = (By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));
        private void openBaseURL(WebDriver driver){
        driver.get(BASE_URL);
        }
        private WebElement getElement(By by, WebDriver driver){

        return driver.findElement(by);
        }
        private List <WebElement> getListOfElements(By by, WebDriver driver){

                return driver.findElements(by);
        }
        private void click (By by, WebDriver driver){
                getElement(by,driver).click();
        }
        private void input (String text, By by, WebDriver driver){
                getElement(by,driver).sendKeys(text);
        }
        private int getListSize (By by, WebDriver driver) {
                return getListOfElements(by, driver).size();
        }
        private int getListSize (List <String> list) {
                return list.size();
        }
        private List <String> getElementsText(By by, WebDriver driver){
                List <WebElement> elementslist = getListOfElements(by,driver);
                List <String> textList = new ArrayList<>();

                for (WebElement element: elementslist){
                        textList.add(element.getText().toLowerCase());
                     //   int i = 0; i < elementslist.size(); i++){
                       // textList.add(elementslist.get(i).getText().toLowerCase());
                }

                return textList;
        }
        @Test
        public void testSearchForLanguageField_HappyPath(){
        final String LANGUAGE_NAME= "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size()>0);

        for(String languageName : languageNames) {
        Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
        }
@Test
        public void testGuestbookFooterLink_WhenClickingOnLink_HappyPath(){
        final String BASE_URL="https://www.99-bottles-of-beer.net/";
        final String expectedResult="[https://www.99-bottles-of-beer.net/guestbookv2.html](https://www.99-bottles-of-beer.net/guestbookv2.html)";

        getDriver().get(BASE_URL);
        WebElement GuestbookOnTheFooter = getDriver().findElement(
        By.xpath("//div[@id='footer']//a[@href='/guestbookv2.html']")
        );
        GuestbookOnTheFooter.click();

        String actualResult = getDriver().getCurrentUrl();
        }}










