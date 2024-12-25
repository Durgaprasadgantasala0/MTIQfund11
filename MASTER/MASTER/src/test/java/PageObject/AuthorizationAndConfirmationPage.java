package PageObject;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class AuthorizationAndConfirmationPage {

		WebDriver driver;

		public AuthorizationAndConfirmationPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(name = "userPwd")
		 WebElement userPwdInput;
		
		@FindBy(xpath = "//button[@type='submit' and contains(@class, 'MuiButton-root') and contains(text(), 'Submit')]")
		private WebElement submitButton;
		@FindBy(xpath = "//button[@type='button' and contains(@class, 'MuiButton-root') and contains(text(), 'Go to Dashboard')]")
		private WebElement goToDashboardButton;
		@FindBy(xpath = "//button[text()='Okay']")
		WebElement OkayButton;
		
		public void UserPwdInput(String pwd) {
			assert userPwdInput.isDisplayed() : "Link  actionsButton is not displayed";
			userPwdInput.sendKeys(pwd);
			}
		
		
			public void FinalsubmitButton() throws InterruptedException {
				assert submitButton.isDisplayed() : "Link  actionsButton is not displayed";
			
				submitButton.click();
			}
			public void DashboardButton() throws InterruptedException {
				assert goToDashboardButton.isDisplayed() : "Link  actionsButton is not displayed";
			
				goToDashboardButton.click();
			}
			public void ConfirmOkayButton( )
			{
				 assert OkayButton.isDisplayed() : "Link 3658341 is not displayed";
				 OkayButton.click();
			}
	}


