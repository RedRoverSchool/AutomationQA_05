package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FormPage;

import java.util.List;

public abstract class GuestBookSubmenuPage extends FormPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a")
    private List<WebElement> guestbookSubmenuButtons;

    public GuestBookSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getGuestbookSubmenuButtonsText() {

        return getListText(guestbookSubmenuButtons);
    }
}
