package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.browse_languages.letters.JPage;
import pages.top_lists.TopRatedRealPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_JTest  extends BaseTest  {

    final static String ACTION = "j.html";

    @Test
    public void testAttributes_DefaultValues() {
        final String PAGE_CONTEXT_BEFORE_REQUEST = "Category J\n" +
                "All languages starting with the letter J are shown, sorted by Language.\n" +
                "Language Author Date Comments Rate\n" +
                "J Roger Hui 04/20/05 6\n" +
                "jamal Feherke 10/11/05 0\n" +
                "Jamfile David Brandon 04/20/05 0\n" +
                "Java Anonymous 04/20/05 33\n" +
                "Java 2 Micro Edition Stefan Scheler 04/20/05 0\n" +
                "Java Servlet Gregor Scheithauer 05/08/05 0\n" +
                "JavaFX Filip Dreger 04/13/09 0\n" +
                "JavaScript JavaScribe 01/09/09 4\n" +
                "jBase PROC dbell 01/05/06 0\n" +
                "JBPM Easy 06/25/10 0\n" +
                "JCL Anonymous 04/20/05 3\n" +
                "JOSS Laurent Vogel 04/20/05 0\n" +
                "Joy inforichland 07/05/09 0\n" +
                "jQuery Vincent Battaglia 12/27/06 1\n" +
                "JR Aaron Keen 01/02/06 0\n" +
                "JScript Philipp Winterberg 04/20/05 2\n" +
                "JScript/NET Chris R. Timmons 04/20/05 0\n" +
                "JSP Davy Boy Hayes 01/24/06 0\n" +
                "JSTL Dave Johnston 03/07/06 0\n" +
                "Julie - Chapel (AKA Julie4Chapel) Fahad Khan 05/08/07 0\n" +
                "JustBasic John Fredrickson 02/21/06 1\n" +
                "Justif Marinus Oosters 07/30/10 0";

        JPage jPage = openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(jPage.getHrefJ(), getBaseUrl() + ACTION);
        Assert.assertEquals(jPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "j.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "j.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL().clickBrowseLanguagesMenu().clickJSubmenu();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void test_API_AllJLinksAreNotBroken () {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
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
        TopRatedRealPage topRatedRealPage = new TopRatedRealPage(getDriver());

        List<WebElement> imgTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .getImages();

        final int expectedWorkingImagesCount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if (imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
                    connection.connect();

                    responseCode = connection.getResponseCode();

                    if (responseCode < 400 && topRatedRealPage.isImageDisplayed(image)) {
                        actualWorkingImagesCount++;
                    } else {
                        Reporter.log(imageURL + " is broken, responseCode " + responseCode
                                + "OR image not displayed", true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Assert.assertEquals(actualWorkingImagesCount, expectedWorkingImagesCount);
    }
}
