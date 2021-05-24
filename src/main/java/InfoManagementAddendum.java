import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

    public void CIS_NOTIFYMANAGER_043(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            ExtLink = prop.get("ExternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement Username = driver.findElement(By.id("mat-input-0"));
            WebElement Password = driver.findElement(By.id("mat-input-1"));
            Username.sendKeys(prop.get("ExtUsername2").toString());
            Password.sendKeys(prop.get("ExtPass2").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement SignInBtn = driver.findElement(ByAngular.buttonText("Sign In"));

            SignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();

            TestStatus = LogStatus.PASS;



        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
}
