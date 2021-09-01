package RestAssuredLearn;

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



public class _Post {
	
	@BeforeMethod
	public void beforeMethod() {
		baseURI = "https://reqres.in/api";
		
	
	}
  @Test
  public void get1() {
	  basePath = "/users?page=2";
	  given()
	  	.get()
	  .then()
	  	.statusCode(200)
	  	.body("data.first_name", hasItems("George","Charles"));
  }
  
  @Test
  public void postMap() {
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("name", "Ali");
	  map.put("Age", 25);
	  System.out.println(map);
  }
  
  @Test
  public void postJSON() {
	JSONObject request = new JSONObject();
	
	request.put("name", "Zeeshan");
	request.put("job", "SQA Engineer");
	
	//System.out.println(request);
	//System.out.println(request.toJSONString());
	
	given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
	.when()
		.post("/users")
	.then()
		.statusCode(201)
		.and()
		.log().all();
  }
  
  
  

}
