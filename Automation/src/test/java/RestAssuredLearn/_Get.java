package RestAssuredLearn;

import org.testng.Assert;
import org.testng.annotations.Test;

/*import io.restassured.RestAssured;
import io.restassured.response.Response;*/

import static io.restassured.RestAssured.*;
//No need to write RestAssured.get(); just write get();
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class _Get {
	String url = "https://reqres.in/api/users?page=2";
	
	//Response resp = get(url);
	/*
	 * @Test public void new1() {
	 * //RestAssured.get("https://reqres.in/api/users?page=2");
	 * 
	 * System.out.println(resp.getStatusCode()+"\n");
	 * System.out.println(resp.getBody().asPrettyString());
	 * 
	 * 
	 * }
	 * 
	 * @Test public void new2() { int statusCode = resp.getStatusCode();
	 * Assert.assertEquals(statusCode, 404); }
	 */
	
  @Test
  public void new3() {
	  given()
	  	.get("https://reqres.in/api/users?page=2")
	  .then()
	  	.statusCode(200);
  }
  
  @Test
  public void new4() {
	  given()
	  .queryParam("page", "2")
	  .when()	
	  	.get("https://reqres.in/api/users")
	  .then()
	  	.statusCode(200)
	  	.log();
  }
  
  
  @Test
  public void new5() {
	  baseURI = "https://reqres.in/api";
	  given()
	  	.get("/users?page=2")
	  .then()
	  	.statusCode(200)
	  	.and()
	  	.log().all();
  }
  
  @Test
  public void new6() {
	  baseURI = "https://reqres.in/api";
	  given()
	  	.get("/users?page=2")
	  .then()
	  	.statusCode(200)
	  	.body("data[4].first_name", equalTo("George"))
	  	.and()
	  	.log().all();
  }

}
