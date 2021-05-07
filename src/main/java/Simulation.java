import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Simulation {

WebDriver driver;
ArrayList RetrievedTestCases;
//LogStatus TestStatus = LogStatus.FAIL;
@Test
    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException, NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        try
        {
            Simulation Sim = new Simulation();
            Sim.IMTests();
        }catch (Exception ex)
        {
            throw ex;
        }
    }

@Test
    public  void IMTests() throws IOException, InvalidKeyException, NoSuchAlgorithmException, SQLException, InvalidAlgorithmParameterException, NoSuchPaddingException, BadPaddingException, ClassNotFoundException, IllegalBlockSizeException {
        try
        {
            RetrieveSaveInfo RSI = new RetrieveSaveInfo();
            TestCasesInfo TCI = new TestCasesInfo();
            RetrievedTestCases = RSI.GetIMTestCases();
            UserAccessManagement UAM = new UserAccessManagement();
            InformationManagement IM = new InformationManagement();

            Setup Set_ = new Setup();

            int Size = RetrievedTestCases.size();

            driver = Set_.Start();
            for (int i = 0;i < Size;i++)
            {
                TCI = (TestCasesInfo) RetrievedTestCases.get(i);

                switch (TCI.Function)
                {
                    case "Number Search":
                        IM.NumberSearch(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Parcel Description Search":
                        IM.ParcelDescSearch(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Sectional Title Search":
                        IM.SectTitleSearch(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Free Text Search":
                        IM.FreeTextSearch(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Range Search":
                        IM.RangeSearch(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Search from Templates" :
                        IM.TemplateSearch(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Data Provisioning" :
                        IM.DataProvisioning(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Pre-packaged data":
                        IM.PrePackagedData(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Pre-packaged data Notification":
                        IM.PrePackagedDataNotification(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Capture request" :
                        if (TCI.Test_case_ID == 10)
                        {
                            IM.CaptureRequest(driver);
                            Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                            IM.ErrorMessage = null;
                            IM.AdditionalNotes = null;
                        }
                        break;
                    case "Check Data Availability" :
                        IM.CheckDataAvailability(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Notify Manager" :
                        IM.NotifyManager(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div/div[6]/div/button");
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;

                    case "Validate Request Size" :
                        IM.ValidateRequestSize(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case  "Notify User if size is greater than specified size" :
                        IM.NotifyUserLimit(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Send Data via email" :
                        IM.SendDataViaEmail(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        //IM.CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button");
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                        break;
                    case "Send Data via FTP" :
                        IM.SendDataViaFtp(driver);
                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
                        IM.ErrorMessage = null;
                        IM.AdditionalNotes = null;
                }
                //Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,UAM.TestStatus,driver);
            }
            Set_.Conclude();
        }
        catch (Exception ex)
        {
            throw  ex;
        }
        finally {
            driver.quit();
        }
    }



}