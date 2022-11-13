package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesAndObjects.SearchPage;
import static helperUtils.WebDriverUtils.driver;

public class CarMakesUI {

	
//	SearchPage searchPage;// = new SearchPage();
	 

	@Given("I am on TradeMe home page")
	public void i_am_on_trade_me_home_page() {

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.trademe.co.nz/a/");

	}

	@When("I click on Motors search")
	public void i_click_on_motors_search() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions


		// clickMotorSearch
		SearchPage.clickMotorSearch(driver);
		
		
//		waiter(driver, "elementToBeClickable", searchPage.motorSearch);
//		driver.findElement(searchPage.motorSearch).click();

	}

	@Then("I evaluate count of all named cars {string}")
	public void i_evaluate_count_of_all_named_cars(String countOfAllNamedCars) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

//		Common.waitForElement(driver, "elementToBeClickable", SearchPage.searchCarMakeSubmit);
//
//		// get the count of namedCars
//		int numberOfNamedCarMakes = driver.findElements(SearchPage.namedCarList).size();
//		List<WebElement> myElements = driver.findElements(SearchPage.namedCarList);
//
//		Iterator<WebElement> iterator = myElements.iterator();
//
//		//Any make is not a named car, so subtract this from the count
//		while (iterator.hasNext()) {
//			if (iterator.next().getText().toString().contentEquals("Any make")) {
//				numberOfNamedCarMakes -= 1;
//				break;
//			}
//		}

		Assert.assertEquals(Integer.parseInt(countOfAllNamedCars), SearchPage.countOfNamedCars(driver));

	}

	@When("search for car make {string}")
	public void search_for_car_make_ferrari(String carMake) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

//		waiter(driver, "elementToBeClickable", By.cssSelector("[name='selectedMake']"));
//		Select carMakeList = new Select(driver.findElement(By.cssSelector("[name='selectedMake']")));
//		carMakeList.selectByValue(carMake);
//
//		waiter(driver, "elementToBeClickable", By.cssSelector("button[type='submit']"));
//		driver.findElement(By.cssSelector("button[type='submit']")).click();

		
		SearchPage.searchForSpecificCarMake(driver,carMake);
		
		
	}

	@Then("I evaluate the count of total listings for the {string}")
	public void i_evaluate_the_count_of_total_listings_for_the_ferrari(String carMake) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		waiterForElement(driver,
//				By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"));
//		String numebrOfNamedCars = driver
//				.findElement(By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"))
//				.getText();

		String numebrOfNamedCars = SearchPage.numberOfListedCarsForSpecificCarMakes(driver);
		
		
		System.out.println("the number of " + carMake + " cars Listed is :" + numebrOfNamedCars);
	}

//	public static void waiter(WebDriver driver, String condition, By by) {
//		switch (condition) {
//		case "elementToBeClickable":
//			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
//			break;
//
//		case "elementVisible":
//			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
//			break;
//
//		default:
//			break;
//		}
//
//	}
//
//	public static void waiterForElement(WebDriver driver, By by) {
//
//		new WebDriverWait(driver, Duration.ofSeconds(25))
//				.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
//
//	}
}