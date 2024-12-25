package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EppPage {
	WebDriver driver;

	public EppPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	   @FindBy(xpath = "//div[@id='demo-simple-select' and @role='button']")
	     WebElement dropdown;
	   @FindBy(xpath = "//*[@id=\"menu-action\"]/div[3]/ul/li[2]")
	     WebElement COLLL;
	  // @FindBy(xpath = "//li[contains(text(), 'ACH') or contains(text(), 'DEBIT CARD')or contains(text(), 'CASH') or contains(text(), 'CHECK')]")
	   // List<WebElement> collateralOptions;
	   
	   @FindBy(css = "input[type='radio'][value='8761002589']")
	    WebElement radioButton;
	   
	   @FindBy(xpath = "//button[contains(text(), 'Finish Extended Payment Plan')]")
		WebElement FinishExtendedPaymentPlanele;
	   
	   public void colldropdown()
	   {
	   	 assert dropdown.isDisplayed() : "Link 3658341 is not displayed";
	   	
	   	dropdown.click();
	   	
	   }
	   public void FinishExtendedPaymentPlan()
	   {
	   	 assert FinishExtendedPaymentPlanele.isDisplayed() : "Link 3658341 is not displayed";
	   	
	   	FinishExtendedPaymentPlanele.click();
	   	
	   }
	   public void ACHCOLLL()
	   {
	   	 assert COLLL.isDisplayed() : "Link 3658341 is not displayed";
	   	
	   	COLLL.click();
	   	
	   }
	 /*  public void selectCollateralType(String collateral) {
	        // Iterate over the list of collateral options and click the one that matches the collateral text
	        for (WebElement option : collateralOptions) {
	            if (option.getText().contains(collateral)) {
	                option.click(); // Click the matching option
	                break; // Exit the loop once the matching option is found
	            }
	        }}*/
	        public void selectACHRadioButton() {
	        	radioButton.click();
		       // if (!radioButton.isSelected()) {
		        	  // Click to select the radio button
		       // }
		    }
	   }

