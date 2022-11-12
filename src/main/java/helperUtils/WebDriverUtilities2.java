/*
 * <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>selenium4.6.0</groupId>
	<artifactId>seleniumLatest</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<dependencies>
		<dependency>
			<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.6.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.paulhammant/ngwebdriver -->
		<dependency>
			<groupId>com.paulhammant</groupId>
			<artifactId>ngwebdriver</artifactId>
			<version>1.2</version>
		</dependency>

	</dependencies>
</project>

*/
package helperUtils;

import com.paulhammant.ngwebdriver.NgWebDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://trademe.co.nz");

		driver.manage().window().maximize();

		String numebrOfNamedCars;

		String[] carMakes = { "Ferrari", "BMW", "Mazda", "Honda" };
		for (String carMake : carMakes) {
			System.out.println(carMake);

			try {				
				
				waiter(driver, "elementToBeClickable", By.cssSelector("tm-shell-logo [title*='Trade Me']"));
				driver.findElement(By.cssSelector("tm-shell-logo [title*='Trade Me']")).click();				
				
				// there is some sort of results caching from previous search
				// As a result, when a new search is performed, the old search results are momentarily shown
				// Before the new results load up
				// So refreshing the page to address this caching issue
				driver.navigate().refresh();

				waiter(driver, "elementToBeClickable",
						By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']"));
				driver.findElement(
						By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']"))
						.click();

				waiter(driver, "elementToBeClickable", By.cssSelector("[name='selectedMake']"));
				Select carMakeList = new Select(driver.findElement(By.cssSelector("[name='selectedMake']")));
				carMakeList.selectByValue(carMake);

				waiter(driver, "elementToBeClickable", By.cssSelector("button[type='submit']"));
				driver.findElement(By.cssSelector("button[type='submit']")).click();

//				waiter(driver, "elementVisible",
//						By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"));
				
				waiterForElement(driver, By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"));
				numebrOfNamedCars = driver
						.findElement(
								By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"))
						.getText();
				System.out.println("the number of " + carMake + " cars Listed is :" + numebrOfNamedCars);				

			} catch (Exception e) {
				// TODO: handle exception

				System.out.println(e);

			}

//			finally {
//				driver.quit();
//			}
		}
		driver.quit();

	}

	public static void waiter(WebDriver driver, String condition, By by) {
		switch (condition) {
		case "elementToBeClickable":
			new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(by));
			break;

		case "elementVisible":
			new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOfElementLocated(by));

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

//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(by));