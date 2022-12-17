package utils;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "letterSubmenu")
    public static Object[][] createLetersSubmenu() {

        return new Object[][] {
                {0, "0-9", "https://www.99-bottles-of-beer.net/0.html", "99 Bottles of Beer | Browse category 0-9"},
                {1, "A", "https://www.99-bottles-of-beer.net/a.html", "99 Bottles of Beer | Browse category A"},
                {2, "B", "https://www.99-bottles-of-beer.net/b.html", "99 Bottles of Beer | Browse category B"},
                {3, "C", "https://www.99-bottles-of-beer.net/c.html", "99 Bottles of Beer | Browse category C"},
                {4, "D", "https://www.99-bottles-of-beer.net/d.html", "99 Bottles of Beer | Browse category D"},
                {5, "E", "https://www.99-bottles-of-beer.net/e.html", "99 Bottles of Beer | Browse category E"},
                {6, "F", "https://www.99-bottles-of-beer.net/f.html", "99 Bottles of Beer | Browse category F"},
                {7, "G", "https://www.99-bottles-of-beer.net/g.html", "99 Bottles of Beer | Browse category G"},
                {8, "H", "https://www.99-bottles-of-beer.net/h.html", "99 Bottles of Beer | Browse category H"},
                {9, "I", "https://www.99-bottles-of-beer.net/i.html", "99 Bottles of Beer | Browse category I"},
                {10, "J", "https://www.99-bottles-of-beer.net/j.html", "99 Bottles of Beer | Browse category J"},
                {11, "K", "https://www.99-bottles-of-beer.net/k.html", "99 Bottles of Beer | Browse category K"},
                {12, "L", "https://www.99-bottles-of-beer.net/l.html", "99 Bottles of Beer | Browse category L"},
                {13, "M", "https://www.99-bottles-of-beer.net/m.html", "99 Bottles of Beer | Browse category M"},
                {14, "N", "https://www.99-bottles-of-beer.net/n.html", "99 Bottles of Beer | Browse category N"},
                {15, "O", "https://www.99-bottles-of-beer.net/o.html", "99 Bottles of Beer | Browse category O"},
                {16, "P", "https://www.99-bottles-of-beer.net/p.html", "99 Bottles of Beer | Browse category P"},
                {17, "Q", "https://www.99-bottles-of-beer.net/q.html", "99 Bottles of Beer | Browse category Q"},
                {18, "R", "https://www.99-bottles-of-beer.net/r.html", "99 Bottles of Beer | Browse category R"},
                {19, "S", "https://www.99-bottles-of-beer.net/s.html", "99 Bottles of Beer | Browse category S"},
                {20, "T", "https://www.99-bottles-of-beer.net/t.html", "99 Bottles of Beer | Browse category T"},
                {21, "U", "https://www.99-bottles-of-beer.net/u.html", "99 Bottles of Beer | Browse category U"},
                {22, "V", "https://www.99-bottles-of-beer.net/v.html", "99 Bottles of Beer | Browse category V"},
                {23, "W", "https://www.99-bottles-of-beer.net/w.html", "99 Bottles of Beer | Browse category W"},
                {24, "X", "https://www.99-bottles-of-beer.net/x.html", "99 Bottles of Beer | Browse category X"},
                {25, "Y", "https://www.99-bottles-of-beer.net/y.html", "99 Bottles of Beer | Browse category Y"},
                {26, "Z", "https://www.99-bottles-of-beer.net/z.html", "99 Bottles of Beer | Browse category Z"}
        };
    }
}