package PageObject;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class DisbursementsPage {

		
		WebDriver driver;

		public DisbursementsPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
			
		@FindBy(xpath = "//button[contains(text(), 'Submit & Authorize')]")
		 WebElement submitButton;

			
			public void SubmitButton() {
				assert submitButton.isDisplayed() : "Link  actionsButton is not displayed";
				submitButton.click();
			
			
			
			
			
			
			
		}

		
		
		
	}


