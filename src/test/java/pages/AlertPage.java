package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AlertPage extends FormPage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertText(WebDriverWait wait){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        return alert.getText();
    }

    public String getAlertText(Alert alert){

        return alert.getText();
    }

    public void acceptAlert(WebDriverWait wait, String text){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
        alert.accept();
    }

    public void acceptAlert(Alert alert, String text){
        alert.sendKeys(text);
        alert.accept();
        alert.accept();
    }
}
