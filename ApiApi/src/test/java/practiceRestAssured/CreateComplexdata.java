package practiceRestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateComplexdata
{ 
  @Test	
  public void addComplexData()
  {
	 RequestSpecification req = RestAssured.given();  
	
	 JSONObject jobj1 = new JSONObject();
	 jobj1.put("Java", "Very Good");
	 jobj1.put("Selenium", "Good");
	 jobj1.put("Manual", "Average");
	 
	 
	 JSONObject jobj2 = new JSONObject();
	 jobj2.put("Name", "Guddu");
	 jobj2.put("Id", 143);
	 jobj2.put("Skills",jobj1);
	 
	 
	 JSONObject jobj3 = new JSONObject();
	 jobj3.put("Employee",jobj2);
	 
	 String jsondata= jobj3.toJSONString();
	 req.body(jsondata);
	 req.contentType(ContentType.JSON);
	 RequestSpecification sender = req.when();
	 Response resp = sender.post("http://localhost:3000/posts");
	 resp.then().log().all();
	 
	 
	
  }
}
