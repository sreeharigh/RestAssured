package com.apitesting.TestAPI;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class TestWeatherAPI {
  @Test(priority=0)
  public void getWeatherInfoOfBangloreWithValidData() {
	  RestAssured.baseURI="http://api.openweathermap.org/data/2.5.weather";
	  //give parameters and add response to object
		String response = RestAssured.given().param("q", "Bangalore").param("appid", "4881452402385466eefb9820314b5504" ).
		when().get().then().extract().asString();
		System.out.println("Response is " + response);
		Reporter.log("Response is " + response, true);
		ValidatableResponse res = RestAssured.given().param("q", "Bangalore").param("appid", "4881452402385466eefb9820314b5504" ).
		when().get().then();
		
		res.statusCode(200);
		Reporter.log("verified status code sucessfully " + response , true);
		res.contentType(ContentType.JSON);
		// parse the Json object 
		Object countryName = res.extract().response().path("sys.country");
		System.out.println("Country Name " + countryName);
		//Create Json Object and pass response
		JsonPath path = new JsonPath(response);
		Object countryNm = path.get("sys.country");
		System.out.println("country Name" + countryNm );
		
		res.body("sys.country", Matchers.notNullValue());
		res.body("sys.country", Matchers.equalToIgnoringCase("IN"));
		Reporter.log("Country code verified sucessfully " , true);
		
		res.body("name", Matchers.notNullValue());
		res.body("name", Matchers.equalToIgnoringCase("Banglore"));
		Reporter.log("Country code verified sucessfully " , true);
  }
		
		 @Test
		  public void getWeatherInfoOfBangloreWithValidData1() {
			 ValidatableResponse res = RestAssured.given().param("q", "Bangalore").param("appid", "4881452402385466eefb9820314b5504" ).
						when().get().then();
			 Reporter.log("Response is : "+res.extract().asString(),true);
			 res.statusCode(404);
			 res.body("message", Matchers.notNullValue());
			 res.body("message", Matchers.equalToIgnoringCase("city not found"));
			 Reporter.log("Verified error message sucessfully " , true);
  }
		 
		 @Test
		  public void getWeatherInfoOfDelhiWithValidData() {
			 ValidatableResponse res = RestAssured.given().param("q", "Delhi")
					 .param("appid", "17e5c69afcefof16365a6c3b0cba4400" ).
						when().get().then();
			// RestAssured.given().auth().preemptive().basic("username", "password" ).param("grant_type", "password");
					 
			 
			 Header first = new Header ("Authorization", "access Token key");
			 Header second = new Header ("X-Remote-User", "userName");
			 Header third = new Header ("Content-type", "application/json");
			 Headers headers = new Headers (first, second, third);
			 
			// RestAssured.given().headers(headers).parm(arg0, arg1)
			 Reporter.log("Response is : "+res.extract().asString(),true);
			 res.statusCode(200);
			 Reporter.log("Verified the status code sucessfully", true);
			 res.contentType(ContentType.JSON);
			 res.body("sys.country", Matchers.notNullValue());
				res.body("sys.country", Matchers.equalToIgnoringCase("IN"));
				Reporter.log("Country code verified sucessfully " , true);
				
				res.body("name", Matchers.notNullValue());
				res.body("name", Matchers.equalToIgnoringCase("Delhi"));
				Reporter.log("Country code verified sucessfully " , true);
		 }
}
