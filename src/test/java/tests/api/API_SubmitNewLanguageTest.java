package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.submit_new_language.SubmitNewLanguagePage;

import java.util.List;

public class API_SubmitNewLanguageTest extends BaseTest {
    final static String ACTION = "submitnewlanguage.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "language";
    final static String NAME_INPUT_2 = "descriptor";
    final static String NAME_INPUT_3 = "url";
    final static String NAME_INPUT_4 = "author";
    final static String NAME_INPUT_5 = "email";
    final static String NAME_INPUT_6 = "homepage";
    final static String NAME_INPUT_7 = "captcha";
    final static String NAME_SELECT_1 = "category";
    final static String NAME_TEXTAREA_1 = "code";
    final static String NAME_TEXTAREA_2 = "teammsg";
    final static String VALUE_INPUT_8 = "Submit Language";
    final static String HTTPS = "=https%3A%2F%2F&";
    final static String PAYLOAD = NAME_INPUT_1 + "=&" + NAME_INPUT_2 + "=&" + NAME_INPUT_3
            + HTTPS + NAME_INPUT_4 + "=&" + NAME_INPUT_5 + "=&"
            + NAME_INPUT_6 + HTTPS + NAME_INPUT_7 + "=&" + NAME_SELECT_1
            + "=1&" + NAME_TEXTAREA_1 + "=&" + NAME_TEXTAREA_2 + "=&"
            + VALUE_INPUT_8.toLowerCase().replace(" ","")
            + "=Submit+Language";
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Language Name:\n\n"
            + "Description:(optional, used to distinguish your example from other entries of the same language)\n\n"
            + "Where can we find information about this language? (optional)\n\n"
            + "Author:\n\n"
            + "E-Mail: (Will never be shown)\n\n"
            + "Homepage (optional):\n\n"
            + "Security Code:\n" + "  " + "\n"
            + "Category:\n"
            + "real language\n"
            + "esoteric language\n"
            + "assembly language\n\n"
            + "Code:\n\n"
            + "Message to the team (optional):";

    @Test (priority = -5)
    public void testDefaultValues() {

        SubmitNewLanguagePage submitNewLanguagePage =
                openBaseURL().clickSubmitNewLanguageFooterMenu();

        Assert.assertEquals(submitNewLanguagePage.getAction(), getBaseUrl() + ACTION );
        Assert.assertEquals(submitNewLanguagePage.getMethod(),METHOD);
        Assert.assertEquals(submitNewLanguagePage.getInput1Name(), NAME_INPUT_1);
        Assert.assertEquals(submitNewLanguagePage.getInput2Name(), NAME_INPUT_2);
        Assert.assertEquals(submitNewLanguagePage.getInput3Name(), NAME_INPUT_3);
        Assert.assertEquals(submitNewLanguagePage.getInput4Name(), NAME_INPUT_4);
        Assert.assertEquals(submitNewLanguagePage.getInput5Name(), NAME_INPUT_5);
        Assert.assertEquals(submitNewLanguagePage.getInput6Name(), NAME_INPUT_6);
        Assert.assertEquals(submitNewLanguagePage.getInput7Name(), NAME_INPUT_7);
        Assert.assertEquals(submitNewLanguagePage.getSelect1Name(), NAME_SELECT_1);
        Assert.assertEquals(submitNewLanguagePage.getTextarea1Name(),NAME_TEXTAREA_1);
        Assert.assertEquals(submitNewLanguagePage.getTextarea2Name(),NAME_TEXTAREA_2);
        Assert.assertEquals(submitNewLanguagePage.getInput8Value(), VALUE_INPUT_8);
        Assert.assertEquals(submitNewLanguagePage.getFormText(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test (priority = -4)
    public void test_API_HttpRequest_GET() {
        final String EXPECTED_METHOD = "GET";
        final String EXPECTED_END_POINT = "submitnewlanguage.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(EXPECTED_END_POINT, EXPECTED_METHOD);

        openBaseURL().clickSubmitNewLanguageFooterMenu();

        Assert.assertEquals(httpRequest.get(0), EXPECTED_METHOD);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + EXPECTED_END_POINT);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test (dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String EXPECTED_STATUS_CODE = "200";
        final String EXPECTED_STATUS_TEXT = "OK";
        final String EXPECTED_END_POINT = "submitnewlanguage.html";
        final double EXPECTED_RESPONSE_TIME_STANDARD = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(EXPECTED_END_POINT);

        openBaseURL().clickSubmitNewLanguageFooterMenu();

        Assert.assertEquals(httpResponse.get(0),EXPECTED_STATUS_CODE);
        Assert.assertEquals(httpResponse.get(1), EXPECTED_STATUS_TEXT);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + EXPECTED_END_POINT);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14))
                <= EXPECTED_RESPONSE_TIME_STANDARD);
    }

    @Test (priority = -3)
    public void test_API_HttpRequest_POST() {

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(ACTION, METHOD.toUpperCase());

        openBaseURL()
                .clickSubmitNewLanguageFooterMenu()
                .clickSubmitLanguageButton();

        Assert.assertEquals(httpRequest.get(0).toLowerCase(), METHOD);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + ACTION);
        Assert.assertEquals(httpRequest.get(2), "Optional[" + PAYLOAD + "]");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_POST")
    public void test_API_HttpResponse_POST() {
        final String EXPECTED_STATUS_CODE = "200";
        final String EXPECTED_STATUS_TEXT = "OK";
        final String EXPECTED_END_POINT = "submitnewlanguage.html";
        final double EXPECTED_RESPONSE_TIME_STANDARD = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(EXPECTED_END_POINT);

        SubmitNewLanguagePage submitNewLanguagePage = openBaseURL()
                .clickSubmitNewLanguageFooterMenu()
                .clickSubmitLanguageButton();

        Assert.assertEquals(httpResponse.get(0), EXPECTED_STATUS_CODE);
        Assert.assertEquals(httpResponse.get(1), EXPECTED_STATUS_TEXT);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + EXPECTED_END_POINT);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14))
                <= EXPECTED_RESPONSE_TIME_STANDARD);
        Assert.assertEquals(submitNewLanguagePage.getFormText(), PAGE_CONTEXT_BEFORE_REQUEST);
    }
}
