package practiceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class FetchDataFromPostApi
{
	 @Test
	  public void getDataRequest()
	  {
		 Response resp = RestAssured.get("http://localhost:3000/posts"); 
		 int statusCode = resp.getStatusCode();
		 System.out.println("status code is:"+ statusCode);
		 
		 System.out.println("---------------------");
		 
		 String contentType = resp.getContentType();
		 System.out.println("content type is:"+ contentType);
		 
		 System.out.println("---------------------");
		 
		 long time = resp.getTime();
		 System.out.println("response time is : "+ time);
		 
		 System.out.println("---------------------");
		 
		 String actualContent = resp.asString();
		 System.out.println("Actual content is :"+ actualContent);
		 System.out.println(actualContent);
		 
		 Headers headers = resp.getHeaders();
		 System.out.println("All headers are: \n" +headers);
		 
	  }

}
