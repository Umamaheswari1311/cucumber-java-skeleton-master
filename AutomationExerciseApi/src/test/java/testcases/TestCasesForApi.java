package testcases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import testbase.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
public class TestCasesForApi extends TestBase{
	TestBase base=new TestBase();
 Response response;
 String responseCode ;
 String msg;
 /*
  * Create User Account
  */
@Test(priority=0)
public void createAccount()
{

	response= RestAssured
			.given()
			.baseUri(base_Url)
			.basePath(post_url_Path)
			.header("content-type", "application/x-www-form-urlencoded")
			.formParams(base.getFormParamsMap())
			.when()
			.post();

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
}
/*
 * Update User Account details
 */
@Test(priority=1)
public void updateAccount()
{
	response= RestAssured
			.given()
			.baseUri(base_Url)
			.basePath(put_Url_Path)
			.header("content-type", "application/x-www-form-urlencoded")
			.formParams(base.getUpdateFormParamsMap())
			.when()
			.put();
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
}
/*
 * Delete User Account
 */
@Test(priority=2)
public void deleteAccount()
{
	response= RestAssured
			.given()
			.baseUri(base_Url)
			.basePath(Delet_Url_Path)
			.header("content-type", "application/x-www-form-urlencoded")
			.formParams(base.getdeleteFormParamsMap())
			.when()
			.delete();
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
}
}