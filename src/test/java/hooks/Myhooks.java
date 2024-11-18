package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Myhooks {
WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void teardown() {		
		driver.quit();		
	}

}
