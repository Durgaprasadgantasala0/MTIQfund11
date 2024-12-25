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

import PageObject.voidDefaultPaymentPage;
import TestBase.BaseClass;

public class VoidDefaultFullpaymentTest extends BaseClass {
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
			advanceSearchPage.boCodeSearch(VOIDDEFFULLBOCODE);
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

		LoansPage ltptl = new LoansPage(driver);

		ltptl.ActionsBtn();
		Thread.sleep(3000);
		ltptl.VoidDefaultPayment();

	}

	@Test(dependsOnMethods = "ActionsBtn")
	public void voiddef() throws Throwable {
		try {
			voidDefaultPaymentPage vdefpp = new voidDefaultPaymentPage(driver);
			Thread.sleep(3000); // Wait for any required page load or action
			vdefpp.voidEPPcashdd(); // Call method to perform action

			Thread.sleep(3000);
			vdefpp.voidEPPcash(); // Call method to perform another action

			Thread.sleep(3000);
			// Capture the voided amount
			VOIDDEFfullPAYAMT = vdefpp.voidamt();

			vdefpp.EPPamt(VOIDDEFfullPAYAMT); // Update EPP amount
			Thread.sleep(3000);
			vdefpp.voidEPPbtn(); // Click the void button
		} catch (Exception e) {
			// Generate a timestamped screenshot filename for the exception
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "voiddef_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of failure
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				// Handle screenshot capture failure
				e1.printStackTrace();
			}

			// Fail the test and provide the exception message
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "voiddef")
	public void authorization() throws Throwable {
		try {
			// Initialize AuthorizationAndConfirmationPage and perform the required actions
			AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);

			// Input the user password
			Thread.sleep(3000); // Wait for the field to load or the action to complete
			arz.UserPwdInput(PWD);

			// Submit the form
			Thread.sleep(3000);
			arz.FinalsubmitButton();

			// Confirm the action
			arz.ConfirmOkayButton();

		} catch (Exception e) {
			// Generate a timestamped screenshot filename for the exception
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "authorization_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of failure
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				// Handle screenshot capture failure
				e1.printStackTrace();
			}

			// Fail the test and provide the exception message
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}

}
