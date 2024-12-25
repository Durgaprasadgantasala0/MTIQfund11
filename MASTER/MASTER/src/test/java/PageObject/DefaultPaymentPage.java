package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DefaultPaymentPage {
	WebDriver driver;

	public DefaultPaymentPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(xpath="//*[@id=\"outlined-basics\"]")	
WebElement amtedit;
@FindBy(xpath="//*[@id=\"C\"]")	
WebElement Tenderamtedit;
@FindBy(xpath="//*[@id=\"root\"]/div/main/div/div[2]/button[2]")	
WebElement deffinishbtn;


public void defamtEdit(String amount)
{
	 assert amtedit.isDisplayed() : "Link 3658341 is not displayed";
	 amtedit.sendKeys(amount);
	 amtedit.clear();
	 amtedit.sendKeys(amount);
}
public String fulldefamtEdit() {
    // Assert that the element is displayed
    assert amtedit.isDisplayed() : "Link 3658341 is not displayed";

    // Get the value attribute of the input field
    String value = amtedit.getAttribute("value");
    
    // Print the value of the input field
    System.out.println("Input value: " + value);
    
    // Return the value
    return value;
}
public void defamtTenderEdit(String amount)
{
	 assert Tenderamtedit.isDisplayed() : "Link 3658341 is not displayed";
	// Tenderamtedit.sendKeys(amount);
	 //Tenderamtedit.clear();
	 Tenderamtedit.sendKeys(amount);
}

public void defFinishBtn()
{
	 assert deffinishbtn.isDisplayed() : "Link 3658341 is not displayed";
	
	 deffinishbtn.click();
	
}
}