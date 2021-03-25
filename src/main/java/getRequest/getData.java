package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class getData {
	
	@Test
	public void testResponsecode()
	{
	
		int code=get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=3fb2d055f59375c5983953ca54a7b406").getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);
	}
		
	@Test
	public void testbody()
	{
	
		
		long time=get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=3fb2d055f59375c5983953ca54a7b406").getTime();
		System.out.println("Response time "+time);
		
		
	

	
	}
	

}
