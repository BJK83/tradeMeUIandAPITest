package pagesAndObjects;

import java.util.Iterator;
import java.util.List;

import helperUtils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	
	

	public static By motorSearch = By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']");
	public static By selectedMake = By.cssSelector("[name='selectedMake']");
	public static By searchCarMakeSubmit = By.cssSelector("button[type='submit']");
	public static By tradeMeHome = By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading");
	public static By searchResultTesxt = By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading");
	public static By namedCarList = By.cssSelector("tg-select-container[label='Make'] option");

	
	public static void clickMotorSearch(WebDriver driver) throws InterruptedException
	{
		Common.waitForElement(driver, "elementToBeClickable", motorSearch);
		driver.findElement(motorSearch).click();
	}
	
	public static int countOfNamedCars(WebDriver driver) throws InterruptedException {
		
		
		Common.waitForElement(driver, "elementToBeClickable", searchCarMakeSubmit);

		// get the count of namedCars
		int numberOfNamedCarMakes = driver.findElements(namedCarList).size();
		List<WebElement> myElements = driver.findElements(namedCarList);

		Iterator<WebElement> iterator = myElements.iterator();

		//Any make is not a named car, so subtract this from the count
		while (iterator.hasNext()) {
			if (iterator.next().getText().toString().contentEquals("Any make")) {
				numberOfNamedCarMakes -= 1;
				break;
			}
		}		
		return numberOfNamedCarMakes;
	}
	
	public static void searchForSpecificCarMake(WebDriver driver, String carMake) throws InterruptedException {
		
		
		Common.waitForElement(driver, "elementToBeClickable", selectedMake);
		Select carMakeList = new Select(driver.findElement(By.cssSelector("[name='selectedMake']")));
		carMakeList.selectByValue(carMake);

		Common.waitForElement(driver, "elementToBeClickable", searchCarMakeSubmit);		
		driver.findElement(searchCarMakeSubmit).click();
	}
	
	public static String numberOfListedCarsForSpecificCarMakes(WebDriver driver) throws InterruptedException {
		Common.waitForElement(driver,"visibilityOf",searchResultTesxt);
		String numebrOfNamedCars = driver
				.findElement(By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"))
				.getText();
	
	return numebrOfNamedCars;
	
	}

	

}
