import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.util.List;

public class RustamKhudoyarovTest extends BaseTest {

        @Test
        public void testSearchLanguageField_HappyPath(){
                final String BASE_URL = "https://www.99-bottles-of-beer.net/";
                final String LANGUAGE_PYTHON = "python";

                getDriver().get(BASE_URL);

                getDriver().findElement(By.xpath("//ul[@id ='menu']/li/a[@href ='/search.html']")).click();
                getDriver().findElement(By.xpath("//input[@name ='search']")).sendKeys(LANGUAGE_PYTHON);
                getDriver().findElement(By.xpath("//input[@name ='submitsearch']")).click();

                List<WebElement> languagesNameList = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td[1]/a"));

                Assert.assertTrue(languagesNameList.size()>0);
                for (WebElement l : languagesNameList) {
                      Assert.assertTrue(l.getText().toLowerCase().contains(LANGUAGE_PYTHON));
                }
        }

}
