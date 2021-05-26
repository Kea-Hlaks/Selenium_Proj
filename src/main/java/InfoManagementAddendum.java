import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
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
    public String IntLink ;
    private Properties prop;
    private NgWebDriver ngWebDriver;
    private WebElement ProvinceDD;
    private WebElement SearchByDD;
    private WebElement SearchByVal;
    private WebElement ProvinceVal;
    private WebElement SearchFilterDD;
    private WebElement SearchFilterVal;
    private WebElement InfoPop;
    private WebElement CertificateCHK;
    private WebElement CertificateType;
    private WebElement CertificateFormat;
    private WebElement PaperSize;
    private WebElement PaperSizeVal;
    private WebElement CertificateTypeVal;
    private WebElement CertificateFormatVal;
    private String ReqNum;
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

            ExtLink = driver.getCurrentUrl();

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
            driver.navigate().refresh();
            driver.get(ExtLink);

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
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
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
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_NOTIFYMANAGER_045(WebDriver driver)
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
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
            SGNumVal.clear();
            SGNumVal.sendKeys("26");

            TestStatus = LogStatus.SKIP;
        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = "Could not process";
        }
    }
    public void CIS_NOTIFYMANAGER_046(WebDriver driver)
    {
        try {

            ExtLink = prop.get("ExternalLink2").toString();

            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement MenuSearchBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
            SGNumVal.clear();
            SGNumVal.sendKeys("26");


            TestStatus = LogStatus.SKIP;
        } catch (Exception Ex) {

        }
    }
    public void CIS_NOTIFYMANAGER_047(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);
