package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AlertPage extends FormPage {
    private final String textUrl= "http://my_text";

    public AlertPage(WebDriver driver) {
        super(driver);
    }
    public String getAlertText(WebDriverWait wait){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        return alert.getText();
    }

    public String getAlertText1(Alert alert){

        return alert.getText();
    }

    public void acceptAlert(WebDriverWait wait, String text){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
        alert.accept();
    }

    public void acceptAlert1(Alert alert, String text){
        alert.sendKeys(text);
        alert.accept();
        alert.accept();
    }
}
