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
package seleniumSimpleTests;

import com.paulhammant.ngwebdriver.NgWebDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	public static NgWebDriver ngdriver;
	static JavascriptExecutor javascriptExecutor;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//
//		javascriptExecutor = (JavascriptExecutor) driver;
//		ngdriver = new NgWebDriver(javascriptExecutor);

		try {
			driver.get("https://trademe.co.nz");
//	ngdriver.waitForAngularRequestsToFinish();
			driver.manage().window().maximize();

			System.out.println(LocalDateTime.now());
//			driver.wait(3000);
			System.out.println(LocalDateTime.now());
			System.out.println("bhavin");

			driver.findElement(
					By.cssSelector(".tm-homepage-search-header__vertical-links-list-item [routerlink='/motors']"))
					.click();

			waiter(driver, "elementToBeClickable", By.cssSelector("button[type='submit']"));
			int x = driver.findElements(By.cssSelector("tg-select-container[label='Make'] option")).size();
			List<WebElement> myElements = driver
					.findElements(By.cssSelector("tg-select-container[label='Make'] option"));

			Iterator<WebElement> iterator = myElements.iterator();

			while (iterator.hasNext()) {
				if (iterator.next().getText() == "Any make") {
					
					break;
				}

			}
			
			

			System.out.println(x);
			System.out.println("after removing item");
			System.out.println(driver.findElements(By.cssSelector("tg-select-container[label='Make'] option")).size());

//			
//			new WebDriverWait(driver, Duration.ofSeconds(10))
//			        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));			

//			new WebDriverWait(driver, Duration.ofSeconds(10))
//			        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

			driver.findElement(By.cssSelector("button[type='submit']")).click();

			String nnn = driver
					.findElement(
							By.cssSelector("tm-search-header-result-count .tm-search-header-result-count__heading"))
					.getText();
			System.out.println(nnn);
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
