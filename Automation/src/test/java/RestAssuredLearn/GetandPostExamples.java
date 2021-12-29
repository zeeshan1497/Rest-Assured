package RestAssuredLearn;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetandPostExamples {
//@Test
	public void testget() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name",equalTo("George")).
		body("data.first_name",hasItems("George","Michael","Byron"));
		
	}
@Test
public void testpost() {
	Map<String,Object> map=new HashMap<String,Object>();
	//map.put("\"name\"","narmeen");
	//map.put("job", "SQa");
	//System.out.println(map);
	JSONObject request= new JSONObject();
	request.put("name","narmeen");
	request.put("job", "SQA");
}
}
