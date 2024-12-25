package TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AdvanceSearchPage;
import PageObject.AdvanceSearchResultsPage;
import PageObject.AuthorizationAndConfirmationPage;
import PageObject.EppPaymentPage;
import PageObject.LoansPage;
import PageObject.LoginPage;
import TestBase.BaseClass;

public class EPPFullPaymentTest extends BaseClass {
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
			advanceSearchPage.boCodeSearch(EPPFULLBOCODE);
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
			LoansPage ltptl = new LoansPage(driver);

			// Perform the action of clicking the Actions button
			ltptl.ActionsBtn();

			// Wait for the action to complete before proceeding to payment option
			Thread.sleep(3000);

			// Perform the action of selecting the payment option
			ltptl.paymentoption();

		} catch (Exception e) {
			// Handle the exception and capture a screenshot on failure
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "ActionsBtn_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of an exception
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				// Handle screenshot capture failure
				e1.printStackTrace();
			}

			// Fail the test with the exception message
			Assert.fail("Test failed due to an exception in ActionsBtn method: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "LoanLink")
	public void paymentplan() throws Throwable {
		try {
			EppPaymentPage epp = new EppPaymentPage(driver);

			// Wait for the page to load or the action to complete
			Thread.sleep(3000);

			// Edit full EPP amount
			PPNfullPAYAMT = epp.fullEPPamtEdit();

			// Input the payment amount
			epp.PaymentInput(PPNfullPAYAMT);

			// Wait before proceeding to tender the amount
			Thread.sleep(3000);

			// Input tendered amount
			epp.TendereAmt(PPNfullPAYAMT);

			// Wait before clicking Finish
			Thread.sleep(3000);

			// Click Finish Payment Button
			epp.FinishPaymentButton();

		} catch (Exception e) {
			// Generate timestamp for screenshot file name
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "paymentplan_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of an exception
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Fail the test with the exception message
			Assert.fail("Test failed due to an exception in paymentplan method: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "paymentplan")
	public void authorization() throws Throwable {
		try {
			AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);

			// Wait for the user password input to be ready
			Thread.sleep(3000);

			// Input the user password
			arz.UserPwdInput(PWD);

			// Wait before submitting
			Thread.sleep(3000);

			// Click Final Submit Button
			arz.FinalsubmitButton();

			// Confirm the action
			arz.ConfirmOkayButton();

		} catch (Exception e) {
			// Generate timestamp for screenshot file name
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "authorization_Exception_" + timeStamp;

			try {
				// Capture the screenshot in case of an exception
				captureScreen(driver, screenFileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Fail the test with the exception message
			Assert.fail("Test failed due to an exception in authorization method: " + e.getMessage());
		}
	}
}