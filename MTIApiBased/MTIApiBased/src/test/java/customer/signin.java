package customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.mongodb.util.JSON;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import CUST_REG.Auth;
import CUST_REG.Authentication;
import CUST_REG.EIGHT;
import CUST_REG.FIVE;
import CUST_REG.FOUR;
import CUST_REG.NINE;
import CUST_REG.ONE;
import CUST_REG.OlDateChange;
import CUST_REG.SEVEN;
import CUST_REG.SIX;
import CUST_REG.TEN;
import CUST_REG.THREE;
import CUST_REG.TWO;
import CUST_REG.encrypt;
import Utility.EXCELL;
import Utility.static_key_values;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.response.Response;

public class signin extends static_key_values {

	public static String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date().getTime());
	public static CookieFilter filter = new CookieFilter();

	public String ssn() throws Throwable {
		Random rand = new Random();
		Integer rand_int1 = rand.nextInt(9);
		Integer rand_int2 = rand.nextInt(9);
		Integer rand_int3 = rand.nextInt(9);
		Integer rand_int4 = rand.nextInt(9);
		String SSN = "65322";
		usssn = SSN + rand_int1 + rand_int2 + rand_int3 + rand_int4;
		System.out.println(usssn);
		return usssn;
	}

	// @Test(priority = 0)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void signin() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;
				Auth signin = new Auth();

				Response res = signin.auth(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
	}

	// @Test(priority = 1)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custspi() throws Throwable {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);
				// System.out.println(encryptpayload);
				String json = encryptpayload;
				 
				String updated = json.replace("SSN", usssn);
				// System.out.println(updated);

				encrypt encrypt = new encrypt();
				encrypt.EncryptSSN(updated, encrypturl);
				// ======================= Updating The Password As Per Requirment in encrypt
				// format ====================
				test.log(LogStatus.INFO, "**** Required Encrypted Password for Signin service ****** ");
				String json1 = SignInpayload;
				String updated1 = json1.replaceAll("SSN", Encryptedssn);
				System.out.println(JSON.parse(updated1));
                String SignInRequest = updated1;
				
				//String SignInRequest = SignInpayload;
				test.log(LogStatus.INFO, "Updated the Encrypted Password is : " + Encryptedssn);
				ONE signin = new ONE();
				Response res = signin.custspi(test, row, SignInRequest, baseuri, filter);

			}
		}
		reports.flush();
	}

	// @Test(priority = 2)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsai() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;
				TWO signin = new TWO();
				Response res = signin.custsai(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
	}

	// @Test(priority = 3)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsci() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;
				;
				THREE signin = new THREE();

				Response res = signin.custsci(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
	}

	// @Test(priority = 4)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsii() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				// System.out.println(encryptpayload);
				String json3 = encryptpayload;
				String updated = json3.replace("PID", usssn + "pid");
				// System.out.println(updated);
				encrypt encrypt = new encrypt();
				encrypt.EncryptPID(updated, encrypturl);
				// ======================= Updating The Password As Per Requirment in encrypt
				// format ====================
				test.log(LogStatus.INFO, "**** Required Encrypted Password for Signin service ****** ");
				String json1 = SignInpayload;
				String updated1 = json1.replaceAll("SSN", Encryptedpid);
				// System.out.println(JSON.parse(updated1));

				String SignInRequest = updated1;
				test.log(LogStatus.INFO, "Updated the Encrypted Password is : " + Encryptedssn);

				FOUR signin = new FOUR();

				Response res = signin.custsii(test, row, SignInRequest, baseuri, filter);

			}
		}
		reports.flush();
	}

	// @Test(priority = 5)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsmp() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;

				FIVE signin = new FIVE();

				Response res = signin.custsmp(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
	}

	// @Test(priority = 6)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsinc() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;

				SIX signin = new SIX();

				Response res = signin.custsinc(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
	}

	// @Test(priority = 7)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsoi() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;

				SEVEN signin = new SEVEN();

				Response res = signin.custsoi(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
	}

	// @Test(priority = 8)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsri() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;

				EIGHT signin = new EIGHT();

				Response res = signin.custsri(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();

	}

	public void custsri1() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;

				EIGHT signin = new EIGHT();

				Response res = signin.custsri(test, row, SignInpayload, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();

	}

	// @Test(priority = 9)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custsbi() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				String json = SignInpayload;
				
				 
				String updated = json.replace("SSN", usssn);
				 System.out.println("----------->"+updated);


                String SignInRequest = updated;
				NINE signin = new NINE();

				Response res = signin.custsbi(test, row, SignInRequest, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
		System.out.println(Number);
	}

	// @Test(priority = 9)//Performing SignIn Operation in Login Service Module
	// with /auth Publishing URL
	public void custscd() throws Exception {
		String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		FileName = System.getProperty("user.dir") + "/TestData/" + APIModule + ".xls";
		System.out.println(FileName);
		String sheetName = Operation;
		TestData = new EXCELL(FileName);
		reports = new ExtentReports(System.getProperty("user.dir") + "/ExecutionReports/" + APIModule + "/" + APIModule
				+ "_" + Operation + "_" + timestamp + ".html", true);
		int lastrow = TestData.getLastRow(sheetName);
		for (int row = 2; row <= lastrow + 1; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String StepDetails = TestData.getCellData(sheetName, "Step Details", row);
				String Step = TestData.getCellData(sheetName, "Step #", row);
				test = reports.startTest(Step + "-" + StepDetails, Operation + " Scenarios-" + StepDetails + "");
				String ExpectedResponse = TestData.getCellData(sheetName, "Response", row);
				String SignInpayload = TestData.getCellData(sheetName, "Request", row);
				String encryptpayload = TestData.getCellData(sheetName, "encryptRequest", row);
				String NodeValidation = TestData.getCellData(sheetName, "Node Validation", row);
				String ExpectedNodeResponse = TestData.getCellData(sheetName, "Expected Node Response", row);
				// DataAccessManager dam = new DataAccessManager();
				Thread.sleep(1000);
				// dam.empUnlock(test);

				
				
				
				
				
				String SignInRequest = SignInpayload;
				test.log(LogStatus.INFO, "Updated the Encrypted Password is : " + Encryptedssn);
				TEN signin = new TEN();
		
				Response res = signin.custscd(test, row, SignInRequest, baseuri, filter);
				// ======================================================

			}
		}
		reports.flush();
		System.out.println(Number);
	}

}
