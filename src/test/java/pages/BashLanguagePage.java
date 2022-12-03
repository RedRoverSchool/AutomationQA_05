package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BashLanguagePage extends BasePage {

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement bashLanguageHeader;

    @FindBy(xpath = "//div[@id='voting']/p[2]/a")
    private List<WebElement> bashLanguageBookmarkingList;

    public BashLanguagePage(WebDriver driver) {
        super(driver);
    }

    public String getBashLanguageHeader() {

        return getText(bashLanguageHeader);
    }

    public List<WebElement> getBashLanguageBookmarking() {

        return getListIfActive(bashLanguageBookmarkingList);
    }
}
