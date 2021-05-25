import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.io.File;
import java.io.IOException;

public class Setup {
    ExtentReports reports = new ExtentReports("Documents"+ "\\TestReports" +"\\CsgReport.html",true);
    ExtentTest test;
    String Test= "Zero";
@Test
    public WebDriver Start(){
    FirefoxDriver driver = null;
    try
    {

        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default");
        profile.setPreference("security.mixed_content.block_active_content", false);
        profile.setPreference("security.mixed_content.block_display_content", false);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);

        BasicConfigurator.configure();

        reports.addSystemInfo("Tester","Sello");
        reports.addSystemInfo("Manager","Pragayanshu");
        reports.addSystemInfo("Project","Cadastral Information System");
    }
    catch (Exception Ex)
    {
        throw Ex;
    }
    finally
    {
        return driver;
    }
}

    public void AfterTest(String TestCaseId,String Process,String Page_Reference, String Function,String Activity_Or_User_Interface,String TEST_CASE_DESCRIPTION,String PRE_REQUISITE,
            String INPUT_DATA,
          String EXPECTED_OUTCOME,
            String INPUT_DATA1,
            String ACTUAL_OUTCOME,
           String STATUS, LogStatus Status, WebDriver driver, String ErrorMessage, String AdditionalNotes) throws IOException {
        String TestDesc = null;
        String Path=null;
        try
        {
            switch (Status)
            {
                case PASS:
                    TestDesc ="Test Passed";
                    break;
                case FAIL:
                    TestDesc = "Test Failed";
                    break;
                case SKIP:
                    TestDesc = "Test Skipped";
                    break;
            }
            Path = TakeScreenshot(driver,TestCaseId);
            test = reports.startTest(TestCaseId);
            test.log(Status,TestDesc);
            test.log(Status,"Test Case ID : " + TestCaseId);
            test.log(Status,"Process : " + Process);
            test.log(Status,"Page Reference : " + Page_Reference);
            test.log(Status,"Function : " + Function);
            test.log(Status,"Activity/User Interface : " + Activity_Or_User_Interface);
            test.log(Status,"Test Case Description : " + TEST_CASE_DESCRIPTION);
            test.log(Status,"Pre-requisite : " + PRE_REQUISITE);
            if(INPUT_DATA != null)
            {
                test.log(Status,"Input Data : " + INPUT_DATA);
            }
            if(EXPECTED_OUTCOME != null)
            {
                test.log(Status,"Expected outcome : " + EXPECTED_OUTCOME);
            }
            if(ACTUAL_OUTCOME != null)
            {
                test.log(Status,"OutCome : " + ACTUAL_OUTCOME);
            }

            if (ErrorMessage != null)
            {
                test.log(Status,"Error Message : " + ErrorMessage);
            }

            if (AdditionalNotes != null)
            {
                test.log(Status,"Additional Notes : " + AdditionalNotes);
            }
            test.log(Status, "See Screenshot Below :" +test.addScreenCapture(Path));
            ErrorMessage="";
            AdditionalNotes = "";
            reports.endTest(test);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    public static String TakeScreenshot(WebDriver driver,String Function) throws IOException {
    String Path = null;
        try
        {
            String FileName = Function+".png";
            String MainPath = "Documents/TestReports/";

            String fileWithPath =  MainPath+FileName;
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination

            File DestFile=new File(fileWithPath);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);

            Path = FileName;
        }catch (Exception ex)
        {
            throw ex;
        }
        finally {
            return Path;
        }

    }

    public void Conclude(){
    try
    {

        reports.flush();
    }
    catch (Exception ex)
    {
        throw ex;
    }

    }
}
