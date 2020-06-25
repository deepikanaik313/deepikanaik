package practiceRestAssured;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllCapitals
{ 
  @Test	
  public void fetchAllCountry()
  {
	Response resp = RestAssured.get("https://restcountries.eu/rest/v2/all");
	System.out.println("Fetching Capitals Of All Countries  In A List--------");
	
	//Object listcapital = resp.jsonPath().get("capital");
	ArrayList<Object> listCapital=resp.jsonPath().get("capital");
	System.out.println(listCapital);
	
	System.out.println("Fetching Capitals Of All Countries One by one--------");
	
	Iterator<Object> it= listCapital.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	
	System.out.println("Fetching Specific Capital By Index--------------");
	
	Object obj = resp.jsonPath().get("capital[0]");
	System.out.println(obj);
	
	System.out.println("Total Capitals Are:"+listCapital.size());
	
  }
}
