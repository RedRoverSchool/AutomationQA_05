package runner;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public final class TestUtils {

    private static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    public static String getBaseUrl() {

        return BASE_URL;
    }

    private static void getBottles(StringBuilder lyrics, int number, String btl) {
        lyrics.append(number).append(btl);
    }

    private static void getNoMore(StringBuilder lyrics, String noMore, String btl) {
        lyrics.append(noMore).append(btl);
    }

    public static String createSongLyricsTextUsingAlgorithm() {
        final String BOTTLES_WALL_CS = " bottles of beer on the wall, ";
        final String BOTTLES_DOT_LN = " bottles of beer.\n";
        final String BOTTLES_DOT = " bottles of beer on the wall.";
        final String TAKE = "Take one down and pass it around, ";
        final String GO = "Go to the store and buy some more, ";
        final String NO_MORE = "No more";

        StringBuilder lyrics = new StringBuilder();

        getBottles(lyrics, 99, BOTTLES_WALL_CS);
        getBottles(lyrics, 99, BOTTLES_DOT_LN);
        for (int i = 98; i > -1; i--) {
            lyrics.append(TAKE);

            if (i == 1) {
                getBottles(lyrics, i, BOTTLES_DOT.replace("s", ""));
                getBottles(lyrics, i, BOTTLES_WALL_CS.replace("s", ""));
                getBottles(lyrics, i, BOTTLES_DOT_LN.replace("s", ""));
            } else if (i == 0) {
                getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOT);
                getNoMore(lyrics, NO_MORE, BOTTLES_WALL_CS);
                getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOT_LN);
            } else {
                getBottles(lyrics, i, BOTTLES_DOT);
                getBottles(lyrics, i, BOTTLES_WALL_CS);
                getBottles(lyrics, i, BOTTLES_DOT_LN);
            }
        }
        lyrics.append(GO);
        getBottles(lyrics, 99, BOTTLES_DOT);

        return lyrics.toString();
    }

    public static String getRandomStr(int length) {

        return RandomStringUtils.random(length,
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    public static int getRandomNumbers(int length) {

        if (length == 2) {

            return (int) (Math.random() * 90 + 10);
        } else if (length == 3) {

            return (int) (Math.random() * 900 + 100);
        } else if (length == 4) {

            return (int) (Math.random() * 9000 + 1000);
        } else if (length == 5) {

            return (int) (Math.random() * 90000 + 10000);
        }

        return -1;
    }

    protected static List<String> getTextOfCode() {

        String b = "bottle(s) of beer";
        String w = " on the wall,";
        String T = "Take one down and pass it around,";
        String Pr = "PRINT ";
        String X = "X";
        String smc = ";";
        String quo = "\"";
        String B = Character.toString(
                        b.charAt(0)
                )
                .toUpperCase() + b.substring(1);

        String B2 = B
                .replace("(", "")
                .replace(")", "");

        String w1 = w
                .replace(",", "");

        List<String> basicCode = new ArrayList<>();

        basicCode.add(
                "REM BASIC Version of 99 "
                        .concat(B2)
        );
        basicCode.add(
                "FOR "
                        .concat(X)
                        .concat("=100 TO 1 STEP -1")
        );
        basicCode.add(
                Pr
                        .concat(X)
                        .concat(smc)
                        .concat(quo)
                        .concat(B)
                        .concat(w)
                        .concat(quo)
                        .concat(smc)
                        .concat(X)
                        .concat(smc)
                        .concat(quo)
                        .concat(b)
                        .concat(quo)
        );
        basicCode.add(
                Pr
                        .concat(quo)
                        .concat(T)
                        .concat(quo));
        basicCode.add(
                Pr
                        .concat(X)
                        .concat("-1")
                        .concat(smc)
                        .concat(quo)
                        .concat(b)
                        .concat(w1)
                        .concat(quo)
        );
        basicCode.add("NEXT");

        return basicCode;
    }

    public static String createBasicCode() {
        StringBuilder basicCode = new StringBuilder();
        int count = 10;
        String sp = " ";
        String ln = "\n";

        for (int i = 0; i < getTextOfCode().size() - 1; i ++ ) {

            basicCode.append(count)
                    .append(sp)
                    .append(getTextOfCode().get(i))
                    .append(ln);

            count+=10;

            if (count == 60) {
                basicCode.append(count)
                        .append(sp)
                        .append(getTextOfCode()
                        .get(getTextOfCode().size() - 1));
            }
        }

        return basicCode.toString();
    }

    protected static String createSrc(String value) {
        StringBuilder sb = new StringBuilder();

        return sb
                .append("http://www.99-bottles-of-beer.net/")
                .append("images/bb/bb")
                .append(value)
                .append(".gif")
                .toString();
    }

    public static String createAttributesSrcOfImg() {
        StringBuilder sb = new StringBuilder();
        String ln = "\n";

        return sb
                .append(createSrc("url"))
                .append(ln)
                .append(createSrc("email"))
                .append(ln)
                .append(createSrc("bold"))
                .append(ln)
                .append(createSrc("italic"))
                .append(ln)
                .append(createSrc("underline"))
                .toString();
    }

    public static String getTrWithRequiredLanguage(String languageName) {
        List<String> languageInformation = new ArrayList<>();
        languageInformation.add("Joy inforichland 07/05/09 0");
        for(String language : languageInformation){
            String name = language.split(" ")[0];
            if(name.equals(languageName)){

                return language;
            }
        }

        return null;
    }

    public static StringBuilder createStringBuilder() {
        StringBuilder sb = new StringBuilder();

        return sb;
    }

    protected static String createTextFromPrompts1(String s) {

        return createStringBuilder()
                .append("Enter the ")
                .append(s)
                .append(" you want to add.")
                .toString();
    }

    protected static String createTextFromPrompts2(String s) {

        return createStringBuilder()
                .append("Enter the text that you want to make ")
                .append(s)
                .append(".")
                .toString();
    }

    public static String createTextFromPromptsUsingAlgorithm() {
        String ln = "\n";

        return createStringBuilder()
                .append(createTextFromPrompts1("URL for the link"))
                .append(ln)
                .append(createTextFromPrompts1("email address"))
                .append(ln)
                .append(createTextFromPrompts2("bold"))
                .append(ln)
                .append(createTextFromPrompts2("italic"))
                .append(ln)
                .append(
                        createTextFromPrompts2("undelined")
                                .replace("make ", "be ")
                )
                .toString();
    }

    public static String createNamesGeneralFieldsUsingAlgorithm() {
        String ln = ", ";

        return createStringBuilder()
                .append("Name:")
                .append(ln)
                .append("Location:")
                .append(ln)
                .append("E-Mail:")
                .append(ln)
                .append("Homepage")
                .append(ln)
                .append("Security Code:")
                .append(ln)
                .append("Message:")
                .toString();
    }
}
