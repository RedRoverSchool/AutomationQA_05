package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ABCTest extends BaseTest {

    @Test
    public void test_ABCVerifyByLetterCategoryInformation() throws InterruptedException {

        List<WebElement> submenuLetters =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getSubmenuLettersElement();

        List<String> culumlanguagesNames =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getSubmenuLettersLowerCase();

        for(int i = 1; i < submenuLetters.size(); i++) {
            List<String> languages =
                    openBaseURL()
                            .clickBrowseLanguagesMenu()
                            .getColumLanguageList(submenuLetters.get(i));

            for (String language : languages) {
                Assert.assertEquals(String.valueOf(language.charAt(0)), culumlanguagesNames.get(i));
            }
        }
    }
}

    @Test
    public void testABCPageURL() {
        String expectedURL = "https://www.99-bottles-of-beer.net/abc.html";

        String actualPageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .getExternalPageURL();
        Assert.assertEquals(actualPageURL, expectedURL);
    } 
    
    @Test
    public void testDefaultHeaderForABCPage() {
        String expectedH2Header = "Category A";

        String actualH2Header = openBaseURL()
                .clickBrowseLanguagesMenu()
                .getH2Header();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }
}

