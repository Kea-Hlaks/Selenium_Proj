import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;

public class UserAccessManagement {


    File configFile = new File("src/main/resources/Config.properties");
    LogStatus TestStatus;

    public String ExtLink ;
    public String IntLink;
    private Properties prop;
    private NgWebDriver ngWebDriver;
    public void CaptureRegistrationReq(WebDriver driver) throws IOException {
        try
        {
//            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//            ProfilesIni profileIni = new ProfilesIni();
//            FirefoxProfile profile = profileIni.getProfile("default");
//            profile.setPreference("security.mixed_content.block_active_content", false);
//            profile.setPreference("security.mixed_content.block_display_content", false);
//            FirefoxOptions options = new FirefoxOptions();
//            options.setProfile(profile);
//            driver = new FirefoxDriver(options);
            ngWebDriver = new NgWebDriver(((FirefoxDriver) driver));
            //Boolean PropertiesOpen = RSI.PropertiesOpen();

            File configFile = new File("src/main/resources/Config.properties");
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);


            ExtLink = prop.get("ExternalLink").toString();

            driver.get(ExtLink);
            WebElement RegisterLik = driver.findElement(By.linkText("Click here to Register"));
            RegisterLik.click();
            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement EmailAddress = ((FirefoxDriver) driver).findElementById("mat-input-2");
            EmailAddress.sendKeys(prop.get("ExtEmail").toString());
            WebElement EmailAddressConfirm = ((FirefoxDriver) driver).findElementById("mat-input-3");
            EmailAddressConfirm.sendKeys(prop.get("ExtEmail").toString());

            WebElement ProvinceDD = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[3]/span/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            WebElement ProvinceVal = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            WebElement RoleDD = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[4]/span/mat-form-field/div/div[1]/div[3]");
            RoleDD.click();
            WebElement RoleVal = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            RoleVal.click();

            WebElement ConfirmNxt = driver.findElement(ByAngular.buttonText("Confirm and Next"));
            ConfirmNxt.click();

            WebElement TitleDD = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[1]/span[1]/mat-form-field/div/div[1]/div[3]");
            TitleDD.click();
            WebElement TitleVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
            TitleVal.click();

            WebElement FirstName = driver.findElement(By.id("mat-input-4"));
            FirstName.sendKeys("Sello_AT");

            WebElement LastName = driver.findElement(By.id("mat-input-5"));
            LastName.sendKeys("Halks_AT");

            WebElement Telephone = driver.findElement(By.id("mat-input-6"));
            Telephone.sendKeys("0119203521");

            WebElement Mobile = driver.findElement(By.id("mat-input-8"));
            Mobile.sendKeys("0740778077");

            WebElement OrganisationDD = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
            OrganisationDD.click();
            WebElement OrganisationVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
            OrganisationVal.click();

            WebElement SectorDD = driver.findElement(By.id("mat-select-8"));
            SectorDD.click();
            WebElement SectorVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
            SectorVal.click();

            for (int i = 0;i < 3;i++)
            {
                //Simplified loop to fill all the 3 addresses
                int Start = 9 + i;
                //i = i-=-1;
                driver.findElement(By.id("mat-input-"+Start)).sendKeys("Test Address : " + i);
            }

            WebElement PostCode = driver.findElement(By.id("mat-input-12"));
            PostCode.sendKeys("1632");

            WebElement ConfirmNxt2 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button"));
            ConfirmNxt2.click();
            if (!ConfirmNxt2.isDisplayed())
            {
                WebElement BackBtn = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[7]/span[1]/button"));
                BackBtn.click();
                if (ConfirmNxt2.isDisplayed())
                {
                    //TestStatus = LogStatus.PASS;
                    this.TestStatus = LogStatus.PASS;
                }
                else{
                    TestStatus = LogStatus.FAIL;
                }
            }
            else{
                TestStatus = LogStatus.FAIL;

            }
        }catch (Exception ex)
        {
            throw ex;
        }

    }

    public  void SelectNotificationOptions(WebDriver driver)
    {
        try
        {
            WebElement ConfirmNxt = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button"));
            ConfirmNxt.click();

            WebElement InfoNot = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[5]/span[1]/mat-checkbox/label/span[1]"));
            InfoNot.click();

            WebElement NewsNot = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[5]/span[2]/mat-checkbox/label/span[1]"));
            NewsNot.click();

            WebElement EventsNot = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[6]/span[2]/mat-checkbox/label/span[1]"));
            EventsNot.click();

            if (InfoNot.isSelected())
            {
                this.TestStatus = LogStatus.PASS;
            }
            else{
                this.TestStatus = LogStatus.FAIL;
            }

        }
        catch (Exception Ex)
        {
            throw Ex;
        }
    }

    public void SelectSecurityQuestions(WebDriver driver)
    {
        try
        {
            WebElement ModeOfComm = driver.findElement(By.cssSelector("mat-form-field.ng-tns-c126-24 > div:nth-child(1) > div:nth-child(1) > div:nth-child(3)"));
            ModeOfComm.click();

            WebElement ModeOfCommVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
            ModeOfCommVal.click();

            WebElement SecurityQuestion1 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[2]/span[1]/mat-form-field/div/div[1]/div[3]"));
            SecurityQuestion1.click();
            WebElement SecurityQuestionVal1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[1]/span"));
            SecurityQuestionVal1.click();
            WebElement SecurityAnswer1 = driver.findElement(By.xpath("//*[@id='mat-input-13']"));
            SecurityAnswer1.sendKeys("Test");

            WebElement SecurityQuestion2 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[3]/span[1]/mat-form-field/div/div[1]/div[3]"));
            SecurityQuestion2.click();
            WebElement SecurityQuestionVal2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
            SecurityQuestionVal2.click();
            WebElement SecurityAnswer2 = driver.findElement(By.xpath("//*[@id='mat-input-14']"));
            SecurityAnswer2.sendKeys("Test");

            WebElement SecurityQuestion3 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]"));
            SecurityQuestion3.click();
            WebElement SecurityQuestionVal3 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
            SecurityQuestionVal3.click();
            WebElement SecurityAnswer3 = driver.findElement(By.xpath("//*[@id='mat-input-15']"));
            SecurityAnswer3.sendKeys("Test");

            WebElement Iagree = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[6]/span[1]/mat-checkbox/label/span[1]"));
            Iagree.click();

            String SecurityAnsVal = SecurityAnswer3.getAttribute("value").toString();
            if (!SecurityAnsVal.equals(""))
            {
             TestStatus= LogStatus.PASS;
            }
            else{
                TestStatus = LogStatus.FAIL;
            }

        }catch (Exception Ex)
        {
            throw Ex;
        }
    }

    public void SubmitRegistrationRequest(WebDriver driver)
    {
        try
        {
            WebElement Submit = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[3]/form/div[7]/span[2]/button"));
            Submit.click();
            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement EmailInput = ExplicitWait(driver,"//*[@id=\"mat-input-16\"]");
            if (!EmailInput.equals(null))
            {
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

    public WebElement ExplicitWait(WebDriver driver, String ExpectedElement)
    {
        WebElement targetElement = null;
        try
        {

            targetElement = new WebDriverWait(driver, Duration.ofSeconds(30)).until((WebDriver dr1) -> dr1.findElement(By.xpath(ExpectedElement)));

//            Func<WebDriver, WebElement> waitForSearchElement = new Func<WebDriver, WebElement>((WebDriver Web) ->
//            {
//                WebElement FoundElement = driver.findElement(By.xpath(ExpectedElement));
//                return FoundElement;
//            });
            //WebDriverWait wait = new WebDriverWait(driver, 30);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            targetElement = wait.until(waitForSearchElement);
            //Thread.sleep(2000);
        }
        catch (Exception e)
        {

            throw e;
        }
        finally {
            return targetElement;
        }
    }

    @Test
    public void _CaptureRegistrationReq() throws IOException {
        try
        {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            ProfilesIni profileIni = new ProfilesIni();
            FirefoxProfile profile = profileIni.getProfile("default");
            profile.setPreference("security.mixed_content.block_active_content", false);
            profile.setPreference("security.mixed_content.block_display_content", false);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            FirefoxDriver driver = new FirefoxDriver(options);
            NgWebDriver ngWebDriver = new NgWebDriver(driver);
            //Boolean PropertiesOpen = RSI.PropertiesOpen();

            File configFile = new File("src/main/resources/Config.properties");
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);


            ExtLink = prop.get("ExternalLink").toString();

            driver.get(ExtLink);
            WebElement RegisterLik = driver.findElement(By.linkText("Click here to Register"));
            RegisterLik.click();
            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement EmailAddress = driver.findElementById("mat-input-2");
            EmailAddress.sendKeys("kidsonmedicine@gmail.com");
            WebElement EmailAddressConfirm = driver.findElementById("mat-input-3");
            EmailAddressConfirm.sendKeys("kidsonmedicine@gmail.com");

            WebElement ProvinceDD = driver.findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[3]/span/mat-form-field/div/div[1]/div[3]");
            ProvinceDD.click();
            WebElement ProvinceVal = driver.findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            ProvinceVal.click();

            WebElement RoleDD = driver.findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[1]/form/div[4]/span/mat-form-field/div/div[1]/div[3]");
            RoleDD.click();
            WebElement RoleVal = driver.findElementByXPath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span");
            RoleVal.click();

            WebElement ConfirmNxt = driver.findElement(ByAngular.buttonText("Confirm and Next"));
            ConfirmNxt.click();

            WebElement TitleDD = driver.findElementByXPath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[1]/span[1]/mat-form-field/div/div[1]/div[3]");
            TitleDD.click();
            WebElement TitleVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[2]/span"));
            TitleVal.click();

            WebElement FirstName = driver.findElement(By.id("mat-input-4"));
            FirstName.sendKeys("Sello_AT");

            WebElement LastName = driver.findElement(By.id("mat-input-5"));
            LastName.sendKeys("Halks_AT");

            WebElement Telephone = driver.findElement(By.id("mat-input-6"));
            Telephone.sendKeys("0119203521");

            WebElement Mobile = driver.findElement(By.id("mat-input-8"));
            Mobile.sendKeys("0740778077");

            WebElement OrganisationDD = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[4]/span[1]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
            OrganisationDD.click();
            WebElement OrganisationVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
            OrganisationVal.click();

            WebElement SectorDD = driver.findElement(By.id("mat-select-8"));
            SectorDD.click();
            WebElement SectorVal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option[3]/span"));
            SectorVal.click();

            for (int i = 0;i < 3;i++)
            {
                //Simplified loop to fill all the 3 addresses
                int Start = 9 + i;
                i = i-=-1;
                driver.findElement(By.id("mat-input-"+Start)).sendKeys("Test Address : " + i);
            }

            WebElement PostCode = driver.findElement(By.id("mat-input-12"));
            PostCode.sendKeys("1632");

            WebElement ConfirmNxt2 = driver.findElement(By.xpath("/html/body/app-root/app-blank/mat-sidenav-container/mat-sidenav-content/app-register/div/div[2]/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/span[2]/button"));
            ConfirmNxt2.click();

        }catch (Exception ex)
        {
            throw ex;
        }

    }
@Test
    public void ReadEmail() throws IOException {
    //POP3Client _client = new POP3Client();
    POP3SClient Client_ = new POP3SClient(true);
    String Password;
        try
        {
            //boolean LogedIn = false;
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);

            Client_.setDefaultTimeout(100000);
            Client_.connect(prop.getProperty("HostName"),Integer.parseInt(prop.getProperty("Port")));
            if (Client_.login(prop.getProperty("User"),prop.getProperty("Pass")))
            {
                POP3MessageInfo[] messages = Client_.listMessages();
                for (int i = 0; i < 5; i++) {
                    int messageNum = messages[i].number;
                    System.out.println("Message number: " + messageNum);
                    Reader reader = Client_.retrieveMessageTop(messageNum, 10);
                    String MsgString = IOUtils.toString(reader);

                    String toBeSearched = "Your password is : ";

                    int ix = MsgString.indexOf(toBeSearched);
                    String Code = MsgString.substring(ix + toBeSearched.length());
                    Password = Code.substring(0, Code.length() > 9 ? 9 : Code.length());
                    //System.out.println("Message:\n" + MsgString);
                    //IOUtils.closeQuietly(reader);
                }
            }
        }catch (Exception Ex)
        {
            throw Ex;
        }
        finally {
            Client_.disconnect();
        }
    }





}
