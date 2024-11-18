package stepsdefinitions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleRegister {
	   WebDriver driver;
	   
	   String expName,expEmail,actualName, actualEmail;
	   
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
		
		@Given("User launch the Browser and navigate URL")
		public void user_launch_the_browser_and_navigate_url() {
		
		    System.out.println("implemented with the help of hooks");
		}

		@Given("Verify that home page is visible")
		public void verify_that_home_page_is_visible() {
			WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(20));
			WebElement homeElement = expWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),\"Home\")]")));
		 if(homeElement.isDisplayed()) 
		 {
			 System.out.println("Home page is visible");
		 }		 
		}

		@Given("Click on Sign in and Login Option")
		public void click_on_Sign_in_and_Login_Option() {
			driver.findElement(By.xpath("//a[contains(text(),\"Signup / Login\")]")).click();
		}

		@Given("Verify New User Signup! is visible")
		public void verify_new_user_signup_is_visible() {
			if(driver.findElement(By.xpath("//h2[contains(text(),\"New User Signup!\")]")).isDisplayed()) {
				System.out.println("New User Signup is Visible now Successfully");
			}
		    
		}

		@When("User Sends username and email")
		public void user_sends_username_and_email(DataTable dataTable) {
			Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
			expName = dataMap.get("name");
			expEmail = dataMap.get("email");
			driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys(expName);
			driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys(expEmail);
			
		    
		}

		@When("Click Signup button")
		public void click_signup_button() {
		 driver.findElement(By.xpath("//button[contains(text(),\"Signup\")]")).click();
		}

		@When("Verify that ENTER ACCOUNT INFORMATION is visible")
		public void verify_that_enter_account_information_is_visible() {
		    actualName = driver.findElement(By.xpath("//input[@name=\"name\"]")).getText();
		    actualEmail = driver.findElement(By.xpath("//input[@name=\"email\"]")).getText();
		    		    		
			if(actualEmail.equals(expEmail) && actualName.equals(expName)) {
				
				System.out.println("user can able to see name value is " +actualName);
				System.out.println("user can able to see email value is " +actualEmail);
		    	
		    }
		}

		@When("Fill details: Title, Name, Email, Password, Date of birth and Select two checkbox")
		public void fill_details_title_name_email_password_date_of_birth_and_select_two_checkbox() {
			//select gender in radio button options
		   driver.findElement(By.xpath("//div[@id=\"uniform-id_gender1\"]")).click();
		   //Enter Pwd details
		   driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("RK123456");
		   //Select DOB 
		   Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@name=\"days\"]")));
		   dayDropdown.selectByValue("10");
		   Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@name=\"months\"]")));
		   monthDropdown.selectByValue("10");
		   Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@name=\"years\"]")));
		   yearDropdown.selectByValue("2000");
		   
		   // Select two checkbox
		   driver.findElement(By.xpath("//label[contains(text() ,\"Sign up for our newsletter!\")]")).click();
		   driver.findElement(By.xpath("//label[contains(text() ,\"Receive special offers from our partners!\")]")).click();   
		   
		}

		@When("Fill Address details")
		public void fill_address_details(DataTable dataTableAddr) {
			Map<String, String> Addr = dataTableAddr.asMap(String.class,String.class);
			driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys(Addr.get("First name"));
			driver.findElement(By.xpath("//input[@id=\"last_name\"]")).sendKeys(Addr.get("Last name"));
			driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys(Addr.get("Address"));
			driver.findElement(By.xpath("//input[@id=\"state\"]")).sendKeys(Addr.get("State"));
			driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys(Addr.get("City"));
			driver.findElement(By.xpath("//input[@id=\"zipcode\"]")).sendKeys(Addr.get("ZipCode"));
			driver.findElement(By.xpath("//input[@id=\"mobile_number\"]")).sendKeys(Addr.get("Mobile"));		    
		}

		@When("Click on Create Account button")
		public void click_on_create_account_button() {
			driver.findElement(By.xpath("//button[contains(text(),\"Create Account\")]")).click();		    
		}

		@When("Verify that ACCOUNT CREATED! is visible")
		public void verify_that_account_created_is_visible() {
		   if(driver.findElement(By.xpath("//b[contains(text(),\"Account Created!\")]")).isDisplayed())
			   System.out.println("Account created successfully");
		  
		}

		@When("Click Continue button")
		public void click_continue_button() {
			driver.findElement(By.xpath("//a[contains(text(),\"Continue\")]")).click();
		   
		}

		@When("Verify that Logged in as username is visible")
		public void verify_that_logged_in_as_username_is_visible() {
		    if(driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]/b[1]")).getText().equals(expName))
		    	System.out.println("user able to see given name in the page");
		}

		@When("Click Delete Account button")
		public void click_delete_account_button() {
		    driver.findElement(By.xpath("//a[contains(text(),\" Delete Account\")]")).click();
		}

		@Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
		public void verify_that_account_deleted_is_visible_and_click_continue_button() {
		   if(driver.findElement(By.xpath("//b[contains(text(),\"Account Deleted!\")]")).isDisplayed()) {
			   System.out.println("Account has deleted successfully.");
		   }
		}


	}


