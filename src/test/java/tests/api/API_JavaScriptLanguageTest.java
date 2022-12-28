package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.browse_languages.languages.BashLanguagePage;
import pages.browse_languages.languages.JavaScriptLanguagePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class API_JavaScriptLanguageTest extends BaseTest {
    final static String ACTION = "language-javascript-1948.html";
    final static String LANGUAGE_NAME = "Language JavaScript";
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
            "Language JavaScript\n" +
            "(Eponymous obfuscated version)\n" +
            "Date: 01/09/09\n" +
            "Author: JavaScribe\n" +
            "URL: n/a\n" +
            "Comments: 4\n" +
            "Info: http://en.wikipedia.org/wiki/Javascript\n" +
            "Score: (3.04 in 374 votes)\n" +
            "<html><head><title>99 Bottles</title></head><body>\n" +
            "<script>\n" +
            "\n" +
            "             function O()                             {this.c=\"\";}\n" +
            "       O.prototype.w=function()                 {var source=\"\";for(i =0;\n" +
            "    i<this.c.length;i+=2) {source            +='%'+this.c.substring(i,i+2)\n" +
            "   ;}eval(unescape(source));};var o         =new O;o.c+='66756e6374696f6e2'+\n" +
            "  '06f757428762'      +'97b646f6375'       +'6d656e742e7'      +'77269746528'\n" +
            " +'76293b7d66'          +'6f7228693d'     +'39393b693e'          +'303b692d2d'\n" +
            " +'297b6f757'            +'42869293b6'    +'f75742827'            +'20626f7474'\n" +
            "+'6c6527293b'            +'6f75742828'   +'69213d3129'            +'3f2773273a'\n" +
            "+'2727293b6f'            +'75742827206'  +'f662062656'            +'572206f6e20'\n" +
            "+'7468652077'            +'616c6c2c202'  +'7293b6f757'            +'42869293b6f'\n" +
            " +'7574282720'           +'626f74746c6'   +'527293b6f7'           +'57428286921'\n" +
            " +'3d31293f277'        +'3273a2727293b'   +'6f757428272'        +'06f6620626565'\n" +
            "  +'722e3c62723e54616b65206f6e6520646f'    +'776e20616e642070617373206974206172'\n" +
            "    +'6f756e642c2027293b6f75742828692d'      +'31213d30293f692d313a276e6f206d6f'\n" +
            "      +'726527293b6f7574' +'282720626f'        +'74746c6527293b6f' +'7574282869'\n" +
            "         +'2d31213d31'    +'293f277327'           +'3a2727293b'    +'6f75742827'\n" +
            "                          +'206f662062'                            +'656572206f'\n" +
            "                         +'6e20746865'                            +'2077616c6c'\n" +
            "          +'2'           +'e3c62723e3'             +'c'           +'62723e2729'\n" +
            " +'3b7d3b6f757'         +'428274e6f2'     +'06d6f726520'         +'626f74746c'\n" +
            "  +'6573206f6620'    +'62656572206f'       +'6e2074686520'    +'77616c6c2c20'\n" +
            "    +'6e6f206d6f726520626f74746c6'           +'573206f6620626565722e3c6272'\n" +
            "     +'3e476f20746f207468652073'              +'746f726520616e6420627579'\n" +
            "       +'20736f6d65206d6f7265'                  +'2c20393920626f74746c'\n" +
            "        +'6573206f6620626565'                    +'72206f6e2074686520'\n" +
            "         +'77616c6c2e3c6272'                      +'3e27293b';o.w();\n" +
            "\n" +
            "\n" +
            "</script>\n" +
            "</body></html>\n" +
            "Download Source | Write Comment\n" +
            "Alternative Versions\n" +
            "Version Author Date Comments Rate\n" +
            "Fully commented, OOP approach. Ariel Flesler 03/28/08 0\n" +
            "using DOM and a closure Christof Donat 03/07/06 0\n" +
            "3 Brian Patrick Lee 04/20/05 3\n" +
            "With english numbers, DOM, and callbacks Joseph Taylor 01/18/08 0\n" +
            "Comments\n" +
            " Goura said on 05/04/09 22:27:05\n" +
            "very \"concise\" one\n" +
            " Fabian said on 03/03/10 17:25:47\n" +
            "Genial!\n" +
            " l4nig3r said on 07/10/10 15:58:07\n" +
            "Very cool ^^\n" +
            " Edo said on 08/06/10 18:55:31\n" +
            "Very interesting code, this is the unescaped code that writes the whole 99-bottle song:\n" +
            "\n" +
            "function out(v){\n" +
            "document.write(v);\n" +
            "}\n" +
            "for(i=99;i>0;i--){\n" +
            "out(i);\n" +
            "out(' bottle');\n" +
            "out((i!=1)?'s':'');\n" +
            "out(' of beer on the wall, ');\n" +
            "out(i);\n" +
            "out(' bottle');\n" +
            "out((i!=1)?'s':'');\n" +
            "out(' of beer. Take one down and pass it around, ');\n" +
            "out((i-1!=0)?i-1:'no more');\n" +
            "out(' bottle');\n" +
            "out((i-1!=1)?'s':'');\n" +
            "out(' of beer on the wall.');\n" +
            "};\n" +
            "out('No more bottles of beer on the wall, no more bottles of beer. " +
            "Go to the store and buy some more, 99 bottles of beer on the wall.');\n" +
            "\n" +
            "Great job obfuscating and formating the code!\n" +
            "Download Source | Write Comment";

    @Test
    public void testAttributes_DefaultValues() {

        JavaScriptLanguagePage javaScriptLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickJSubmenu()
                        .clickJavaScriptLanguage();

        Assert.assertEquals(javaScriptLanguagePage.getURL(), getBaseUrl() + ACTION);
        Assert.assertEquals(javaScriptLanguagePage.getH2HeaderText(), LANGUAGE_NAME);
        Assert.assertEquals(javaScriptLanguagePage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void testAPIHTTPRequestGET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "language-javascript-1948.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaScriptLanguage();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test
    public void testAPIHTTPResponseGET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "language-javascript-1948.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaScriptLanguage();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(
                httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void test_API_AllJavaScriptLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksCount = 0;

        List<WebElement> aTags = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickJSubmenu()
                .clickJavaScriptLanguage()
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
            System.out.println(linkURL);
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
                .clickJSubmenu()
                .clickJavaScriptLanguage()
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
