package practiceRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AssertionHeadersByTestNG 
{
 @Test	
 public void checkAssertion()
 {
     Response resp = given().when().get("http://localhost:3000/posts");
  
      //Status Code Validation
    int actstatusCode = resp.getStatusCode();
    System.out.println(actstatusCode);
  
   int expstatusCode =200;
   System.out.println(expstatusCode);
 
   Assert.assertEquals(actstatusCode, expstatusCode);
   
   
   resp.then().log().all();
 }
}
