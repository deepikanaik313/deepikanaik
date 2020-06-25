package com.api.genericlib;

import java.util.ArrayList;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
 
/**
 * @author Deepika
 *
 *{@code} This is Useful For All Common Scenarios For RestApi
 *
 *@since 2020
 */
public class RestAssuredCommonUtils
{
	
  public void validateStatusCode(Response resp , int expectedStatusCode)
  {
	resp.then().assertThat().statusCode(expectedStatusCode);  
  }
  
  public void validateContentType(Response resp)
  {
	  resp.then().assertThat().contentType(ContentType.JSON);  
  }
  
  public void validateResponseTime(Response resp , long rangeofWithInTime )
  {
	resp.then().assertThat().time(Matchers.lessThan(rangeofWithInTime));
  }
  
  public void validateKVPair(Response resp , String jsonpath ,String expectedValue)
  {
	  Object obj = resp.jsonPath().get(jsonpath);
	  String actualValue = obj.toString();
	  Assert.assertEquals(actualValue, expectedValue);
  }
  
  public ArrayList<String> conertObjectList_To_StringList(ArrayList<Object> list)
  {
	  ArrayList<String> s = new  ArrayList<String>();
	  for(Object obj : list)
	  {
		  String s1 = obj.toString();
		  s.add(s1);
	  }
	  return s;
  }
  
  public String fetchTokenID(Response resp , String jsonPath)
  {
	Object objtoken = resp.jsonPath().get(jsonPath);
	return objtoken.toString();
  }
  
   
}
