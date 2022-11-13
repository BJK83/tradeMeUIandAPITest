package helperUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {

	public static WebDriver driver;

	public static void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		driver.get("https://trademe.co.nz");

	}
	
	public static void tearDown()
	{
		driver.quit();

	}
	
}
