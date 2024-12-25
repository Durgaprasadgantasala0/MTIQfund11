package TestCases;





	import org.testng.Assert;
	import org.testng.annotations.Test;

	import PageObject.AdvanceSearchPage;
	import PageObject.AdvanceSearchResultsPage;
	import PageObject.AuthorizationAndConfirmationPage;
	import PageObject.DefaultPaymentPage;
import PageObject.EppPage;
import PageObject.LoansPage;
	import PageObject.LoginPage;
	import TestBase.BaseClass;

	public class EppTest extends BaseClass{
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
			public void performAdvanceSearch() throws Throwable {

				AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(driver);
				advanceSearchPage.custNbrBtn();
				advanceSearchPage.boCodeSearch(EPBOCODE);
				Thread.sleep(3000);
				advanceSearchPage.custNbrBtnclick();

				String advanceSearchConfMsg = advanceSearchPage.getConfirmationMsg();
				Assert.assertEquals(advanceSearchConfMsg, ADVANCE_SEARCH_RESULTS_MSG,
						"Advance Search Results confirmation message is not as expected!");
			}

			@Test(dependsOnMethods = "performAdvanceSearch")

			public void LoanLink() {

				AdvanceSearchResultsPage advanceSearchResultsPage = new AdvanceSearchResultsPage(driver);
				advanceSearchResultsPage.Loanlinknclick();
			}
			@Test(dependsOnMethods = "LoanLink")

			public void ActionsBtn() throws Throwable {

				LoansPage ltptl = new LoansPage(driver);
				
				ltptl.ActionsBtn();
				
				
				Thread.sleep(3000);
				ltptl.EPP();
				
			}
			@Test(dependsOnMethods = "LoanLink")

			public void buypayemt() throws Throwable {

				EppPage ep =new EppPage(driver);
				Thread.sleep(3000);
				ep.colldropdown();
				Thread.sleep(5000);
				ep.ACHCOLLL();
				Thread.sleep(3000);
				ep.selectACHRadioButton();
				Thread.sleep(3000);
				ep.FinishExtendedPaymentPlan();
				
						
			}
			@Test(dependsOnMethods = "buypayemt")

			public void  authorzation() throws Throwable {
				AuthorizationAndConfirmationPage arz = new AuthorizationAndConfirmationPage(driver);
				Thread.sleep(3000);
				arz.UserPwdInput(PWD);
				Thread.sleep(3000);
				arz.FinalsubmitButton();
				Thread.sleep(3000);
				arz.ConfirmOkayButton();
				
				}
	}






