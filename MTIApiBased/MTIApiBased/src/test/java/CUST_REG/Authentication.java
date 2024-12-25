package CUST_REG;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import customer.signin;

import static io.restassured.RestAssured.given;

import io.restassured.filter.cookie.CookieFilter;
import io.restassured.response.Response;

public class Authentication extends signin {
	public Response authentication(ExtentTest test, int row, String payload, String baseuri, CookieFilter filter)
			throws Exception {

		String method = new Exception().getStackTrace()[0].getMethodName();
		test.log(LogStatus.INFO, "<FONT color=green style=Arial> ********Performing  API ********" + method);
		test.log(LogStatus.INFO, "End Pont URL is " + baseuri + method);
		test.log(LogStatus.INFO, "Request provided in BODY " + payload);
		System.out.println("0--------------->");
		System.out.println(baseuri + method);
		System.out.println("REQUEST");
		System.out.println("######--------------->" + payload);
		System.out.println("RESPONSE");
		Response res = given().filter(filter).relaxedHTTPSValidation().header("Content-type", "application/json")
				.header("TIMEZONE_OFFSET", new Date().getTime()).body(payload).when().post(baseuri + method).then()
				.extract().response();
		XUSEDETAILS = res.header("X-USER-DETAILS");
		int s1 = res.statusCode();
		// System.out.println(s1+"Response is "+res.asString());
		System.out.println(XUSEDETAILS);
		test.log(LogStatus.PASS, "BearerToken Captured is : " + res.header("bt"));
		RefreshToken = res.header("rt");
		int s2 = res.statusCode();
		// System.out.println(s2+"Response is "+res.asString());
		System.out.println(RefreshToken);
		test.log(LogStatus.PASS, "RefreshToken Captured is : " + res.header("rt"));
		test.log(LogStatus.INFO, "API Request Hit Completed and Resluted with response status as " + res.statusCode());
		return res;
	}
}
