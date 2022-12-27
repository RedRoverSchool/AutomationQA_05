package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class API_KotlinLanguageTest extends BaseTest {

    final static String ACTION = "vote.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "exampleid";
    final static String VALUE_INPUT1 = "2901";
    final static String NAME_INPUT_2 = "http_referer";
    final static String VALUE_INPUT2 = "/language-kotlin-2901.html";
    final static String NAME_SELECT = "rate";
    final static String VALUE_SELECT = "0";
    final static String NAME_INPUT_4 = "submitcomment";
    final static String VALUE_INPUT4 = "Vote";

    final static String PAYLOAD = NAME_INPUT_1 + "=" + VALUE_INPUT1 + "&" + NAME_INPUT_2 + "="
            + URLEncoder.encode(VALUE_INPUT2) + "&" + NAME_SELECT + "=" + VALUE_SELECT + "&" + NAME_INPUT_4
            + "=" + VALUE_INPUT4;
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Voting\n" + "Error: Please select something.\n" + "Back";

    @Test
    public void testAttributes_DefaultVAlues() {

        KotlinLanguagePage kotlinLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKotlinLanguage();

        Assert.assertEquals(kotlinLanguagePage.getAction(), getBaseUrl() + ACTION);
        Assert.assertEquals(kotlinLanguagePage.getMethod(), METHOD);
        Assert.assertEquals(kotlinLanguagePage.getInput1Name(), NAME_INPUT_1);
        Assert.assertEquals(kotlinLanguagePage.getInput1Value(), VALUE_INPUT1);
        Assert.assertEquals(kotlinLanguagePage.getInput2Name(), NAME_INPUT_2);
        Assert.assertEquals(kotlinLanguagePage.getInput2Value(), VALUE_INPUT2);
        Assert.assertEquals(kotlinLanguagePage.getSelect3Name(), NAME_SELECT);
        Assert.assertEquals(kotlinLanguagePage.getSelect3Value(), VALUE_SELECT);
        Assert.assertEquals(kotlinLanguagePage.getInput4Name(), NAME_INPUT_4);
        Assert.assertEquals(kotlinLanguagePage.getInput4Value(), VALUE_INPUT4);
    }

    @Test
    public void test_API_HttpRequest_POST() {
        final String expectedMethod = "POST";
        final String expectedEndPoint = "vote.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(ACTION, METHOD.toUpperCase());

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
                .clickVoteButton();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2).substring(9, 91), PAYLOAD);
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_POST")
    public void test_API_HttpResponse_POST() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "vote.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(getBaseUrl() + expectedEndPoint);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
                .clickVoteButton();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
        Assert.assertEquals(new KotlinLanguagePage(getDriver()).getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_AllLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
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
        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        List<WebElement> imgTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
                .getImages();

        final int expectedWorkingImagesCount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if (imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    responseCode = connection.getResponseCode();

                    if (responseCode < 400 && kotlinLanguagePage.isImageDisplayed(image)) {
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
