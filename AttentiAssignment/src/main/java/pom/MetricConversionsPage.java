package pom;

import com.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MetricConversionsPage extends AbstractPage {

    @FindBy(className = "main")
    private WebElement pageContainer;

    private ConversionsForm conversionsForm;

    public MetricConversionsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean openPage(String url) {
        try {
            chromeDriver.manage().window().maximize();
            chromeDriver.get(PropertiesReader.getInstance().getProperty("base.url").concat(url));
            chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean convert(int value, String from, String to) {
        try {
            if (conversionsForm == null)
                conversionsForm = new ConversionsForm(chromeDriver);
            conversionsForm.convert(value, from, to);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main"))).isDisplayed();
    }
}
