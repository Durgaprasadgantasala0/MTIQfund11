package PageObject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoansPage {
	
	WebDriver driver;
public LoansPage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


@FindBy(xpath = "//*[@id=\"cell-8-undefined\"]/span")
WebElement actionselement;
@FindBy(xpath = "//li[text()='EPP Payment']")
WebElement EPPpayelement;

@FindBy(xpath = "//li[text()='Void EPP Payment']")
WebElement voidEPPpayelement;


@FindBy(xpath = "//li[text()='Default Payment']")
WebElement DefaultPaymentelement;
@FindBy(xpath = "//li[text()='Void Default Payment']")
WebElement voidDefaultPaymentelement;
@FindBy(xpath = "//li[text()='Payment']")
WebElement buybackPaymentelement;
@FindBy(xpath = "//li[text()='EPP']")
WebElement EPPelement;

@FindBy(xpath = "//li[text()='Void EPP']")
WebElement voidEPPelement;

@FindBy(xpath = "//li[text()='Due Date Extension']")
WebElement DueDateExtensionntelement;
@FindBy(xpath = "//li[text()='Void Buy Back']")
WebElement VoidBuyBackelement;



public void ActionsBtn()
{
	 assert actionselement.isDisplayed() : "Link 3658341 is not displayed";
	 actionselement.click();
	 
}
public void paymentoption()
{
	 assert EPPpayelement.isDisplayed() : "Link 3658341 is not displayed";
	 EPPpayelement.click();
}
public void voidEpp()
{
	 assert voidEPPelement.isDisplayed() : "Link 3658341 is not displayed";
	 voidEPPelement.click();
}
public void voidEPPpay()
{
	 assert voidEPPpayelement.isDisplayed() : "Link 3658341 is not displayed";
	 voidEPPpayelement.click();
}
public void DefaultPayment()
{
	 assert DefaultPaymentelement.isDisplayed() : "Link 3658341 is not displayed";
	 DefaultPaymentelement.click();
}
public void VoidDefaultPayment()
{
	 assert voidDefaultPaymentelement.isDisplayed() : "Link 3658341 is not displayed";
	 voidDefaultPaymentelement.click();
}
public void buybackPayment()
{
	 assert buybackPaymentelement.isDisplayed() : "Link 3658341 is not displayed";
	 buybackPaymentelement.click();
}
public void VoidBuyBack()
{
	 assert VoidBuyBackelement.isDisplayed() : "Link 3658341 is not displayed";
	 VoidBuyBackelement.click();
}
public void EPP()
{
	 assert EPPelement.isDisplayed() : "Link 3658341 is not displayed";
	 EPPelement.click();
}



}