package com.automationexercise.specification;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.github.javafaker.Faker;

public class TestBase 
{
	public static Properties prop;
	public TestBase(){
	try {
		prop = new Properties();
		FileReader reader=new FileReader("config.properties");
		prop.load(reader);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
    }
	
	
}
