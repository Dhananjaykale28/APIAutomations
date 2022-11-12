package apiAutoPkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIAutomation {

	/*public static void main(String[] args) {
		//RestAssured is class, which will help you to build restful web service
		RestAssured.baseURI = "http://www.knowledgeware.in:9091/RestTutorial";

		//It is an interface which will help you sent request to your server
		RequestSpecification reSpec = RestAssured.given();

		//I want to Hit the request of your choice of method
		Response response = reSpec.get("/employee/51");

		//Print Response code
		System.out.println(response.getStatusCode());

		//Print complete response received from server
		ResponseBody body =  response.getBody();
		System.out.println(body.asString());
		String respBody = body.asString();
		if(respBody.contains("Suryakumar Yadhav")) {
			System.out.println("Yes Surya is there");
		}

	}*/
	@Test
	public void verifyPlayerIsAvailable() {
		//RestAssured is class, which will help you to build restful web service
		RestAssured.baseURI = "http://www.knowledgeware.in:9091/RestTutorial";

		//It is an interface which will help you sent request to your server
		RequestSpecification reSpec = RestAssured.given();

		//I want to Hit the request of your choice of method
		Response response = reSpec.get("/employee/51");

		//Print Response code
		System.out.println(response.getStatusCode());

		//Print complete response received from server
		ResponseBody body =  response.getBody();
		System.out.println(body.asString());
		String respBody = body.asString();
		if(respBody.contains("Suryakumar Yadhav")) {
			System.out.println("Yes Surya is there");
		}
	}
	@Test(description = "This test is to validate responce code")
	public void validateStatusCode() {
		RestAssured.baseURI = "http://www.knowledgeware.in:9091/RestTutorial";

		//It is an interface which will help you sent request to your server
		RequestSpecification reSpec = RestAssured.given();

		//I want to Hit the request of your choice of method
		Response response = reSpec.get("/employee");

		//Print Response code
		Assert.assertEquals(200,response.getStatusCode());

	}
	@Test
	public void validatePlayerName() {
		//RestAssured is class, which will help you to build restful web service
		RestAssured.baseURI = "http://www.knowledgeware.in:9091/RestTutorial";

		//It is an interface which will help you sent request to your server
		RequestSpecification reSpec = RestAssured.given();

		//I want to Hit the request of your choice of method
		Response response = reSpec.get("/employee/51");

		//Print Response code
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		String  respBody = body.asString();
		Assert.assertEquals(respBody.contains("Suryakumar Yadhav"), true);

	}

	@Test
	public void validateResponse() {
		RequestSpecification reqSpec = new RequestSpecBuilder().build();
		reqSpec.baseUri("http://www.knowledgeware.in:9091/RestTutorial");
		reqSpec.basePath("/employee");
		RestAssured.given()
		.spec(reqSpec)
		.when()
		.get("/51")
		.then()
		.statusCode(200);
	}

	@Test
	public void getRsponseInJson() {
		RestAssured.baseURI = "http://www.knowledgeware.in:9091/RestTutorial";

		RequestSpecification reSpec = RestAssured.given();

		Response response = reSpec.get("/employee/51");

		JsonPath jpath = response.jsonPath();

		String val = (jpath.get("x.instructions[0][7].name")); 

		//String val = jpath.get("name");
		System.out.println(val);






	}

}

/*
 * BDD - Behavior Driven Development
 * 
 * Who knows the behavior of your application ?
 * Ans - Business Analyst and Product Owner are know the complete
 * 		 behavior of your application. These are non technical people 
 * 
 * BDD concept works on GWT 
 * 
 * G - Given (Pre-requisites)
 * W - When  (Action)
 * T - Then  (Expected Result)
 * 
 * GWT supports cucumber framework
 * Cucumber FrameWork Supports GWT concept of BDD
 * 
 * Cucumber support Gerkin language
 * 
 * What is gerkin language ?
 * It is called Plane English Language, means
 * Anyone who is known to English can write their features
 * 
 * What cucmber supports ?
 * Cucumber supports three different files
 * 
 * #Feature File
 * #Defination File
 * #Test File
 * 
 * What Feature File -- BA/PO/Non Technical Mgr can write feature in
 * 						 Gerkin Language
 * 
 * What is Defination File -- Code on feature in specific language of 
 * 							you choice its supports multiple type of language
 * 
 * What is Test File -- Calling of defination  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */


