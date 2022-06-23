package com.automationexercise.specification;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;
import com.github.javafaker.Faker;


public class DataProviders {

	static Faker faker = new Faker();
	static String fname= faker.name().firstName();
	static String lname=faker.name().lastName();
	static String pwd="testuser";
	static String mail=fname+faker.number().randomDigit()+"@gmail.com";
	@DataProvider
	public static Object[][] getFormParamsMap() {
		Map<String,Object> formParams = new HashMap<String,Object>();
		   
		    formParams.put("name", fname);
		    formParams.put("email", mail);
		    formParams.put("password", pwd);
		    formParams.put("title","Mrs");
		    formParams.put("firstname",fname );
		    formParams.put("lastname",lname);
		    formParams.put("company","abc" );
		    formParams.put("address1",faker.address().streetAddress() );
		    formParams.put("address2", faker.address().streetName());
		    formParams.put("country",faker.address().country() );
		    formParams.put("zipcode",faker.address().zipCode() );
		    formParams.put("state",faker.address().state());
		    formParams.put("city",faker.address().cityName() );
		    formParams.put("mobile_number",faker.phoneNumber().cellPhone() );
		    formParams.put("birth_date",faker.number().digits(1));
		    formParams.put("birth_month",faker.number().digits(1) );
		    formParams.put("birth_year",faker.number().digits(4));
		    return new Object[][] {{formParams},
			};
		}
	
	@DataProvider
	public Object[][]  getUpdateFormParamsMap() {
		  Map<String, Object> formParams = new HashMap<String, Object>();		   
		    formParams.put("name", fname);
		    formParams.put("email",mail );
		    formParams.put("password", pwd);
		    formParams.put("title","Mrs");
		    formParams.put("firstname",fname );
		    formParams.put("lastname",lname );
		    formParams.put("company","abc" );
		    formParams.put("address1",faker.address().streetAddress() );
		    formParams.put("address2", faker.address().streetName());
		    formParams.put("country",faker.address().country() );
		    formParams.put("zipcode",faker.address().zipCode() );
		    formParams.put("state",faker.address().state());
		    formParams.put("city",faker.address().cityName() );
		    formParams.put("mobile_number",faker.phoneNumber().cellPhone() );
		    formParams.put("birth_date",faker.number().digits(1));
		    formParams.put("birth_month",faker.number().digits(1) );
		    formParams.put("birth_year",faker.number().digits(4));
		    return new Object[][] {{formParams}};
		}
	@DataProvider
	public Object[][] getdeleteFormParamsMap() {
		  Map<String, Object> formParams = new HashMap<String, Object>();		   		 
		    formParams.put("email",mail );
		    formParams.put("password", pwd);		   
		    return new Object[][] {{formParams}};
		}
	
}
