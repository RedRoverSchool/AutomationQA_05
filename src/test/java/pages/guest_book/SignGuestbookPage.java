package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignGuestbookPage extends GuestbookSubmenuPage {

    @FindBy(name = "location")
    private WebElement location;

    @FindBy(name = "comment")
    private WebElement message;

    @FindBy(xpath = "//a/img[@src='/images/bb/bburl.gif']")
    private WebElement urlIcon;

    @FindBy(name = "submit")
    private WebElement submitButton;

    public SignGuestbookPage(WebDriver driver) {
        super(driver);
    }

    public void inputMessage(String text) {
        input(text, message);
    }

    public SignGuestbookPage clickSubmitButton() {
        click(submitButton);

        return this;
    }
}
