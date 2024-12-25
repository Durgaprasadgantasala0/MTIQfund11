package TestBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;




public class  BaseClass{
	
public WebDriver driver;

	
	public static final String DASHBOARD_MSG = "Dashboard";
	public static final String ADVANCE_SEARCH_RESULTS_MSG = "Advance Search Results";
	
	//public static final String URL = "https://aeauiuxdev.qfund.net";
	public static final String URL = "https://mtlmsdev.qfund.net/";public static final String STCODE = "49";public static final String USER = "CA49";
	
	
	
	//public static final String URL = "https://sandboxlms.qfund.net";public static final String STCODE = "45";public static final String USER = "CA45";
  public static final String PWD = "1234";
  
  public static final String EPBOCODE = "11839755";//EPP
	public static final String EPPFULLBOCODE = "12033819";//EPPpay
	public static final String voidEPPFULLBOCODE = "12033819";//EPPpay
	public static final String EPPPARTIALBOCODE = "12033819";//EPPpay
	public static final String voidEPPPARTIALBOCODE = "12033819";//EPPpay
	public static final String DEFFULLBOCODE = "12075926";//def
	public static final String VOIDDEFFULLBOCODE = "12075926";//def
	public static final String DEFPARTIALBOCODE = "12075926";//def
	public static final String VOIDDEFPARTIALBOCODE = "12075926";//def
	public static final String BOCODE = "12034444";//bnk
public static final String BUYBOCODE = "12098467";//buy
public static final String voidBUYBOCODE = "12098467";//buy

	public static final String COLL = "ACH";
	//public static final String COLL = "DEBIT CARD";
	//public static final String COLL = "CHECK";
	//public static final String COLL = "CASH";
	public static final String AMT = "200";
	public static final String PAYAMT = "10";
	public static  String BUYfullPAYAMT ;
	public static  String VOIDBUYfullPAYAMT ;
	public static  String PPNfullPAYAMT ;
	public static  String VOIDPPNfullPAYAMT ;
	public static  String DEFfullPAYAMT ;
	public static  String VOIDDEFfullPAYAMT ;
	public Logger logger; //For Logging 
	@BeforeClass 
	
	public void log_in() throws Throwable {
	
		
		System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://mtlmsdev.qfund.net/");
	
		
		
	}
		
		@AfterClass
		public void tearDown()
		{
		driver.close();
		}
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File("C:\\Users\\durgaprasad.g\\Downloads\\Qfund11WebBase\\src\\test\\resources\\screenshots\\" + tname + ".png");
			FileUtils.copyFile(source, target);
		}
}