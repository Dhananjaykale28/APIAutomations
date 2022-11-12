package crudPkg;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD {
	
	String creatPayLoad = " {\n"
							+ " \"id\": \"50\",\n"
							+ "\"name\": \"Chris\",\n"
							+ "\"email\": \"mark.dhananjay@auscrickinfo.com\",\n"
							+ "\"phone\": \"+17322541987\"\n"
							+ "}";
	
	String updatePayLoad =  " {\n"
							+ " \"id\": \"50\",\n"
							+ "\"name\": \"Chris Gayle\",\n"
							+ "\"email\": \"mark.dhananjay@auscrickinfo.com\",\n"
							+ "\"phone\": \"+17322541987\"\n"
							+ "}";
	
	//@Test(priority = 1, description = "This Test is verify Virat is already exist")
	public void verfifyPlayerExist() {
		RequestSpecification reqSpec = new RequestSpecBuilder().build();
		reqSpec.baseUri("http://www.knowledgeware.in:9091/RestTutorial");
		reqSpec.basePath("/employee");
		
		RestAssured.given()
			.spec(reqSpec)
			.when()
			.get("/50")
			.then()
			.statusCode(200)
			.body("", Matchers.hasSize(0));//Matchers is class which will you to match to any of the size of the body
		
	}
	
	//@Test(priority = 2 , description = "This test is to create a New Player")
	public void createNewPlayer() {
		
		RestAssured.baseURI ="http://www.knowledgeware.in:9091/RestTutorial/employee";
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.contentType(ContentType.JSON)
			   .body(creatPayLoad)
			   .post("/signup")
			   .then()
			   .statusCode(200);
	}
	
	//@Test(priority = 3, description = "This Test to verity is created or not")
	public void verifyPlayerCreated() {
		
		RequestSpecification reqSpec = new RequestSpecBuilder().build();
		reqSpec.baseUri("http://www.knowledgeware.in:9091/RestTutorial");
		reqSpec.basePath("/employee");
		
		RestAssured.given()
				   .spec(reqSpec)
				   .when()
				   .get("/50")
				   .then()
				   .statusCode(200)
				   .body(CoreMatchers.containsString("Chris"));
	}
	
	//@Test(priority = 4, description = "This test to update newly created player")
	public void updateNewPlayer() {
		RestAssured.baseURI ="http://www.knowledgeware.in:9091/RestTutorial/employee";
		
		Response responce =   RestAssured.given()
				   .header("Content-Type","application/json")
				   .and()
				   .body(updatePayLoad)
				   .when()
				   .put("/50")
				   .then()
				   .extract()
				   .response();
		Assert.assertEquals(responce.statusCode(), 200);
		
	}
	//@Test(priority = 5, description = "This Test to verify Virat is updated or Not")
	public void verifyPlayerUpdate() {
		RequestSpecification reqSpec = new RequestSpecBuilder().build();
		
		reqSpec.baseUri("http://www.knowledgeware.in:9091/RestTutorial");
		reqSpec.basePath("/employee");
		
		RestAssured.given()
				   .spec(reqSpec)
				   .when()
				   .get("/50")
				   .then()
				   .statusCode(200)
				   .body(CoreMatchers.containsString("Chris Gayle"));
		
		
	}
	//@Test(priority = 6, description = "This test to delete newly created player")
	public void deletePlayer() {
		
		RestAssured.baseURI = "http://www.knowledgeware.in:9091/RestTutoria/employee";
		Response  response = RestAssured.given()
				.header("Content-TYpe","application/json")
				.when()
				.delete("/50")
				.then()
				.extract()
				.response();
		Assert .assertEquals(response.statusCode(),200);
	}
	@Test(priority = 7, description = "This Test to verity Chris is deleted")
	public void verifyPlayerDeleted() {
		RequestSpecification reqSpec = new RequestSpecBuilder().build();
		reqSpec.baseUri("http://www.knowledgeware.in:9091/RestTutorial");
		reqSpec.basePath("/employee");
		
		RestAssured.given()
			.spec(reqSpec)
			.when()
			.get("/50")
			.then()
			.statusCode(200)
			.body("", Matchers.hasSize(0));//Matchers is class which will you to match to any of the size of the body
		
	
	}
	
}
