package practiceRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BasicChallenging_Authentication
{
	@Test
	  public void checkAuth()
	  {
	  Response resp= given().auth().basic("ToolsQA", "TestPassword").get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
	  resp.then().log().all();
      }
}
