package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.Collections;
import java.util.List;

public class NatalyaYanochkovaTest extends BaseTest{
    @Test
    public void testSearchLanguageFieldByName_HappyPath(){
        final String BASE_URL = "https://www.99-bottles-of-beer.net/";
        final String Language_Python = "python";

        getDriver().get(BASE_URL);
        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//*[@id=\"menu\"]/li[3]/a")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(Language_Python);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNameList = Collections.singletonList(getDriver().findElement(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")));

        Assert.assertTrue(languagesNameList.size()>0);

        for(int i=0; i<languagesNameList.size(); i++){
            Assert.assertTrue(languagesNameList.get(i).getText().toLowerCase().contains(Language_Python));
        }
    }
}
