package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSearchResultsPage {
	WebDriver driver;
	public  AdvanceSearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css = "a.MuiTypography-root.MuiLink-root")
	 WebElement custlink;
	public void custlinknclick()
	{
		 assert custlink.isDisplayed() : "Link 3658341 is not displayed";
		custlink.click();
	}
	@FindBy(xpath = "//*[@id=\"cell-3-undefined\"]/div/a")
	WebElement loanlinknclick;
	
	
	public void Loanlinknclick()
	{
		 assert loanlinknclick.isDisplayed() : "Link 3658341 is not displayed";
		 loanlinknclick.click();
	}
	
	
}
