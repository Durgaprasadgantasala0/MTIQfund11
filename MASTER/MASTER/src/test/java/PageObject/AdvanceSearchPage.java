package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSearchPage {

	
WebDriver driver;
	
	public AdvanceSearchPage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	 @FindBy(xpath = "//span[@aria-label='Adv Search']")
	WebElement custNbrserc;
	
	@FindBy(name="migCustomerNumber")
	WebElement custNbr;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement custNbrbtn;
	
	 @FindBy(xpath = "//h2[text()='Advance Search Results']")
	     WebElement advanceSearchResultsHeader;
	
	public void custNbrBtn()
	{
		custNbrserc.click();
	}
	
	
	public void boCodeSearch(String bocode )
	{
		custNbr.sendKeys(bocode);
	}
	
	public void custNbrBtnclick()
	{
		custNbrbtn.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
		return (advanceSearchResultsHeader.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
