package PageObject;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CollateralDetailsPage {
		WebDriver driver;
		public CollateralDetailsPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//a[(text()='Loan Journey')]")
		WebElement loanJourneySelect;
		@FindBy(xpath = "//span[@aria-label='Close']")
		WebElement loanJourneycloseSelect;
		 @FindBy(css = "input[name='achSelect']")
		    WebElement achRadioButton;
		
		@FindBy(xpath = "//button[(text()='Save & Continue')]")
		WebElement savecoll;
		
		public void selectACHRadioButton() {
	        if (!achRadioButton.isSelected()) {
	            achRadioButton.click();  // Click to select the radio button
	        }
	    }
		
		public void SavColl() {
			assert savecoll.isDisplayed() : "Link  actionsButton is not displayed";
			savecoll.click();
		}
		public void LoanJourneySelect() {
			assert loanJourneySelect.isDisplayed() : "Link  actionsButton is not displayed";
			loanJourneySelect.click();
			
		}
		public void loanJourneyCloseSelect() {
			assert loanJourneycloseSelect.isDisplayed() : "Link  actionsButton is not displayed";
			loanJourneycloseSelect.click();
		}
	}


