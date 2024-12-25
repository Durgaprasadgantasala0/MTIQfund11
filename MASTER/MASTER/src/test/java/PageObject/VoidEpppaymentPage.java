package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VoidEpppaymentPage {

	WebDriver driver;
public VoidEpppaymentPage(WebDriver driver)
	
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
@FindBy(xpath = "//button[text()='Finish Void Payment Plan Payment']")
WebElement voideeppayelement;
@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div/strong")
WebElement voideepelamt;

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
	 amtinputField.sendKeys(paymentamt);
}
public void voidEPPpaybtn()
{
	 assert voideeppayelement.isDisplayed() : "Link 3658341 is not displayed";
	 voideeppayelement.click();
}
public String voideppamt() {
    // Assert that the element is displayed
    assert voideepelamt.isDisplayed() : "Link 3658341 is not displayed";

    String voidvalue = voideepelamt.getText();

    // Print the value
    System.out.println("Extracted value: " + voidvalue);
    return voidvalue;
    
}
}




