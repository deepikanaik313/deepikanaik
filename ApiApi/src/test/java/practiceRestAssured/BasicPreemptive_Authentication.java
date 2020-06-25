package practiceRestAssured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BasicPreemptive_Authentication
{
	@Test
  public void checkAuth()
  {
  Response resp= given().auth().preemptive().basic("ToolsQA", "TestPassword").get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
  resp.then().log().all();
  }
}
