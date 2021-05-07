import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;


public class SeleniumTests {

    public static void tests() throws IOException, InvalidKeyException, NoSuchAlgorithmException, SQLException, InvalidAlgorithmParameterException, NoSuchPaddingException, BadPaddingException, ClassNotFoundException, IllegalBlockSizeException, InterruptedException {

        ArrayList TestCasesBulk = null;
        RetrieveSaveInfo RSI = new RetrieveSaveInfo();
        TestCasesBulk = RSI.GetUamTestCases();





        FirefoxDriver driver = null;
        String Url = "https://external-cis.web.app/";
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

            //driver =new FirefoxDriver();
            NgWebDriver ngWebDriver = new NgWebDriver(driver);

            //driver = new RemoteWebDriver(Url, capability);
            driver.get("https://external-cis.web.app/");
            ngWebDriver.waitForAngularRequestsToFinish();
            WebElement Username = driver.findElement(By.id("mat-input-0"));
            WebElement Password = driver.findElement(By.id("mat-input-1"));
            Username.sendKeys("demo29@cis.co.za");
            Password.sendKeys("Test@123");
            ngWebDriver.waitForAngularRequestsToFinish();
            Thread.sleep(5000);

            WebElement SignInBtn = driver.findElement(ByAngular.buttonText("Sign In"));
            System.out.println("Button found");
            SignInBtn.click();
            Thread.sleep(10000);



        }catch (Exception ex)
        {
            throw ex;
        }
        finally {
            if (driver != null)
            {
                driver.close();

            }
        }
    }
}
