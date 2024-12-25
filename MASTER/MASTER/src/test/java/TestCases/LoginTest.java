package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AdvanceSearchPage;
import PageObject.AdvanceSearchResultsPage;
import PageObject.LoginPage;
import TestBase.BaseClass;

public class LoginTest extends BaseClass {

    // Constants for expected confirmation messages
    private static final String DASHBOARD_MSG = "Dashboard";
    private static final String ADVANCE_SEARCH_RESULTS_MSG = "Advance Search Results";

    @Test
    public void storeLogin() {
        // Step 1: Navigate to the website and maximize the window
        driver.get("https://aeauiuxdev.qfund.net");
        driver.manage().window().maximize();

        // Step 2: Perform login using LoginPage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.storeCode("4393");
        loginPage.userName("apr4393");
        loginPage.userPassword("1234");
        loginPage.continueBtn();

        // Step 3: Assert Login Confirmation Message
        String confirmationMsg = loginPage.getConfirmationMsg();
        Assert.assertEquals(confirmationMsg, DASHBOARD_MSG, "Login confirmation message is not as expected!");
    }
    @Test(dependsOnMethods = "storeLogin")  // This ensures the loginTest is executed first
    public void performAdvanceSearch() {
        // Step 1: Perform actions on AdvanceSearchPage
        AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(driver);
        advanceSearchPage.custNbrBtn();
        advanceSearchPage.boCodeSearch("3658341");
        advanceSearchPage.custNbrBtnclick();

        // Step 2: Assert Advance Search Results confirmation message
        String advanceSearchConfMsg = advanceSearchPage.getConfirmationMsg();
        Assert.assertEquals(advanceSearchConfMsg, ADVANCE_SEARCH_RESULTS_MSG, "Advance Search Results confirmation message is not as expected!");
    }
    
    @Test(dependsOnMethods = "performAdvanceSearch")  
    // This ensures that the advance search test is executed first
    public void clickCustomerLink() {
        // Step 1: Click on the customer link on the results page
        AdvanceSearchResultsPage advanceSearchResultsPage = new AdvanceSearchResultsPage(driver);
        advanceSearchResultsPage.custlinknclick();
    }
}
