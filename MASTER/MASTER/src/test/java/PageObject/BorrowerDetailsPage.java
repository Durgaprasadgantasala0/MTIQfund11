package PageObject;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class BorrowerDetailsPage {

		WebDriver driver;

		public BorrowerDetailsPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//button[text()='Actions']")
		WebElement actionsBtn;
		@FindBy(xpath = "//li[contains(text(),'New Loan')]")
		WebElement newloanButton;

		public void actionsButton() {
			assert actionsBtn.isDisplayed() : "Link  actionsButton is not displayed";
			actionsBtn.click();
		}
		public void NewLoanButton() {
			assert newloanButton.isDisplayed() : "Link  actionsButton is not displayed";
			newloanButton.click();
		}
	}


