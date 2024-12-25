package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AdvanceSearchPage;
import PageObject.AdvanceSearchResultsPage;
import PageObject.AuthorizationAndConfirmationPage;
import PageObject.BorrowerDetailsPage;
import PageObject.CollateralDetailsPage;
import PageObject.DisbursementsPage;
import PageObject.LoanDecisioningPage;
import PageObject.LoanDetailsPage;
import PageObject.LoginPage;
import TestBase.BaseClass;


public class LoanOriginationTest extends BaseClass {

   
    @Test
	public void storeLogin() {

    	  
   

    		driver.get(URL);
    		driver.manage().window().maximize();

    		LoginPage loginPage = new LoginPage(driver);
    		loginPage.storeCode(STCODE);
    		loginPage.userName(USER);
    		loginPage.userPassword(PWD);
    		loginPage.continueBtn();

    		String confirmationMsg = loginPage.getConfirmationMsg();
    		Assert.assertEquals(confirmationMsg, DASHBOARD_MSG, "Login confirmation message is not as expected!");
    	}

    	@Test(dependsOnMethods = "storeLogin")
    	public void performAdvanceSearch() {

    		AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(driver);
    		advanceSearchPage.custNbrBtn();
    		advanceSearchPage.boCodeSearch(BOCODE);
    		advanceSearchPage.custNbrBtnclick();

    		String advanceSearchConfMsg = advanceSearchPage.getConfirmationMsg();
    		Assert.assertEquals(advanceSearchConfMsg, ADVANCE_SEARCH_RESULTS_MSG,
    				"Advance Search Results confirmation message is not as expected!");
    	}

    	@Test(dependsOnMethods = "performAdvanceSearch")

    	public void clickCustomerLink() {

    		AdvanceSearchResultsPage advanceSearchResultsPage = new AdvanceSearchResultsPage(driver);
    		advanceSearchResultsPage.custlinknclick();
    	}

    	@Test(dependsOnMethods = "clickCustomerLink")

    	public void clickloanLink() {
    		BorrowerDetailsPage bdp = new BorrowerDetailsPage(driver);
    		bdp.actionsButton();
    		bdp.NewLoanButton();
    	}
    	
    @Test(dependsOnMethods = "clickloanLink")

    	public void LoanDecisioning() throws Throwable {
    		LoanDecisioningPage ldp = new LoanDecisioningPage(driver);
    		Thread.sleep(15000);
    		ldp.CollateralTypeSelect();
    		Thread.sleep(5000);
    		ldp.selectCollateralType(COLL); 
    		//ldp.EligibilityButton();
    		Thread.sleep(5000);
    		ldp.ProductSelection();
    		ldp.ContinueButton();
    	}
    	@Test(dependsOnMethods = "LoanDecisioning")

    	public void  LoanDetails() throws Throwable {
    		LoanDetailsPage ldtp = new LoanDetailsPage(driver);
    		Thread.sleep(3000);
    		ldtp.AmtEdit();
    		Thread.sleep(3000);
    		ldtp.AmtEnter(AMT);
    		Thread.sleep(3000);
    		ldtp.AmtFreez();
    		ldtp.SaveAndContinueButton();
    }
    	@Test(dependsOnMethods = "LoanDetails")

    	public void  Collateraldetails() throws Throwable {
    		CollateralDetailsPage coldp = new CollateralDetailsPage(driver);
    		Thread.sleep(5000);
    		coldp.LoanJourneySelect();
    		Thread.sleep(5000);
    		coldp.loanJourneyCloseSelect();
    		Thread.sleep(2000);
    		coldp.selectACHRadioButton();
    		coldp.SavColl();
    		
    }
    	
    	@Test(dependsOnMethods = "Collateraldetails")

    	public void  Disbursements() throws Throwable {
    		DisbursementsPage lddp = new DisbursementsPage(driver);
    		Thread.sleep(3000);
    		lddp.SubmitButton();
    	}
    	
    	@Test(dependsOnMethods = "Disbursements")

    	public void  authorzation() throws Throwable {
    		AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);
    		Thread.sleep(3000);
    		arz.UserPwdInput(PWD);
    		Thread.sleep(3000);
    		arz.FinalsubmitButton();
    		Thread.sleep(3000);
    		arz.DashboardButton();
    		
    	
    	
    	}}