package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesAndObjects.SearchPage;
import static helperUtils.WebDriverUtils.driver;

public class CarMakesUI {

	
	@Given("I am on TradeMe home page")
	public void i_am_on_trade_me_home_page() {

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.trademe.co.nz/a/");

	}

	@When("I click on Motors search")
	public void i_click_on_motors_search() throws InterruptedException {

		SearchPage.clickMotorSearch(driver);			

	}

	@Then("I evaluate count of all named cars {string}")
	public void i_evaluate_count_of_all_named_cars(String countOfAllNamedCars) throws InterruptedException {

		Assert.assertEquals(Integer.parseInt(countOfAllNamedCars), SearchPage.countOfNamedCars(driver));

	}

	@When("search for car make {string}")
	public void search_for_car_make_ferrari(String carMake) throws InterruptedException {
		
		SearchPage.searchForSpecificCarMake(driver,carMake);		
		
	}

	@Then("I evaluate the count of total listings for the {string}")
	public void i_evaluate_the_count_of_total_listings_for_the_ferrari(String carMake) throws InterruptedException {

		String numebrOfNamedCars = SearchPage.numberOfListedCarsForSpecificCarMakes(driver);		
		
		System.out.println("the number of " + carMake + " cars Listed is :" + numebrOfNamedCars);
	}
}