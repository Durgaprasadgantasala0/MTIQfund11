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

public class BuyBackPaymentTest extends BaseClass {
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

            //Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "storeLogin")
    public void performAdvanceSearch() throws Throwable {
        try {
            AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(driver);
            Thread.sleep(3000);
            advanceSearchPage.custNbrBtn();
            advanceSearchPage.boCodeSearch(BUYBOCODE);
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

            //Assert.fail("Test failed due to an exception: " + e.getMessage());
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

            //Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "LoanLink")
    public void ActionsBtn() throws Throwable {
        try {
            LoansPage ltptl = new LoansPage(driver);
            ltptl.ActionsBtn();
            Thread.sleep(3000);
            ltptl.buybackPayment();

        } catch (Exception e) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String screenFileName = "ActionsBtn_Exception_" + timeStamp;

            try {
                captureScreen(driver, screenFileName);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "LoanLink")
    public void buypayemt() throws Throwable {
        try {
            DefaultPaymentPage dfpg = new DefaultPaymentPage(driver);
            Thread.sleep(3000);

            BUYfullPAYAMT = dfpg.fulldefamtEdit();

            Thread.sleep(3000);
            dfpg.defamtTenderEdit(BUYfullPAYAMT);

            Thread.sleep(3000);
            dfpg.defFinishBtn();

        } catch (Exception e) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String screenFileName = "buypayemt_Exception_" + timeStamp;

            try {
                captureScreen(driver, screenFileName);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "buypayemt")
    public void authorization() throws Throwable {
        try {
            AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);
            Thread.sleep(3000);

            arz.UserPwdInput(PWD);

            Thread.sleep(3000);
            arz.FinalsubmitButton();

            Thread.sleep(3000);
            arz.ConfirmOkayButton();

        } catch (Exception e) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String screenFileName = "authorization_Exception_" + timeStamp;

            try {
                captureScreen(driver, screenFileName);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
