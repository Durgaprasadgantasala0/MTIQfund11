package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EppPaymentPage {
	WebDriver driver;
	public  EppPaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//*[@id='outlined-basics' and @placeholder='Enter Amt']")
	WebElement paymentInput;
	@FindBy(xpath = "//*[@id='C']")
	WebElement TendereAmtlement;
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[3]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div/div")
	WebElement eppamtpay;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/button[2]")
	WebElement finishPaymentButton;
	
	public String fullEPPamtEdit() {
	    // Assert that the element is displayed
	    assert eppamtpay.isDisplayed() : "Link 3658341 is not displayed";

	    // Get the value attribute of the input field
	    String value = eppamtpay.getText();
	    
	    // Print the value of the input field
	    System.out.println("Input value: " + value);
	    
	    // Return the value
	    return value;
	}

	public void PaymentInput(String payemtamt)
	{
		 assert paymentInput.isDisplayed() : "Link 3658341 is not displayed";
		 paymentInput.sendKeys(payemtamt);
		 paymentInput.clear();
		 paymentInput.sendKeys(payemtamt);
	}
	
	public void TendereAmt(String payemtamt)
	{
		 assert TendereAmtlement.isDisplayed() : "Link 3658341 is not displayed";
		 TendereAmtlement.sendKeys(payemtamt);;
	}
	public void FinishPaymentButton( )
	{
		 assert finishPaymentButton.isDisplayed() : "Link 3658341 is not displayed";
		 finishPaymentButton.click();
	}
	
}
