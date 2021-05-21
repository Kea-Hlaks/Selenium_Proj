import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

public class InformationManagement {
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
    public void NumberSearch(WebDriver driver) throws IOException
    {
        try {
//            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//            ProfilesIni profileIni = new ProfilesIni();
//            FirefoxProfile profile = profileIni.getProfile("default");
//            profile.setPreference("security.mixed_content.block_active_content", false);
//            profile.setPreference("security.mixed_content.block_display_content", false);
//            FirefoxOptions options = new FirefoxOptions();
//            options.setProfile(profile);
//            driver = new FirefoxDriver(options);
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
            if (Results.isDisplayed()){
                TestStatus = LogStatus.PASS;
            }
            else {
                TestStatus = LogStatus.FAIL;
            }
        }catch (Exception Ex)
        {
            throw Ex;
        }
    }
    public void ParcelDescSearch(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            ngWebDriver.waitForAngularRequestsToFinish();
            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal =ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[4]/span");
            SearchByVal.click();
            ngWebDriver.waitForAngularRequestsToFinish();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement MunicipalityDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            MunicipalityDD.click();
            WebElement MunicipalityVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[10]/span");
            MunicipalityVal.click();

            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement AdministrativeDistDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            AdministrativeDistDD.click();
//Test Fails since the Search data is not correct

            TestStatus = LogStatus.FAIL;
            ErrorMessage = "Incorrect Data binded Expected Data eg : JR";

        }catch (Exception Ex){
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void SectTitleSearch(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            ngWebDriver.waitForAngularRequestsToFinish();
            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[1]/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[5]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            ngWebDriver.waitForAngularRequestsToFinish();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            WebElement MunicipalityDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            MunicipalityDD.click();

            WebElement MunicipalityVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[9]/span");
            MunicipalityVal.click();

            WebElement FillingNum = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[2]/mat-form-field/div/div[1]/div[3]");
            FillingNum = FillingNum.findElement(By.id("mat-input-4"));
            FillingNum.sendKeys("DM8880");


            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();
            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement Result = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div[1]/mat-card/mat-card-content");

            if (Result.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Result not Displayed";
            }
        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
            throw Ex;//Remove on production

        }

    }
    public void FreeTextSearch(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            ngWebDriver.waitForAngularRequestsToFinish();

            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            WebElement TextSearch = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/form/mat-form-field/div/div[1]/div[3]");
            TextSearch = TextSearch.findElement(By.id("mat-input-2"));
            TextSearch.sendKeys("1/1995");

            WebElement SearchBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button");
            SearchBtn.click();

            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement Result = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content");
            if (Result.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Result not Displayed";
            }
        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
            throw Ex;
        }
    }
    public void RangeSearch(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            ngWebDriver.waitForAngularRequestsToFinish();

            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[1]/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[7]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            ngWebDriver.waitForAngularRequestsToFinish();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SearchFilterVal.click();

            WebElement Township = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            Township.click();

            TestStatus = LogStatus.FAIL;
            ErrorMessage = "Incorrect data displayed under Township/Allotment , Expected data eg ('BEDFORDVIEW')";
        }catch (Exception Ex)
        {
            throw Ex;
        }

    }
    public  void TemplateSearch(WebDriver driver)
    {
        try {
            driver.navigate().refresh();
            ngWebDriver.waitForAngularRequestsToFinish();
            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[1]/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();
            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[2]/span");
            SearchByVal.click();

            WebElement FileUploadtextbox = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[1]/mat-form-field/div/div[1]/div[3]");
            if (FileUploadtextbox.isDisplayed())
            {
                JavascriptExecutor JE = (JavascriptExecutor)driver;
                JE.executeScript("document.querySelector('#newFile').hidden = false");

                WebElement FileUpload = ExplicitWait(driver, "//*[@id='newFile']");
                FileUpload.sendKeys("C:\\Users\\Sello.TERRA\\IdeaProjects\\Selenium_Proj\\Documents\\SearchData\\CsvTemplates\\template.csv");

                WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
                SearchBtn.click();
                ngWebDriver.waitForAngularRequestsToFinish();

                try
                {
                    WebElement DataNotFoundNot = ExplicitWait(driver, "//*[@id='mat-dialog-0']");
                    if (DataNotFoundNot.isDisplayed())
                    {
                        TestStatus = LogStatus.FAIL;
                        ErrorMessage = "Data not Found : SG Number : 1/1995";
                        AdditionalNotes = "The system cant fetch data ";
                    }
                }
                catch (NoSuchElementException Ex)
                {
                    TestStatus = LogStatus.PASS;
                }


            }
            else {
                TestStatus = LogStatus.FAIL;
                ErrorMessage ="Failed to upload file";
            }

            
        }catch (Exception Ex){
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
            throw Ex;
        }
    }
    public void DataProvisioning(WebDriver driver)
    {
        try
        {
            TestStatus = LogStatus.UNKNOWN;
            AdditionalNotes = "The System doesnt show the predefined Size limit ";
        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void PrePackagedData(WebDriver driver)
    {
        try {
            driver.navigate().refresh();
            WebElement DPViewAllBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[2]/div[2]/div/mat-card/mat-card-content/div[1]/span[2]/span");
            DPViewAllBtn.click();

            WebElement LocationDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-pre-packages/div/div[1]/div/mat-card/mat-card-content/div[3]/div/mat-form-field/div/div[1]/div[3]");
            LocationDD.click();
            WebElement LocationVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[4]/span"); //val = municipality
            LocationVal.click();

            WebElement _ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-pre-packages/div/div[1]/div/mat-card/mat-card-content/div[3]/div[2]/form/mat-form-field/div/div[1]/div[3]");
            _ProvinceDD.click();

            WebElement _provinceVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            _provinceVal.click();

            WebElement MunicipalityDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-pre-packages/div/div[1]/div/mat-card/mat-card-content/div[3]/div[3]/form/mat-form-field/div/div[1]/div[3]");
            MunicipalityDD.click();

            WebElement MunicipalityVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[5]/span");
            MunicipalityVal.click();

            JavascriptExecutor je = (JavascriptExecutor) driver;

            WebElement MonthBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-pre-packages/div/div[2]/div[1]/mat-card/mat-card-content/div[4]/div[1]/mat-radio-group/mat-radio-button[1]/label");

            je.executeScript("arguments[0].scrollIntoView(true);",MonthBtn);

            MonthBtn.click();

            WebElement SubscribeBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-pre-packages/div/div[2]/div[1]/mat-card/mat-card-content/div[4]/div[2]/button");
            SubscribeBtn.click();

            WebElement SubmitRequestBtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-subscription-dialog/div[2]/div[2]/button");
            SubmitRequestBtn.click();

            WebElement RefNumDiv = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-pre-sub-modal/div/div[5]/div");
            PrePackagedRef = RefNumDiv.getText();
            WebElement CloseBtn = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container/app-pre-sub-modal/div/div[6]/div/button");
            if (CloseBtn.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else {
                TestStatus = LogStatus.FAIL;
                ErrorMessage ="Failed to place a Request";
            }

        }
        catch (Exception Ex){
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void PrePackagedDataNotification(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            Thread.sleep(10000);
            String EmailBody = ReadEmail();
            String ClearEmail = EmailBody.substring(EmailBody.lastIndexOf("7bit")+1);
            String RefNum = EmailBody.substring(EmailBody.lastIndexOf("No: ")-1,EmailBody.indexOf("</p><p>Subscription"));
            RefNum = RefNum.replaceAll("\\s+"," ").trim();
            RefNum = RefNum.substring(4);
            PrePackagedRef = PrePackagedRef.replaceAll("\\s+"," ").trim();
            if (RefNum.equals(PrePackagedRef))
            {
                TestStatus = LogStatus.PASS;
                AdditionalNotes = ClearEmail;
            }
            else
            {
                Thread.sleep(5000);
                EmailBody = ReadEmail();
                RefNum = EmailBody.substring(EmailBody.lastIndexOf("No: ")-1,EmailBody.indexOf("</p><p>Subscription"));

                if (RefNum.equals(PrePackagedRef))
                {
                    TestStatus = LogStatus.PASS;
                    AdditionalNotes = ClearEmail;
                }
                else
                {
                    TestStatus = LogStatus.FAIL;
                    AdditionalNotes = "Failed to read email";
                }
            }
        {}



        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }

    }
    public void CaptureRequest(WebDriver driver)
    {
        try {
            //driver.navigate().refresh();
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
            SGNumVal = SGNumVal.findElement(By.id("mat-input-5"));
            SGNumVal.sendKeys("1/1995");

            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            WebElement Result = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content/div/span/a");
            if (Result.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else
            {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Failed to Fetch Results";
            }
        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CheckDataAvailability(WebDriver driver)
    {
        try
        {
            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-5"));
            SGNumVal.clear();
            SGNumVal.sendKeys("1/2006");
            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();
            WebElement Result = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content/div/span/a");
            if (Result.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
            }
            else
            {
                TestStatus = LogStatus.FAIL;
                ErrorMessage = "Failed to Fetch Results";
            }

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void NotifyManager(WebDriver driver)
    {
        try
        {
            WebElement SGNumVal = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SGNumVal = SGNumVal.findElement(By.id("mat-input-5"));
            SGNumVal.clear();
            SGNumVal.sendKeys("1");
            WebElement SearchBtn = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button"));
            SearchBtn.click();

            WebElement Yesbtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div/button[1]");
            Yesbtn.click();

            WebElement CommentsTxt = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div[2]/mat-form-field/div/div[1]/div[3]");
            CommentsTxt = CommentsTxt.findElement(By.id("mat-input-7"));
            CommentsTxt.sendKeys("Testing Notify manager");
            WebElement Submitbtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div[3]/div[3]/button[1]");
            Submitbtn.click();
            WebElement ManagerNotification = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div/div[6]/div/button");
            if (ManagerNotification.isDisplayed())
            {
                TestStatus = LogStatus.PASS;
                AdditionalNotes = "Negative test using '1' as our input under SG Number";
            }
            else
            {
                try {
                    WebElement Result = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content/div/span/a");
                    if (Result.isDisplayed())
                    {
                        TestStatus = LogStatus.FAIL;
                        ErrorMessage = "Results were not supposed to be displayed";
                    }
                    else
                    {
                        TestStatus = LogStatus.PASS;
                    }
                }catch (NoSuchElementException Ex)
                {
                    TestStatus = LogStatus.PASS;
                }

            }

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CloseBtn(WebDriver driver,String Xpath)
    {
        try
        {
            //Function created to reduce cross dependency of functions
            WebElement CloseBtn = ExplicitWait(driver,Xpath);
            CloseBtn.click();
        }catch (Exception Ex)
        {
            throw Ex;
        }

    }
    public void ValidateRequestSize(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal =ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();

            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[5]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[5]/span");
            SearchFilterVal.click();

            WebElement MunicipalityDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            MunicipalityDD.click();
            WebElement MunicipalityVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[1]/span");
            MunicipalityVal.click();

            WebElement DeedRegNumTxt = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            DeedRegNumTxt = DeedRegNumTxt.findElement(By.id("mat-input-5"));
            DeedRegNumTxt.sendKeys("200/1999");

            WebElement Searchbtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[1]/div/mat-card/mat-card-content/div[5]/span[1]/button");
            Searchbtn.click();

            WebElement ViewResultsbtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content/div/span/a/mat-icon");
            ViewResultsbtn.click();

            WebElement ReqSize = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[1]/mat-card/mat-card-content/div/div[2]/div[1]/div[3]/span/span[2]/span[2]");
            String FileSize = ReqSize.getText();

            WebElement DownloadBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[1]/a");
            if (DownloadBtn.isDisplayed())
            {
                TestStatus = LogStatus.FAIL;
                AdditionalNotes = "The requets current size is : "+ FileSize +" ,And the system has not prompted the user that the reuest will be regarded/marked as bulk as per FRS v1.2 INformation Management Page 26";
            }
            else
            {
                TestStatus = LogStatus.PASS;
            }


        }
        catch (Exception Ex)
        {
            throw Ex;
        }
    }

    public void NotifyUserLimit(WebDriver driver)
    {
        try
        {
            TestStatus = LogStatus.FAIL;
            AdditionalNotes = "Refer to the previous test case ";

        }catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void SendDataViaEmail(WebDriver driver) throws IOException {
        try
        {
            driver.navigate().refresh();
            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal =ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();

            SearchByVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[5]/span");
            SearchByVal.click();

            SearchFilterDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[3]/form/mat-form-field/div/div[1]/div[3]");
            SearchFilterDD.click();
            SearchFilterVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[5]/span");
            SearchFilterVal.click();

            WebElement MunicipalityDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            MunicipalityDD.click();
            WebElement MunicipalityVal = ExplicitWait(driver,"/html/body/div[3]/div/div/div/mat-option[1]/span");
            MunicipalityVal.click();

            WebElement DeedRegNumTxt = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            DeedRegNumTxt = DeedRegNumTxt.findElement(By.id("mat-input-5"));
            DeedRegNumTxt.sendKeys("200/1999");

            WebElement Searchbtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[1]/div/mat-card/mat-card-content/div[5]/span[1]/button");
            Searchbtn.click();

            WebElement ViewResultsbtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content/div/span/a/mat-icon");
            ViewResultsbtn.click();

            WebElement AddToCart = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[2]/button[2]");
            AddToCart.click();

            WebElement SelectDeliveryMethod = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-cart-page/div[2]/div/div/button[2]");
            SelectDeliveryMethod.click();

            WebElement ElectronicRdoBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[3]/mat-radio-group/mat-radio-button[3]/label/span[2]");
            ElectronicRdoBtn.click();

            WebElement EmailRdoBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[1]/div[2]/mat-radio-group/mat-radio-button[1]/label/span[2]");
            EmailRdoBtn.click();

            WebElement Commentstxt = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[2]/div[2]/mat-form-field/div/div[1]/div[3]");
            Commentstxt = Commentstxt.findElement(By.id("mat-input-7"));
            Commentstxt.sendKeys("Single Request Test (Automated)");

            WebElement FinishCheckOutBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[3]/button");
            FinishCheckOutBtn.click();

            WebElement RequestNumStr = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[5]/div/p");
            String RequestNumber_ = RequestNumStr.getText();

            CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button");
            String EmailBody = ReadEmail();

            String ClearEmail = EmailBody.substring(EmailBody.lastIndexOf("7bit")+1);

            String RefNum = ClearEmail.substring(ClearEmail.indexOf("number is ")+10);
            RefNum = RefNum.substring(0,9);
            if(RequestNumber_.equals(RefNum))
            {
                TestStatus = LogStatus.PASS;
                AdditionalNotes = ClearEmail.substring(5);
            }
            else
            {
                TestStatus = LogStatus.FAIL;
                AdditionalNotes = "Failed to receive communication Email";
            }

        }catch (Exception Ex)
        {
            throw Ex;
        }
    }

    public  void SendDataViaFtp(WebDriver driver)
    {
        try {

            driver.navigate().refresh();
            WebElement SeaarchBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[2]/a");
            SeaarchBtn.click();

            ProvinceDD = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[1]/form/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal =ExplicitWait(driver,"/html/body/div[2]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            SearchByDD = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[2]/span[2]/form/mat-form-field/div/div[1]/div[3]");
            SearchByDD.click();

            SearchByVal = ExplicitWait(driver,"/html/body/div[2]/div/div/div/mat-option[3]/span");
            SearchByVal.click();

            WebElement SgNumberVal = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[3]/span/mat-form-field/div/div[1]/div[3]");
            SgNumberVal = SgNumberVal.findElement(By.id("mat-input-4"));
            SgNumberVal.sendKeys("1/1995");

            WebElement Searchbtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div/div/mat-card/mat-card-content/div[5]/span[1]/button");
            Searchbtn.click();

            WebElement ViewResultsbtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-page/div/div/div[1]/div[2]/div/mat-card/mat-card-content/div/span/a/mat-icon");
            ViewResultsbtn.click();

            WebElement AddToCart = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-search-details/div[2]/div/div[2]/button[2]");
            AddToCart.click();

            WebElement SelectDeliveryMethod = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-cart-page/div[2]/div/div/button[2]");
            SelectDeliveryMethod.click();

            WebElement ElectronicRdoBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[3]/mat-radio-group/mat-radio-button[3]/label/span[2]");
            ElectronicRdoBtn.click();

            WebElement FtpRdoBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[1]/div[2]/mat-radio-group/mat-radio-button[2]/label/span[2]");
            FtpRdoBtn.click();

            WebElement Commentstxt = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[2]/div[2]/mat-form-field/div/div[1]/div[3]");
            Commentstxt = Commentstxt.findElement(By.id("mat-input-6"));
            Commentstxt.sendKeys("Single Request Test (Automated)");

            WebElement FinishCheckOutBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-delivery-page/div/mat-card/mat-card-content/div[4]/mat-card/mat-card-content/div[3]/button");
            FinishCheckOutBtn.click();

            TestStatus = LogStatus.FAIL;
            ErrorMessage = "Failed t o receive Email with Ftp link";


        }catch (Exception ex)
        {
            throw ex;
        }
    }

@Test
    public String ReadEmail() throws IOException {
        POP3SClient Client_ = new POP3SClient(true);
        String Password;
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);
            Client_.setDefaultTimeout(100000);
            Client_.connect(prop.getProperty("HostName"),Integer.parseInt(prop.getProperty("Port")));
            if (Client_.login(prop.getProperty("User"),prop.getProperty("Pass")))
            {
                POP3MessageInfo[] messages = Client_.listMessages();
                int totalmsgs = messages.length;
                int messageNum;
                if (NumberOfEmails == 0)
                {
                    messageNum = messages[totalmsgs - 1].number;

                    NumberOfEmails = messageNum;
                    Reader reader = Client_.retrieveMessageTop(messageNum, 10);
                    String MsgString = IOUtils.toString(reader);
                    EmailBody = MsgString;
                }
                else
                {
                    messageNum = messages[totalmsgs - 1].number;
                    if(messageNum > NumberOfEmails)
                    {
                        NumberOfEmails = messageNum;
                        Reader reader = Client_.retrieveMessageTop(messageNum, 10);
                        String MsgString = IOUtils.toString(reader);
                        EmailBody = MsgString;
                    }
                    else{
                        ReadEmail();
                    }

                }


            }
            return EmailBody;
        }catch (Exception Ex)
        {
            throw Ex;
        }
        finally {
            Client_.disconnect();
        }
    }

}
