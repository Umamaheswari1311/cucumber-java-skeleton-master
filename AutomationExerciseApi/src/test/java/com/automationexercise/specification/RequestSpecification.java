package com.automationexercise.specification;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestSpecification extends TestBase implements EndPoints{

Response response;
	
 public Response postRequestWithFormParam(Map<String,Object> formParams ) {
        response =RestAssured.given()
				.baseUri(prop.getProperty("base_Url"))
				.basePath(CREATE_ACCOUNT)
				.header("content-type", "application/x-www-form-urlencoded")
				.formParams(formParams)
				.when()
				.post();		
		return response;
	}
 public Response putRequestWithFormParam(Map<String,Object> formParams ) {
     response =RestAssured.given()
				.baseUri(prop.getProperty("base_Url"))
				.basePath(UPDATE_ACCOUNT)
				.header("content-type", "application/x-www-form-urlencoded")
				.formParams(formParams)
				.when()
				.put();		
		return response;
	}
 public Response deleteRequestWithFormParam(Map<String,Object> formParams ) {
     response =RestAssured.given()
				.baseUri(prop.getProperty("base_Url"))
				.basePath(DELETE_ACCOUNT)
				.header("content-type", "application/x-www-form-urlencoded")
				.formParams(formParams)
				.when()
				.delete();	
		return response;
	}
}
