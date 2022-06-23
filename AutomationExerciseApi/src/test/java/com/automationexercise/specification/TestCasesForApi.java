package com.automationexercise.specification;


import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import io.restassured.response.Response;

public class TestCasesForApi 
{

RequestSpecification spec=new RequestSpecification();
 Response response;
 String responseCode ;
 String msg;
 /*
  * Create User Account
  */
@Test(priority=0,dataProviderClass=DataProviders.class,dataProvider="getFormParamsMap")
public void createAccount(Map<String,Object> formParams)
{
  
  response= spec.postRequestWithFormParam(formParams);
			response
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.and()
			.statusLine("HTTP/1.1 200 OK")
			.and()
			.header("content-type", "text/html; charset=utf-8");

    responseCode = response.jsonPath().getString("responseCode");
    msg = response.jsonPath().getString("message");
   Assert.assertEquals(responseCode, "201");
   Assert.assertEquals(msg, "User created!");
   Reporter.log("Account Created Successfully");
}
/*
 * Update User Account details
 */
@Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="getUpdateFormParamsMap")
public void updateAccount(Map<String,Object> formParams)
{
	response= spec.putRequestWithFormParam(formParams);
			response
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.and()
			.statusLine("HTTP/1.1 200 OK")
			.and()
			.header("content-type", "text/html; charset=utf-8");
		
	 responseCode = response.jsonPath().getString("responseCode");
	 msg = response.jsonPath().getString("message");
	 Assert.assertEquals(responseCode, "200");
	 Assert.assertEquals(msg, "User updated!"); 
	 Reporter.log("Account Updated Successfully");
}
/*
 * Delete User Account
 */
@Test(priority=2,dataProviderClass=DataProviders.class,dataProvider="getdeleteFormParamsMap")
public void deleteAccount(Map<String,Object> formParams)
{
	response= spec.deleteRequestWithFormParam(formParams);
			response
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.and()
			.statusLine("HTTP/1.1 200 OK")
			.and()
			.header("content-type", "text/html; charset=utf-8");
		
	 responseCode = response.jsonPath().getString("responseCode");
	 msg = response.jsonPath().getString("message");
	 Assert.assertEquals(responseCode, "200");
	 Assert.assertEquals(msg, "Account deleted!"); 
	 Reporter.log("Account Deleted Successfully");
}
}