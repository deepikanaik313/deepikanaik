package com.api.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericlib.BaseClass;

import io.restassured.response.Response;

public class FetchAllPostsTest extends BaseClass
{
	@Test
   public void checkFetchAllPosts() throws IOException  
   {
		
		
		String apiTestData = config.getApiTestData("fetchallposts");
		
		Response resp = config.executeRequest(apiTestData);
		
		resp.then().log().all(); 
   }
} 
