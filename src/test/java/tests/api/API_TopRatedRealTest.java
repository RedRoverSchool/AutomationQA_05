package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.top_lists.TopRatedRealPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_TopRatedRealTest extends BaseTest {

    final static String ACTION = "toplist_real.html";

    @Test
    public void testAttributes_DefaultValues() {
        final String PAGE_CONTEXT_BEFORE_REQUEST =
                "Top Rated Real Languages\n" +
                "# Language Author Date Comments Rate\n" +
                "1. REBOL Anonymous 04/20/05 1\n" +
                "2. Express Lori Smallwood 04/20/05 0\n" +
                "3. NetLogo (Some kind of logo for Multi Agent System) Antoine Cervoise 07/16/10 0\n" +
                "4. clojure (More clojurisk and human readable versio) Thomas G. Kristensen 03/08/10 0\n" +
                "5. Scheme (original version) Tim Goodwin 04/20/05 2\n" +
                "6. Racket (Now with full and complete lyrics!) Eli Barzilay, Ian Gibson 08/10/12 0\n" +
                "7. Haskell Iavor 03/03/06 5\n" +
                "8. Smalltalk (Squeak, VisualWorks) Jim Freeman 07/03/05 4\n" +
                "9. Cobra Tim Locke 07/11/10 0\n" +
                "10. D Stewart Gordon 05/31/05 4\n" +
                "11. OCaml (working with new versions, using printf) David Baelde 11/08/05 0\n" +
                "12. Python (This example demonstrates the simplicity) Gerold Penz 07/23/05 15\n" +
                "13. Sisal Pat Miller 04/20/05 3\n" +
                "14. Ada (multitasking) tmoran[at]bix[dot]com 04/20/05 0\n" +
                "15. Factor (Factor 0.83) John Kimber 08/23/06 0\n" +
                "16. Self David Eddyshaw 04/20/05 0\n" +
                "17. Forth (ANS standard) Ian Osgood 07/12/05 12\n" +
                "18. Ruby (Using continuations, singleton classes) Victor Borja 09/15/06 9\n" +
                "19. Modula-2 (ISO Modula-2 version) Terry Ross 08/25/08 0\n" +
                "20. Io Laurent Vogel 04/20/05 2\n" +
                "21. Cat Tim Locke 02/19/09 0\n" +
                "22. Tcl (alternative version) mackenga 07/14/05 0\n" +
                "23. PL/M-80 John Durbetaki 04/20/05 0\n" +
                "24. Perl (bottled by Acme::EyeDrops) Andrew Savige 06/04/05 76\n" +
                "25. Kotlin Franck Rasolo 06/22/12 0";

        TopRatedRealPage topRatedRealPage = openBaseURL().clickTopListsMenu().clickTopRatedRealSubmenu();

        Assert.assertEquals(topRatedRealPage.getHref(), getBaseUrl() + ACTION);
        Assert.assertEquals(topRatedRealPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
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
        final String expectedEndPoint = "toplist_real.html";
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
    public void test_API_AllTopRatedRealLanguagesListLinksAreNotBroken () {
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
        TopRatedRealPage topRatedRealPage = new TopRatedRealPage(getDriver());

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

                    if (responseCode < 400 && topRatedRealPage.isImageDisplayed(image)) {
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
