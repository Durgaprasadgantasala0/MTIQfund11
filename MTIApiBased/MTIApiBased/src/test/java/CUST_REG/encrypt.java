package CUST_REG;

import static io.restassured.RestAssured.given;

import java.util.Date;

import com.relevantcodes.extentreports.LogStatus;

import customer.signin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


	
public class encrypt extends signin{
	
	public Response Encrypt(String payload,String encrypturl) throws Exception{		
		test.log(LogStatus.INFO, "<FONT color=green style=Arial> ********Performing  API  To Encrypt Password********");
		test.log(LogStatus.INFO, "URL is "+encrypturl);
		test.log(LogStatus.INFO, "Request provided in BODY "+payload);
		System.out.println(payload);
		Response res=given().filter(filter).
				     relaxedHTTPSValidation().
				     header("Content-type", "application/json").
				     header("TIMEZONE_OFFSET",new Date().getTime()).
				     body(payload).
				     when().
				     post(encrypturl).
				     then().
				     extract().response();
		
		JsonPath newData = res.jsonPath();
		Encryptedpwd = newData.get("value");
		System.out.println(Encryptedpwd);          
		return res;
	
	}
	public Response EncryptSSN(String payload,String encrypturl) throws Exception{		
		test.log(LogStatus.INFO, "<FONT color=green style=Arial> ********Performing  API  To Encrypt Password********");
		test.log(LogStatus.INFO, "URL is "+encrypturl);
		test.log(LogStatus.INFO, "Request provided in BODY "+payload);
		System.out.println(payload);
		Response res=given().filter(filter).
				     relaxedHTTPSValidation().
				     header("Content-type", "application/json").
				     header("TIMEZONE_OFFSET",new Date().getTime()).
				     body(payload).
				     when().
				     post(encrypturl).
				     then().
				     extract().response();
		
		JsonPath newData = res.jsonPath();
		Encryptedssn = newData.get("value");
		System.out.println(Encryptedssn);          
		return res;
	}
	public Response EncryptPID(String payload,String encrypturl) throws Exception{		
		test.log(LogStatus.INFO, "<FONT color=green style=Arial> ********Performing  API  To Encrypt Password********");
		test.log(LogStatus.INFO, "URL is "+encrypturl);
		test.log(LogStatus.INFO, "Request provided in BODY "+payload);
		System.out.println(payload);
		Response res=given().filter(filter).
				     relaxedHTTPSValidation().
				     header("Content-type", "application/json").
				     header("TIMEZONE_OFFSET",new Date().getTime()).
				     body(payload).
				     when().
				     post(encrypturl).
				     then().
				     extract().response();
		
		JsonPath newData = res.jsonPath();
		Encryptedpid = newData.get("value");
		System.out.println(Encryptedpid);          
		return res;
	}
}