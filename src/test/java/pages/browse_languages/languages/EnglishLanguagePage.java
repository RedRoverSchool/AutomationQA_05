package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.submit_new_language.SubmitNewLanguagePage;

public class EnglishLanguagePage extends LanguagePage {

    public EnglishLanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@href='#addcomment']")
    private WebElement writeComment;

    @FindBy(xpath = "//div[@id='addcomments']//a[@href='/submitnewlanguage.html']")
    private WebElement formLink;

    public EnglishLanguagePage clickWriteComment() {
        click(writeComment);

        return this;
    }

    public SubmitNewLanguagePage clickFormLink() {
        click(formLink);

        return new SubmitNewLanguagePage(getDriver());
    }
}
