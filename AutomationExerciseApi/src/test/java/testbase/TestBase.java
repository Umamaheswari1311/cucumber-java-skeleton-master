package testbase;

import java.util.HashMap;
import java.util.Map;

import com.github.javafaker.Faker;

public class TestBase {

	Faker faker = new Faker();
	public static String base_Url="https://automationexercise.com/api";
	public static String post_url_Path="/createAccount";
	public static String put_Url_Path="/updateAccount";
	public static String Delet_Url_Path="/deleteAccount";
	String fname= faker.name().firstName();
	String lname=faker.name().lastName();
	String pwd="testuser";
	String mail=fname+faker.number().randomDigit()+"@gmail.com";
	
	public Map<String, String> getFormParamsMap() {
		  Map<String, String> formParams = new HashMap<String, String>();
		   
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
		    return formParams;
		}
	
	public Map<String, String> getUpdateFormParamsMap() {
		  Map<String, String> formParams = new HashMap<String, String>();		   
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
		    return formParams;
		}
	public Map<String, String> getdeleteFormParamsMap() {
		  Map<String, String> formParams = new HashMap<String, String>();		   		 
		    formParams.put("email",mail );
		    formParams.put("password", pwd);		   
		    return formParams;
		}
}
