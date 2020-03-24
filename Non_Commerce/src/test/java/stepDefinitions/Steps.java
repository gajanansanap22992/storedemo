package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import testBase.TestBase;
import utilities.Employee;
import utilities.Utility;

public class Steps extends TestBase {
	public WebDriver driver;
	public LoginPage lp;
	public TestBase tb;
	public AddCustomerPage addcust;
	@Before
	public void setup() throws IOException
	{
	    tb =new TestBase();
		driver=tb.getDriver();
		lp=new LoginPage(driver);
	   addcust=new AddCustomerPage(driver);
		
	}
	
	@Given("user open browser")
	public void user_open_browser() {
		//driver=getDriver();
		driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("user enter url {string}")
	public void user_enter_url(String url) {
	   driver.get(url);
	}

	@When("user get page with title {string}")
	public void user_get_page_with_title(String title) {
		Assert.assertEquals(title, driver.getTitle());
	  
	}

	
	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws InterruptedException {
		lp.enterEmailandpassword(email, password);
	  
	}

	@When("user click on login button")
	public void user_click_on_login_button() throws InterruptedException {
	   lp.clickOnLoginButton();
	   }

	@Then("user get the page with {string}")
	public void user_get_the_page_with(String title) 
	{
		if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again."))
		{
			Assert.assertTrue(false);
		}
		else
		{
		Assert.assertEquals(title, driver.getTitle());
		}
	   
	}
	@When("user click on customers menu")
	public void user_click_on_customers_menu() {
	   addcust.clickOnCustomer();
	}

	@When("user click on customers item from customers menu")
	public void user_click_on_customers_item_from_customers_menu() {
	   addcust.clickOnCustomerMenuItem();
	}
	@When("user click on addNew button")
	public void user_click_on_addNew_button() {
	    
	}
	@When("user select customer role")
	public void user_select_customer_role() throws InterruptedException {
		addcust.selectCustomerRole("Administrators");
	}

	@When("user enter customers details")
	public void user_enter_customers_details() throws InterruptedException, IOException {
		List<Employee> al=Utility.getData();
		al.size();
		for (int i=0;i<al.size();i++)
		{
		Employee e=Utility.getData().get(i);
		addcust.clickOnAddnewButton();
		driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
	    addcust.enterEmail(e.email);
	    addcust.enterpassword(e.password);
	    addcust.enterFirstname(e.firstname);
	    addcust.enterLastname(e.lastname);
	    addcust.selectGender(e.gender);
	    addcust.enterDateofBirth(e.dateofbirth);
	    addcust.enterCompanyName(e.companyname);
	    addcust.select_taxExempt_Newsletter(e.taxexempt,e.newsletter);
	    addcust.selectCustomerRole(e.customerrole);
	    addcust.selectManagerOfVendor(e.manager);
	    addcust.SelectActive(e.active);
	    addcust.enterAdminComment(e.admincomment);
	    addcust.clickOnSaveButton();
	    Thread.sleep(2000);
		}
	}

	@When("user click on save button")
	public void user_click_on_save_button() throws InterruptedException {
	   addcust.clickOnSaveButton();
	   
	}
	@When("user get successfull message as {string}")
	public void user_get_successfull_message_as(String string) throws InterruptedException {
		Thread.sleep(2000);
		 Assert.assertTrue(driver.getPageSource().contains(string));
		   
	}

	@Then("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		 lp.clickOnLogoutButton();
	}

	

	@Then("user close browser")
	public void user_close_browser() {System.out.println("test ends close browser");}
	
	@SuppressWarnings("deprecation")
	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		 if (scenario.isFailed())
		 {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		   // embed it in the report.
		      scenario.embed(screenshot, "image/png"); 
		    }
		 else if (scenario.getStatus()==Status.PASSED)
		 {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		   // embed it in the report.
		      scenario.embed(screenshot, "image/png"); 
		    }
		
		Thread.sleep(2000);
	   driver.quit();
	}




}
