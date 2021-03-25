package oAuth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class oAuth2 
{

	@Test
	public void accessValidAPI()
	{
		//Response resp=RestAssured.given().auth().oauth2("2f25ba5c8d256b822db7ab86108fd8c930a91299").post("http://coop.apps.symfonycasts.com/api/1766/eggs-collect");
		//System.out.println("Code "+resp.getStatusCode());
		//System.out.println("Code "+resp.getBody().asString());
		
		Response resp=RestAssured.given().formParam("client_id","JoydeepApp")
		.formParam("client_secret", "891ef46f2166029f3510484b8e0354b3")
		.formParams("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		//System.out.println(resp.jsonPath().prettify());
		
		String token=resp.jsonPath().get("access_token");
		
		Response resp1=RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1766/eggs-collect");
		Assert.assertEquals(resp1.getStatusCode(), 200);
	
	}

	@Test
	public void accessInValidAPI()
	{
		
		Response resp=RestAssured.given().formParam("client_id","JoydeepApp")
		.formParam("client_secret", "891ef46f2166029f3510484b8e0354b3")
		.formParams("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
				
		String token=resp.jsonPath().get("access_token");
		
		Response resp1=RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1766/chickens-feed");
		
		//System.out.println("Code "+resp1.getStatusCode());
		
		//System.out.println("Code "+resp.getBody().asString());
		
		Assert.assertEquals(resp1.getStatusCode(), 401);
	
	}
	
}
