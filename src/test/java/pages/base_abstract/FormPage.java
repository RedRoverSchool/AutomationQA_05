package pages.base_abstract;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class FormPage<GenericType> extends MainPage<GenericType> {

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(xpath = "//div[@id='main']/p")
    private WebElement errorMessage;

    @FindBy(xpath = "//a/img[@src='/images/bb/bburl.gif']")
    WebElement urlIcon;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void inputName(String text) {
        input(text, name);
    }

    public GenericType inputEmail(String text) {
        input(text, email);

        return createPage();
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }

    public void clickUrlIcon() {
        click(urlIcon);
    }

    public String getAlertText(Alert alert) {

        return alert.getText();
    }

    public void acceptAlert(Alert alert, String text) {
        alert.sendKeys(text);
        alert.accept();
        alert.accept();
    }
}
