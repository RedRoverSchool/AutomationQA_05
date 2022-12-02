package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class FormPage extends GuestBookSubmenuPage{
    @FindBy (name = "name")
    WebElement name;

    @FindBy (name = "location")
    WebElement location;

    @FindBy (name = "email")
    WebElement email;

    @FindBy (name = "comment")
    WebElement message;

    @FindBy(xpath = "//a/img[@src = '/images/bb/bburl.gif']")
    WebElement urlIcon;

    @FindBy (name = "submit")
    WebElement submitButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void clickUrlIcon() {
        click(urlIcon);
    }
    }

