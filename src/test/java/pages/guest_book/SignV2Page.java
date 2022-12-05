package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignV2Page extends GuestBookSubmenuPage {

    @FindBy(xpath = "//div [@id = 'main']/p")
    private WebElement errorMessage;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "location")
    private WebElement location;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "comment")
    private WebElement message;

    @FindBy(xpath = "//a/img[@src = '/images/bb/bburl.gif']")
    private WebElement urlIcon;

    @FindBy(name = "submit")
    private WebElement submitButton;


    public SignV2Page(WebDriver driver) {
        super(driver);
    }

    public SignV2Page inputName(String text){
        input( text, name );

        return this;
    }

    public SignV2Page inputMessage(String text){
        input( text, message);

        return this;
    }
    public SignV2Page inputEmail(String text){
        input( text, email);

        return this;
    }

    public SignV2Page clickSubmitButton(){
        click(submitButton);

        return this;
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }
}
