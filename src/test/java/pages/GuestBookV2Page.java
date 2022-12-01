package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuestBookV2Page extends GuestBookSubmenuPage {
    @FindBy(xpath = "//ul[@id = 'submenu']/li/a[@href = './signv2.html']")
    WebElement sign_Guestbook;

    public GuestBookV2Page(WebDriver driver) {
        super(driver);
    }
    public SignV2Page clickSignGuestbook() {
        click(sign_Guestbook);

        return new SignV2Page(getDriver());
    }
}
