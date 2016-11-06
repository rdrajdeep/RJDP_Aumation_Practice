package pkgTest;
import pkgConfigDriver.ConfigureDriver;
import pkgExcelUtility.ExcelUtility;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
//import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pkgLogin.Login;
import pkgPageObjects.HomePage;
import pkgUIoperations.UIoperations;


public class InvokeTest {
	 
	String URL="https://www.cvt.inttra.com"; // CVT URL
	//String browser_name="IE";
	//String URL ="https://www.inttraworks.inttra.com/portal/login.do"; //PROD URL
    @BeforeClass	
	public void setup() throws IOException{
    		ConfigureDriver.getInstance().setDriver();
    		ConfigureDriver.getInstance().getDriver().get(URL);
    		}
    	
   	@Test(priority=0)    // Login module	 
    	public  void runner() throws InterruptedException, IOException{  		
   		UIoperations objUI=new UIoperations();
   		ExcelUtility.excelInstance().setExcelFile("Login_Credential.xlsx", "Sheet1");
   		Login login=new Login();  		
   		ArrayList<String> array=ExcelUtility.excelInstance().loginCredential("TC_1");
   		String username = array.get(0);
        String password = array.get(1);
        //System.out.println(username+"  "+password);
       
   		login.signIn(username,password);
   		objUI.invokeClick(HomePage.administrationURL);
   		//ExcelUtility.excelInstance().writeToExcel(1, 3, "Login_Credential.xlsx");
    	
    	} 
   	@Test(enabled=true)// Track & Trace setup module
   	public void TnT_UI_setup() throws IOException, InterruptedException{
   		//UIoperations objui=new UIoperations();
   		ExcelUtility.excelInstance().setExcelFile("Gen2Setup_test.xlsx", "Sheet1");
   		Login login=new Login();
   		ArrayList<Double> array=ExcelUtility.excelInstance().Gen2Setup();
    	int size=array.size();
    	int company_id;
    	String companyidAsString=null;
    	Double d;
    	for(int i=0;i<size;i++){
    		d=new Double(array.get(i));//company_id=array.get(i);
    		company_id=d.intValue(); //convert double to int
    		companyidAsString = Integer.toString(company_id); // convert int to string
    		//Thread.sleep(200);
    		login.onlySearchCompany(companyidAsString);
    		login.addTnT("CU2000", "CU2000");
    		
   	}
   	}
   	/*
   	@Test(enabled=false) // Gen2 BK setup module
   	public void TC_gen2BKSetup() throws IOException, InterruptedException{
   		UIoperations objui=new UIoperations();
   		ExcelUtility.excelInstance().setExcelFile("Gen2Setup_test.xlsx", "Sheet1");
   		Login login=new Login();
   		String ediID="CARGOWISE";
   		String ftpID="c0235380";
   		String IBMapName="IFTMBF2_D99B_IN";
    	String OBMapName= "IFTMBC2_D99B_OUT";	
    	String subscriptionType = "Booking Confirm/Pending/Decline/Replace";
    	
    	ArrayList<Double> array=ExcelUtility.excelInstance().Gen2Setup();
    	int size=array.size();
    	int company_id;
    	String companyidAsString=null;
    	Double d;
    	for(int i=0;i<size;i++){
    		d=new Double(array.get(i));//company_id=array.get(i);
    		company_id=d.intValue(); //convert double to int
    		companyidAsString = Integer.toString(company_id); // convert int to string
    		login.searchCompany(companyidAsString);
    		login.BKlinkSetupIB(ediID,ftpID,IBMapName);
        	login.BKlinkSetupOB(ediID, ftpID, OBMapName,subscriptionType);
        	objui.invokeClick(HomePage.administration);
    	}
   		
   	}
   	
   	@Test(enabled=false) //OB Email setup module
   	public void TC_OBemailSetup() throws IOException,InterruptedException{
   		Login login=new Login();
   		login.searchCompany("802999");
   		login.BKEmailSetupOB("Success", "rajdeep.das@inttra.com");  		
   	} 
  	
   	
   	@Test (enabled=false)
   	public void Gen2BLSetup() throws IOException, InterruptedException{
   		ExcelUtility.excelInstance().setExcelFile("Gen2Setup_test.xlsx", "Sheet1");
   		Login login=new Login();
   		
   		ArrayList<Double> array=ExcelUtility.excelInstance().Gen2Setup();
    	int size=array.size();
    	int company_id;
    	String companyidAsString=null;
    	Double d;
    	for(int i=0;i<size;i++){
    		d=new Double(array.get(i));//company_id=array.get(i);
    		company_id=d.intValue(); //convert double to int
    		companyidAsString = Integer.toString(company_id); // convert int to string
    		Thread.sleep(200);
    		login.onlySearchCompany(companyidAsString);
    		login.BLlinkSetupOB("690549662", "d1632347", "BL_XML_OUT");
    	}
   	} 
   	@Test(enabled=false)// Invoice reprocess
   	public void invoiceReprocess()throws IOException, InterruptedException{
//   		ExcelUtility.excelInstance().setExcelFile("Gen2Setup_test.xlsx", "Sheet1");
   		Login login=new Login();
//   		
//   		ArrayList<Double> array=ExcelUtility.excelInstance().Gen2Setup();
//    	int size=array.size();
//    	int company_id;
//    	String companyidAsString=null;
//    	Double d;
//    	for(int i=0;i<size;i++){
//    		d=new Double(array.get(i));//company_id=array.get(i);
//    		company_id=d.intValue(); //convert double to int
//    		companyidAsString = Integer.toString(company_id); // convert int to string
//    		Thread.sleep(200);
    	
    	//}
   		
   		login.invoiceReprocess("1675318557");
   	}
   	@AfterTest(enabled=false)
   	public void tearDown(){
   		ConfigureDriver.getInstance().getDriver().close();
   	}
   	*/
   	}
    
