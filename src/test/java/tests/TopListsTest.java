package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TopListsTest extends BaseTest {

    @Test
    public void testVerifyListOfElementsOfTopListsMenu() {
        List<String> expectedElementsOfTopListsMenu = new ArrayList<>();
        expectedElementsOfTopListsMenu.add("Top Rated");
        expectedElementsOfTopListsMenu.add("Top Rated Real");
        expectedElementsOfTopListsMenu.add("Top Rated Esoteric");
        expectedElementsOfTopListsMenu.add("Top Rated Assembly");
        expectedElementsOfTopListsMenu.add("Top Hits");
        expectedElementsOfTopListsMenu.add("New Languages this month");
        expectedElementsOfTopListsMenu.add("New Comments");

        List<String> actualElementsOfTopListsMenu =
                openBaseURL()
                        .clickTopListsMenu()
                        .getText();

        Assert.assertTrue(actualElementsOfTopListsMenu.size() > 0);
        Assert.assertEquals(actualElementsOfTopListsMenu, expectedElementsOfTopListsMenu);
    }
}
