package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.search_languages.SearchLanguagesPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_SearchLanguagesTest extends BaseTest {

    final static String LANGUAGE_NAME = "python";
    final static String ACTION = "search.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "search";
    final static String NAME_INPUT_2 = "submitsearch";
    final static String VALUE_INPUT2 = "GO";
    final static String PAYLOAD = NAME_INPUT_1 + "=" + LANGUAGE_NAME + "&" + NAME_INPUT_2 + "=" + VALUE_INPUT2;
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Search Languages\n" + "Search for:";

    @Test
    public void testAttributes_DefaultValues() {
        SearchLanguagesPage searchLanguagesPage =
                openBaseURL().clickSearchLanguagesFooterMenu();

        Assert.assertEquals(searchLanguagesPage.getAction(), getBaseUrl() + ACTION);
        Assert.assertEquals(searchLanguagesPage.getMethod(), METHOD);
        Assert.assertEquals(searchLanguagesPage.getInput1Name(), NAME_INPUT_1);
        Assert.assertEquals(searchLanguagesPage.getInput2Name(), NAME_INPUT_2);
        Assert.assertEquals(searchLanguagesPage.getInput2Value(), VALUE_INPUT2);
        Assert.assertEquals(searchLanguagesPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "search.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL().clickSearchLanguagesFooterMenu();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "search.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL().clickSearchLanguagesFooterMenu();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void test_API_HttpRequest_POST() {

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(ACTION, METHOD.toUpperCase());

        openBaseURL()
                .clickSearchLanguagesFooterMenu()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton();

        Assert.assertEquals(httpRequest.get(0).toLowerCase(), METHOD);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + ACTION);
        Assert.assertEquals(httpRequest.get(2), "Optional[" + PAYLOAD + "]");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_POST")
    public void test_API_HttpResponse_POST() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "search.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        SearchLanguagesPage searchLanguagesPage = openBaseURL()
                .clickSearchLanguagesFooterMenu()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
        Assert.assertNotEquals(searchLanguagesPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_AllLanguagesLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickSearchLanguagesMenu()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton()
                .getLanguagesLinks();

        final int expectedWorkingLinksCount = aTags.size();
        int internalLinks = expectedWorkingLinksCount;

        for (WebElement link : aTags) {
            linkURL = link.getAttribute("href");

            if (linkURL != null && !linkURL.isBlank() && !linkURL.isEmpty()) {
                if (!linkURL.startsWith(getBaseUrl())) {
                    Reporter.log(linkURL + " is externalLink ", true);
                    internalLinks--;
                } else {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) (new URL(linkURL).openConnection());
                        connection.setRequestMethod("HEAD");
                        connection.connect();

                        responseCode = connection.getResponseCode();

                        if (responseCode < 400) {
                            actualWorkingLinksCount++;
                        } else {
                            Reporter.log(linkURL + " is broken, responseCode " + responseCode, true);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Assert.assertEquals(actualWorkingLinksCount, internalLinks);
        Assert.assertEquals(actualWorkingLinksCount, expectedWorkingLinksCount);
    }

    @Test
    public void test_API_AllImagesAreNotBroken() {
        String imageURL = "";
        int responseCode;
        int actualWorkingImagesCount = 0;
        SearchLanguagesPage searchLanguagesPage = new SearchLanguagesPage(getDriver());

        List<WebElement> imgTags = openBaseURL()
                .clickSearchLanguagesMenu()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton()
                .getImages();

        final int expectedWorkingImagesCount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if (imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
                    connection.connect();

                    responseCode = connection.getResponseCode();

                    if (responseCode < 400 && searchLanguagesPage.isImageDisplayed(image)) {
                        actualWorkingImagesCount++;
                    } else {
                        Reporter.log(imageURL + " is broken, responseCode " + responseCode + "OR image not displayed", true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Assert.assertEquals(actualWorkingImagesCount, expectedWorkingImagesCount);
    }
}