package practiceRestAssured;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllCurrencies 
{    
	@Test
	 public void fetchAllCountry()
	  {
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
		System.out.println("Fetching Currencies Of All Currencies---------");
		
		
		//Object listCurrencies = resp.jsonPath().get("capital");
		ArrayList<Object> listCurrencies=resp.jsonPath().get("currencies");
		System.out.println(listCurrencies);
		
		System.out.println("Fetching Currencies Of All Countries One by one--------");
		
		Iterator<Object> it= listCurrencies.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println("Fetching Specific Currency By Index--------------");
		
		Object obj = resp.jsonPath().get("currencies[0]");
		System.out.println(obj);
		
		System.out.println("Total Currencies Are:"+listCurrencies.size());
     }
}
