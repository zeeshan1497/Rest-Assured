package RestAssuredLearn;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class _Delete {

	@BeforeMethod
	public void beforeMethod() {
		baseURI = "https://reqres.in/api";
		
	}
	
	@Test
	public void delete() {
		
		when()
			.delete("/users/2")
		.then()
			.statusCode(204)
			.log().all();
			
	}
}