//
//         //opens browser
//            ExtLink = prop.get("ExternalLink2").toString();
//            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
//            driver.get(ExtLink);
//            ngWebDriver.waitForAngularRequestsToFinish();
//        //logs the external user in
//            WebElement Username = driver.findElement(By.id("mat-input-0"));
//            WebElement Password = driver.findElement(By.id("mat-input-1"));
//            Username.sendKeys(prop.get("ExtUsername2").toString());
//            Password.sendKeys(prop.get("ExtPass2").toString());
//            ngWebDriver.waitForAngularRequestsToFinish();
//
//            WebElement SignInBtn = driver.findElement(ByAngular.buttonText("Sign In"));
//
//            SignInBtn.click();
//            ngWebDriver.waitForAngularRequestsToFinish();

        //Click the search btn on the nav bar
            driver.navigate().refresh();
            driver.get(ExtLink);

            WebElement MenuSearchBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

         //selects the search items
            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[2]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
            SGNumVal.sendKeys("1/1908");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            InfoPop= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content");
            InfoPop.click();

            CertificateCHK= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[2]/div/div/span[3]/mat-checkbox/label");
            CertificateCHK.click();

            CertificateType= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[1]/mat-form-field/div/div[1]/div[3]");

            JavascriptExecutor JE = (JavascriptExecutor)driver;
            JE.executeScript("arguments[0].scrollIntoView();",CertificateType);

            CertificateType.click();
            CertificateTypeVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            CertificateTypeVal.click();

            CertificateFormat= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[2]/mat-form-field/div/div[1]/div[3]");
            CertificateFormat.click();
             CertificateFormatVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            CertificateFormatVal.click();


            PaperSize=ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[3]/mat-form-field/div/div[1]/div[3]");
            PaperSize.click();
            PaperSizeVal=ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[5]/span");
            PaperSizeVal.click();

            WebElement AddToCartBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[2]/button[2]"));
            AddToCartBtn.click();

            WebElement SelectDMethodBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-cart-page/div[2]/div/div/button[2]"));
            SelectDMethodBtn.click();


            WebElement FinishCheckOuTBtn = driver.findElement(By.xpath(" /html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[4]/button\n"));
            FinishCheckOuTBtn.click();
            WebElement ReqNu_ = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[5]/div/p");
            ReqNum = ReqNu_.getText();
            WebElement ManagerNotification = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container");

            WebElement CloseBtn = driver.findElement(By.xpath(" /html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button"));

            CloseBtn.click();
            //opens browser

            IntLink = prop.get("InternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);
            ngWebDriver.waitForAngularRequestsToFinish();
            //log in as manager
            WebElement DepartmentAddress = driver.findElement(By.id("mat-input-0"));
            WebElement DPassword = driver.findElement(By.id("mat-input-1"));
            DepartmentAddress.sendKeys(prop.get("InternalUsername2").toString());
            DPassword.sendKeys(prop.get("InternalPass").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement ManagerSignInBtn= driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/button"));
            ManagerSignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();


            WebElement MenuTaskBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuTaskBtn.click();

            WebElement InitiaReNu = ExplicitWait(driver,"//*[@id=\"mat-tab-content-0-0\"]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[2]");
            String StringRefNu = InitiaReNu.getText();
            if(StringRefNu.equals(ReqNum))
            {
                WebElement OpenTask = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-list/div/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[9]");
                OpenTask.click();

                WebElement Decision = ExplicitWait(driver,"            /html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[1]/div[7]/div/div/div/div[2]/p[2]\n");
                Decision .click();

                WebElement YesRadio=ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[1]/div/mat-radio-group/mat-radio-button[2]/label/span[1]/span[1]");
                YesRadio.click();

                WebElement OfficerSelect= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[1]/div/div/div[1]/mat-form-field/div/div[1]/div[3]\n");
                OfficerSelect.click();
                WebElement OfficerSelectVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[4]/span");
                OfficerSelectVal.click();

                WebElement Comment= driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[2]/div/mat-form-field/div/div[1]/div[3]/textarea\n"));
                Comment.sendKeys(prop.get("InternalPass").toString());

                WebElement SubmitBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[4]/div/div/button[1]\n");
                SubmitBtn.click();

                WebElement Notification = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container");

                WebElement CloseDecisionBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-decision/div/div[6]/button\n"));
                CloseDecisionBtn.click();

                //opens browser

                IntLink = prop.get("InternalLink2").toString();

                ProfilesIni profileIni = new ProfilesIni();
                FirefoxProfile profile = profileIni.getProfile("default");
                profile.setPreference("security.mixed_content.block_active_content", false);
                profile.setPreference("security.mixed_content.block_display_content", false);
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                driver = new FirefoxDriver(options);

                ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
                driver.get(IntLink);
                ngWebDriver.waitForAngularRequestsToFinish();
                //log in as Officer
                WebElement DAddress = driver.findElement(By.id("mat-input-0"));
                WebElement DPass= driver.findElement(By.id("mat-input-1"));
                DAddress.sendKeys(prop.get("OfficerUser").toString());
                DPass.sendKeys(prop.get("OfficerPass").toString());
                ngWebDriver.waitForAngularRequestsToFinish();

                WebElement OfficerSignInBtn= driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/button"));
                OfficerSignInBtn.click();
               // ngWebDriver.waitForAngularRequestsToFinish();


            }
            else
            {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Faild to find Reuest number : "+ ReqNum;
            }


            TestStatus = LogStatus.PASS;
            AdditionalNotes = "Manager was able to access the request and assign it to a officer ";

        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_NOTIFYMANAGER_048(WebDriver driver)
    {
        try {
//            InputStream inputStream = new FileInputStream(configFile);
//            prop = new Properties();
//            prop.load(inputStream);
//
//            //opens browser
//            ExtLink = prop.get("ExternalLink2").toString();
//            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
//            driver.get(ExtLink);
//            ngWebDriver.waitForAngularRequestsToFinish();
//            //logs the external user in
//            WebElement Username = driver.findElement(By.id("mat-input-0"));
//            WebElement Password = driver.findElement(By.id("mat-input-1"));
//            Username.sendKeys(prop.get("ExtUsername2").toString());
//            Password.sendKeys(prop.get("ExtPass2").toString());
//            ngWebDriver.waitForAngularRequestsToFinish();
//
//            WebElement SignInBtn = driver.findElement(ByAngular.buttonText("Sign In"));
//
//            SignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();

            //Click the search btn on the nav bar
            WebElement MenuSearchBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

            //selects the search items
            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[2]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
            SGNumVal.sendKeys("1/1908");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            InfoPop = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content");
            InfoPop.click();

            CertificateCHK = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[2]/div/div/span[3]/mat-checkbox/label");
            CertificateCHK.click();

            // CertificateType= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[1]/mat-form-field/div/div[1]/div[3]");
            //  CertificateType.click();
            //  CertificateTypeVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            // CertificateTypeVal.click();

            // CertificateFormat= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[2]/mat-form-field/div/div[1]/div[3]");
            // CertificateFormat.click();
            // CertificateFormatVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            // CertificateFormatVal.click();


            //PaperSize=ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[3]/mat-form-field/div/div[1]/div[3]");
            //PaperSize.click();
            //PaperSizeVal=ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[5]/span");
            //PaperSizeVal.click();

            WebElement AddToCartBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[2]/button[2]"));
            AddToCartBtn.click();

            WebElement SelectDMethodBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-cart-page/div[2]/div/div/button[2]"));
            SelectDMethodBtn.click();


            WebElement FinishCheckOuTBtn = driver.findElement(By.xpath(" /html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[4]/button\n"));
            FinishCheckOuTBtn.click();
            WebElement ReqNu_ = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[5]/div/p");
            ReqNum = ReqNu_.getText();
            WebElement ManagerNotification = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container");

            WebElement CloseBtn = driver.findElement(By.xpath(" /html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button"));

            CloseBtn.click();


            //opens browser

            IntLink = prop.get("InternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);
            ngWebDriver.waitForAngularRequestsToFinish();
            //log in as manager
            WebElement DepartmentAddress = driver.findElement(By.id("mat-input-0"));
            WebElement DPassword = driver.findElement(By.id("mat-input-1"));
            DepartmentAddress.sendKeys(prop.get("InternalUsername2").toString());
            DPassword.sendKeys(prop.get("InternalPass").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement ManagerSignInBtn = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/button"));
            ManagerSignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();


            WebElement MenuTaskBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuTaskBtn.click();

            WebElement InitiaReNu = ExplicitWait(driver, "//*[@id=\"mat-tab-content-0-0\"]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[2]");
            String StringRefNu = InitiaReNu.getText();
            if (StringRefNu.equals(ReqNum)) {
                WebElement OpenTask = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-list/div/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[9]");
                OpenTask.click();

                WebElement Decision = ExplicitWait(driver, "            /html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[1]/div[7]/div/div/div/div[2]/p[2]\n");
                Decision.click();

                WebElement NoRadio = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[1]/div/mat-radio-group/mat-radio-button[1]/label/span[1]/span[2]");
                NoRadio.click();

                WebElement OfficerSelect = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[1]/div/div/div[1]/mat-form-field/div/div[1]/div[3]\n");
                OfficerSelect.click();
                WebElement OfficerSelectVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[4]/span");
                OfficerSelectVal.click();

                WebElement Comment = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[2]/div/mat-form-field/div/div[1]/div[3]/textarea\n"));
                Comment.sendKeys(prop.get("InternalPass").toString());

                WebElement SubmitBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[2]/div/div[2]/div/form/div[4]/div/div/button[1]\n");
                SubmitBtn.click();

                WebElement Notification = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container");

                WebElement CloseDecisionBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-decision/div/div[6]/button\n"));
                CloseDecisionBtn.click();
            }
            else
            {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Failed to find Request number : "+ ReqNum;
            }

        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_NOTIFYMANAGER_049(WebDriver driver)
    {
        try {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            //opens browser
            ExtLink = prop.get("ExternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();
            //logs the external user in
            WebElement Username = driver.findElement(By.id("mat-input-0"));
            WebElement Password = driver.findElement(By.id("mat-input-1"));
            Username.sendKeys(prop.get("ExtUsername2").toString());
            Password.sendKeys(prop.get("ExtPass2").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement SignInBtn = driver.findElement(ByAngular.buttonText("Sign In"));

            SignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();

            //Click the search btn on the nav bar
            WebElement MenuSearchBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

            //selects the search items
            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[2]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
            SGNumVal.sendKeys("1/1908");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            InfoPop = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content");
            InfoPop.click();

            CertificateCHK = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[2]/div/div/span[3]/mat-checkbox/label");
            CertificateCHK.click();

            // CertificateType= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[1]/mat-form-field/div/div[1]/div[3]");
            //  CertificateType.click();
            //  CertificateTypeVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            // CertificateTypeVal.click();

            // CertificateFormat= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[2]/mat-form-field/div/div[1]/div[3]");
            // CertificateFormat.click();
            // CertificateFormatVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            // CertificateFormatVal.click();


            //PaperSize=ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[3]/mat-form-field/div/div[1]/div[3]");
            //PaperSize.click();
            //PaperSizeVal=ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[5]/span");
            //PaperSizeVal.click();

            WebElement AddToCartBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[2]/button[2]"));
            AddToCartBtn.click();

            WebElement SelectDMethodBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-cart-page/div[2]/div/div/button[2]"));
            SelectDMethodBtn.click();


            WebElement FinishCheckOuTBtn = driver.findElement(By.xpath(" /html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[4]/button\n"));
            FinishCheckOuTBtn.click();
            WebElement ReqNu_ = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[5]/div/p");
            ReqNum = ReqNu_.getText();
            WebElement ManagerNotification = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container");

            WebElement CloseBtn = driver.findElement(By.xpath(" /html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button"));

            CloseBtn.click();


            //opens browser

            IntLink = prop.get("InternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);
            ngWebDriver.waitForAngularRequestsToFinish();
            //log in as manager
            WebElement DepartmentAddress = driver.findElement(By.id("mat-input-0"));
            WebElement DPassword = driver.findElement(By.id("mat-input-1"));
            DepartmentAddress.sendKeys(prop.get("InternalUsername2").toString());
            DPassword.sendKeys(prop.get("InternalPass").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement ManagerSignInBtn = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/button"));
            ManagerSignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();


            WebElement MenuTaskBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuTaskBtn.click();

            WebElement InitiaReNu = ExplicitWait(driver, "//*[@id=\"mat-tab-content-0-0\"]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[2]");
            String StringRefNu = InitiaReNu.getText();
            if (StringRefNu.equals(ReqNum)) {
                WebElement OpenTask = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-list/div/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[9]");
                OpenTask.click();

            }
            else
            {
                TestStatus = LogStatus.FAIL;
                //ErrorMessage = "Failed to find Request number : "+ ReqNum;
            }

            TestStatus = LogStatus.SKIP;

        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_NOTIFYMANAGER_050(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            //opens browser
            ExtLink = prop.get("ExternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();
            //logs the external user in
            WebElement Username = driver.findElement(By.id("mat-input-0"));
            WebElement Password = driver.findElement(By.id("mat-input-1"));
            Username.sendKeys(prop.get("ExtUsername2").toString());
            Password.sendKeys(prop.get("ExtPass2").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement SignInBtn = driver.findElement(ByAngular.buttonText("Sign In"));

            SignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();

            //Click the search btn on the nav bar
            WebElement MenuSearchBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuSearchBtn.click();

            //selects the search items
            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[2]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver, "/html/body/div[3]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span");
            SearchFilterVal.click();

            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-7"));
            SGNumVal.sendKeys("1/1908");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            InfoPop = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content");
            InfoPop.click();

            CertificateCHK = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[2]/div/div/span[3]/mat-checkbox/label");
            CertificateCHK.click();

            // CertificateType= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[1]/mat-form-field/div/div[1]/div[3]");
            //  CertificateType.click();
            //  CertificateTypeVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            // CertificateTypeVal.click();

            // CertificateFormat= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[2]/mat-form-field/div/div[1]/div[3]");
            // CertificateFormat.click();
            // CertificateFormatVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            // CertificateFormatVal.click();


            //PaperSize=ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[3]/div[2]/div[3]/mat-form-field/div/div[1]/div[3]");
            //PaperSize.click();
            //PaperSizeVal=ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[5]/span");
            //PaperSizeVal.click();

            WebElement AddToCartBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[2]/button[2]"));
            AddToCartBtn.click();

            WebElement SelectDMethodBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-cart-page/div[2]/div/div/button[2]"));
            SelectDMethodBtn.click();


            WebElement FinishCheckOuTBtn = driver.findElement(By.xpath(" /html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[4]/button\n"));
            FinishCheckOuTBtn.click();
            WebElement ReqNu_ = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[5]/div/p");
            ReqNum = ReqNu_.getText();
            WebElement ManagerNotification = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container");

            WebElement CloseBtn = driver.findElement(By.xpath(" /html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button"));

            CloseBtn.click();


            //opens browser

            IntLink = prop.get("InternalLink2").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);
            ngWebDriver.waitForAngularRequestsToFinish();
            //log in as manager
            WebElement DepartmentAddress = driver.findElement(By.id("mat-input-0"));
            WebElement DPassword = driver.findElement(By.id("mat-input-1"));
            DepartmentAddress.sendKeys(prop.get("InternalUsername2").toString());
            DPassword.sendKeys(prop.get("InternalPass").toString());
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement ManagerSignInBtn = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/button"));
            ManagerSignInBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();


            WebElement MenuTaskBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a/img");
            MenuTaskBtn.click();

            WebElement InitiaReNu = ExplicitWait(driver, "//*[@id=\"mat-tab-content-0-0\"]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[2]");
            String StringRefNu = InitiaReNu.getText();
            if (StringRefNu.equals(ReqNum)) {
                WebElement OpenTask = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-list/div/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[9]");
                OpenTask.click();

            }
            else
            {
                TestStatus = LogStatus.FAIL;
                //ErrorMessage = "Failed to find Request number : "+ ReqNum;
            }

            TestStatus = LogStatus.SKIP;
        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_NOTIFYMANAGER_051(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_NOTIFYMANAGER_052(WebDriver driver)
    {
        try
        {

        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_NOTIFYMANAGER_053(WebDriver driver)
    {
        try
        {

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
