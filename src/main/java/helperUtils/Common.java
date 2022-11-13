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
//			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(webElement));
			break;
		case "visibilityOf":
			new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOfElementLocated(by));
			break;
		default:
			Thread.sleep(10000);
			break;
		}

	}
	
	public void clickElement(WebDriver driver, By by) throws InterruptedException {
		
		waitForElement(driver,"elementToBeClickable",by);
		driver.findElement(by).click();
		
	}
//	
//	public void getText(WebDriver driver, By by) throws InterruptedException {
//		
//		waitForElement(driver,"visibilityOf",by);
//		driver.findElement(by).click();
//		
//	}

}
