package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.start.StartPage;
import utils.ReportUtils;
import utils.TestUtils;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private WebDriver driver;

    private String BASE_URL = TestUtils.getBaseUrl();

    @BeforeSuite
    protected void beforeSuite(ITestContext context) {

        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();
        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public StartPage openBaseURL() {
        getDriver().get(BASE_URL);

        return new StartPage(getDriver());
    }

    public String getExternalPageTitle() {

        return getDriver().getTitle();
    }

    public String getExternalPageURL() {

        return getDriver().getCurrentUrl();
    }
}
