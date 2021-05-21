import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

public class InfoManagementAddendum {
    File configFile = new File("src/main/resources/Config.properties");
    LogStatus TestStatus;
    String ErrorMessage = null;
    public String ExtLink ;
    public String IntLink;
    private Properties prop;
    private NgWebDriver ngWebDriver;
    private WebDriver driver;
    private WebElement ProvinceDD;
    private WebElement SearchByDD;
    private WebElement SearchByVal;
    private WebElement ProvinceVal;
    private WebElement SearchFilterDD;
    private WebElement SearchFilterVal;
    String AdditionalNotes = null;
    private String PrePackagedRef;
    private int NumberOfEmails = 0;
    private String EmailBody = null;

    public WebElement ExplicitWait(WebDriver driver, String Xpath)
    {
        WebElement targetElement = null;
        try
        {
            ngWebDriver.waitForAngularRequestsToFinish();
            targetElement = new WebDriverWait(driver, Duration.ofMinutes(1)).until((WebDriver dr1) -> dr1.findElement(By.xpath(Xpath)));

        }
        catch (Exception e)
        {

            throw e;
        }
        finally {
            return targetElement;
        }
    }

}
