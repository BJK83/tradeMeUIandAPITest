package pagesAndObjects;

import org.openqa.selenium.By;
import helperUtils.WebDriverUtils;


public class SearchPage {
	
	public SearchPage() {
		
	}
	
	public void setUp() {
		WebDriverUtils.setUp();		
	}
	
	public void tearDown() {
		WebDriverUtils.tearDown();
	}
	
	
	public By motorSearch = By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']");
	public By carMake = By.cssSelector("tg-select-container[label='Make'] option");
	public By selectedMake = By.cssSelector("[name='selectedMake']");
	public By searchCarMakeSubmit = By.cssSelector("button[type='submit']");
	public By tradeMeHome = By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading");
	public By searchResultTesxt = By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading");
	

}
