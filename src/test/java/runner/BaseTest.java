package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

//    public StartPage openBaseURL() {
//        getDriver().get(BASE_URL);
//
//        return new StartPage(getDriver());
//    }
//
//    public String getExternalPageTitle() {
//
//        return getDriver().getTitle();
//    }
//
//    public String getExternalPageURL() {
//
//        return getDriver().getCurrentUrl();
//    }
}
