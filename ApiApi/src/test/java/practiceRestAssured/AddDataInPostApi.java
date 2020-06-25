package practiceRestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddDataInPostApi 
{    @Test
	 public void createNewData()
	  {
		RequestSpecification preConditionreq=RestAssured.given();  
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "gu");
		jobj.put("gender", "male");
		
		String jsondata= jobj.toJSONString();
		preConditionreq.body(jsondata);
		
		preConditionreq.contentType(ContentType.JSON);
		
		RequestSpecification sender = preConditionreq.when();
		
		Response resp = sender.put("http://localhost:3000/posts/6");
		
		ValidatableResponse vr = resp.then();
		
		vr.log().all(); 
	  }

	
}
