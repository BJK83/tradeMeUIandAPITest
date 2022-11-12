/*

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
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

public class WebDriverUtilities {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		try {
			driver.get("https://trademe.co.nz");
	
			driver.manage().window().maximize();

			driver.findElement(By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']"))
					.click();

			waiter(driver, "elementToBeClickable", By.cssSelector("button[type='submit']"));
			
			// get the count of namedCars
			int numberOfNamedCarMakes = driver.findElements(By.cssSelector("tg-select-container[label='Make'] option")).size();
			List<WebElement> myElements = driver
					.findElements(By.cssSelector("tg-select-container[label='Make'] option"));

			Iterator<WebElement> iterator = myElements.iterator();

// Any make is not a named car, so subtract this from the count
			while (iterator.hasNext()) {
				if(iterator.next().getText().toString().contentEquals("Any make"))
				{
					numberOfNamedCarMakes -=1;
				}
			}			
			
// Print the total number of named cars
			System.out.println(numberOfNamedCarMakes);
			System.out.println(numberOfNamedCarMakes);
			
//			
//			new WebDriverWait(driver, Duration.ofSeconds(10))
//			        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));			

//			new WebDriverWait(driver, Duration.ofSeconds(10))
//			        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

//			String nnn = driver
//					.findElement(
//							By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"))
//					.getText();
//			System.out.println(nnn);
//	ngdriver.waitForAngularRequestsToFinish();

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);

		} finally {
			driver.quit();
		}

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

}
