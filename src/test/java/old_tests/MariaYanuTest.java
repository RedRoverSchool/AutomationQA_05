package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class MariaYanuTest extends BaseTest {
    final String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final String START_URL = "https://www.99-bottles-of-beer.net/";
    final String HEADER_TEXT = "Welcome to 99 Bottles of Beer";
    final int AMOUNT_HEADER_LINKS = 6;
    final String[] TEXT_OF_HEADER_LINKS = {"Start", "Browse Languages", "Search Languages", "Top Lists", "Guestbook", "Submit new Language"};
    final static By START_LINK = By.xpath("//div[@id='navigation']//a[text()='Start']");
    final static By HEADER = By.xpath("//div[@id='main']//h2");
    final static By HEADER_LINKS = By.xpath("//ul[@id='menu']//li");

    public void openBaseUrl(WebDriver driver) {
        getDriver().get(BASE_URL);
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    public String getElementText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }

    public List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    public int getSizeListOfElements(By by){

        return getListOfElements(by, getDriver()).size();
    }

    public List<String> getTextListOfElements(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by,driver);
        List<String> textElements = new ArrayList<>();

        for(WebElement element : elementsList) {
            textElements.add(element.getText().toLowerCase());
        }

        return textElements;
    }

    @Test
    public void testHeaderOnTheStartPage_HappyPath() {

        openBaseUrl(getDriver());
        click(START_LINK);

        Assert.assertEquals(getDriver().getCurrentUrl(),START_URL);

        String currentHeader = getElementText(HEADER, getDriver());

        Assert.assertEquals(currentHeader, HEADER_TEXT);
    }

    @Test
    public void testNavigationMenuLinksAmountAndText() {

        openBaseUrl(getDriver());

        int amountOfHeaderLinks = getSizeListOfElements(HEADER_LINKS);

        Assert.assertTrue(amountOfHeaderLinks > 0);
        Assert.assertEquals(amountOfHeaderLinks,AMOUNT_HEADER_LINKS);

        List<String> textOfHeaderLinks = getTextListOfElements(HEADER_LINKS, getDriver());

        for (int i = 0; i < TEXT_OF_HEADER_LINKS.length; i++){

            Assert.assertEquals(textOfHeaderLinks.get(i), TEXT_OF_HEADER_LINKS[i].toLowerCase());
        }

    }
}
