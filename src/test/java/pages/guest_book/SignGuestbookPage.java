package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignGuestbookPage extends GuestbookSubmenuPage {

    @FindBy(xpath = "//div[@id='main']/p")
    private WebElement errorMessage;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "location")
    private WebElement location;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "comment")
    private WebElement message;

    @FindBy(xpath = "//a/img[@src='/images/bb/bburl.gif']")
    private WebElement urlIcon;

    @FindBy(name = "submit")
    private WebElement submitButton;

    public SignGuestbookPage(WebDriver driver) {
        super(driver);
    }

    public SignGuestbookPage inputName(String text){
        input(text, name);

        return this;
    }

    public SignGuestbookPage inputMessage(String text){
        input(text, message);

        return this;
    }
    public SignGuestbookPage inputEmail(String text){
        input(text, email);

        return this;
    }

    public SignGuestbookPage clickSubmitButton(){
        click(submitButton);

        return this;
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }
}
