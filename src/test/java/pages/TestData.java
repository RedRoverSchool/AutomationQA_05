package pages;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "MainTestData")
    public static Object[][] mainDataProvider() {

        return new Object[][]{
                {0, "Start", "/", "https://www.99-bottles-of-beer.net/", "99 Bottles of Beer | Start"},
                {1, "Browse Languages", "/abc.html", "https://www.99-bottles-of-beer.net/abc.html", "99 Bottles of Beer | Browse category A"},
                {2, "Search Languages", "/search.html", "https://www.99-bottles-of-beer.net/search.html", "99 Bottles of Beer | Search Languages"},
                {3, "Top Lists", "/toplist.html", "https://www.99-bottles-of-beer.net/toplist.html", "99 Bottles of Beer | Top Rated"},
                {4, "Guestbook", "/guestbookv2.html", "https://www.99-bottles-of-beer.net/guestbookv2.html", "99 Bottles of Beer | Guestbook"},
                {5, "Submit new Language", "/submitnewlanguage.html", "https://www.99-bottles-of-beer.net/submitnewlanguage.html", "99 Bottles of Beer | Submit new Language"}
        };
    }
}
