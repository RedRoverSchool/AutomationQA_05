package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BPage extends BrowseLanguagesSubmenuPage {
    @FindBy(xpath = "//h2[normalize-space()='Category B']")
    private WebElement bCatagoryTitle;
    @FindBy(xpath = "//div[@id='main']/p[contains(text(),'All languages')]")
    private WebElement bCatagoryDescription;
    @FindBy(xpath = "//table[@id = 'category']//a[starts-with(text(), 'B')]")
    private List<WebElement> bList;


    @FindBy(xpath = "//a[@href ='language-bash-98.html']")
    private WebElement bashLanguageLink;

    public BPage(WebDriver driver) {
        super(driver);
    }

    public BashLanguagePage clickBashLanguageLink() {
        click(bashLanguageLink);

        return new BashLanguagePage(getDriver());
    }

    public WebElement getbCatagoryTitle() {

        return bCatagoryTitle;
    }

    public WebElement getbCatagoryDescription() {

        return bCatagoryDescription;
    }

    public List<String> getBLanguagesNames() {

        return getListTextInLowerCase(bList);
    }
}
