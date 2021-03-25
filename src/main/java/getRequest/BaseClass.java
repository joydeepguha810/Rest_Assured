package getRequest;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass 
{

	@BeforeClass
	public void setup()
	{
		RestAssured.authentication=RestAssured.preemptive().basic("postman", "password");
		
		RestAssured.baseURI="https://postman-echo.com/digest-auth/";
		
	}
	
}
