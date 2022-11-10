package stepDefinitions;


import jSONDeserialize.*;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DeserializationFeature;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIEndPoints;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CarMakes {
	
//	ObjectMapper objectMapper = new ObjectMapper(); objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	RequestSpecification request;
	Category response;
	int number = 0;
	String dynamicResource = "";
	
	@Given("I have end points")
	public void i_have_end_points() {
	    // Write code here that turns the phrase above into concrete actions

		requestSpecification = new RequestSpecBuilder()
				.setBaseUri(APIEndPoints.valueOf("baseURI").getResource())
				.setContentType("application/json")
				.build();
	
	}

	@When("I execute Get request")
	public void i_execute_get_request() {
	    // Write code here that turns the phrase above into concrete actions

		dynamicResource = APIEndPoints.valueOf("getNamedCars").getResource();

		responseSpecification = new ResponseSpecBuilder().build();

		request = given().spec(requestSpecification);

		
	
	}

	@Then("I have a list of car makes returned")
	public void i_have_a_list_of_car_makes_returned() {
	    // Write code here that turns the phrase above into concrete actions

		final ObjectMapper objectMapper = 
			    new ObjectMapper()
			        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			        
		Category category = request.when().get(dynamicResource).then().spec(responseSpecification).extract().as(Category.class);
		
		System.out.println("Count is: \n");
		System.out.println(category.getSubcategories().size());
		number = category.getSubcategories().size();
		
		
		
	}

	@Then("I verify the count of named cars")
	public void i_verify_the_count_of_named_cars() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(number, 78);
	}
}
