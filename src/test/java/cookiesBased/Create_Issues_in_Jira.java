package cookiesBased;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Issues_in_Jira 
{

	@Test
	public void JsesessionID()
	{
		JSONObject json= new JSONObject();
		json.put("username", "joydeepguha810");
		json.put("password", "babai1234");
		
		
		Response resp=RestAssured.given()
		.header("content-type", "application/json")
		.body(json)
		.post("http://localhost:8080/rest/auth/1/session");
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		String sessionID=resp.getCookies().get("JSESSIONID");
		
		
		Response response=RestAssured.given().contentType(ContentType.JSON)
		.cookie("JSESSIONID",sessionID)
		.body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"JOYD\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"Font size issue\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}")
		.post("http://localhost:8080/rest/api/2/issue/");
		
		System.out.println(response.getBody().jsonPath().prettify());
	}
	
	
}
