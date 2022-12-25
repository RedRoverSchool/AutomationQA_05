package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.browse_languages.languages.MagnumLanguagePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_MagnumLanguageTest extends BaseTest {
    final static String LANGUAGE_NAME = "Language Magnum";
    final static String ACTION_MAGNUM = "language-magnum-654.html";
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Voting\n"
            + "Please select\n"
            + "* Bad as Hell\n"
            + "** Nothing new\n"
            + "*** Good\n"
            + "**** Nice Coding\n"
            + "***** TOP GEEK\n"
            + "Category\n"
            + "real language\n"
            + "Bookmarking\n"
            + "\n"
            + "Language Magnum\n"
            + "Date: 05/17/05\n"
            + "Author: Wim Roeling\n"
            + "URL: n/a\n"
            + "Comments: 2\n"
            + "Info: n/a\n"
            + "Score: (3.00 in 5 votes)\n"
            + "! Magnum is a procedural language belonging to a DBMS, developed by Tymshare Inc. "
            + "in the mid 70's.\n"
            + "! It is still in use today and supported by Allshare BV, The Netherlands\n"
            + " \n"
            + "procedure bottles.of.beer\n"
            + "begin\n"
            + "  field x as '5z'\n"
            + "! Magnum Version of 99 Bottles of beer\n"
            + "  move 100 to x\n"
            + "  while x > 0 do\n"
            + "  begin\n"
            + "    type x,\" Bottle(s) of beer on the wall,\"\n"
            + "                  ,x,\" bottle(s) of beer\" ,@cr\n"
            + "                  ,\"Take one down and pass it around,\" ,@cr\n"
            + "                  ,(x-1) as '5z',\" bottle(s) of beer on the wall\" ,@cr\n"
            + "    subtract 1 from x\n"
            + "  end\n"
            + "end\n"
            + "Download Source | Write Comment\n"
            + "Alternative Versions\n"
            + "Comments\n"
            + " michael nowacki said on 01/25/06 03:03:22\n"
            + "the 'move' and 'subtract' COBOL-style statements are a blemish!\n"
            + "\n"
            + "x = 100\n"
            + "x = x-1\n"
            + "\n"
            + "work just fine; most of the tymshare mis code used the non-daim-bramaged syntax variants.\n"
            + "\n"
            + "you could do system-level programming with mag if you knew the un-documented type "
            + "interfaces and statements. *sigh*\n"
            + "\n"
            + "i can still remember the first time i saw sql. i thought 'no need to learn this; "
            + "NO ONE will be stupid enough to use this "
            + "language...'\n"
            + " Afterson said on 09/07/08 00:05:24\n"
            + "Hi folks,\n"
            + "\n"
            + "I have some ideas about magnum ...\n"
            + "I would like to know how to compile a magnum procedure? With bliss?\n"
            + "The binary file is runnable on VMS? on i386-based emulator?\n"
            + "\n"
            + "Many thanks for your help.\n"
            + "Download Source | Write Comment";

    @Test
    public void testAttributes_DefaultValuesMagnum() {
        MagnumLanguagePage magnumLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickMSubmenu()
                .clickMagnumLanguage();

        Assert.assertEquals(magnumLanguagePage.getURL(), getBaseUrl() + ACTION_MAGNUM);
        Assert.assertEquals(magnumLanguagePage.getH2HeaderText(), LANGUAGE_NAME);
        Assert.assertEquals(magnumLanguagePage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "language-magnum-654.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickMSubmenu()
                .clickMagnumLanguage();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "language-magnum-654.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickMSubmenu()
                .clickMagnumLanguage();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(
                httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void API_AllLanguagesLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickMSubmenu()
                .clickMagnumLanguage()
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
        MagnumLanguagePage magnumLanguagePage = new MagnumLanguagePage(getDriver());

        List<WebElement> imgTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickMSubmenu()
                .clickMagnumLanguage()
                .getImages();

        final int expectedWorkingImagesCount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if (imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
                    connection.connect();

                    responseCode = connection.getResponseCode();

                    if (responseCode < 400 && magnumLanguagePage.isImageDisplayed(image)) {
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
