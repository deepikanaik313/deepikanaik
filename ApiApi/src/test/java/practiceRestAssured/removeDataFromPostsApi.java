package practiceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class removeDataFromPostsApi
{ 
  @Test	
  public void removeData()
  {
	 Response resp = RestAssured.delete("http://localhost:3000/posts/7"); 
	 ValidatableResponse vr = resp.then();
	 vr.log().all();
//   resp.then().log().all();
	 
  }
 	
}
