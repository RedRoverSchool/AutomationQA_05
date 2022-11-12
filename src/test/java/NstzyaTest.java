import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class NstzyaTest extends BaseTest { //extends помог взять методы из класса BaseTest

    @Test
    public void testSearchForLanguageByNameField_HappyPath() {
        //arrange:
        final String BASE_URL = "https://www.99-bottles-of-beer.net/"; //название переменной капсом, если она FINAL!!!!!!! - мы её в рамках проекта поменять не можем
        final String LANGUAGE_NAME = "python";
        //здесь дб expectedResult - НО! в данном конкретном тесте нет ни actual, ни expectedResult

        //act:
        getDriver().get(BASE_URL);

        //верхнее меню на сайте - menu
        //нижнее меню - footer

        WebElement searchLanguagesMenu = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/search.html']")
        );
        searchLanguagesMenu.click();

        WebElement searchForField = getDriver().findElement(By.name("search"));
        searchForField.click();
        searchForField.sendKeys(LANGUAGE_NAME);

        WebElement goButton = getDriver().findElement(By.name("submitsearch"));
        goButton.click();

        List<WebElement> languagesNamesList = getDriver().findElements(
                By.xpath("//table[@id='category']/tbody/tr/td[1]/a")
        );//по этому xpath находятся данные из первых столбцоа таблицы, поэтому .findElementS
        //и ещё - List!!!!!! он собирает все элементы и собирает их в переменную
        //List<String> languagesNamesList - пример

        //assert:
        //проверяем, что список больше нуля (не пустой), после чего можем совершать дальнейшую проверку:
        Assert.assertTrue(languagesNamesList.size() > 0);
        //теперь по листу можно пойти циклом for:
        for (int i = 0; i < languagesNamesList.size(); i ++) {
            Assert.assertTrue(languagesNamesList.get(i).getText().toLowerCase().contains(LANGUAGE_NAME));
            //перебираем элементы листа и проверяем, что этот текст в lowerCase содержит искомое слово "python"
            //это наш actualResult
        }
    }
}
