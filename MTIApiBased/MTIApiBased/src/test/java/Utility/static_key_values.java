package Utility;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sun.xml.fastinfoset.sax.Properties;

public class static_key_values {
		static String Operation = new Exception().getStackTrace()[0].getMethodName();
		String APIModule = this.getClass().getSimpleName();
		//public static String baseuri = "https://192.168.2.202/";
				//public static String baseuri = "https://qfunduiuxqa.qfund.net/";
			//	public static String baseuri = "https://qfunduiuxdev.qfund.net/";
			//	public static String encrypturl = "https://192.168.2.190/common/v1/json/encrypt";
				// public static String baseuri = "https://qfunduiux.qfund.net/";
		//public static String baseuri = "https://192.168.2.202/";
	//public static String baseuri = "https://qfunduiuxqa.qfund.net/";
		//public static String baseuri = "https://qf11demo.qfund.net/";
		
	//public static String baseuri = "https://qfunduiuxdev.qfund.net/";
	public static String baseuri = "https://mtlmsdev.qfund.net/";
	
	//public static String baseuri = "https://sandboxlms.qfund.net/";
		public static String encrypturl = "https://192.168.2.208/common/v1/json/encrypt";
		public static String FileName;
		public static ExtentReports reports;
		public static ExtentTest test;
		public static EXCELL TestData;
		public static Properties prop;
		public static String BearerToken;
		public static String RefreshToken;
		public static String Encryptedpwd;
		public static String Encryptedssn;
		public static String Encryptedpid;
		public static String XUSEDETAILS;
		public static Integer Number;
		public static String LNNumber;
		public static String usssn;
		public static int bo_code;
		//="5585706";
	
		
	}




