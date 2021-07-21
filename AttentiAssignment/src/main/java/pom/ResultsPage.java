package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends AbstractPage {

    @FindBy(id = "resultBanner")
    private WebElement container;

    @FindBy(id = "answer")
    private WebElement resultText;

    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public String getResult() {
        return wait.until(ExpectedConditions.visibilityOf(resultText)).getText();
    }

    @Override
    public boolean isPageDisplayed() {
        return container.isDisplayed();
    }

}
