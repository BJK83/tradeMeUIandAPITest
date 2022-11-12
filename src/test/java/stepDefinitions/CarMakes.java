package stepDefinitions;


import jSONDeserialize.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import resources.APIEndPoints;
import static org.junit.Assert.assertEquals;

public class CarMakes {
	
//	ObjectMapper objectMapper = new ObjectMapper(); objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
	RequestSpecification reqSpec;
	Category response;
	
	@Given("I have basePath {string}")
	public void i_have_base_path(String basePath) {

		reqBuilder.setBaseUri(APIEndPoints.valueOf("baseURI").getResource())
		.setBasePath(APIEndPoints.valueOf(basePath).getResource()).setContentType("application/json");
		reqSpec = reqBuilder.build();
	
	}

	@When("I execute Get request")
	public void i_execute_get_request() {

		response = RestAssured.given(reqSpec).get().then().extract().as(Category.class);	
	
	}
	
	@Then("I verify the count of named cars in response to be {string}")
	public void i_verify_the_count_of_named_cars_in_response_to_be(String expectedNamedCars) {
		
		System.out.println("The response count recieved is :"+response.getSubcategories().size());
		assertEquals(response.getSubcategories().size(), Integer.parseInt(expectedNamedCars));
	}

}
