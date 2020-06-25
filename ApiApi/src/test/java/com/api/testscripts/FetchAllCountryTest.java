package com.api.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericlib.BaseClass;

import io.restassured.response.Response;

public class FetchAllCountryTest extends BaseClass
{
	@Test
   public void checkAllCountries() throws IOException
   {
        String apiTestData = config.getApiTestData("FetchAllCountry");
		
		Response resp = config.executeRequest(apiTestData);
		
		resp.then().log().all(); 
   }
}
