package practiceRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllCountries
{  
   @Test
   public void fetchAllCountry()
   {
	  Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");  
	 // resp.then().log().all();    here we will get header with body as output
	  
	  resp.prettyPrint();        // here we will get only body as output
   }
}
