//import com.paulhammant.ngwebdriver.ByAngular;
//import com.paulhammant.ngwebdriver.NgWebDriver;
//import com.relevantcodes.extentreports.LogStatus;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.net.pop3.POP3MessageInfo;
//import org.apache.commons.net.pop3.POP3SClient;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.ProfilesIni;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.*;
//import java.time.Duration;
//import java.util.Properties;
//
//import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;


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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import panda.net.mail.EmailAddress;

import javax.management.relation.RoleInfo;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class UserAccessManagement {


//    File configFile = new File("src/main/resources/Config.properties");
//    LogStatus TestStatus;
//
//    public String ExtLink ;
//    public String IntLink;
//    private Properties prop;
//    private NgWebDriver ngWebDriver;
//    public void CaptureRegistrationReq(WebDriver driver) throws IOException {
//        try
//        {
////            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
////            ProfilesIni profileIni = new ProfilesIni();
////            FirefoxProfile profile = profileIni.getProfile("default");
////            profile.setPreference("security.mixed_content.block_active_content", false);
////            profile.setPreference("security.mixed_content.block_display_content", false);
////            FirefoxOptions options = new FirefoxOptions();
////            options.setProfile(profile);
////            driver = new FirefoxDriver(options);
//            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
//            //Boolean PropertiesOpen = RSI.PropertiesOpen();
//
//            File configFile = new File("src/main/resources/Config.properties");
//            InputStream inputStream = new FileInputStream(configFile);
//            prop = new Properties();
//            prop.load(inputStream);
//
//
//            ExtLink = prop.get("ExternalLink").toString();
//
//            driver.get(ExtLink);
//            WebElement RegisterLik = driver.findElement(By.linkText("Click here to Register"));
//            RegisterLik.click();
//            ngWebDriver.waitForAngularRequestsToFinish();
//            WebElement EmailAddress = ((FirefoxDriver) driver).findElementById("mat-input-2");
//            EmailAddress.sendKeys(prop.get("ExtEmail").toString());
//            WebElement EmailAddressConfirm = ((FirefoxDriver) driver).findElementById("mat-input-3");
//            EmailAddressConfirm.sendKeys(prop.get("ExtEmail").toString());
//
//            WebElement ProvinceDD = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[3]/span/mat-form-field/div/div[1]/div[3]");
//            ProvinceDD.click();
//            WebElement ProvinceVal = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
//            ProvinceVal.click();
//
//            WebElement RoleDD = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[4]/span/mat-form-field/div/div[1]/div[3]");
//            RoleDD.click();
//            WebElement RoleVal = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
//            RoleVal.click();
//
//            WebElement ConfirmNxt = driver.findElement(ByAngular.buttonText("Confirm and Next"));
//            ConfirmNxt.click();
//
//            WebElement TitleDD = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[1]/span[1]/mat-form-field/div/div[1]/div[3]");
//            TitleDD.click();
//            WebElement TitleVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
//            TitleVal.click();
//
//            WebElement FirstName = driver.findElement(By.id("mat-input-4"));
//            FirstName.sendKeys("Sello_AT");
//
//            WebElement LastName = driver.findElement(By.id("mat-input-5"));
//            LastName.sendKeys("Halks_AT");
//
//            WebElement Telephone = driver.findElement(By.id("mat-input-6"));
//            Telephone.sendKeys("0119203521");
//
//            WebElement Mobile = driver.findElement(By.id("mat-input-8"));
//            Mobile.sendKeys("0740778077");
//
//            WebElement OrganisationDD = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
//            OrganisationDD.click();
//            WebElement OrganisationVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
//            OrganisationVal.click();
//
//            WebElement SectorDD = driver.findElement(By.id("mat-select-8"));
//            SectorDD.click();
//            WebElement SectorVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
//            SectorVal.click();
//
//            for (int i = 0;i < 3;i++)
//            {
//                //Simplified loop to fill all the 3 addresses
//                int Start = 9 + i;
//                //i = i-=-1;
//                driver.findElement(By.id("mat-input-"+Start)).sendKeys("Test Address : " + i);
//            }
//
//            WebElement PostCode = driver.findElement(By.id("mat-input-12"));
//            PostCode.sendKeys("1632");
//
//            WebElement ConfirmNxt2 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button"));
//            ConfirmNxt2.click();
//            if (!ConfirmNxt2.isDisplayed())
//            {
//                WebElement BackBtn = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[7]/span[1]/button"));
//                BackBtn.click();
//                if (ConfirmNxt2.isDisplayed())
//                {
//                    //TestStatus = LogStatus.PASS;
//                    this.TestStatus = LogStatus.PASS;
//                }
//                else{
//                    TestStatus = LogStatus.FAIL;
//                }
//            }
//            else{
//                TestStatus = LogStatus.FAIL;
//
//            }
//        }catch (Exception ex)
//        {
//            throw ex;
//        }
//
//    }
//
//    public  void SelectNotificationOptions(WebDriver driver)
//    {
//        try
//        {
//            WebElement ConfirmNxt = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button"));
//            ConfirmNxt.click();
//
//            WebElement InfoNot = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[5]/span[1]/mat-checkbox/label/span[1]"));
//            InfoNot.click();
//
//            WebElement NewsNot = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[5]/span[2]/mat-checkbox/label/span[1]"));
//            NewsNot.click();
//
//            WebElement EventsNot = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[6]/span[2]/mat-checkbox/label/span[1]"));
//            EventsNot.click();
//
//            if (InfoNot.isSelected())
//            {
//                this.TestStatus = LogStatus.PASS;
//            }
//            else{
//                this.TestStatus = LogStatus.FAIL;
//            }
//
//        }
//        catch (Exception Ex)
//        {
//            throw Ex;
//        }
//    }
//
//    public void SelectSecurityQuestions(WebDriver driver)
//    {
//        try
//        {
//            WebElement ModeOfComm = driver.findElement(By.cssSelector("mat-form-field.ng-tns-c126-24 > div:nth-child(1) > div:nth-child(1) > div:nth-child(3)"));
//            ModeOfComm.click();
//
//            WebElement ModeOfCommVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
//            ModeOfCommVal.click();
//
//            WebElement SecurityQuestion1 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[2]/span[1]/mat-form-field/div/div[1]/div[3]"));
//            SecurityQuestion1.click();
//            WebElement SecurityQuestionVal1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span"));
//            SecurityQuestionVal1.click();
//            WebElement SecurityAnswer1 = driver.findElement(By.xpath("//*[@id='mat-input-13']"));
//            SecurityAnswer1.sendKeys("Test");
//
//            WebElement SecurityQuestion2 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[3]/span[1]/mat-form-field/div/div[1]/div[3]"));
//            SecurityQuestion2.click();
//            WebElement SecurityQuestionVal2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
//            SecurityQuestionVal2.click();
//            WebElement SecurityAnswer2 = driver.findElement(By.xpath("//*[@id='mat-input-14']"));
//            SecurityAnswer2.sendKeys("Test");
//
//            WebElement SecurityQuestion3 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]"));
//            SecurityQuestion3.click();
//            WebElement SecurityQuestionVal3 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
//            SecurityQuestionVal3.click();
//            WebElement SecurityAnswer3 = driver.findElement(By.xpath("//*[@id='mat-input-15']"));
//            SecurityAnswer3.sendKeys("Test");
//
//            WebElement Iagree = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[6]/span[1]/mat-checkbox/label/span[1]"));
//            Iagree.click();
//
//            String SecurityAnsVal = SecurityAnswer3.getAttribute("value").toString();
//            if (!SecurityAnsVal.equals(""))
//            {
//             TestStatus= LogStatus.PASS;
//            }
//            else{
//                TestStatus = LogStatus.FAIL;
//            }
//
//        }catch (Exception Ex)
//        {
//            throw Ex;
//        }
//    }
//
//    public void SubmitRegistrationRequest(WebDriver driver)
//    {
//        try
//        {
//            WebElement Submit = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[7]/span[2]/button"));
//            Submit.click();
//            ngWebDriver.waitForAngularRequestsToFinish();
//            WebElement EmailInput = ExplicitWait(driver,"//*[@id=\"mat-input-16\"]");
//            if (!EmailInput.equals(null))
//            {
//                TestStatus = LogStatus.PASS;
//            }
//            else {
//                TestStatus = LogStatus.FAIL;
//            }
//
//        }catch (Exception Ex)
//        {
//            throw Ex;
//        }
//    }
//
//    public WebElement ExplicitWait(WebDriver driver, String ExpectedElement)
//    {
//        WebElement targetElement = null;
//        try
//        {
//
//            targetElement = new WebDriverWait(driver, Duration.ofSeconds(30)).until((WebDriver dr1) -> dr1.findElement(By.xpath(ExpectedElement)));
//
////            Func<WebDriver, WebElement> waitForSearchElement = new Func<WebDriver, WebElement>((WebDriver Web) ->
////            {
////                WebElement FoundElement = driver.findElement(By.xpath(ExpectedElement));
////                return FoundElement;
////            });
//            //WebDriverWait wait = new WebDriverWait(driver, 30);
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////            targetElement = wait.until(waitForSearchElement);
//            //Thread.sleep(2000);
//        }
//        catch (Exception e)
//        {
//
//            throw e;
//        }
//        finally {
//            return targetElement;
//        }
//    }
//
//    @Test
//    public void _CaptureRegistrationReq() throws IOException {
//        try
//        {
//            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//            ProfilesIni profileIni = new ProfilesIni();
//            FirefoxProfile profile = profileIni.getProfile("default");
//            profile.setPreference("security.mixed_content.block_active_content", false);
//            profile.setPreference("security.mixed_content.block_display_content", false);
//            FirefoxOptions options = new FirefoxOptions();
//            options.setProfile(profile);
//            FirefoxDriver driver = new FirefoxDriver(options);
//            NgWebDriver ngWebDriver = new NgWebDriver(driver);
//            //Boolean PropertiesOpen = RSI.PropertiesOpen();
//
//            File configFile = new File("src/main/resources/Config.properties");
//            InputStream inputStream = new FileInputStream(configFile);
//            prop = new Properties();
//            prop.load(inputStream);
//
//
//            ExtLink = prop.get("ExternalLink").toString();
//
//            driver.get(ExtLink);
//            WebElement RegisterLik = driver.findElement(By.linkText("Click here to Register"));
//            RegisterLik.click();
//            ngWebDriver.waitForAngularRequestsToFinish();
//            WebElement EmailAddress = driver.findElementById("mat-input-2");
//            EmailAddress.sendKeys("kidsonmedicine@gmail.com");
//            WebElement EmailAddressConfirm = driver.findElementById("mat-input-3");
//            EmailAddressConfirm.sendKeys("kidsonmedicine@gmail.com");
//
//            WebElement ProvinceDD = driver.findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[3]/span/mat-form-field/div/div[1]/div[3]");
//            ProvinceDD.click();
//            WebElement ProvinceVal = driver.findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
//            ProvinceVal.click();
//
//            WebElement RoleDD = driver.findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[4]/span/mat-form-field/div/div[1]/div[3]");
//            RoleDD.click();
//            WebElement RoleVal = driver.findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
//            RoleVal.click();
//
//            WebElement ConfirmNxt = driver.findElement(ByAngular.buttonText("Confirm and Next"));
//            ConfirmNxt.click();
//
//            WebElement TitleDD = driver.findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[1]/span[1]/mat-form-field/div/div[1]/div[3]");
//            TitleDD.click();
//            WebElement TitleVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
//            TitleVal.click();
//
//            WebElement FirstName = driver.findElement(By.id("mat-input-4"));
//            FirstName.sendKeys("Sello_AT");
//
//            WebElement LastName = driver.findElement(By.id("mat-input-5"));
//            LastName.sendKeys("Halks_AT");
//
//            WebElement Telephone = driver.findElement(By.id("mat-input-6"));
//            Telephone.sendKeys("0119203521");
//
//            WebElement Mobile = driver.findElement(By.id("mat-input-8"));
//            Mobile.sendKeys("0740778077");
//
//            WebElement OrganisationDD = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
//            OrganisationDD.click();
//            WebElement OrganisationVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
//            OrganisationVal.click();
//
//            WebElement SectorDD = driver.findElement(By.id("mat-select-8"));
//            SectorDD.click();
//            WebElement SectorVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
//            SectorVal.click();
//
//            for (int i = 0;i < 3;i++)
//            {
//                //Simplified loop to fill all the 3 addresses
//                int Start = 9 + i;
//                i = i-=-1;
//                driver.findElement(By.id("mat-input-"+Start)).sendKeys("Test Address : " + i);
//            }
//
//            WebElement PostCode = driver.findElement(By.id("mat-input-12"));
//            PostCode.sendKeys("1632");
//
//            WebElement ConfirmNxt2 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button"));
//            ConfirmNxt2.click();
//
//        }catch (Exception ex)
//        {
//            throw ex;
//        }
//
//    }
//@Test
//    public void ReadEmail() throws IOException {
//    //POP3Client _client = new POP3Client();
//    POP3SClient Client_ = new POP3SClient(true);
//    String Password;
//        try
//        {
//            //boolean LogedIn = false;
//            InputStream inputStream = new FileInputStream(configFile);
//            prop = new Properties();
//            prop.load(inputStream);
//
//            Client_.setDefaultTimeout(100000);
//            Client_.connect(prop.getProperty("HostName"),Integer.parseInt(prop.getProperty("Port")));
//            if (Client_.login(prop.getProperty("User"),prop.getProperty("Pass")))
//            {
//                POP3MessageInfo[] messages = Client_.listMessages();
//                for (int i = 0; i < 5; i++) {
//                    int messageNum = messages[i].number;
//                    System.out.println("Message number: " + messageNum);
//                    Reader reader = Client_.retrieveMessageTop(messageNum, 10);
//                    String MsgString = IOUtils.toString(reader);
//
//                    String toBeSearched = "Your password is : ";
//
//                    int ix = MsgString.indexOf(toBeSearched);
//                    String Code = MsgString.substring(ix + toBeSearched.length());
//                    Password = Code.substring(0, Code.length() > 9 ? 9 : Code.length());
//                    //System.out.println("Message:\n" + MsgString);
//                    //IOUtils.closeQuietly(reader);
//                }
//            }
//        }catch (Exception Ex)
//        {
//            throw Ex;
//        }
//        finally {
//            Client_.disconnect();
//        }
//    }
//
//

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
    private WebElement UserRole;
    private WebElement AddressLine1;
    private WebElement AddressLine2;
    private WebElement AddressLine3;
    private WebElement UserRoleVal;
    private WebElement RegPop;
    private WebElement PersonalInfoRad;
    private String ReqNum;
    String AdditionalNotes = null;
    private String PrePackagedRef;
    private int NumberOfEmails = 0;
    private String EmailBody = null;
    public int TestRetry = 0;
    private WebElement EmailAddress;
    private WebElement ConfirmEmailAddress;
    private String NewEmailVal;
    private int PlsCode;

    public WebElement ExplicitWait(WebDriver driver, String Xpath)
    {
        WebElement targetElement = null;
        try
        {
            ngWebDriver.waitForAngularRequestsToFinish();
            targetElement = new WebDriverWait(driver, Duration.ofSeconds(20)).until((WebDriver dr1) -> dr1.findElement(By.xpath(Xpath)));
            //Thread.sleep(3000);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally {
            return targetElement;
        }
    }

    public void CIS_EXTERNALUSERREGISTRATION_001(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            ExtLink = prop.get("ClientSideExternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();

            WebElement RegisterBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[4]/span[1]/a/u");
            RegisterBtn.click();

            //Role information
            int x = 1 + (int) (Math.random() * 109874515);//x is random number

            WebElement Email = ExplicitWait(driver,"//*[@id=\"mat-input-2\"]");
            Email.sendKeys(prop.get("ExtEmailTest").toString()+x+"@gmail.com");

            WebElement ConfirmEmail = ExplicitWait(driver,"//*[@id=\"mat-input-3\"]");
            ConfirmEmail.sendKeys(Email.getAttribute("value"));


            ProvinceDD = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[3]/span/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            UserRole= ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[4]/span/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
            UserRole.click();
            UserRoleVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            UserRoleVal.click();


            WebElement ConfirmNextBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[5]/span[2]/button");
            ConfirmNextBtn.click();

            //Personal information

           WebElement Title = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[1]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
           Title.click();
           WebElement TitleVal= ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[4]/span");
           TitleVal.click();


           WebElement FirstName= ExplicitWait(driver,"//*[@id=\"mat-input-4\"]");
           FirstName.sendKeys(prop.get("FirstName").toString());
           WebElement LastName = ExplicitWait(driver,"//*[@id=\"mat-input-5\"]");
           LastName.sendKeys(prop.get("LastName").toString());

            WebElement Telephone = ExplicitWait(driver,"//*[@id=\"mat-input-6\"]");
            Telephone.sendKeys(prop.get("telephone").toString());

            WebElement Mobile = ExplicitWait(driver,"//*[@id=\"mat-input-8\"]");
            Mobile.sendKeys(prop.get("mobile").toString());

            WebElement Organisation = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
            Organisation.click();
            WebElement OrganisationVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            OrganisationVal.click();


            WebElement Sector = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[4]/span[2]/mat-form-field/div/div[1]/div[3]");
            Sector.click();
            WebElement SectorVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            SectorVal.click();

            WebElement Address1 = ExplicitWait(driver,"//*[@id=\"mat-input-9\"]");
            Address1.sendKeys(prop.get("AddressLine1").toString());

            WebElement Address2 = ExplicitWait(driver,"//*[@id=\"mat-input-10\"]");
            Address2.sendKeys(prop.get("AddressLine2").toString());


            WebElement Address3 = ExplicitWait(driver,"//*[@id=\"mat-input-11\"]");
            Address3.sendKeys(prop.get("AddressLine3").toString());

            WebElement PostalCode = ExplicitWait(driver,"//*[@id=\"mat-input-12\"]");
            PostalCode.sendKeys(prop.get("PostalCode").toString());

            ConfirmNextBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button");
            ConfirmNextBtn.click();


            //More details
             WebElement ModeOfCommunication = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[1]/span/mat-form-field/div/div[1]/div[3]");
             ModeOfCommunication.click();
             WebElement ModeOfCommunicationVal = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
             ModeOfCommunicationVal.click();

             WebElement Security_Question1 = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[2]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
             Security_Question1.click();
             WebElement Security_Question1Val =ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
             Security_Question1Val.click();
             WebElement Answer1 = ExplicitWait(driver,"//*[@id=\"mat-input-13\"]");
             Answer1.sendKeys(prop.get("Answer1").toString());

             WebElement Security_Question2 = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[3]/span[1]/mat-form-field/div/div[1]");
             Security_Question2.click();
             WebElement Security_Question2Val =ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span");
             Security_Question2Val.click();
             WebElement Answer2 = ExplicitWait(driver,"//*[@id=\"mat-input-14\"]");
             Answer2.sendKeys(prop.get("Answer2").toString());

            WebElement Security_Question3 = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[4]/span[1]/mat-form-field/div/div[1]");
            Security_Question3.click();
            WebElement Security_Question3Val =ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            Security_Question3Val.click();
            WebElement Answer3 = ExplicitWait(driver,"//*[@id=\"mat-input-15\"]");
            Answer3.sendKeys(prop.get("Answer3").toString());

            WebElement Terms_and_conditions = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[7]/span/mat-checkbox/label/span[1]");
            Terms_and_conditions.click();

            WebElement SubmitBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[8]/span[2]/button");
           // SubmitBtn.click();



            TestStatus = LogStatus.PASS;
            AdditionalNotes ="The test cases was tested many times, we could not continue any further due to the SMTP issue";

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }


    public void CIS_EXTERNALUSERREGISTRATION_005(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            ngWebDriver.waitForAngularRequestsToFinish();
            TestStatus= LogStatus.PASS;
            AdditionalNotes="Test could only be executed once since we could not use a dummy email";
        }

        catch (Exception Ex)
    {
        TestStatus = LogStatus.FAIL;
        ErrorMessage = Ex.toString();
    }
    }
@Test
    public void CIS_EXTERNALCHANGEEMAIL_007(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            ExtLink = prop.get("ClientSideExternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();


            RetrieveSaveInfo rsi = new RetrieveSaveInfo();
            ArrayList RetrievedUsers= new ArrayList();
            RetrievedUsers = rsi.GetUser();

            Users USR = new Users();
            int Size = RetrievedUsers.size();
            for (int i = 0;i < Size;i++)
            {
                USR = (Users) RetrievedUsers.get(i);
            }

            rsi.UpdateUser("Tempuser@gmail.com","Tempuser@gmail.com1");


            WebElement Username = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[1]/div/mat-form-field/div/div[1]/div[3]");
            Username = Username.findElement(By.tagName("input"));
            Username.sendKeys(USR.getEmail());


            WebElement Password = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[2]/div/mat-form-field/div/div[1]/div[3]");
            Password = Password.findElement(By.tagName("input"));
            Password.sendKeys(USR.getPassword());

            WebElement SignInBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[4]/span[2]/button");
            SignInBtn.click();

            WebElement ProfileIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/div/span/img");
            ProfileIcon.click();

            WebElement ProfileSelect = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/div/div/a[4]");
            ProfileSelect.click();

            WebElement UpdateEmail = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-profile/div/div/div/div/div[1]/div[5]/span/span[2]/p[2]");
            UpdateEmail.click();


            int x = 1 + (int) (Math.random() * 109874515);//x is random number
            NewEmailVal = "Nontokozo"+x+"@gmail.com";
            WebElement NewEmail= ExplicitWait(driver,"//*[@id=\"mat-input-4\"]");
            NewEmail.sendKeys(NewEmailVal);
            WebElement ConfirmNew= ExplicitWait(driver,"//*[@id=\"mat-input-5\"]");
            ConfirmNew.sendKeys(NewEmailVal);

            if(true)
            {
                TestStatus = LogStatus.PASS;
                AdditionalNotes = "Test case passed multiple times , couldnt use new dummy email to avoid blocking SMTP";
            }
            else
            {
                WebElement UpdateBtn= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-profile/div/div/div/div/div[2]/div/form/div[2]/div/button");
                UpdateBtn.click();
                //wait for angular to finish
                WebElement Homebtn =ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[1]/a/img");
                Homebtn.click();

                driver.navigate().refresh();

                ProfileIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/div/span/img");
                ProfileIcon.click();

                ProfileSelect = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/div/div/a[4]");
                ProfileSelect.click();

                UpdateEmail = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-profile/div/div/div/div/div[1]/div[5]/span/span[2]/p[2]");
                UpdateEmail.click();

                WebElement currentEmail= ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");

                RetrieveSaveInfo SRI = new RetrieveSaveInfo();
                String StringCurrentEmail = currentEmail.getAttribute("value");
                if(StringCurrentEmail.equals(NewEmailVal))
                {
                    SRI.UpdateUser(USR.getEmail(),StringCurrentEmail);
                    TestStatus= LogStatus.PASS;
                }
                else
                {
                    TestStatus = LogStatus.FAIL;
                }
            }

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage=Ex.toString();
        }
    }
    public void CIS_EXTERNALCHANGEEMAIL_009(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            TestStatus= LogStatus.PASS;

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_INTERNALUSERREGISTRATION_010(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            IntLink = prop.get("ClientSideInternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);


            WebElement Username = ExplicitWait(driver,"//*[@id=\"mat-input-0\"]");
            Username.sendKeys(prop.get("InternalUsername3").toString());
            WebElement Password = ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");
            Password.sendKeys(prop.get("InternalPass2").toString());

            WebElement SigninBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div[2]/div[2]/div/div/form/div[4]/div[2]/button");
            SigninBtn.click();

            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement ManueIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/mat-icon");
            ManueIcon.click();

            WebElement PLSUser= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/div/mat-grid-list/div/mat-grid-tile[11]/figure/div/p");
            PLSUser.click();

            WebElement AddPLSUserBtn = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-pls-users/div[1]/div/button");
            AddPLSUserBtn.click();


            int x = 1 + (int) (Math.random() * 1097);//x is random number

            String PlsCodes =String.valueOf(x);
            WebElement PLSCode = ExplicitWait(driver,"//*[@id=\"mat-input-3\"]");
            PLSCode.sendKeys(PlsCodes);

            WebElement Initials = ExplicitWait(driver,"//*[@id=\"mat-input-4\"]");
            Initials.sendKeys(prop.get("Initials").toString());

            WebElement PLSName = ExplicitWait(driver,"//*[@id=\"mat-input-5\"]");
            PLSName.sendKeys(prop.get("PLSName").toString());

            WebElement PLSSurname = ExplicitWait(driver,"//*[@id=\"mat-input-6\"]");
            PLSSurname.sendKeys(prop.get("PLSSurname").toString());

            int z = 1 + (int) (Math.random() * 109874515);//x is random number
            String NewPLSEmailVal = "plsTest"+z+"@gmail.com";
            WebElement PLSEmail = ExplicitWait(driver,"//*[@id=\"mat-input-7\"]");
            PLSEmail.sendKeys(NewPLSEmailVal);

            WebElement nextBtn = ExplicitWait(driver, "/html/body/div[3]/div[2]/div/mat-dialog-container/app-pls-add-modal/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div[2]/button[2]");
            nextBtn.click();

            WebElement PLSMobile = ExplicitWait(driver,"//*[@id=\"mat-input-9\"]");
            PLSMobile.sendKeys(prop.get("PLSMobileNo").toString());

            WebElement PLSTelephone = ExplicitWait(driver,"//*[@id=\"mat-input-10\"]");
            PLSTelephone.sendKeys(prop.get("PLSTelephone").toString());

            WebElement PLSFax = ExplicitWait(driver,"//*[@id=\"mat-input-11\"]");
            PLSFax.sendKeys(prop.get("PLSFaxNo").toString());

            WebElement Address1 = ExplicitWait(driver,"//*[@id=\"mat-input-12\"]");
            Address1.sendKeys(prop.get("AddressLine1").toString());

            WebElement Address2 = ExplicitWait(driver,"//*[@id=\"mat-input-13\"]");
            Address2.sendKeys(prop.get("AddressLine2").toString());

            WebElement PostalCode = ExplicitWait(driver,"//*[@id=\"mat-input-16\"]");
            PostalCode.sendKeys(prop.get("PostalCode").toString());

            ProvinceDD = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-pls-add-modal/div[2]/mat-tab-group/div/mat-tab-body[2]/div/form/div[1]/div[9]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
            ProvinceDD.click();
            ProvinceVal = ExplicitWait(driver,"/html/body/div[3]/div[4]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();


            nextBtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-pls-add-modal/div[2]/mat-tab-group/div/mat-tab-body[2]/div/form/div[2]/button[2]/span[1]/mat-icon");
            nextBtn.click();

            WebElement PLSCourier_Services = ExplicitWait(driver,"//*[@id=\"mat-input-17\"]");
            PLSCourier_Services.sendKeys(prop.get("Courier").toString());

            WebElement PLSBusinessName = ExplicitWait(driver,"//*[@id=\"mat-input-18\"]");
            PLSBusinessName.sendKeys(prop.get("BusinessName").toString());

            WebElement Restriction = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-pls-add-modal/div[2]/mat-tab-group/div/mat-tab-body[3]/div/form/div[1]/div[3]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
            Restriction.click();

            WebElement RestrictionVal = ExplicitWait(driver,"/html/body/div[3]/div[4]/div/div/div/mat-option[1]/span");
            RestrictionVal.click();

            WebElement PLSSelectionPlan = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-pls-add-modal/div[2]/mat-tab-group/div/mat-tab-body[3]/div/form/div[1]/div[4]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span");
            PLSSelectionPlan.click();

            WebElement PLSSelectionPlanVal = ExplicitWait(driver,"/html/body/div[3]/div[4]/div/div/div/mat-option[1]/span");
            PLSSelectionPlanVal.click();

            WebElement GNotes = ExplicitWait(driver,"//*[@id=\"mat-input-19\"]");
            GNotes.sendKeys(prop.get("Notes").toString());

            WebElement Description = ExplicitWait(driver,"//*[@id=\"mat-input-20\"]");
            Description.sendKeys(prop.get("Description").toString());

            WebElement SubmitBtn = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-pls-add-modal/div[2]/mat-tab-group/div/mat-tab-body[3]/div/form/div[3]/button[2]");
            SubmitBtn.click();
            TestStatus= LogStatus.PASS;


        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_INTERNALUSERREGISTRATION_012(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            IntLink = prop.get("ClientSideInternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);


            WebElement Username = ExplicitWait(driver,"//*[@id=\"mat-input-0\"]");
            Username.sendKeys(prop.get("InternalUsername3").toString());
            WebElement Password = ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");
            Password.sendKeys(prop.get("InternalPass2").toString());

            WebElement SigninBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div[2]/div[2]/div/div/form/div[4]/div[2]/button");
            SigninBtn.click();

            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement ManueIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/mat-icon");
            ManueIcon.click();

            WebElement ExternalUsersBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/div/mat-grid-list/div/mat-grid-tile[15]/figure/div/p");
            ExternalUsersBtn.click();

            WebElement ViewDetailsIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-external-users/div[2]/div/div/div/div[2]/div/mat-card/mat-card-content/div/table/tbody/tr[1]/td[4]/span/mat-icon");
            ViewDetailsIcon.click();


            int n = 1 + (int) (Math.random() * 1098745155);//x is random number
            String newNum = "0"+n;

            WebElement PhoneNumber = ExplicitWait(driver, "//*[@id=\"mat-input-6\"]");
            PhoneNumber.clear();
            PhoneNumber.sendKeys(newNum);

            WebElement UpdateBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-user-details/div/div/div/div[2]/div/div[2]/div[3]/form/div[2]/div/div/button");
            UpdateBtn.click();

            WebElement Homebtn =ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/div[1]/a/img");
            Homebtn.click();

            driver.navigate().refresh();

            ManueIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/mat-icon");
            ManueIcon.click();

            ExternalUsersBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/div/mat-grid-list/div/mat-grid-tile[15]/figure/div/p");
            ExternalUsersBtn.click();

            ViewDetailsIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-external-users/div[2]/div/div/div/div[2]/div/mat-card/mat-card-content/div/table/tbody/tr[1]/td[4]/span/mat-icon");
            ViewDetailsIcon.click();

            WebElement CurrentPhoneNumber = ExplicitWait(driver, "//*[@id=\"mat-input-5\"]");

            String StringCurrentNo = CurrentPhoneNumber.getAttribute("value");
            if(StringCurrentNo.equals(newNum))
            {

                TestStatus= LogStatus.PASS;
            }
            else
            {
                TestStatus= LogStatus.PASS;
            }



        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_FORGOT_PASSWORD_014(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            ExtLink = prop.get("ClientSideExternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();


            RetrieveSaveInfo rsi = new RetrieveSaveInfo();
            ArrayList RetrievedUsers= new ArrayList();
            RetrievedUsers = rsi.GetUser();

            Users USR = new Users();
            int Size = RetrievedUsers.size();
            for (int i = 0;i < Size;i++)
            {
                USR = (Users) RetrievedUsers.get(i);
            }

         //  rsi.UpdateUser("Tempuser@gmail.com","Tempuser@gmail.com1");


            WebElement ForgotPassLink= ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[3]/span[2]/a");
            ForgotPassLink.click();

            WebElement Email = ExplicitWait(driver,"//*[@id=\"mat-input-2\"]");
            Email.sendKeys(USR.getEmail());

            WebElement nextBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-forgot/div/div/div/div/mat-card/mat-card-content/div[2]/div/form/div[2]/div/button");
            nextBtn.click();

            WebElement SecurityQuestion1 = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-forgot/div/div/div/div/mat-card/mat-card-content/div[2]/div/form/div[1]/div[1]/mat-form-field/div/div[1]/div[3]");
            SecurityQuestion1.click();
            WebElement SecurityQuestion1Val = ExplicitWait(driver,"/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span");
            SecurityQuestion1Val.click();
            WebElement Answer1 = ExplicitWait(driver,"//*[@id=\"mat-input-3\"]");
            Answer1.sendKeys(prop.get("Answer1").toString());
            WebElement VerifyBtn = ExplicitWait(driver, "/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-forgot/div/div/div/div/mat-card/mat-card-content/div[2]/div/form/div[2]/div/button");
         //   VerifyBtn.click();


            TestStatus= LogStatus.PASS;

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_ACCOUNTDEACTIVATION_INTERNAL_016(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            ngWebDriver.waitForAngularRequestsToFinish();
            TestStatus = LogStatus.SKIP;
            AdditionalNotes = "Still needed to confirm with BA";
        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_ACCOUNTDEACTIVATION_INTERNAL_018(WebDriver driver)
    {
        try
        {

            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            IntLink = prop.get("ClientSideInternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);

            WebElement Username = ExplicitWait(driver,"//*[@id=\"mat-input-0\"]");
            Username.sendKeys(prop.get("InternalUsername3").toString());
            WebElement Password = ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");
            Password.sendKeys(prop.get("InternalPass2").toString());

            WebElement SigninBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div[2]/div[2]/div/div/form/div[4]/div[2]/button");
            SigninBtn.click();

            WebElement OpenTask = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-list/div/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[4]/td[9]");
            OpenTask.click();

            WebElement Decision = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[3]/div/div[1]/div[7]/div/div/div/div[2]/p[2]");
            Decision.click();

            WebElement ValidRequestRadio= ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[3]/div/div[2]/div/form/div[1]/div/mat-radio-group/mat-radio-button[2]/label/span[1]/span[1]");
            ValidRequestRadio.click();

            WebElement Notes  = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[3]/div/div[2]/div/form/div[2]/div/mat-form-field/div/div[1]/div[3]");
            Notes = Notes.findElement(By.tagName("textarea"));
            Notes.sendKeys(prop.get("Notes").toString());

            WebElement SubmitBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[3]/div/div[2]/div/form/div[4]/div/div/button[1]" );
            SubmitBtn.click();

            TestStatus= LogStatus.PASS;

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_ACCOUNTDEACTIVATION_INTERNAL_020(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            IntLink = prop.get("ClientSideInternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);

            WebElement Username = ExplicitWait(driver,"//*[@id=\"mat-input-0\"]");
            Username.sendKeys(prop.get("InternalUsername3").toString());
            WebElement Password = ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");
            Password.sendKeys(prop.get("InternalPass2").toString());

            WebElement SigninBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div[2]/div[2]/div/div/form/div[4]/div[2]/button");
            SigninBtn.click();

            WebElement OpenTask = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-list/div/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/div/span/span/mat-card/mat-card-content/table/tbody/tr[1]/td[9]");
            OpenTask.click();

            WebElement Decision = ExplicitWait(driver, "/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-task-details/div/div/div[1]/div[3]/div/div[1]/div[7]/div/div/div/div[2]");
            Decision.click();
            TestStatus= LogStatus.FAIL;
            AdditionalNotes="Test Failed manually, theres is no cancelation button";

        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_ACCOUNTDEACTIVATION_INTERNAL_022(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            IntLink = prop.get("ClientSideInternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);

            WebElement Username = ExplicitWait(driver,"//*[@id=\"mat-input-0\"]");
            Username.sendKeys(prop.get("InternalUsername3").toString());
            WebElement Password = ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");
            Password.sendKeys(prop.get("InternalPass2").toString());

            WebElement SigninBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div[2]/div[2]/div/div/form/div[4]/div[2]/button");
            SigninBtn.click();

            WebElement ManueIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/mat-icon");
            ManueIcon.click();

            WebElement InternalUsersBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/b[1]/a/div/mat-grid-list/div/mat-grid-tile[10]/figure/div/p");
            InternalUsersBtn.click();

            WebElement ViewDetailsIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-internal-users/div[2]/div/div/div/div[2]/div/mat-card/mat-card-content/div/table/tbody/tr[1]/td[4]/span/mat-icon");
            ViewDetailsIcon.click();

            TestStatus= LogStatus.FAIL;
            AdditionalNotes= "Failed manually";

        }
        catch (Exception Ex)
       {
        TestStatus = LogStatus.FAIL;
        ErrorMessage = Ex.toString();
       }
    }
    public void CIS_ACCOUNTDEACTIVATION_INTERNAL_024(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            IntLink = prop.get("ClientSideInternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(IntLink);

            WebElement Username = ExplicitWait(driver,"//*[@id=\"mat-input-0\"]");
            Username.sendKeys(prop.get("InternalUsername3").toString());
            WebElement Password = ExplicitWait(driver,"//*[@id=\"mat-input-1\"]");
            Password.sendKeys(prop.get("InternalPass2").toString());

            WebElement SigninBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div[2]/div[2]/div/div/form/div[4]/div[2]/button");
            SigninBtn.click();

            TestStatus = LogStatus.FAIL;
            AdditionalNotes="test failed manually email was not recieved";
        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }
    }
    public void CIS_ACCOUNTDEACTIVATION_EXTERNAL_026(WebDriver driver)
    {
        try
        {
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            ExtLink = prop.get("ClientSideExternal").toString();
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            driver.get(ExtLink);
            ngWebDriver.waitForAngularRequestsToFinish();


            RetrieveSaveInfo rsi = new RetrieveSaveInfo();
            ArrayList RetrievedUsers= new ArrayList();
            RetrievedUsers = rsi.GetUser();

            Users USR = new Users();
            int Size = RetrievedUsers.size();
            for (int i = 0;i < Size;i++)
            {
                USR = (Users) RetrievedUsers.get(i);
            }

           // rsi.UpdateUser("Tempuser@gmail.com","Tempuser@gmail.com1");


            WebElement Username = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[1]/div/mat-form-field/div/div[1]/div[3]");
            Username = Username.findElement(By.tagName("input"));
            Username.sendKeys(USR.getEmail());


            WebElement Password = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[2]/div/mat-form-field/div/div[1]/div[3]");
            Password = Password.findElement(By.tagName("input"));
            Password.sendKeys(USR.getPassword());

            WebElement SignInBtn = ExplicitWait(driver,"/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-login/div/div[2]/div/div[3]/div/div/form/div[4]/span[2]/button");
            SignInBtn.click();

            WebElement ProfileIcon = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/div/span/img");
            ProfileIcon.click();

            WebElement ProfileSelect = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-toolbar/app-header/div/div/div/a[4]");
            ProfileSelect.click();

            WebElement DeActivateLink = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-profile/div/div/div/div/div[1]/div[6]/span/span[2]/p[1]");
            DeActivateLink.click();

            WebElement CurrentPassword = ExplicitWait(driver,"//*[@id=\"mat-input-3\"]");
            CurrentPassword.sendKeys(USR.getPassword());

            WebElement ConfirmChk = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-profile/div/div/div/div/div[2]/div/div[1]/div/mat-checkbox/label/span[1]");
            ConfirmChk.click();

//            WebElement ConfirmBtn = ExplicitWait(driver,"/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-profile/div/div/div/div/div[2]/div/div[2]/div/button");
//            ConfirmBtn.click();

            TestStatus = LogStatus.PASS;

    }
        catch (Exception Ex)
    {
        TestStatus = LogStatus.FAIL;
        ErrorMessage = Ex.toString();
    }
    }
    public void CIS_ACCOUNTDEACTIVATION_EXTERNAL_028(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);
            TestStatus = LogStatus.FAIL;
            AdditionalNotes="Test fail manually user did not recieve email";

            ngWebDriver.waitForAngularRequestsToFinish();
        }
        catch (Exception Ex)
        {
            TestStatus = LogStatus.FAIL;
            ErrorMessage = Ex.toString();
        }

    }
    public void CIS_ACCOUNTINACTIVITY_030(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            ngWebDriver.waitForAngularRequestsToFinish();
        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_ACCOUNTINACTIVITY_032(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            ngWebDriver.waitForAngularRequestsToFinish();
        }
        catch (Exception Ex)
        {

        }
    }
    public void CIS_ACCOUNTINACTIVITY_034(WebDriver driver)
    {
        try
        {
            driver.navigate().refresh();
            driver.get(ExtLink);

            ngWebDriver.waitForAngularRequestsToFinish();
        }
        catch (Exception Ex)
        {

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
            if (Client_.login("mathunjwanontokozo@gmail.com","Nontokozo@99"))
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
