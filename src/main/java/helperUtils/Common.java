package helperUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public static void waitForElement(WebDriver driver, String condition, By by) throws InterruptedException {
		switch (condition) {
		case "elementToBeClickable":
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
			break;
		case "visibilityOf":
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
			break;
		default:
			Thread.sleep(10000);
			break;
		}

	}

}
