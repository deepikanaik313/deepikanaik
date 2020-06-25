package practiceRestAssured;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CheckJsonPath 
{
 @Test	
 public void fetchParticularData()
 {
	Response resp= RestAssured.get("http://localhost:3000/posts/9"); 
	resp.prettyPrint();
	
	System.out.println("Fetch The rating Of Selenium");
	Object obj1 = resp.jsonPath().get("Employee.Skills.Selenium");
	System.out.println("Selenium Rating Is :"+obj1);
	
	System.out.println("Fetch The rating Of Manual");
	Object obj2 = resp.jsonPath().get("Employee.Skills.Manual");
	System.out.println("Manual Rating Is :"+obj2);
	
	System.out.println("Fetch The Name Of Employee");
	Object obj3 = resp.jsonPath().get("Employee.Name");
	System.out.println("Name Of Employee Is :"+obj3);
	
	System.out.println("Fetch All Skills");
	Object obj4 = resp.jsonPath().get("Employee.Skills");
	System.out.println("All Skills Are :"+obj4);
	
	System.out.println("Fetch All Skills");
	HashMap<Object,Object> obj5=resp.jsonPath().get("Employee.Skills");
	System.out.println("All Skills Are :"+obj5);

	
	
	
 }
}
