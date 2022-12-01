package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuestBookV2Page extends GuestBookSubmenuPage {
    @FindBy(xpath = "//ul[@id = 'submenu']/li/a[@href = './signv2.html']")
    WebElement sign_Guestbook;

    @FindBy(xpath = "//ul[@id='menu']/li/a[@href= '/guestbookv2.html']")
    private WebElement goButtonGuestbookV2;

    public GuestBookV2Page(WebDriver driver) {
        super(driver);
    }
    
    public GuestBookV2Page clickButtonGuestbookV2() {
        click(goButtonGuestbookV2);

        return new GuestBookV2Page(getDriver());
        
        public SignV2Page clickSignGuestbook() {
        click(sign_Guestbook);

        return new SignV2Page(getDriver());
    }
}
