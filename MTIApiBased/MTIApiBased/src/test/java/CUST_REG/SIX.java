package CUST_REG;


	import static io.restassured.RestAssured.given;

	import java.util.Date;

	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

import customer.signin;
import io.restassured.filter.cookie.CookieFilter;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	public class SIX extends signin {

		public  Response custsinc(ExtentTest test,int row,String payload,String baseuri,CookieFilter filter) throws Exception
		  {
		String method= new Exception() .getStackTrace()[0].getMethodName();	
				test.log(LogStatus.INFO, "<FONT color=green style=Arial> ********Performing  API ********"+method);
				test.log(LogStatus.INFO, "End Pont URL is "+baseuri+method);
				test.log(LogStatus.INFO, "Request provided in BODY "+payload);
				System.out.println(Number);  
				System.out.println("6--------------->");
				System.out.println(baseuri+method);
				System.out.println("REQUEST");
				System.out.println("######--------------->"+payload);
				System.out.println("RESPONSE");
				
				Response res=given().filter(filter).
						     relaxedHTTPSValidation().
						     header("Content-type", "application/json").
						     header("TIMEZONE_OFFSET",new Date().getTime()).
						     header("bt", BearerToken).
						     header("rt", RefreshToken).
						     header("cn", Number).
						     body(payload).
						     when().
						     post(baseuri+method).
						     then().
						     log().body().
						     extract().response();
				//JsonPath newData = res.jsonPath();
				//Number = newData.get("customerNumber");
				//System.out.println(Number);  
				 
				return res;
			
		  }	

	}






