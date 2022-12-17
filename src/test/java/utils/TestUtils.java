package utils;

import org.apache.commons.lang3.RandomStringUtils;

public final class TestUtils {
    private static final String bottles = " bottles of beer";
    private static final String wall = " on the wall";
    private static final String commaSpace = ", ";
    private static final String dot = ".";
    private static final String take = "Take one down and pass it around";
    private static final String br = "\n";
    private static final String noMore = "No more";

    private static StringBuilder method1(int i, String bottles) {
        return new StringBuilder()
                .append(i)
                .append(bottles)
                .append(wall)
                .append(commaSpace)
                .append(i)
                .append(bottles)
                .append(dot)
                .append(br)
                .append(take)
                .append(commaSpace);
    }

    private static StringBuilder method2(int i, String bottles) {

        return new StringBuilder()
                .append(i)
                .append(bottles)
                .append(wall)
                .append(dot);
    }

    public static String createSongLyrics() {
        StringBuilder sb = new StringBuilder();

        sb.append(method1(99, bottles));

        for (int i = 98; i >= 1; i--) {
            if (i == 1) {
                sb
                        .append(method2(i, bottles.replace("s", "")))
                        .append(method1(i, bottles.replace("s", "")));
                break;
            }
            sb
                    .append(method2(i, bottles))
                    .append(method1(i, bottles));
        }
        sb
                .append(noMore.toLowerCase())
                .append(bottles)
                .append(wall)
                .append(dot)
                .append(noMore)
                .append(bottles)
                .append(wall)
                .append(commaSpace)
                .append(noMore.toLowerCase())
                .append(bottles)
                .append(dot)
                .append(br)
                .append("Go to the store and buy some more")
                .append(commaSpace)
                .append(method2(99, bottles));

        return sb.toString();

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
}
