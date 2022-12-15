package tests;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.browse_languages.languages.BashLanguagePage;

import static utils.TestUtils.getBaseUrl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_BashLanguageTest extends BaseTest {
    final static String LANGUAGE_NAME = "Language BASH";
    final static String ACTION_BASH = "language-bash-1815.html";
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Voting\n" +
            "Please select\n" +
            "* Bad as Hell\n" +
            "** Nothing new\n" +
            "*** Good\n" +
            "**** Nice Coding\n" +
            "***** TOP GEEK\n" +
            "Category\n" +
            "real language\n" +
            "Bookmarking\n" +
            "\n" +
            "Language BASH\n" +
            "(No loop, no recursion)\n" +
            "Date: 07/08/08\n" +
            "Author: Fr�d�ric Lang\n" +
            "URL: http://fr.lang.free.fr\n" +
            "Comments: 3\n" +
            "Info: http://fr.lang.free.fr/cours\n" +
            "Score: (3.01 in 157 votes)\n" +
            "Download Source | Write Comment\n" +
            "Alternative Versions\n" +
            "Version Author Date Comments Rate\n" +
            "Self Writing Olosta 07/18/12 0\n" +
            "Bourne Again Shell Dave Plonka 04/20/05 5\n" +
            "portable, rich of features, readable Bastian Bittorf 08/20/07 0\n" +
            "with arrays and functions Vittorio Cagnetta 06/30/06 0\n" +
            "Arithmetic on English words for numbers Bill Brown 07/31/08 0\n" +
            "recursive function Koen Noens 12/30/07 0\n" +
            "Comments\n" +
            " Vittorio said on 09/13/08 14:11:26\n" +
            " yeti said on 10/27/08 02:07:02\n" +
            "Dear Vittorio, \"no recursion\" is correct because \"source $0\" does not mimic a call. It acts like placing the same soure lines linearily at this point at the same level as the preceeding lines.\n" +
            " Paulo Matos said on 12/18/08 03:22:07\n" +
            "Sorry this script is recursive. Recursion is done with $order.\n" +
            "Download Source | Write Comment";

    @Test
    public void testAttributes_DefaultValuesBASH() {
        BashLanguagePage bashLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .clickBashLanguage();
//                        .clickBashLanguageLink();

        Assert.assertEquals(bashLanguagePage.getURL(), getBaseUrl() + ACTION_BASH);
        Assert.assertEquals(bashLanguagePage.getH2HeaderText(), LANGUAGE_NAME);
        Assert.assertEquals(bashLanguagePage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void testAPIHTTPRequestGET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "language-bash-1815.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .clickBashLanguage();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test
    public void testAPIHTTPResponseGET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "language-bash-1815.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .clickBashLanguage();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(
                httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void test_API_AllLanguagesLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .clickBashLanguage()
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
        BashLanguagePage bashLanguagePage = new BashLanguagePage(getDriver());

        List<WebElement> imgTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .clickBashLanguage()
                .getImages();

        final int expectedWorkingImagesCount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if (imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
                    connection.connect();

                    responseCode = connection.getResponseCode();

                    if (responseCode < 400 && bashLanguagePage.isImageDisplayed(image)) {
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
