package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.search_languages.SearchLanguagesPage;
import pages.top_lists.TopRatedRealPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_TopListRealTest extends BaseTest {

    final static String END_POINT = "toplist_real.html";
    final static String HEADER = "Top Rated Real Languages";

    @Test
    public void testAttributes_DefaultVAlues() {

        TopRatedRealPage topListRealPage =
                openBaseURL()
                        .clickTopListsMenu()
                        .clickTopRatedRealSubmenu();

        Assert.assertEquals(topListRealPage.getURL(), getBaseUrl() + END_POINT);
        Assert.assertEquals(topListRealPage.getH2HeaderText(), HEADER);
        Assert.assertNotNull(topListRealPage.getPageContext());
    }

    @Test
    public void test_API_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "toplist_real.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL()
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "toplist.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL()
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void test_API_AllTopListSubmenuLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu()
                .getLinks();

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
                .clickTopListsMenu()
                .clickTopRatedRealSubmenu()
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
