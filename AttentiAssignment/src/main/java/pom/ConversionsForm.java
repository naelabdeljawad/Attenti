package pom;

import com.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

class ConversionsForm extends AbstractPage {

    @FindBy(id = "typeMenu")
    private WebElement container;

    @FindBy(id = "queryFrom")
    private WebElement from;

    @FindBy(id = "queryTo")
    private WebElement to;

    public ConversionsForm(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean convert(int value, String from, String to) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queryFrom"))).sendKeys(from);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queryTo"))).sendKeys(to);
            CommonUtils.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".convertForm input"))).get(0).sendKeys(String.valueOf(value));
            chromeDriver.findElements(By.className("greenButton")).get(0).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPageDisplayed() {
        return container.isDisplayed();
    }

}
