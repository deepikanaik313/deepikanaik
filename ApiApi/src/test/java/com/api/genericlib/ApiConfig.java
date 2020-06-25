package com.api.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiConfig 
{
  public String[] keyValuePairArray;
  public String getApiTestData(String apiTestName) throws IOException
  {
	FileInputStream fis = new FileInputStream("./src/test/resources/ApiList.properties") ;
	Properties pobj = new Properties(); 
	pobj.load(fis);
	String apidata = pobj.getProperty(apiTestName);
	return apidata;
  }
  public Response executeRequest(String apidata)
  {
	Response resp =null;
	String[] apiDataArray = apidata.split(";");
	
	if(apiDataArray[0].equals("get"))
	{
	  resp = given().
			  queryParam("userID","12").
			  when().
			  get(apiDataArray[1]);
	}
	else if(apiDataArray[0].equals("post"))
	{
	 String jsonObj = createJsonObject(apiDataArray[2]);	
	 resp = given().
			 body(jsonObj).
			 contentType(ContentType.JSON).
			 when().
			 post(apiDataArray[1]);
	}
	else if(apiDataArray[0].equals("put"))
	{
		String jsonObj = createJsonObject(apiDataArray[2]);	
		 resp = given().
				 body(jsonObj).
				 contentType(ContentType.JSON).
				 when().
				 put(apiDataArray[1]);
	}
	else if(apiDataArray[0].equals("patch"))
	{
		String jsonObj = createJsonObject(apiDataArray[2]);	
		 resp = given().
				 body(jsonObj).
				 contentType(ContentType.JSON).
				 when().
				 patch(apiDataArray[1]);
		
	}
	else if(apiDataArray[0].equals("delete"))
	{
		resp = given().
				when().
				post(apiDataArray[1]);
		
	}
	return resp;
  }
  
  public String createJsonObject(String jsonData)
  { 
	  JSONObject jobj = new JSONObject();
	  String[] jsondataArray = jsonData.split(",");
	  
	  for(int i=0;i<jsondataArray.length;i++)
	  {
	   keyValuePairArray = jsondataArray[i].split(":");
	      jobj.put(keyValuePairArray[0], keyValuePairArray[1]);
	  }
	  return jobj.toJSONString();
  }
}

    





























