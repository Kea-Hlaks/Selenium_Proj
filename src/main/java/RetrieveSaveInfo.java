import org.junit.Test;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class RetrieveSaveInfo {
    public ArrayList TestCasesBulk = new ArrayList();
    public ArrayList UsersBulk = new ArrayList();
//Declarations
    private boolean Connected = false;
    private TestCasesInfo TCI;
    private Users USR;
    private String Username;
    private String Password;
    private String Url;
    private final Security Sec = new Security();
    private Properties prop;
    private Connection con = null;
    private Statement Stmt;
    private ResultSet Rs;
    private final String UAMQuery="SELECT * FROM UAM_TEST";
    private final String IMQuery = "SELECT * FROM INFORMATIONMANAGEMENT";
    private final String GetUserQue = "SELECT * FROM USERS_ WHERE username = ";
    private final String UpdateUser = "UPDATE users_ SET username = '' WHERE username = ''";


  //


    public ArrayList GetUamTestCases() throws SQLException, ClassNotFoundException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        try
        {
            if (PropertiesOpen())
            {

                Username = prop.get("Username").toString();
                Password = prop.get("Password").toString();
                Url = prop.get("Url").toString();
                UserAccessManagement UAM = new UserAccessManagement();
                UAM.IntLink = prop.get("ClientSideInternal").toString();
                UAM.ExtLink = prop.get("ClientSideExternal").toString();

                Class.forName("oracle.jdbc.driver.OracleDriver");

                con = DriverManager.getConnection(Url,Username,Password);
                Stmt = con.createStatement();
                Rs = Stmt.executeQuery(UAMQuery);

                while(Rs.next())
                {
                    TCI = new TestCasesInfo();

                    TCI.Test_case_ID = Rs.getString("TESTCASEID");
                    TCI.Module = Rs.getString("MODULE");
                    TCI.Process = Rs.getString("PROCESS");
                    TCI.Function = Rs.getString("FUNCTION");

                    TestCasesBulk.add(TCI);
                }
                Connected = true;
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            con.close();
        }

        if (TestCasesBulk.isEmpty())
        {
            return null;
        }
        else {
            return TestCasesBulk;
        }

    }
@Test
    public ArrayList GetIMTestCases() throws SQLException, IOException, ClassNotFoundException {
        try
        {
            if (PropertiesOpen())
            {

                Username = prop.get("Username").toString();
                Password = prop.get("Password").toString();
                Url = prop.get("Url").toString();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(Url,Username,Password);
                Stmt = con.createStatement();
                Rs = Stmt.executeQuery(IMQuery);


                while(Rs.next())
                {
                    TCI = new TestCasesInfo();

                    TCI.Test_case_ID = Rs.getString("TESTCASEID");
                    TCI.Module = Rs.getString("MODULE");
                    TCI.Process = Rs.getString("PROCESS");
                    TCI.Function = Rs.getString("FUNCTION");

                    TestCasesBulk.add(TCI);
                }
                Connected = true;
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            if(con != null) {
                con.close();
            }
        }

        if (TestCasesBulk.isEmpty())
        {
            return null;
        }
        else {
            return TestCasesBulk;
        }
    }

    public ArrayList GetTestCases(String Query) throws SQLException, IOException, ClassNotFoundException {
        try
        {
            if (PropertiesOpen())
            {

                Username = prop.get("Username").toString();
                Password = prop.get("Password").toString();
                Url = prop.get("Url").toString();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(Url,Username,Password);
                Stmt = con.createStatement();
                Rs = Stmt.executeQuery(Query);
                while(Rs.next())
                {
                    TCI = new TestCasesInfo();
                    TCI.Test_case_ID = Rs.getString("TEST_CASE_ID");
                    TCI.Process = Rs.getString("PROCESS");
                    TCI.Page_Reference = Rs.getString("PAGE_REFERENCE");
                    TCI.Function = Rs.getString("FUNCTION");
                    TCI.Activity_Or_User_Interface = Rs.getString("ACTIVITY_OR_USER_INTERFACE");
                    TCI.TEST_CASE_DESCRIPTION = Rs.getString("TEST_CASE_DESCRIPTION");
                    TCI.PRE_REQUISITE = Rs.getString("PRE_REQUISITE");
                    TCI.INPUT_DATA = Rs.getString("INPUT_DATA");
                    TCI.EXPECTED_OUTCOME = Rs.getString("EXPECTED_OUTCOME");
                    TCI.INPUT_DATA1 = Rs.getString("INPUT_DATA1");
                    TCI.ACTUAL_OUTCOME = Rs.getString("ACTUAL_OUTCOME");
                    TCI.STATUS = Rs.getString("STATUS");
                    TestCasesBulk.add(TCI);
                }
                Connected = true;
            }
        }catch (Exception Ex)
        {
            throw Ex;
        }

        finally
        {
            if(con != null) {
                con.close();
            }
        }

        if (TestCasesBulk.isEmpty())
        {
            return null;
        }
        else {
            return TestCasesBulk;
        }
    }

    public boolean PropertiesOpen() throws IOException {
        boolean open = false;
        try
        {
            File configFile = new File("src/main/resources/Config.properties");
            InputStream inputStream = new FileInputStream(configFile);
            prop = new Properties();
            prop.load(inputStream);
            open = true;
        }catch (Exception Ex)
        {
            throw  Ex;
        }
        finally {
            return open;
        }
    }

    public ArrayList GetUser() throws SQLException, ClassNotFoundException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        try
        {
            if (PropertiesOpen())
            {

                Username = prop.get("Username").toString();
                Password = prop.get("Password").toString();
                Url = prop.get("Url").toString();
                UserAccessManagement UAM = new UserAccessManagement();
                UAM.IntLink = prop.get("ClientSideInternal").toString();
                UAM.ExtLink = prop.get("ClientSideExternal").toString();

                Class.forName("oracle.jdbc.driver.OracleDriver");

                con = DriverManager.getConnection(Url,Username,Password);
                Stmt = con.createStatement();
                //Rs = Stmt.executeQuery("SELECT * FROM USERS_ WHERE username = '"+Email+"'");
                Rs = Stmt.executeQuery("SELECT * FROM USERS_");

                while(Rs.next())
                {
                    USR = new Users();

                    USR.setEmail(Rs.getString("USERNAME"));
                    USR.setPassword(Rs.getString("PASSWORD"));

                    UsersBulk.add(USR);
                }
                Connected = true;
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            con.close();
        }

        if (UsersBulk.isEmpty())
        {
            return null;
        }
        else {
            return UsersBulk;
        }

    }
@Test
    public void Test() throws InvalidAlgorithmParameterException, SQLException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ClassNotFoundException {



    }

    public void UpdateUser(String OldEmail,String NewEmail) throws SQLException, ClassNotFoundException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        try
        {
            if (PropertiesOpen())
            {

                Username = prop.get("Username").toString();
                Password = prop.get("Password").toString();
                Url = prop.get("Url").toString();
                UserAccessManagement UAM = new UserAccessManagement();
                UAM.IntLink = prop.get("InternalLink").toString();
                UAM.ExtLink = prop.get("ExternalLink").toString();

                Class.forName("oracle.jdbc.driver.OracleDriver");

                con = DriverManager.getConnection(Url,Username,Password);
                Stmt = con.createStatement();
                Rs = Stmt.executeQuery("UPDATE users_ SET username ="+"'"+NewEmail+"'"+ " WHERE username = "+ "'"+ OldEmail +"'");


                Connected = true;
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        finally
        {
            con.close();
        }


    }


}
