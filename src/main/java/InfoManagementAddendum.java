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
    private Properties prop;
    private NgWebDriver ngWebDriver;
    private WebElement ProvinceDD;
    private WebElement SearchByDD;
    private WebElement SearchByVal;
    private WebElement ProvinceVal;
    private WebElement SearchFilterDD;
    private WebElement SearchFilterVal;
    String AdditionalNotes = null;
    private String PrePackagedRef;
    private final int NumberOfEmails = 0;
    private final String EmailBody = null;

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

            WebElement MenuSearchBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-6"));
            SGNumVal.sendKeys("1/19956");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();
            WebElement ManagerNotification = ExplicitWait(driver,"//*[@id=\"mat-dialog-0\"]");
            WebElement YesBtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div/button[1]");
            YesBtn.click();
            WebElement CommentTxt = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div[2]");
            CommentTxt = CommentTxt.findElement(By.id("mat-input-8"));
            CommentTxt.sendKeys("Notify Manager and continue with the task");

            WebElement Submitbtn = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div[3]/button[1]");
            Submitbtn.click();

            WebElement ManagerNotifiedModal = ExplicitWait(driver,"//*[@id=\"mat-dialog-0\"]");

            WebElement Closebtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div/div[6]/div/button");
            Closebtn.click();

            TestStatus = LogStatus.FAIL;
            AdditionalNotes = "The user could not continue with the Request since the data was not found it only notified the manager";

        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_NOTIFYMANAGER_044(WebDriver driver)
    {
        try
        {
            ExtLink = prop.get("ExternalLink2").toString();

            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement MenuSearchBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-6"));
            SGNumVal.clear();
            SGNumVal.sendKeys("26");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();
            WebElement Nobtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div/button[2]");
            Nobtn.click();

            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            if (ProvinceDD.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else
            {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Could not cancel request";
            }
        }
        catch (Exception Ex)
        {

        }
    }


    public void CIS_SEARCH_001(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            WebElement Search = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img"));
            Search.click();
            ngWebDriver.waitForAngularRequestsToFinish();

            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "//*[@id=\"mat-input-6\"]");
            SGNumVal.sendKeys("1/1995");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement Results = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content");
            if (Results.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else
            {
                TestStatus = LogStatus.FAIL;
            }

        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
        }
    }
    
    public  void CIS_SEARCH_002(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_003(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_004(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_005(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_006(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_007(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_008(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_009(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_010(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_011(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_012(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_013(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_014(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }

    public void CIS_SEARCH_015(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }










}
