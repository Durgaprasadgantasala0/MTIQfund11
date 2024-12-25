package PageObject;


	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoanDecisioningPage {

		WebDriver driver;

		public LoanDecisioningPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(id = "mui-component-select-Collateral Type")
		WebElement collateralTypeSelect;

		//@FindBy(xpath = "//li[contains(text(), 'ACH')]")
	   // WebElement SelectCollateral;
		
		 @FindBy(xpath = "//li[contains(text(), 'ACH') or contains(text(), 'DEBIT CARD')or contains(text(), 'CASH') or contains(text(), 'CHECK')]")
		    List<WebElement> collateralOptions;

		@FindBy(xpath = "//button[contains(text(), 'Eligibility')]")
		WebElement eligibilityButton;
		
		 
		
		// @FindBy(xpath = "//*[@id='root']/div/main/div/div[2]/div[5]/div/div[2]/div[2]/div/div[2]/div/div[4]/div[1]/div/div/div/div/div/div/div/div/div")
		 
		 @FindBy(xpath = "//*[@id='root']/div/main/div/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div/div[4]/div[1]/div/div/div/div/div/div/div/div/div/div")
		WebElement yourElement;
		 @FindBy(xpath = "//button[(text()='Continue')]")
			WebElement continuebutton;
		 
		 
		 
		public void CollateralTypeSelect() {
			assert collateralTypeSelect.isDisplayed() : "Link  actionsButton is not displayed";
			collateralTypeSelect.click();
		}

		 public void selectCollateralType(String collateral) {
		        // Iterate over the list of collateral options and click the one that matches the collateral text
		        for (WebElement option : collateralOptions) {
		            if (option.getText().contains(collateral)) {
		                option.click(); // Click the matching option
		                break; // Exit the loop once the matching option is found
		            }
		        }
		}

		public void EligibilityButton() {

			eligibilityButton.click();
		}

		public void ProductSelection() {

			yourElement.click();
		}
		public void ContinueButton() {

			continuebutton.click();
		}
	}


