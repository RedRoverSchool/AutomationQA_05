package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KotlinLanguagePage extends LanguagePage{

    @FindBy(xpath = "//div[@id = 'voting']//input[@name = 'submitcomment']")
    private WebElement voteButton;

    @FindBy(xpath = "//div[@id = 'voting']//form")
    private WebElement votingForm;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[1]")
    private WebElement input1Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[2]")
    private WebElement input2Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//select")
    private WebElement select3Voting;

    @FindBy(xpath = "//div[@id = 'voting']//form//input[3]")
    private WebElement input4Voting;

    public KotlinLanguagePage(WebDriver driver) {
        super(driver);
    }

    public KotlinLanguagePage clickVoteButton() {
        click(voteButton);

        return new KotlinLanguagePage(getDriver());
    }

    public String getAction() {

        return getAttribute(votingForm, "action");
    }

    public String getMethod() {

        return getAttribute(votingForm, "method");
    }

    public String getInput1Value() {

        return getAttribute(input1Voting, "value");
    }

    public String getInput2Value() {

        return getAttribute(input2Voting, "value");
    }

    public String getSelect3Value() {

        return getAttribute(select3Voting, "value");
    }

    public String getInput4Value() {

        return getAttribute(input4Voting, "value");
    }

    public String getInput1Name() {

        return getAttribute(input1Voting, "name");
    }

    public String getInput2Name() {

        return getAttribute(input2Voting, "name");
    }

    public String getSelect3Name() {

        return getAttribute(select3Voting, "name");
    }

    public String getInput4Name() {

        return getAttribute(input4Voting, "name");
    }
}
