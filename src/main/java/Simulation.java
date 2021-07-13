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
private final String IM_Addendum_Query = "SELECT * FROM IM_ADDENDUM";
private final String UAMQuery="SELECT * FROM UAM_TEST";
//LogStatus TestStatus = LogStatus.FAIL;
@Test
    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException, NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        try
        {
            RetrieveSaveInfo rsi = new RetrieveSaveInfo();
            ArrayList RetrievedUsers= new ArrayList();
            RetrievedUsers = rsi.GetUser();

            Users USR = new Users();
            int Size = RetrievedUsers.size();
            for (int i = 0;i < Size;i++)
            {
                USR = (Users) RetrievedUsers.get(i);
            }
            String Password = USR.getPassword();
            String email = USR.getEmail();
            rsi.UpdateUser("Tempuser@gmail.com","Tempuser@gmail.com1");

            Simulation Sim = new Simulation();
            //Sim.IMTests();
            Sim.UAMTests();

        }catch (Exception ex)
        {
            throw ex;
        }
    }

    public  void IMTests() throws IOException, InvalidKeyException, NoSuchAlgorithmException, SQLException, InvalidAlgorithmParameterException, NoSuchPaddingException, BadPaddingException, ClassNotFoundException, IllegalBlockSizeException
    {
        try
        {
            RetrieveSaveInfo RSI = new RetrieveSaveInfo();
            TestCasesInfo TCI = new TestCasesInfo();
//            RetrievedTestCases = RSI.GetIMTestCases();
            RetrievedTestCases = RSI.GetTestCases(IM_Addendum_Query);
            InformationManagement IM = new InformationManagement();
            InfoManagementAddendum IMAdd = new InfoManagementAddendum();

            Setup Set_ = new Setup();

            int Size = RetrievedTestCases.size();

            driver = Set_.Start();


            for (int i = 0;i < Size;i++)
            {
                TCI = (TestCasesInfo) RetrievedTestCases.get(i);

                switch (TCI.Test_case_ID)
                {
                    case "CIS_NOTIFYMANAGER_043" :
                        IMAdd.CIS_NOTIFYMANAGER_043(driver);

                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                        IMAdd.ErrorMessage = null;
                        IMAdd.AdditionalNotes = null;
                        break;
                    case "CIS_NOTIFYMANAGER_044" :
                        IMAdd.CIS_NOTIFYMANAGER_044(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                        IMAdd.ErrorMessage = null;
                        IMAdd.AdditionalNotes = null;
                        break;
                    case "CIS_NOTIFYMANAGER_047" :
                        IMAdd.CIS_NOTIFYMANAGER_047(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                        IMAdd.ErrorMessage = null;
                        IMAdd.AdditionalNotes = null;
                        break;
                    case "CIS_NOTIFYMANAGER_048" :
                        IMAdd.CIS_NOTIFYMANAGER_048(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                        IMAdd.ErrorMessage = null;
                        IMAdd.AdditionalNotes = null;
                        break;

                    case "CIS_SEARCH_001" :
                        IMAdd.CIS_SEARCH_001(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                        IMAdd.ErrorMessage = null;
                        IMAdd.AdditionalNotes = null;
                        break;

                        case "CIS_SEARCH_002" :
                        IMAdd.CIS_SEARCH_002(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                            IMAdd.ErrorMessage = null;
                            IMAdd.AdditionalNotes = null;
                        break;

                        case "CIS_SEARCH_003" :
                        IMAdd.CIS_SEARCH_003(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                            IMAdd.ErrorMessage = null;
                            IMAdd.AdditionalNotes = null;
                        break;

                        case "CIS_SEARCH_004" :
                        IMAdd.CIS_SEARCH_004(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                IMAdd.TestStatus,
                                driver,
                                IMAdd.ErrorMessage,
                                IMAdd.AdditionalNotes
                        );
                            IMAdd.ErrorMessage = null;
                            IMAdd.AdditionalNotes = null;
                        break;
                }
                //Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,UAM.TestStatus,driver);
            }
            Set_.Conclude();


//            for (int i = 0;i < Size;i++)
//            {
//                TCI = (TestCasesInfo) RetrievedTestCases.get(i);
//
//                switch (TCI.Function)
//                {
//                    case "Number Search":
//                        IM.NumberSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Parcel Description Search":
//                        IM.ParcelDescSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Sectional Title Search":
//                        IM.SectTitleSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Free Text Search":
//                        IM.FreeTextSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Range Search":
//                        IM.RangeSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Search from Templates" :
//                        IM.TemplateSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Data Provisioning" :
//                        IM.DataProvisioning(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Pre-packaged data":
//                        IM.PrePackagedData(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Pre-packaged data Notification":
//                        IM.PrePackagedDataNotification(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Capture request" :
//                        if (TCI.Test_case_ID == 10)
//                        {
//                            IM.CaptureRequest(driver);
//                            Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                            IM.ErrorMessage = null;
//                            IM.AdditionalNotes = null;
//                        }
//                        break;
//                    case "Check Data Availability" :
//                        IM.CheckDataAvailability(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Notify Manager" :
//                        IM.NotifyManager(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div/div[6]/div/button");
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//
//                    case "Validate Request Size" :
//                        IM.ValidateRequestSize(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case  "Notify User if size is greater than specified size" :
//                        IM.NotifyUserLimit(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Send Data via email" :
//                        IM.SendDataViaEmail(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        //IM.CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button");
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Send Data via FTP" :
//                        IM.SendDataViaFtp(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                }
//                //Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,UAM.TestStatus,driver);
//            }
//            Set_.Conclude();
        }
        catch (Exception ex)
        {
            throw  ex;
        }
        finally {
            if (driver != null)
            {
                driver.quit();
            }

        }
    }

    public  void UAMTests() throws IOException, InvalidKeyException, NoSuchAlgorithmException, SQLException, InvalidAlgorithmParameterException, NoSuchPaddingException, BadPaddingException, ClassNotFoundException, IllegalBlockSizeException
    {
        try
        {
            RetrieveSaveInfo RSI = new RetrieveSaveInfo();
            TestCasesInfo TCI = new TestCasesInfo();
//            RetrievedTestCases = RSI.GetIMTestCases();
            RetrievedTestCases = RSI.GetTestCases(UAMQuery);
            UserAccessManagement UAM = new UserAccessManagement();

            Setup Set_ = new Setup();

            int Size = RetrievedTestCases.size();

            driver = Set_.Start();


            for (int i = 0;i < Size;i++)
            {
                TCI = (TestCasesInfo) RetrievedTestCases.get(i);
                switch (TCI.Test_case_ID)
                {
                    case "CIS_EXTERNALUSERREGISTRATION_001" :
                        UAM.CIS_EXTERNALUSERREGISTRATION_001(driver);

                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                    case "CIS_EXTERNALUSERREGISTRATION_005" :
                          UAM.CIS_EXTERNALUSERREGISTRATION_005(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                    case "CIS_EXTERNALCHANGEEMAIL_007" :
                        UAM.CIS_EXTERNALCHANGEEMAIL_007(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                    case "CIS_EXTERNALCHANGEEMAIL_009" :
                        UAM.CIS_EXTERNALCHANGEEMAIL_009(driver);

                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                    case "CIS_INTERNALUSERREGISTRATION_010" :
                        UAM.CIS_INTERNALUSERREGISTRATION_010(driver);

                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                    case "CIS_INTERNALUSERREGISTRATION_012" :
                         UAM.CIS_INTERNALUSERREGISTRATION_012(driver);

                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                    case "CIS_FORGOT PASSWORD_014" :
                        UAM.CIS_FORGOT_PASSWORD_014(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                 case "CIS_ACCOUNTDEACTIVATION(INTERNAL)_016" :
                        UAM.CIS_ACCOUNTDEACTIVATION_INTERNAL_016(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                 case "CIS_ACCOUNTDEACTIVATION(INTERNAL)_018" :
                        UAM.CIS_ACCOUNTDEACTIVATION_INTERNAL_018(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                        case "CIS_ACCOUNTDEACTIVATION(EXTERNAL)_026" :
                        UAM.CIS_ACCOUNTDEACTIVATION_EXTERNAL_026(driver);
                        Set_.AfterTest(
                                TCI.Test_case_ID,
                                TCI.Process,
                                TCI.Page_Reference,
                                TCI.Function,
                                TCI.Activity_Or_User_Interface,
                                TCI.TEST_CASE_DESCRIPTION,
                                TCI.PRE_REQUISITE,
                                TCI.INPUT_DATA,
                                TCI.EXPECTED_OUTCOME,
                                TCI.INPUT_DATA1,
                                TCI.ACTUAL_OUTCOME,
                                TCI.STATUS,
                                UAM.TestStatus,
                                driver,
                                UAM.ErrorMessage,
                                UAM.AdditionalNotes
                        );
                        UAM.ErrorMessage = null;
                        UAM.AdditionalNotes = null;
                        break;
                }

                //Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,UAM.TestStatus,driver);
            }
            Set_.Conclude();

//            for (int i = 0;i < Size;i++)
//            {
//                TCI = (TestCasesInfo) RetrievedTestCases.get(i);
//
//                switch (TCI.Function)
//                {
//                    case "Number Search":
//                        IM.NumberSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Parcel Description Search":
//                        IM.ParcelDescSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Sectional Title Search":
//                        IM.SectTitleSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Free Text Search":
//                        IM.FreeTextSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Range Search":
//                        IM.RangeSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Search from Templates" :
//                        IM.TemplateSearch(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Data Provisioning" :
//                        IM.DataProvisioning(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Pre-packaged data":
//                        IM.PrePackagedData(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Pre-packaged data Notification":
//                        IM.PrePackagedDataNotification(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Capture request" :
//                        if (TCI.Test_case_ID == 10)
//                        {
//                            IM.CaptureRequest(driver);
//                            Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                            IM.ErrorMessage = null;
//                            IM.AdditionalNotes = null;
//                        }
//                        break;
//                    case "Check Data Availability" :
//                        IM.CheckDataAvailability(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Notify Manager" :
//                        IM.NotifyManager(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-search-request-modal/div[2]/div/div/div[6]/div/button");
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//
//                    case "Validate Request Size" :
//                        IM.ValidateRequestSize(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case  "Notify User if size is greater than specified size" :
//                        IM.NotifyUserLimit(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Send Data via email" :
//                        IM.SendDataViaEmail(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        //IM.CloseBtn(driver,"/html/body/div[3]/div[2]/div/mat-dialog-container/app-confirm-common-dailog/div/div/div[6]/button");
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                        break;
//                    case "Send Data via FTP" :
//                        IM.SendDataViaFtp(driver);
//                        Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,IM.TestStatus,driver,IM.ErrorMessage,IM.AdditionalNotes);
//                        IM.ErrorMessage = null;
//                        IM.AdditionalNotes = null;
//                }
//                //Set_.AfterTest(TCI.Test_case_ID,TCI.Process, TCI.Function,UAM.TestStatus,driver);
//            }
//            Set_.Conclude();
        }
        catch (Exception ex)
        {
            throw  ex;
        }
        finally {
            if (driver != null)
            {
                driver.quit();
            }

        }
    }


}
