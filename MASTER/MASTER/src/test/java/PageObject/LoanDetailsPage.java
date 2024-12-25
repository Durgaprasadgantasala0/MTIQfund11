package PageObject;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoanDetailsPage {
		WebDriver driver;

		public LoanDetailsPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//span[(text()='edit')]")
		WebElement amtEdit;

		@FindBy(name = "reqAmount")
		WebElement amtenter;

		@FindBy(xpath = "//span[(text()='new_releases')]")
		WebElement amtfreez;

		@FindBy(xpath = "//button[text()='Save & Continue']")
		WebElement saveAndContinueButton;

		public void AmtEdit() {
			assert amtEdit.isDisplayed() : "Link  actionsButton is not displayed";
			amtEdit.click();
		}

		public void AmtEnter(String amt) {
			assert amtenter.isDisplayed() : "Link  actionsButton is not displayed";
			amtenter.sendKeys(amt);
			amtenter.clear();
			amtenter.sendKeys(amt);
		}

		public void AmtFreez() {
			assert amtfreez.isDisplayed() : "Link  actionsButton is not displayed";
			amtfreez.click();

		}

		public void SaveAndContinueButton() {
			assert saveAndContinueButton.isDisplayed() : "Link  actionsButton is not displayed";
			saveAndContinueButton.click();

		}

	}


