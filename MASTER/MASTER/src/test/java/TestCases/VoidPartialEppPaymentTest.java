package TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AdvanceSearchPage;
import PageObject.AdvanceSearchResultsPage;
import PageObject.AuthorizationAndConfirmationPage;
import PageObject.LoansPage;
import PageObject.LoginPage;

import PageObject.VoidEpppaymentPage;
import TestBase.BaseClass;

public class VoidPartialEppPaymentTest extends BaseClass {
	@Test

	public void storeLogin() {
		try {
			driver.get(URL);
			driver.manage().window().maximize();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.storeCode(STCODE);
			loginPage.userName(USER);
			loginPage.userPassword(PWD);
			loginPage.continueBtn();

			String className = this.getClass().getSimpleName();
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = className + "_" + methodName + "_" + timeStamp;

			captureScreen(driver, screenFileName);

			String confirmationMsg = loginPage.getConfirmationMsg();
			Assert.assertEquals(confirmationMsg, DASHBOARD_MSG, "Login confirmation message is not as expected!");

		} catch (Exception e) {
			String exceptionTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "test_account_Registration_Exception_" + exceptionTimeStamp;

			try {
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "storeLogin")
	public void performAdvanceSearch() throws Throwable {
		try {
			AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(driver);
			Thread.sleep(3000);
			advanceSearchPage.custNbrBtn();
			advanceSearchPage.boCodeSearch(voidEPPPARTIALBOCODE);
			Thread.sleep(3000);
			advanceSearchPage.custNbrBtnclick();

			String advanceSearchConfMsg = advanceSearchPage.getConfirmationMsg();
			Assert.assertEquals(advanceSearchConfMsg, ADVANCE_SEARCH_RESULTS_MSG,
					"Advance Search Results confirmation message is not as expected!");

		} catch (Exception e) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "performAdvanceSearch_Exception_" + timeStamp;

			try {
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "performAdvanceSearch")
	public void LoanLink() {
		try {
			AdvanceSearchResultsPage advanceSearchResultsPage = new AdvanceSearchResultsPage(driver);
			advanceSearchResultsPage.Loanlinknclick();

		} catch (Exception e) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "LoanLink_Exception_" + timeStamp;

			try {
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "LoanLink")
	public void ActionsBtn() throws Throwable {
		try {
			// Initialize the LoansPage object
			LoansPage ltptl = new LoansPage(driver);

			// Perform the action and wait for 3 seconds (if needed for page load)
			ltptl.ActionsBtn();
			Thread.sleep(3000);

			// Execute the void payment action
			ltptl.voidEPPpay();

		} catch (Exception e) {
			// Generate a timestamped screenshot filename
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "ActionsBtn_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of failure
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				// Handle screenshot capture failure
				e1.printStackTrace();
			}

			// Log the exception message and fail the test
			System.out.println("Test failed in method ActionsBtn due to an exception: " + e.getMessage());
			Assert.fail("Test failed in method ActionsBtn due to an exception: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "ActionsBtn")
	public void voidEpp() throws Throwable {
		try {
			// Initialize VoidEpppaymentPage
			VoidEpppaymentPage vpp = new VoidEpppaymentPage(driver);

			// Perform the required actions with some sleep time
			Thread.sleep(3000);
			vpp.voidEPPcashdd();
			Thread.sleep(3000);
			vpp.voidEPPcash();
			Thread.sleep(3000);

			// Capture the voided amount
			VOIDPPNfullPAYAMT = vpp.voideppamt();

			// Update EPP amount and proceed with voiding the payment
			vpp.EPPamt(VOIDPPNfullPAYAMT);
			Thread.sleep(3000);

			// Click the void button
			vpp.voidEPPpaybtn();

		} catch (Exception e) {
			// Generate a timestamped screenshot filename
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "voidEpp_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of failure
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				// Handle screenshot capture failure
				e1.printStackTrace();
			}

			// Log the exception message and fail the test
			System.out.println("Test failed in method voidEpp due to an exception: " + e.getMessage());
			Assert.fail("Test failed in method voidEpp due to an exception: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "voidEpp")
	public void authorization() throws Throwable {
		try {
			// Initialize AuthorizationAndConfirmationPage
			AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);

			// Perform actions related to authorization
			Thread.sleep(3000);
			arz.UserPwdInput(PWD);
			Thread.sleep(3000);
			arz.FinalsubmitButton();
			arz.ConfirmOkayButton();

		} catch (Exception e) {
			// Generate a timestamped screenshot filename
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "authorization_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of failure
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				// Handle screenshot capture failure
				e1.printStackTrace();
			}

			// Log the exception message and fail the test
			System.out.println("Test failed in method authorization due to an exception: " + e.getMessage());
			Assert.fail("Test failed in method authorization due to an exception: " + e.getMessage());
		}
	}
}