package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FormPage;

import java.util.List;

public abstract class GuestbookSubmenuPage extends FormPage<ReadGuestbookPage> {

    private static final String GUEST_BOOK_SUBMENU_PATH = "//ul[@id='submenu']/li/a";

    @FindBy(xpath = GUEST_BOOK_SUBMENU_PATH)
    private List<WebElement> guestbookSubmenus;

    @FindBy(xpath = GUEST_BOOK_SUBMENU_PATH + "[@href='./signv2.html']")
    private WebElement signGuestbook;

    @FindBy(xpath = GUEST_BOOK_SUBMENU_PATH + "[@href='./guestbookv2.html']")
    private WebElement readGuestbook;

    public GuestbookSubmenuPage(WebDriver driver) {
        super(driver);
    }

    protected ReadGuestbookPage createPage() {

        return new ReadGuestbookPage(getDriver());
    }

    public List<String> getGuestbookSubmenus() {

        return getListText(guestbookSubmenus);
    }

    public List<WebElement> getGuestbookSubmenusLinks() {

        return guestbookSubmenus;
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
