package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartPage extends StartSubmenuPage  {

    @FindBy(xpath = "//div[@id = 'main']/descendant-or-self::p")
    private WebElement verifyText;


    public String getTeamWishes () {

        return getText(verifyText);
    }



    public StartPage(WebDriver driver) {
        super(driver);
    }


}

