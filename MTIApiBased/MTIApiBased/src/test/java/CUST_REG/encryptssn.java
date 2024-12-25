package CUST_REG;

	import static io.restassured.RestAssured.given;
	import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

import customer.signin;
//import Qfund11.APIServices.LoginService;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;

	
	public class encryptssn extends signin{
		
	/*	public Response encryptssn(String payload,String encrypturl) throws Exception{		
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
		
		
		public void encrypt_validate(ExtentTest test,Response res,int row,String StepDetails,String ExpectedResponse,String NodeValidation,String ExpectedNodeResponse) 	 
		{		
			if(res.statusCode()==200)
			{		
				String ActualResponse = res.asString();
				System.out.println(ActualResponse);
				test.log(LogStatus.INFO, "ExpectedResponse is: "+ExpectedResponse);
				test.log(LogStatus.INFO, "ActualResponse is: "+ActualResponse);
				test.log(LogStatus.INFO, "ExpectedNodeResponse is: "+ExpectedNodeResponse);			
				JsonPath newData = res.jsonPath();
				String message = newData.get(NodeValidation);	
				               
				test.log(LogStatus.INFO, "ActualResponse message description: "+message);
				if(message.replaceAll("(<br>)*$","").trim().equals(ExpectedNodeResponse.trim()))
				{
					test.log(LogStatus.PASS, "<FONT color=green> <b style='text-transform:uppercase;font-weight:bold'> "+StepDetails +" Scenario is Pass</b></n>Actual Node Message is Equal to Expected Node Message");
				}
				else
				{
					test.log(LogStatus.FAIL, "<FONT color=red> <b style='text-transform:uppercase;font-weight:bold'> "+StepDetails +" Scenario is Fail</b></n>Actual Node Message is not equal to Expected Node Message");
				}
			}
			else
			{
				if(StepDetails.equals("With Empty test data")||StepDetails.equals("with test data will null")||StepDetails.equals("Enter valid userpwd & invalid  locnbr")||StepDetails.equals("Enter valid remoteIp & invalid logintype")||StepDetails.equals("Enter valid logintype with empty"))
				{
					if(res.statusCode()==400)
					{
					test.log(LogStatus.PASS, "<FONT color=green> <b style='text-transform:uppercase;font-weight:bold'> "+StepDetails +" Scenario is Pass</b>");
					}
					else
					{
						test.log(LogStatus.FAIL, "<FONT color=red> <b style='text-transform:uppercase;font-weight:bold'>SIGIN FAIL DUE TO STATUS CODE</b>"+res.statusCode());
					}																
			    }
				else
				{
					test.log(LogStatus.FAIL, "<FONT color=red> <b style='text-transform:uppercase;font-weight:bold'>SIGIN FAIL DUE TO STATUS CODE</b>"+res.statusCode());
				}

			}}*/
		
		public Response encryptssn(String payload,String encrypturl) throws Exception{		
			test.log(LogStatus.INFO, "<FONT color=green style=Arial> ********Performing  API  To Encrypt Password********");
			test.log(LogStatus.INFO, "URL is "+encrypturl);
			test.log(LogStatus.INFO, "Request provided in BODY "+payload);
			System.out.println(payload);
		
			signin s=new signin();
	
		
			System.out.println("--------->"+usssn);
			HashMap data =new HashMap();
			
			data.put("value", usssn);
			Response res=given().filter(filter).
					     relaxedHTTPSValidation().
					     header("Content-type", "application/json").
					     header("TIMEZONE_OFFSET",new Date().getTime()).
					     body(data). 
					     when().
					     post(encrypturl).
					     then().
					     extract().response();
			
			JsonPath newData = res.jsonPath();
			Encryptedssn = newData.get("value");
			System.out.println(Encryptedssn);          
			return res;
		
		}
	
	
	
	}
	




	
	

