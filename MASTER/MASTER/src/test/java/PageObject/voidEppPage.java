package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class voidEppPage {
	WebDriver driver;

	public voidEppPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//button[text()='Void Payment Plan']")
	WebElement voideepelement;

public void voidEPPbtn()
{
	 assert voideepelement.isDisplayed() : "Link 3658341 is not displayed";
	 voideepelement.click();
}}