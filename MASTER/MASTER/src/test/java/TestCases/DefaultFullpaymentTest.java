package TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AdvanceSearchPage;
import PageObject.AdvanceSearchResultsPage;
import PageObject.AuthorizationAndConfirmationPage;
import PageObject.DefaultPaymentPage;
import PageObject.LoansPage;
import PageObject.LoginPage;
import TestBase.BaseClass;

public class DefaultFullpaymentTest extends BaseClass {
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
			advanceSearchPage.boCodeSearch(DEFFULLBOCODE);
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
			// Initialize LoansPage and perform actions
			LoansPage ltptl = new LoansPage(driver);
			ltptl.ActionsBtn();
			Thread.sleep(3000); // Wait for any required page load
			ltptl.DefaultPayment();
		} catch (Exception e) {
			// Generate a timestamped screenshot filename for the exception
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "ActionsBtn_Exception_" + timeStamp;

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

	@Test(dependsOnMethods = "LoanLink")
	public void defpayemt() throws Throwable {
		try {
			// Initialize DefaultPaymentPage and perform payment actions
			DefaultPaymentPage dfpg = new DefaultPaymentPage(driver);
			Thread.sleep(3000); // Wait for the page load or any other required wait

			// Edit full default amount
			DEFfullPAYAMT = dfpg.fulldefamtEdit();

			Thread.sleep(3000); // Wait for the field to be updated
			// Edit tendered amount
			dfpg.defamtTenderEdit(DEFfullPAYAMT);

			Thread.sleep(3000); // Wait for the field to be updated
			// Click on Finish button
			dfpg.defFinishBtn();
		} catch (Exception e) {
			// Generate a timestamped screenshot filename for the exception
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenFileName = "defpayemt_Exception_" + timeStamp;

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

	@Test(dependsOnMethods = "defpayemt")
	public void authorization() throws Throwable {
		try {
			// Initialize AuthorizationAndConfirmationPage and perform actions
			AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);

			// Input password
			Thread.sleep(3000); // Wait for the field to load or perform any required wait
			arz.UserPwdInput(PWD);

			Thread.sleep(3000); // Wait for the field to be updated
			// Submit the form
			arz.FinalsubmitButton();

			// Confirm the action
			Thread.sleep(3000); // Wait for the action to complete
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
			//Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}
}
