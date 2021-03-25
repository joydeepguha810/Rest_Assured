package oAuth;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Twitter 

{

	@Test
	public void postTweet()
	{
		Response resp=RestAssured.given()
		.auth()
		.oauth("WaoKFqTXOMrnJrj5PcL6F9TNo", "3SBBxGfl4sFi6a1wSIluk8KeNyEPhqn5EjUiWE6U8N5fB5Hqq4",
				"3195481723-wILF4DKvMtrSI1NOafwk7d25uD4nmUPSrCelhrd", "9gB3DSs6j1V3x0jO1EXF3ngXzwBBiIJexwBPQvbFAnyrA")
		//.post("https://api.twitter.com/1.1/statuses/update.json?status=This tweet is via API");//
		.post("https://api.twitter.com/1.1/statuses/destroy/1370425517803900929.json");
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		
		JsonPath json=resp.jsonPath();
		String tweetId=json.get("id_str");
		System.out.println("My Tweet Id is "+tweetId);
	}
	
}
