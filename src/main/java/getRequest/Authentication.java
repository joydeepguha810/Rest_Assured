package getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Authentication extends BaseClass

{
	@Test
	public void test1()
	{
		int code=RestAssured.given()
		.get()
		.getStatusCode();
		
		System.out.println("Response code is "+code);
		
	}
	
}
