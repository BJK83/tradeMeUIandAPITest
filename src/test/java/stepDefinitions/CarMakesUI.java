package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CarMakesUI {

	public static WebDriver driver;

	@Before("@UI")
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@After("@UI")
	public void tearDown() {
		driver.quit();
	}

	@Given("I am on TradeMe home page")
	public void i_am_on_trade_me_home_page() {
		driver.get("https://trademe.co.nz");

	}

	@When("I click on Motors search")
	public void i_click_on_motors_search() {
		// Write code here that turns the phrase above into concrete actions
		waiter(driver, "elementToBeClickable",
				By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']"));
		driver.findElement(
				By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']")).click();

	}

	@Then("I evaluate count of all named cars {string}")
	public void i_evaluate_count_of_all_named_cars(String countOfAllNamedCars) {
		// Write code here that turns the phrase above into concrete actions

		waiter(driver, "elementToBeClickable", By.cssSelector("button[type='submit']"));

		// get the count of namedCars
		int numberOfNamedCarMakes = driver.findElements(By.cssSelector("tg-select-container[label='Make'] option"))
				.size();
		List<WebElement> myElements = driver.findElements(By.cssSelector("tg-select-container[label='Make'] option"));

		Iterator<WebElement> iterator = myElements.iterator();

//Any make is not a named car, so subtract this from the count
		while (iterator.hasNext()) {
			if (iterator.next().getText().toString().contentEquals("Any make")) {
				numberOfNamedCarMakes -= 1;
				break;
			}
		}

		Assert.assertEquals(Integer.parseInt(countOfAllNamedCars), numberOfNamedCarMakes);

	}

	@When("search for car make {string}")
	public void search_for_car_make_ferrari(String carMake) {
		// Write code here that turns the phrase above into concrete actions

		waiter(driver, "elementToBeClickable", By.cssSelector("[name='selectedMake']"));
		Select carMakeList = new Select(driver.findElement(By.cssSelector("[name='selectedMake']")));
		carMakeList.selectByValue(carMake);

		waiter(driver, "elementToBeClickable", By.cssSelector("button[type='submit']"));
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	@Then("I evaluate the count of total listings for the {string}")
	public void i_evaluate_the_count_of_total_listings_for_the_ferrari(String carMake) {
		// Write code here that turns the phrase above into concrete actions
		waiterForElement(driver,
				By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"));
		String numebrOfNamedCars = driver
				.findElement(By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"))
				.getText();
		System.out.println("the number of " + carMake + " cars Listed is :" + numebrOfNamedCars);
	}

	public static void waiter(WebDriver driver, String condition, By by) {
		switch (condition) {
		case "elementToBeClickable":
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
			break;

		case "elementVisible":
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
			break;

		default:
			break;
		}

	}
	
	public static void waiterForElement(WebDriver driver, By by) {

		new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(
				driver.findElement(by)));

	}
}