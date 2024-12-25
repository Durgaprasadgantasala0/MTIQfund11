package PageObject;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;



	public class voidDefaultPaymentPage extends BaseClass {

		WebDriver driver;
	public voidDefaultPaymentPage(WebDriver driver)
		
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div")
	WebElement cashOptiondrop;

	@FindBy(xpath = "//li[@data-value='C']")
	WebElement cashOption;


	@FindBy(xpath = "//*[@id=\"outlined-basics\"]")
	WebElement amtinputField;
	@FindBy(xpath = "//button[text()='Void Default Payment']")
	WebElement voideepelement;
	@FindBy(xpath = "//button[text()='Void Payment']")
	WebElement voidbuyelement;
	 @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div[1]/div/div[1]/div/strong")
	     WebElement strongElement;

	public void voidEPPcashdd()
	{
		 assert cashOptiondrop.isDisplayed() : "Link 3658341 is not displayed";
		 cashOptiondrop.click();
	}


	public void voidEPPcash()
	{
		 assert cashOption.isDisplayed() : "Link 3658341 is not displayed";
		 cashOption.click();
	}

	public void EPPamt(String paymentamt)
	{
		 assert amtinputField.isDisplayed() : "Link 3658341 is not displayed";
		// amtinputField.sendKeys(paymentamt);
		 amtinputField.clear();
		 amtinputField.sendKeys(paymentamt);
	}
	public void voidEPPbtn()
	{
		 assert voideepelement.isDisplayed() : "Link 3658341 is not displayed";
		 voideepelement.click();
	}
	public void voidbuybtn()
	{
		 assert voidbuyelement.isDisplayed() : "Link 3658341 is not displayed";
		 voidbuyelement.click();
	}
	public String voidamt() {
	    // Assert that the element is displayed
	    assert strongElement.isDisplayed() : "Link 3658341 is not displayed";

	    String voidvalue = strongElement.getText();

        // Print the value
        System.out.println("Extracted value: " + voidvalue);
        return voidvalue;
	    
	}
	}





