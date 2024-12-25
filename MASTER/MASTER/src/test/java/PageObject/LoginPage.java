package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="locNbr")
	WebElement txtlocNbr;
	@FindBy(name="userId")
	WebElement textuserid;
	@FindBy(name="userPwd")
	WebElement txtuserpwd;
	@FindBy(xpath="//*[@id='root']/div/div/div/div/div/div[2]/form/div/div[3]/div/button")
	WebElement btncontinue;
	@FindBy(xpath = "//h2[text()='Dashboard']")
     WebElement dashboardHeader;
	
	public void storeCode(String stcode)
	{
		txtlocNbr.sendKeys(stcode);
	}
	public void userName(String uid)
	{
		textuserid.sendKeys(uid);
	}
	public void userPassword(String pwd)
	{
		txtuserpwd.sendKeys(pwd);
	}
	
	public void continueBtn()
	{
		btncontinue.click();
	}
	public String getConfirmationMsg()
	{
		try
		{
		return (dashboardHeader.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
