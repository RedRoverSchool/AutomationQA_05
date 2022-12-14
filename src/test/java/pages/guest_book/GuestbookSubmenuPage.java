package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FormPage;

import java.util.List;

public abstract class GuestbookSubmenuPage extends FormPage {

    @FindBy(xpath = "//ul[@id='submenu']/li/a")
    private List<WebElement> guestbookSubmenus;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='./signv2.html']")
    private WebElement signGuestbook;

    @FindBy(xpath = "//ul[@id='submenu']/li/a[@href='./guestbookv2.html']")
    private WebElement readGuestbook;

    public GuestbookSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getGuestbookSubmenus() {

        return getListText(guestbookSubmenus);
    }

    public ReadGuestbookPage clickReadGuestbookSubmenu() {
        click(readGuestbook);

        return new ReadGuestbookPage(getDriver());
    }

    public SignGuestbookPage clickSignGuestbookSubmenu() {
        click(signGuestbook);

        return new SignGuestbookPage(getDriver());
    }
}
